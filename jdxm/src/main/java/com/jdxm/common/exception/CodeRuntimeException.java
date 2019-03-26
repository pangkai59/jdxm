package com.jdxm.common.exception;


public class CodeRuntimeException extends RuntimeException {

    private String code;

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public CodeRuntimeException(String code,String message) {
        super(message);
        this.code = code;
    }
    public CodeRuntimeException(Integer code,String message) {
        super(message);
        this.code = code.toString();
    }

    public String getCode() {
        return code;
    }
    @Override
    public String toString() {
        return String.format("%s@[code=%s, message=%s]", getClass().getName(), code, getMessage());
    }
}
