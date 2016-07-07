package mybatis.exception;

/**
 * Created by jiaranran on 2016/7/4.
 */
public class CustomException extends Exception {
    private String message;
    public CustomException(String message) {
        super(message);
        this.message=message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
