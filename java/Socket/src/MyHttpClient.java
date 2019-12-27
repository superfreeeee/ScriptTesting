import java.io.*;
import java.net.*;
/**
 * MyHttpClient
 */
public class MyHttpClient {

  public static void main(String[] args) throws Exception {
    InetAddress inet = InetAddress.getByName("www.baidu.com\n");
    System.out.println(inet.getHostAddress());
    Socket socket = new Socket(inet.getHostAddress(), 80);

    InputStream in = socket.getInputStream();
    OutputStream out = socket.getOutputStream();
    BufferedReader reader = new BufferedReader(new InputStream(in));
    PrintWriter writer = new PrintWriter(out);

    StringBuilder temp = new StringBuilder();
    temp.append("GET /home.html HTTP/1.1\n\n");//home.html是关于百度的页面
		temp.append("Accept: image/gif, image/x-xbitmap, image/jpeg, image/pjpeg, application/x-shockwave-flash, application/xaml+xml, application/vnd.ms-xpsdocument, application/x-ms-xbap, application/x-ms-application, application/msword, application/vnd.ms-excel, application/vnd.ms-powerpoint, **\n");
		temp.append("Accept-Language: en-us,zh-cn;q=0.5\n");
		temp.append("Accept-Encoding: gzip, deflate\n");
		temp.append("Host: www.baidu.com\n");
		temp.append("User-Agent: Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1; .NET CLR 1.1.4322; .NET CLR 2.0.50727; .NET CLR 3.0.04506.30; .NET CLR 3.0.4506.2152; .NET CLR 3.5.30729)\n");
		temp.append("Connection: Keep-Alive\n");
    
    writer.println(temp.toString());
    String line = reader.readLine();
    while(line != null){
      System.out.println(line);
      line = reader.readLine();
    }
    reader.close();
    writer.close();
  }  
}


