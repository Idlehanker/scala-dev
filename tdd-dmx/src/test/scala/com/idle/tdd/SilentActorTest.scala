package com.idle.tdd

import org.scalatest.WordSpecLike
import org.scalatest.MustMatchers


import akka.testkit.{ TestActorRef, TestKit }
import akka.actor._

package silentactor2{

class SilentActorTest extends TestKit(ActorSystem("testsystem"))
  with WordSpecLike
  with MustMatchers
  with TerminalAfterAll{

    "A Silent Actor " must {
      "change internal state when it receives a message, single " in {

        import SilentActor._

        val silentActor = TestActorRef[SilentActor]
        silentActor ! SilentMessage("whisper")
        silentActor.underlyingActor.state must (contain("whisper"))

      }
    }
  }

object SilentActor {
  case class SilentMessage(data: String)
}

class SilentActor extends Actor{

  var internalState = Vector[String]()

  import SilentActor._
  def receive = {

    case SilentMessage(data) => {
      internalState  = internalState :+ data
    }
  }
  def state = internalState
}
}
