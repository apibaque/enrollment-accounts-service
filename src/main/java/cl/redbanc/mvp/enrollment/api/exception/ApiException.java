package cl.redbanc.mvp.enrollment.api.exception;

public class ApiException extends Exception {

	private static final long serialVersionUID = -6252221927148878522L;
	
	private int code;

	public ApiException(int code, String msg) {
		super(msg);
		setCode(code);
	}

	/**
	 * @return the code
	 */
	public int getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(int code) {
		this.code = code;
	}

}
