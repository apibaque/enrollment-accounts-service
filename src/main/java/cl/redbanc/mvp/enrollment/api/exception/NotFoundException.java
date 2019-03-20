package cl.redbanc.mvp.enrollment.api.exception;

public class NotFoundException extends ApiException {

	private static final long serialVersionUID = -2954739044714494944L;

	public NotFoundException(int code, String msg) {
		super(code, msg);
		setCode(code);
	}

}
