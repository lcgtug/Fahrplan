package org.lcgtug

import org.neo4j.scala.{EmbeddedGraphDatabaseServiceProvider, Neo4jWrapper}
import java.text.SimpleDateFormat
import org.neo4j.graphdb.{Relationship, Direction, DynamicRelationshipType}

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

    val tt = createNode
    tt.setProperty("name", "Tettnang")

    val rv = createNode
    rv.setProperty("name", "Ravensburg")

    val kn = createNode
    kn.setProperty("name", "Konstanz")

    /**
     * connections
     */
    addConnection(fn --> bus --> tt <, "09:20", "00:17")
    addConnection(fn --> ferry --> kn <, "10:10", "01:10")
    addConnection(fn --> tram --> rv <, "10:30", "00:31")
    addConnection(tt --> tram --> rv <, "12:10", "40:00")
    addConnection(tt --> ferry --> kn <, "08:05", "02:15")
    addConnection(rv --> tram --> kn <, "13:40", "03:47")

  }

  def addConnection(rel:Relationship, startTime:String, duration:String) = {
    rel.setProperty("starttime", startTime)
    rel.setProperty("duration", duration)
  }

}