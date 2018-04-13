package com.idle.tdd

import org.scalatest.{ Suite, BeforeAndAfterAll }
// import akka.testkit.Testkit
import akka.testkit.TestKit

trait TerminalAfterAll extends BeforeAndAfterAll {
  this: TestKit with Suite =>
  override protected def afterAll(): Unit = {

    super.afterAll()
    system.terminate()
  }
}
