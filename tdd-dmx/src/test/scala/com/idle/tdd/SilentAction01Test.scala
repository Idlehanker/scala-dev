package com.idle.tdd

import org.scalatest.{ WordSpecLike, MustMatchers }
import akka.testkit.TestKit

import akka.actor._

class SilentAction01Test extends TestKit(ActorSystem("testsystem"))
  with WordSpecLike
  with MustMatchers
  with TerminalAfterAll{

    "A Silent Actor" must {
      "change state when it receives a message, single threaded" ignore {
        fail("not implemented yet")
      }
      "change state when it receives a message, multi-threaded" ignore {
        fail("not implemented yet")
      }
    }
}

class SilentActor extends Actor{
  def receive = {
    case msg =>
  }
}
