package com.revature.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

	@Component(value = "aspect")
	@Aspect
	public class LoggingAspect {

		private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);
	
		
		@Pointcut("within(com.revature.controller.*)") 
		public void allControllerPointCut() {
		}
		
		@Pointcut("within(com.revature.service.*)")
		public void allServicePointCut() {
			
		}
		
	
		@Before(value = "allControllerPointCut()") 
		public void logBefore(JoinPoint jp) { 

			
			LOG.info("The " + jp.getSignature().getName() + " method is going to be invoked!");
		}
		
		@After(value = "allServicePointCut()") 
		public void logAfter(JoinPoint jp) {
			
			LOG.info("The " + jp.getSignature().getName() + " method has been invoked!");
		}
		
		@AfterReturning(value = "allServicePointCut()", returning = "returnedValue") //This AfterReturning advice is injected after
		//a method returns.
		public void logAfterReturning(JoinPoint jp, Object returnedValue) {
			
			LOG.info("The " + jp.getSignature().getName() + " method has been invoked and it returned " + returnedValue + "!");
		}
		
		
		@AfterThrowing(value = "allControllerPointCut()", throwing = "thrownException") //This AfterThrowing advice is injected after
		//a method throws an exception.
		public void logAfterThrowingException(JoinPoint jp, Exception thrownException) {
			
			LOG.info("The " + jp.getSignature().getName() + " method has been invoked and it just threw a " + thrownException + "!");
		}
	
	
	}

