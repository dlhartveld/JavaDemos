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

	private static final Logger LOG = LoggerFactory.getLogger(BeanValidationTest.class);

	@Test
	public void demonstrationOfFailedValidation() {
		LOG.info("Starting demonstration...");

		Injector injector = Guice.createInjector(new ValidationModule());
		Bean bean = injector.getInstance(Bean.class);

		boolean exceptionWasThrown = false;
		try {

			LOG.info("The following call will be validated, and fails...");
			bean.doSomething(0, 0);

		} catch (ConstraintViolationException e) {

			LOG.info("Validation failed. Test success: {}", e.getMessage(), e);
			exceptionWasThrown = true;

		}
		assertThat(exceptionWasThrown, is(true));

	}

	@Test
	public void demonstrationOfSucceedingValidation() {
		LOG.info("Starting demonstration...");

		Injector injector = Guice.createInjector(new ValidationModule());
		Bean bean = injector.getInstance(Bean.class);

		LOG.info("The following call will be validated, and succeeds...");
		bean.doSomething(20, 5);
	}

}
