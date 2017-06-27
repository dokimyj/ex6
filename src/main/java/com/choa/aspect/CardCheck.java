package com.choa.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect //이 클래스가 공통 로직이냐 핵심 로직이냐 하는 내용을 구분해줌
public class CardCheck {
	
	@Before("execution(* com.choa.aspect..Trip.*())") //Trip클래스의 메소드들 실행 전에 이 메소드를 실행하겠다는 Annotation
	public void reservation(){
		System.out.println("예약하기");
		System.out.println("======================");
	}
	
	@Around("execution(* com.choa.aspect..Transport.*())") //Transport클래스의 메소드들 실행 전후로 이 메소드를 실행하겠다는 Annotation
	public void check(ProceedingJoinPoint join){ //메소드를 한 번 파싱하는 ProceedingJoinPoint클래스를 매개변수로 받음
		//여기서 ProceedingJoinPoint객체는 프록시의 역할을 하며, 역으로 이 메소드가 호출되는 클래스를 메소드 안으로 가져와서 실행해버리는 역할을 함.
		System.out.println("Card Check-In");
		Object obj=null;
		try{
			obj=join.proceed();
		}catch(Throwable e){
		}
		System.out.println("Card Check-Out");
	}
}
