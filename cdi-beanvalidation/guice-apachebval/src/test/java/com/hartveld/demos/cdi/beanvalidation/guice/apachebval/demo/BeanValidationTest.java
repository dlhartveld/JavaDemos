package com.hartveld.demos.cdi.beanvalidation.guice.apachebval.demo;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.validation.ConstraintViolationException;

import org.apache.bval.guice.ValidationModule;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class BeanValidationTest {

	private static final Logger logger = LoggerFactory
			.getLogger(BeanValidationTest.class);

	@Test
	public void demonstration() {

		logger.info("Starting demonstration...");

		Injector injector = Guice.createInjector(new ValidationModule());
		Bean bean = injector.getInstance(Bean.class);

		boolean exceptionWasThrown = false;
		try {

			logger.info("The following call will be validated, and fails...");
			bean.doSomething(0, 0);

		} catch (ConstraintViolationException e) {

			logger.info("Validation failed. Test success!");
			exceptionWasThrown = true;

		}
		assertThat(exceptionWasThrown, is(true));

	}

}
