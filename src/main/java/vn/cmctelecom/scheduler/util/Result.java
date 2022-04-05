package vn.cmctelecom.scheduler.util;
import org.apache.http.HttpStatus;

/**
 * @author sang.nq
 * define code http status
 */
public enum Result implements HttpStatus {
	SUCCESS(1, "Success"),
	UNAUTHORIZED(401, "Unauthorized"),
	TOKEN_EXPIRE_TIME(401, "Token expire time"),
	BAD_REQUEST(400, "Bad request"),
	FORBIDDEN(403, "Forbidden"),
	NOT_FOUND(404, "Api not found"),
	METHOD_NOT_ALLOW(405, "Method not allow"),
	NO_CONTENT(204, "No content"),
    SERVER_ERROR(500, "500 Internal server error"),
    PASSWORD_ERROR(501, "Password does not match."),
    SCHEDULE_ERR_ONRUNING(502, "Schedule running"),
    SCHEDULE_ERR_OFF(503, "Schedule off");

	private int code;
	private String message;

	Result(int code, String message){
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isSuccess() {
		return (this.code==1);
	}

}
