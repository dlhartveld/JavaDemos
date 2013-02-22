package com.hartveld.demos.cdi.beanvalidation.weld.hibernatevalidator.demo;

import javax.validation.constraints.Max;

/**
 * Interface with parameter pre-conditions annotated on member methods.
 */
public interface Bean {

	/**
	 * Method annotated with bean-validation annotations.
	 * 
	 * @param i
	 *            Must be at most 10.
	 */
	void doSomething(@Max(10) int i);

}
