package org.neo4j.scala.so;

/**
 * @author Christopher Schmidt
 *         Date: 11.05.11
 *         Time: 06:34
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface geo {
    
}