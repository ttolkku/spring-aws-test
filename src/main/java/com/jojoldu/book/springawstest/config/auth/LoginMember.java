package com.jojoldu.book.springawstest.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어노테이션이 생성될 수 있는 위치지정
//메소드의 파라티머로 선언된 객체에서만 사용
//클래스 선언문에 쓸수 있는 TYPE 등
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
//어노테이션 클래스
public @interface LoginMember {
}
