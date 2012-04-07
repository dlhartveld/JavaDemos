package com.hartveld.demos.cdi.beanvalidation.guice.apachebval.demo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.apache.bval.guice.Validate;

public class BeanImpl implements Bean {

	@Override
	@Validate
	public void doSomething(@Min(10) int x, @Max(10) int y) {

	}

}
