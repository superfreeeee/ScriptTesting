import java.io.*;
import java.net.*;
/**
 * MyServer
 */
public class MyServer {

  public static void main(String[] args) {
    ServerSocket serverSocket = new ServerSocket(8080);
    while(true){
      Socket socket = serverSocket.accept();

      byte[] buf = new byte[1024*1024];
      InputStream in = socket.getInputStream();
      int byteRead = in.read(buf, 0, 1024*1024);
      String data = new String(buf, 0, byteRead);
      System.out.println(data);
      in.close();
      socket.close();
    }
  }
}