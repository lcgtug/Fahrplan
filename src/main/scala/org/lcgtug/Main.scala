package org.lcgtug

import org.neo4j.scala.{EmbeddedGraphDatabaseServiceProvider, Neo4jWrapper}
import org.neo4j.graphdb.{Direction, DynamicRelationshipType}

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
    val start = createNode
    val end = createNode
    val relType = DynamicRelationshipType.withName("foo")
    start --> relType --> end
  }

  println("Hello LCGTUG Hackathon")
}