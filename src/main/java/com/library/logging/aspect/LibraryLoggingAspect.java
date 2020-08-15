/*
 * 
 */
package com.library.logging.aspect;

import java.time.Duration;
import java.time.Instant;

import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * The Class LibraryLoggingAspect.
 */
@Aspect
@Component
public class LibraryLoggingAspect {

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(LibraryLoggingAspect.class);

	/** The Constant ARG_SEPARATOR. */
	private static final String ARG_SEPARATOR = ".";
	
	/** The Constant START_MESSAGE. */
	private static final String START_MESSAGE = "%s execution starts %s";
	
	/** The Constant END_MESSAGE. */
	private static final String END_MESSAGE = "%s execution ends in %d ms";
	
	/** The Constant FAIL_MESSAGE. */
	private static final String FAIL_MESSAGE = "Method %s execution failed";

	/**
	 * Service methods.
	 */
	@Pointcut("execution(public * com.library.service.*.*(..))")
	public void serviceMethods() {
	}

	/**
	 * Dao methods.
	 */
	@Pointcut("execution(public * com.library.dao.*.*(..))")
	public void daoMethods() {
	}

	/**
	 * Util methods.
	 */
	@Pointcut("execution(public * com.library.utils.*.*(..))")
	public void utilMethods() {
	}

	/**
	 * Log method success trace.
	 *
	 * @param proceedingJoinPoint the proceeding join point
	 * @return the object
	 * @throws Throwable the throwable
	 */
	@Around("serviceMethods() || daoMethods() || utilMethods()")
	public Object logMethodSuccessTrace(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

		String methodName = getMethodName(proceedingJoinPoint);
		Object[] args = proceedingJoinPoint.getArgs();
		StringBuilder argInfo = new StringBuilder();

		if (ArrayUtils.isNotEmpty(args)) {
			argInfo.append("with agrs ");
			for (int i = 0; i < args.length; i++) {
				argInfo.append("arg" + i + "=" + args[i] + ",");
			}
		}

		String startMessage = String.format(START_MESSAGE, methodName, argInfo.toString());

		LOGGER.info(startMessage);
		Instant startTime = Instant.now();
		Object returnVal = proceedingJoinPoint.proceed();
		Instant endTime = Instant.now();
		long duration = Duration.between(startTime, endTime).toMillis();

		String endMessage = String.format(END_MESSAGE, methodName, duration);
		LOGGER.info(endMessage);
		return returnVal;
	}

	/**
	 * Log method fail trace.
	 *
	 * @param joinPoint the join point
	 * @param th the th
	 */
	@AfterThrowing(value = "serviceMethods() || daoMethods() || utilMethods()", throwing = "th")
	public void logMethodFailTrace(JoinPoint joinPoint, Throwable th) {

		String methodName = getMethodName(joinPoint);
		String failMessage = String.format(FAIL_MESSAGE, methodName);
		LOGGER.error(failMessage);
	}

	/**
	 * Gets the method name.
	 *
	 * @param proceedingJoinPoint the proceeding join point
	 * @return the method name
	 */
	private String getMethodName(JoinPoint proceedingJoinPoint) {
		String className = proceedingJoinPoint.getSignature().getDeclaringType().getSimpleName();
		String methodName = proceedingJoinPoint.getSignature().getName();

		return className + ARG_SEPARATOR + methodName;
	}

}
