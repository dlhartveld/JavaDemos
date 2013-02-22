package com.hartveld.demos.cdi.beanvalidation.weld.hibernatevalidator.demo;

import javax.validation.ValidationException;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BeanTest {

	private Weld weld;

	private Bean bean;

	@Before
	public void setUp() {
		weld = new Weld();

		final WeldContainer container = weld.initialize();

		bean = container.instance().select(Bean.class).get();
	}

	@After
	public void tearDown() {
		weld.shutdown();
	}

	@Test(expected = ValidationException.class)
	public void testThatValidationFailureThrowsAnException() {
		bean.doSomething(11);
	}

	@Test
	public void testThatValidationSuccessDoesNotThrowException() {
		bean.doSomething(7);
	}

}
