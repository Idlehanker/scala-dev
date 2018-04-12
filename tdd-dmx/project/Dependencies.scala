import sbt._

object Dependencies {

  // lazy val akkaVersion = "2.5.11"
  // lazy val akka = Seq(
  //     "com.typesafe.akka" %% "akka-actor"   % akkaVersion,
  //     "org.scalatest"     %% "scalatest"    % "3.0.5"       % Test,
  //     "com.typesafe.akka" %% "akka-testkit" % akkaVersion   % Test,
  //     "com.typesafe.akka" %%  "akka-slf4j"  % akkaVersion,
  //   )
  lazy val akkaVersion = "2.4.19"
  lazy val akka = Seq(
      "com.typesafe.akka" %% "akka-actor"   % akkaVersion,
      "org.scalatest"     %% "scalatest"    % "3.0.0"       % Test,
      "com.typesafe.akka" %% "akka-testkit" % akkaVersion   % Test,
      "com.typesafe.akka" %%  "akka-slf4j"  % akkaVersion,
    )
}
