
package socket;

import java.io.*;
import java.net.*;

public class MyHttpClient {
	public static void main(String[] args) throws Exception{
		InetAddress inet = InetAddress.getByName("www.baidu.com");
		System.out.println(inet.getHostAddress());
		Socket socket = new Socket(inet.getHostAddress(),80);
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		PrintWriter writer = new PrintWriter(out);
		writer.println("GET /home.html HTTP/1.1");//home.html是关于百度的页面
		writer.println("Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint, **");
		writer.println("Accept-Language: en-us,zh-cn;q=0.5");
		writer.println("Accept-Encoding: gzip, deflate");
		writer.println("Host: www.baidu.com");
		writer.println("User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)");
		writer.println("Connection: Keep-Alive");
		writer.println();
		writer.flush();
		String line = reader.readLine();
		while(line!=null){
			System.out.println(line);
			line = reader.readLine();
		}
		reader.close();
		writer.close();
	}
  }

	package socket;

import java.io.*;
import java.net.*;

public class MyServer {
	public static void main(String[] args) throws IOException{
		ServerSocket svrSocket = new ServerSocket(8080);
		while(true){
			Socket socket = svrSocket.accept();
			//足够大的一个缓冲区
			byte[] buf = new byte[1024*1024];
			InputStream in = socket.getInputStream();
			int byteRead = in.read(buf, 0, 1024*1024);
			String dataString = new String(buf, 0, byteRead);
			System.out.println(dataString);
			in.close();
			socket.close();
		}
	}
}


package socket;

import java.io.*;
import java.net.*;
/**
 * MyHttpServer 实现一个简单的HTTPserver端，能够获取用户提交的内容
 * 并给用户一个response
 * 由于时间的关系，对http头的处理显得不规范
 * 对于上传附件，临时仅仅能解析仅仅上传一个附件并且附件位置在第一个的情况
 * 转载请注明来自http://blog.csdn.net/sunxing007
 * **/
public class MyHttpServer {
    //server根文件夹，post.html, upload.html都放在该位置
    public static String WEB_ROOT = "c:/root";
    //port
    private int port;
    //用户请求的文件的url
    private String requestPath;
    //mltipart/form-data方式提交post的分隔符, 
    private String boundary = null;
    //post提交请求的正文的长度
    private int contentLength = 0;

