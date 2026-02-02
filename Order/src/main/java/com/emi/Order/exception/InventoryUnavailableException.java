package com.emi.order.exception;

public class InventoryUnavailableException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}