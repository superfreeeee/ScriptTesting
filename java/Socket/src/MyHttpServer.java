import java.io.*;
import java.net.*;

/**
 * MyHttpServer
 */
public class MyHttpServer {
  public static String WEB_ROOT = "/Users/superfree/Desktop/Java測試/Socket";
  private int port;
  private String requestPath;
  private String boundary = null;
  private int contentLength = 0;

  public MyHttpServer(int port){
    this.port = port;
    requestPath = null;
  }

  public MyHttpServer(String root, int port){
    WEB_ROOT = root;
    this.port = port;
    requestPath = null;
  }
  
  private void doGet(DataInputStream reader, OutputStream out) throws Exception {
    if(new File(WEB_ROOT + this.requestPath).exists()) {
      InputStream fileIn = new FileInputStream(WEB_ROOT + this.requestPath);
      byte[] buf = new byte[fileIn.avalibale()];
      fileIn.read(buf);
      out.write(buf);

      out.close();
      fileIn.close();
      reader.close();
      System.out.println("request complete");
    }
  }

  private void doPost(DataInputStream reader, OutputStream out) throws Exception {
    String line = reader.readLine();
    while(line != null) {
      System.out.println(line);
      line = reader.readerLine();
      if("".equals(line)) {
        break;
      } else if (line.indexOf("content-Length") != -1) {
        this.contentLength = Integer.parseInt(line.substring(line.indexOf("Content-Length") + 16));
      } else if (line.indexOf("multipart/form-data") != -1) {
        this.boundary = line.substring(line.indexOf("boundary") + 9);
        this.doMultiPart(reader, out);
        return ;
      }
    }

    System.out.println("begin reading posted data......");
    String dataLine = null;
    byte[] buf = {};
    int size = 0;
    if (this.contentLength != 0) {
      buf = new byte[this.contentLength];
      while (size < this.contentLength) {
        int c = reader.read();
        buf[size++] = (byte)c;
      }
      System.out.println("The data user posted: " + new String(buf, 0, size));
    }

    StringBuilder response = new StringBuilder();
    response.append("HTTP/1.1 200 OK\n");
    response.append("Server: Sunpache 1.0\n");
    response.append("Content-Type: text/html\n");
    response.append("Last-Modified: Mon, 11 Jan 1998 13:23:42 GMT\n");
    response.append("Accept-ranges: bytes\n");
    String body = "<html><head><title>test server</title></head><body><p>post ok:</p>" + new String(buf, 0, size) + "</body></html>";
    System.out.println(body);
    out.write(response.toString().getBytes());
    out.write(body.getBytes());
    out.flush();

    reader.close();
    out.close();
    System.out.println("request complete");
  }

  private doMultiPart(DataInputStream reader, OutputStream out) throws Exception {
    System.out.println("doMultiPart......");
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
        this.boundary = line.substring(line.indexOf("boundary") + 9);
      }
    }

    System.out.println("begin get data......");
  }
}