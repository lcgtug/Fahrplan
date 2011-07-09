package org.lcgtug

import org.neo4j.graphdb._
import collection.JavaConversions._

/**
 * Created by IntelliJ IDEA.
 * User: nkuebler
 * Date: 7/9/11
 * Time: 4:34 PM
 * To change this template use File | Settings | File Templates.
 */

class CustomExpander(val direction:Direction = Direction.OUTGOING) extends org.neo4j.graphdb.RelationshipExpander {

  def expand(node: Node): java.lang.Iterable[Relationship] = {
    val relations = node.getRelationships(direction)
    // TODO nur Kanten zurueck geben die auch moeglich sind
    return relations
  }

  def reversed: RelationshipExpander = {
       return new CustomExpander(Direction.INCOMING)
  }
}