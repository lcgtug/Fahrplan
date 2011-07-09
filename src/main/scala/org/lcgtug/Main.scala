package org.lcgtug

import org.neo4j.scala.{EmbeddedGraphDatabaseServiceProvider, Neo4jWrapper}
import org.neo4j.graphdb.{Direction, DynamicRelationshipType}
import java.text.SimpleDateFormat

/**
 *
 * @author Christopher Schmidt
 * Date: 09.07.11
 * Time: 12:08
 */

object Main extends App with Neo4jWrapper with EmbeddedGraphDatabaseServiceProvider {

  def neo4jStoreDir = "/tmp/temp-neo-test"

  Runtime.getRuntime.addShutdownHook(new Thread() {
    override def run() {
      ds.gds.shutdown
    }
  })

  withTx {
    implicit neo =>

    /*val start = createNode

    val end = createNode
    val relType = DynamicRelationshipType.withName("foo")

    val r = start --> relType --> end <

    r.setProperty("blah", "blsh")

    println(r.getProperty("blah"))*/

    /**
     * Rel Types
     */

    val bus = DynamicRelationshipType.withName("BUS")
    val tram = DynamicRelationshipType.withName("TRAM")
    val ferry = DynamicRelationshipType.withName("FERRY")

    /**
     * Orte
     */

    val fn = createNode
    fn.setProperty("name", "Friedrichshafen")

    val tettnang = createNode
    tettnang.setProperty("name", "Tettnang")

    val rv = createNode
    rv.setProperty("name", "Ravensburg")

    val ulm = createNode
    ulm.setProperty("name", "Ulm")

    /**
     * connections
     */
    val busFnUlm = fn --> bus --> ulm <
    busFnUlm.setProperty("starttime", "09:20")
  }

}