package com.hartveld.demos.cdi.beanvalidation.weld.hibernatevalidator.demo;

import org.jboss.seam.validation.AutoValidating;

/**
 * Bean that must be automatically validated by Seam Validation.
 * <p>
 * Note that the {@link AutoValidating} annotation is required on the
 * <b>implementing</b> class.
 */
@AutoValidating
public class BeanImpl implements Bean {

	/**
	 * Method whose parameters are automatically checked against the contract,
	 * because of the bean-validation annotations on the {@link Bean} interface.
	 * 
	 * @see Bean#doSomething(int)
	 */
	@Override
	public void doSomething(int i) {

	}

}
