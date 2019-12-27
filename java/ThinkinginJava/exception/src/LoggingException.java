import java.util.logging.*;
import java.io.*;

public class LoggingException extends Test{
  private static Logger logger = Logger.getLogger("LoggingException");
  public static void logException(Exception e){
    StringWriter trace = new StringWriter();
    e.printStackTrace(new PrintWriter(trace));
    logger.severe(trace.toString());
  }

  public void go(){
    System.out.println("\ntest:");
    try{
      throw new NullPointerException();
    }catch(Exception e){
      LoggingException.logException(e);
    }
  }
}