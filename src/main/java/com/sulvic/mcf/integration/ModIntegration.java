package com.sulvic.mcf.integration;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.*;

@Retention(RUNTIME)
@Target(TYPE)
public @interface ModIntegration{

	String[] value();

}
