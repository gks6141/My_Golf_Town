package com.MyGolfTown.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Aspect // 부가 기능 정의(advice) + 어디에 적용(pointcut)
//싱글턴 구조
public class TimeTraceAop {
	
	//@Around("execution(* com.MyGolfTown..*(..))") // 패키지 범위 ==> 어디에 적용(pointcut)
	@Around("@annotation(TimeTrace)") // 어느 어노테이션이 붙어있을 때 수행?
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		// 시간 측정
		StopWatch sw = new StopWatch();
		sw.start();
		
		Object proceedObj = joinPoint.proceed();  // 본래 할 일 수행
		
		sw.stop();
		
		log.info("######## 실행시간(ms):" + sw.getTotalTimeMillis());
		log.info(sw.prettyPrint());
		return proceedObj;
		
	}
}
