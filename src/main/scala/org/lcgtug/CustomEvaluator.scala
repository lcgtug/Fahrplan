package org.lcgtug

import org.neo4j.graphalgo.CostEvaluator
import org.neo4j.graphdb.{Relationship, Direction}
import java.text.SimpleDateFormat

/**
 * Created by IntelliJ IDEA.
 * User: nkuebler
 * Date: 7/9/11
 * Time: 4:43 PM
 * To change this template use File | Settings | File Templates.
 */

class CustomEvaluator extends CostEvaluator[java.lang.Double] {
  def getCost(relationship: Relationship, direction: Direction): java.lang.Double = {
    val date = new SimpleDateFormat("HH:mm").parse(relationship.getProperty("duration").asInstanceOf[String])
    date.getTime() / 1000;
  }
}