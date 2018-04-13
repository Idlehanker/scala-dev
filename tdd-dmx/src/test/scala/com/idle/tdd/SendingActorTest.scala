package com.idle.tdd

import akka.testkit.TestKit
import akka.actor._

import org.scalatest.{WordSpecLike, MustMatchers}

class SendingTest
    extends TestKit(ActorSystem("testsystem"))
    with WordSpecLike
    with MustMatchers
    with TerminalAfterAll {
  "A sending actor" must {
    "send a message to another actor when it process finished " in {

      val sendingActor =
        system.actorOf(SendingActor.props(testActor), "sendingActor")

      val size = 10
      val maxInclusive = 1000000

      import scala.util.Random
      import SendingActor._

      def randomEvents() =
        (0 until size).map { _ =>
          Event(Random.nextInt(maxInclusive))
        }.toVector

      val unsorted = randomEvents()

      sendingActor ! SortEvents(unsorted)
      expectMsgPF() {
        case SortedEvents(events) =>
          events.size must be(size)
          unsorted.sortBy(_.id) must be(events)
      }
    }
  }
}

object SendingActor {
  // val actor  = system.actorOf(Props[SendingActor],"sIII")
  // def props = new Props()
  def props(receiver: ActorRef) = Props(new SendingActor(receiver))

  case class Event(id: Long)

  case class SortEvents(unsorted: Vector[Event])
  case class SortedEvents(sorted: Vector[Event])

}
class SendingActor(receiver: ActorRef) extends Actor {

  import SendingActor._

  def receive = {
    case SortEvents(unsorted) =>
      receiver ! SortedEvents(unsorted.sortBy(_.id))
  }
}
