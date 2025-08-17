package com.sulvic.mcf.util;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR})
/**
 * Used to mark any class, method, field, or parameter as incomplete in terms of implementation.
 */
public @interface Incomplete{}
