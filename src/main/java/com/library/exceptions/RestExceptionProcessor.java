/*
 * 
 */
package com.library.exceptions;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.library.constants.*;

/**
 * The Class RestExceptionProcessor.
 */
@ControllerAdvice
public class RestExceptionProcessor {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionProcessor.class);
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;
	
	/**
	 * Library exception.
	 *
	 * @param ex the ex
	 * @return the message info
	 */
	@ExceptionHandler(LibraryException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ResponseBody
	public MessageInfo proctorException(LibraryException ex) {
		String errorMessage = null;
		Locale locale = LocaleContextHolder.getLocale();
		errorMessage = messageSource.getMessage(ex.getErrorCode(),new String [] {ex.getParameterList()}, locale);
		LOGGER.error(ex.getErrorCode() + " Exception cause: "+ex.getParameterList());
		return new MessageInfo(AppConstants.FAILURE, errorMessage);
	}

	/**
	 * Handle exception.
	 *
	 * @param req the req
	 * @param ex the ex
	 * @return the message info
	 */
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public MessageInfo handleException(HttpServletRequest req, Exception ex) {
		LOGGER.error(ex.getCause() + " " +ex.getMessage());
		return new MessageInfo(AppConstants.FAILURE, AppConstants.FAILURE);
	}
}
