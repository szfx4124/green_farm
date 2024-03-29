package cn.nchu.green_farm.controller.exception;
/**
 * 上传文件超出限制的异常
 */
public class FileSizeOutOfLimitException extends FileUploadException {

	private static final long serialVersionUID = -8449983418301878109L;

	public FileSizeOutOfLimitException() {
		super();
	}

	public FileSizeOutOfLimitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public FileSizeOutOfLimitException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileSizeOutOfLimitException(String message) {
		super(message);
	}

	public FileSizeOutOfLimitException(Throwable cause) {
		super(cause);
	}

}
