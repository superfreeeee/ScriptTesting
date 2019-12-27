import lombok.Data;

@Data
public class SimpleResponse {

  private int code;

  private String status;

  private String message;

  protected SimpleResponse(int code, String status, String message) {
    this.code = code;
    this.status = status;
    this.message = message;
  }

  public static SimpleResponse ok(String message) {
    return new SimpleResponse(ResponseCode.SUCCESS, "success", message);
  }

  public static SimpleResponse error(String message) {
    return new SimpleResponse(ResponseCode.ERROR, "error", message);
  }
}


