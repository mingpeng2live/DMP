package com.admaster.dmp;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.NoSuchMessageException;

import com.admaster.dmp.rest.MessageSourceUtils;

/**
 * 控制器父类
 *
 * @author pengming
 * @Date  2015年10月29日 下午3:13:49
 */
public abstract class BaseController {
	
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	
	/**
	 * Retrieve the message for the given code, using the "defaultHtmlEscape" setting.
	 * @param code code of the message
	 * @param defaultMessage String to return if the lookup fails
	 * @return the message
	 */
	public static String getMessage(String code, String defaultMessage) {
		return MessageSourceUtils.getMessage(code, defaultMessage);
	}

	/**
	 * Retrieve the message for the given code, using the "defaultHtmlEscape" setting.
	 * @param code code of the message
	 * @param args arguments for the message, or {@code null} if none
	 * @param defaultMessage String to return if the lookup fails
	 * @return the message
	 */
	public static String getMessage(String code, Object[] args, String defaultMessage) {
		return MessageSourceUtils.getMessage(code, args, defaultMessage);
	}

	/**
	 * Retrieve the message for the given code, using the "defaultHtmlEscape" setting.
	 * @param code code of the message
	 * @param args arguments for the message as a List, or {@code null} if none
	 * @param defaultMessage String to return if the lookup fails
	 * @return the message
	 */
	public static String getMessage(String code, List<?> args, String defaultMessage) {
		return MessageSourceUtils.getMessage(code, args, defaultMessage);
	}

	/**
	 * Retrieve the message for the given code.
	 * @param code code of the message
	 * @param args arguments for the message, or {@code null} if none
	 * @param defaultMessage String to return if the lookup fails
	 * @param htmlEscape HTML escape the message?
	 * @return the message
	 */
	public static String getMessage(String code, Object[] args, String defaultMessage, boolean htmlEscape) {
		return MessageSourceUtils.getMessage(code, args, defaultMessage, htmlEscape);
	}

	/**
	 * Retrieve the message for the given code, using the "defaultHtmlEscape" setting.
	 * @param code code of the message
	 * @return the message
	 * @throws org.springframework.context.NoSuchMessageException if not found
	 */
	public static String getMessage(String code) throws NoSuchMessageException {
		return MessageSourceUtils.getMessage(code);
	}

	/**
	 * Retrieve the message for the given code, using the "defaultHtmlEscape" setting.
	 * @param code code of the message
	 * @param args arguments for the message, or {@code null} if none
	 * @return the message
	 * @throws org.springframework.context.NoSuchMessageException if not found
	 */
	public static String getMessage(String code, Object[] args) throws NoSuchMessageException {
		return MessageSourceUtils.getMessage(code, args);
	}

	/**
	 * Retrieve the message for the given code, using the "defaultHtmlEscape" setting.
	 * @param code code of the message
	 * @param args arguments for the message as a List, or {@code null} if none
	 * @return the message
	 * @throws org.springframework.context.NoSuchMessageException if not found
	 */
	public static String getMessage(String code, List<?> args) throws NoSuchMessageException {
		return MessageSourceUtils.getMessage(code, args);
	}

	/**
	 * Retrieve the message for the given code.
	 * @param code code of the message
	 * @param args arguments for the message, or {@code null} if none
	 * @param htmlEscape HTML escape the message?
	 * @return the message
	 * @throws org.springframework.context.NoSuchMessageException if not found
	 */
	public static String getMessage(String code, Object[] args, boolean htmlEscape) throws NoSuchMessageException {
		return MessageSourceUtils.getMessage(code, args, htmlEscape);
	}

	/**
	 * Retrieve the given MessageSourceResolvable (e.g. an ObjectError instance), using the "defaultHtmlEscape" setting.
	 * @param resolvable the MessageSourceResolvable
	 * @return the message
	 * @throws org.springframework.context.NoSuchMessageException if not found
	 */
	public static String getMessage(MessageSourceResolvable resolvable) throws NoSuchMessageException {
		return MessageSourceUtils.getMessage(resolvable);
	}

	/**
	 * Retrieve the given MessageSourceResolvable (e.g. an ObjectError instance).
	 * @param resolvable the MessageSourceResolvable
	 * @param htmlEscape HTML escape the message?
	 * @return the message
	 * @throws org.springframework.context.NoSuchMessageException if not found
	 */
	public static String getMessage(MessageSourceResolvable resolvable, boolean htmlEscape) throws NoSuchMessageException {
		return MessageSourceUtils.getMessage(resolvable, htmlEscape);
	}
	
}
