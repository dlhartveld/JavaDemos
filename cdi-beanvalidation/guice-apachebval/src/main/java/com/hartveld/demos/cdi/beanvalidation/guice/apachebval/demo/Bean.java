package com.hartveld.demos.cdi.beanvalidation.guice.apachebval.demo;

import com.google.inject.ImplementedBy;

@ImplementedBy(BeanImpl.class)
public interface Bean {

	void doSomething(int x, int y);

}
