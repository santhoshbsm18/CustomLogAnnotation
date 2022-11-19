package com.example.demo.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Aspect
@Component
public class Advice {

	private static final Logger log = LoggerFactory.getLogger(Advice.class);
	
	
	@Around("@annotation(com.example.demo.annotation.LogRequest)")
	public Object printRequestLog(ProceedingJoinPoint pjp) throws Throwable {
	    LogRequest lr =  ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(LogRequest.class);
	    if(lr.value())
	    	log.info("Logging Request : " + JsonMapper.builder().addModule(new JavaTimeModule()).build().writeValueAsString(pjp.getArgs()));
		return pjp.proceed();
	}
}
