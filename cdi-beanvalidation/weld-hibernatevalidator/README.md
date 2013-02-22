# README for CDI / Bean Validation with Weld, Hibernate Validator and Seam Validation

This project demonstrates Bean Validation with CDI, based on Hibernate Validator and Weld. The glue between Weld and
Hibernate Validator, i.e, the interceptor that does the actual method parameter checks, is provided by the Seam
Validation module. Unfortunately, class invariants other than annotations on fields are not yet supported. (This could also be implemented with an
interceptor that executes a method annotated with e.g. @Invariant.)

## What do you need?

* Maven dependencies on weld-se-core and seam-validation as declared in the POM.
* An interface Bean, with methods annotated with javax.validation.constraint.* annotations.
* An implementor BeanImpl of Bean, annotated with @org.jboss.seam.validation.AutoValidating to mark it for actual validation.
* A beans.xml in META-INF with an interceptor definition for org.jboss.seam.validation.ValidationInterceptor.

See the actual files in this project for more details.
	