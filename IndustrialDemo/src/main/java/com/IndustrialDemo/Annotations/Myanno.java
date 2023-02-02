package com.IndustrialDemo.Annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@interface Myanno{
	
	int myvalue() default 0;
	
	String myname() default "bhuva";
	
	String mycity() default "jetpur";
} 
