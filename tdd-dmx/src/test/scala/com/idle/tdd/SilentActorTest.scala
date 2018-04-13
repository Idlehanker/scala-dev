package com.idle.tdd

import org.scalatest.WordSpecLike
import org.scalatest.MustMatchers

import akka.testkit.{TestActorRef, TestKit}
import akka.actor._

package silentactor2 {

  class SilentActorTest
      extends TestKit(ActorSystem("testsystem"))
      with WordSpecLike
      with MustMatchers
      with TerminalAfterAll {

    "A Silent Actor " must {
      "change internal state when it receives a message, single " in {

        import SilentActor._

        val silentActor = TestActorRef[SilentActor]
        silentActor ! SilentMessage("whisper")
        silentActor.underlyingActor.state must (contain("whisper"))

        silentActor ! SilentMessage("whisper1")
        silentActor.underlyingActor.state must (contain("whisper1"))
      }
    }
  }

  object SilentActor {
    case class SilentMessage(data: String)
    case class GetState(receiver: ActorRef)
  }

  class SilentActor extends Actor {

    var internalState = Vector[String]()

    import SilentActor._
    def receive = {

      case SilentMessage(data) => {
        internalState = internalState :+ data
      }
      case GetState(receiver) => receiver ! internalState
    }
    def state = internalState
  }
}

package silentpackage2 {
  class SilentActorTest
      extends TestKit(ActorSystem("actorsystem"))
      with WordSpecLike
      with MustMatchers
      with TerminalAfterAll {
    "A Silent Actor " must {
      "change internal state when it recieves a message, multi " in {

        import SilentActor._
        val silentActor = system.actorOf(Props[SilentActor], "s3")
        silentActor ! SilentMessage("whister1")
        silentActor ! SilentMessage("whister2")

        silentActor ! GetState(testActor)
        expectMsg(Vector("whister1", "whister2"))
      }
    }
  }
  object SilentActor {
    case class SilentMessage(message: String)
    case class GetState(reciver: ActorRef)
  }
  class SilentActor extends Actor {
    
    import SilentActor._
    var internalState = Vector[String]()

    def receive = {
      case SilentMessage(data) =>
        internalState = internalState :+ data

      case GetState(receiver) =>
        receiver ! internalState
    }
  }
}