    public MyHttpServer(String root, int port) {
        WEB_ROOT = root;
        this.port = port;
        requestPath = null;
    }
    //处理GET请求
    private void doGet(DataInputStream reader, OutputStream out) throws Exception {
        if (new File(WEB_ROOT + this.requestPath).exists()) {
            //从server根文件夹下找到用户请求的文件并发送回浏览器
            InputStream fileIn = new FileInputStream(WEB_ROOT + this.requestPath);
            byte[] buf = new byte[fileIn.available()];
            fileIn.read(buf);
            out.write(buf);
            out.close();
            fileIn.close();
            reader.close();
            System.out.println("request complete.");
        }
    }
    //处理post请求
    private void doPost(DataInputStream reader, OutputStream out) throws Exception {
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
            if ("".equals(line)) {
                break;
            } else if (line.indexOf("Content-Length") != -1) {
                this.contentLength = Integer.parseInt(line.substring(line.indexOf("Content-Length") + 16));
            }
            //表明要上传附件， 跳转到doMultiPart方法。
            else if(line.indexOf("multipart/form-data")!= -1){
                //得multiltipart的分隔符
                this.boundary = line.substring(line.indexOf("boundary") + 9);
                this.doMultiPart(reader, out);
                return;
            }
        }
        //继续读取普通post（没有附件）提交的数据
        System.out.println("begin reading posted data......");
        String dataLine = null;
        //用户发送的post数据正文
        byte[] buf = {};
        int size = 0;
        if (this.contentLength != 0) {
            buf = new byte[this.contentLength];
            while(size<this.contentLength){
                int c = reader.read();
                buf[size++] = (byte)c;
                
            }
            System.out.println("The data user posted: " + new String(buf, 0, size));
        }
        //发送回浏览器的内容
        String response = "";
        response += "HTTP/1.1 200 OK/n";
        response += "Server: Sunpache 1.0/n";
        response += "Content-Type: text/html/n";
        response += "Last-Modified: Mon, 11 Jan 1998 13:23:42 GMT/n";
        response += "Accept-ranges: bytes";
        response += "/n";
        String body = "<html><head><title>test server</title></head><body><p>post ok:</p>" + new String(buf, 0, size) + "</body></html>";
        System.out.println(body);
        out.write(response.getBytes());
        out.write(body.getBytes());
        out.flush();
        reader.close();
        out.close();
        System.out.println("request complete.");
    }
    //处理附件
    private void doMultiPart(DataInputStream reader, OutputStream out) throws Exception {
        System.out.println("doMultiPart ......");
        String line = reader.readLine();
        while (line != null) {
            System.out.println(line);
            line = reader.readLine();
            if ("".equals(line)) {
                break;
            } else if (line.indexOf("Content-Length") != -1) {
                this.contentLength = Integer.parseInt(line.substring(line.indexOf("Content-Length") + 16));
                System.out.println("contentLength: " + this.contentLength);
            } else if (line.indexOf("boundary") != -1) {
                //获取multipart分隔符
                this.boundary = line.substring(line.indexOf("boundary") + 9);
            }
        }
        System.out.println("begin get data......");
        /*以下的凝视是一个浏览器发送带附件的请求的全文，全部中文都是说明性的文字*****
        <HTTP头部内容略>
        ............
        Cache-Control: no-cache
        <这里有一个空行，表明接下来的内容都是要提交的正文>
        -----------------------------7d925134501f6<这是multipart分隔符>
        Content-Disposition: form-data; name="myfile"; filename="mywork.doc"
        Content-Type: text/plain
        
        <附件正文>........................................
        .................................................
        
        -----------------------------7d925134501f6<这是multipart分隔符>
        Content-Disposition: form-data; name="myname"<其它字段或附件>
        <这里有一个空行>
        <其它字段或附件的内容>
        -----------------------------7d925134501f6--<这是multipart分隔符，最后一个分隔符多两个->
        ****************************************************************/
        /**
         * 上面的凝视是一个带附件的multipart类型的POST的全文模型，
         * 要把附件去出来，就是要找到附件正文的起始位置和结束位置
         * **/
        if (this.contentLength != 0) {
            //把全部的提交的正文，包含附件和其它字段都先读到buf.
            byte[] buf = new byte[this.contentLength];
            int totalRead = 0;
            int size = 0;
            while (totalRead < this.contentLength) {
                size = reader.read(buf, totalRead, this.contentLength - totalRead);
                totalRead += size;
            }
            //用buf构造一个字符串，能够用字符串方便的计算出附件所在的位置
            String dataString = new String(buf, 0, totalRead);
            System.out.println("the data user posted:/n" + dataString);
            int pos = dataString.indexOf(boundary);
            //下面略过4行就是第一个附件的位置
            pos = dataString.indexOf("/n", pos) + 1;
            pos = dataString.indexOf("/n", pos) + 1;
            pos = dataString.indexOf("/n", pos) + 1;
            pos = dataString.indexOf("/n", pos) + 1;
            //附件開始位置
            int start = dataString.substring(0, pos).getBytes().length;
            pos = dataString.indexOf(boundary, pos) - 4;
            //附件结束位置
            int end = dataString.substring(0, pos).getBytes().length;
            //下面找出filename
            int fileNameBegin = dataString.indexOf("filename") + 10;
            int fileNameEnd = dataString.indexOf("/n", fileNameBegin);
            String fileName = dataString.substring(fileNameBegin, fileNameEnd);
            /**
             * 有时候上传的文件显示完整的文件名称路径,比方c:/my file/somedir/project.doc
             * 但有时候仅仅显示文件的名字，比方myphoto.jpg.
             * 所以须要做一个推断。
            */
            if(fileName.lastIndexOf("//")!=-1){
                fileName = fileName.substring(fileName.lastIndexOf("//") + 1);
            }
            fileName = fileName.substring(0, fileName.length()-2);
            OutputStream fileOut = new FileOutputStream("c://" + fileName);
            fileOut.write(buf, start, end-start);
            fileOut.close();
            fileOut.close();
        }
        String response = "";
        response += "HTTP/1.1 200 OK/n";
        response += "Server: Sunpache 1.0/n";
        response += "Content-Type: text/html/n";
        response += "Last-Modified: Mon, 11 Jan 1998 13:23:42 GMT/n";
        response += "Accept-ranges: bytes";
        response += "/n";
        out.write("<html><head><title>test server</title></head><body><p>Post is ok</p></body></html>".getBytes());
        out.flush();
        reader.close();
        System.out.println("request complete.");
    }

    public void service() throws Exception {
        ServerSocket serverSocket = new ServerSocket(this.port);
        System.out.println("server is ok.");
        //开启serverSocket等待用户请求到来，然后依据请求的类别作处理
        //在这里我仅仅针对GET和POST作了处理
        //当中POST具有解析单个附件的能力
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("new request coming.");
            DataInputStream reader = new DataInputStream((socket.getInputStream()));
            String line = reader.readLine();
            String method = line.substring(0, 4).trim();
            OutputStream out = socket.getOutputStream();
            this.requestPath = line.split(" ")[1];
            System.out.println(method);
            if ("GET".equalsIgnoreCase(method)) {
                System.out.println("do get......");
                this.doGet(reader, out);
            } else if ("POST".equalsIgnoreCase(method)) {
                System.out.println("do post......");
                this.doPost(reader, out);
            }
            socket.close();
            System.out.println("socket closed.");
        }
    }
    public static void main(String args[]) throws Exception {
        MyHttpServer server = new MyHttpServer("c:/root", 8080);
        server.service();
    }
}


post.html
<html> 
<head> 
<title>test my server</title> 
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"> 
</head> 
<body> 
<p>upload</p> 
来自http://blog.csdn.net/sunxing007<br>
<form name="UploadForm" method="post" action="http://localhost:8080/">
<input type="text" name="myname" /><br>
<select name="myage">
  <option value="18">18</option>
  <option value="20">20</option>
  <option value="22">22</option>
</select><br>
<input type="submit"value="Sutmit">
</form>
</body> 
</html>


upload.html
<head>
<title>my page</title>
<style>
  table{
    border-collapse: collapse;
  }
</style>
</head>
<body>
来自http://blog.csdn.net/sunxing007<br>
    <form action='http://localhost:8080/' method='post' enctype='multipart/form-data'>
    file: <input type='file' name='myfile' /><br>
    <input type='submit' />
    </form>
</body>
</html>