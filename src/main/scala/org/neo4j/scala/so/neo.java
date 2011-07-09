package org.neo4j.scala.so;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * Defines a persistent field, including primitive types or arrays of primitives,
 * complex types, and collections of complex types.  (Arrays of complex types are not
 * supported).
 *
 * @author Taylor Cowan
 *
 */
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface neo {
	public static final String DEFAULT = "default";

	/**
	 * If the value is specified, the node property or relationship
	 * will be named accordingly.  Defaults to the qualified field name.
	 *
	 * @return
	 */
	String value() default DEFAULT;

	/**
	 * If true the field will be indexed by jo4neo.
	 * It is the client's responsibility to ensure uniqueness, as jo4neo
	 * allows multiple entities to be indexed against a single value.  Defaults
	 * to false.
	 * @return
	 */
	boolean index() default false;

	/**
	 * Name of a relationship for which this field acts as inverse.
	 * All incoming edges with the same name will be treated as if they
	 * were outgoing.
	 *
	 * @return
	 */
	String inverse() default DEFAULT;

//	/**
//	 * Declares a {@link TraverserProvider} from which the field (of type Collection)
//	 * will be generated.
//	 *
//	 * @return
//	 */
//	Class<? extends TraverserProvider> traverser() default DefaultTraverserProvider.class;
//
//	/**
//	 * If true jo4neo manages a list of instances in most recent order.
//	 *
//	 * @see ObjectGraph#getMostRecent(Class, int)
//	 */
	boolean recency() default false;

	boolean fulltext() default false;
}