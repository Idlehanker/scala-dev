import Dependencies._

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.idle",
      scalaVersion := "2.11.8",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "inaction-projx0",
    //libraryDependencies += scalaTest % Test
    libraryDependencies ++= {
      val akkaVersion = "2.4.12"
      Seq(
        "com.typesafe.akka" %% "akka-actor"      % akkaVersion, 
        "com.typesafe.akka" %% "akka-http-core"  % "2.4.11", 
        "com.typesafe.akka" %% "akka-http-experimental"  % "2.4.11", 
        "com.typesafe.akka" %% "akka-http-spray-json-experimental"  % "2.4.11", 
        "com.typesafe.akka" %% "akka-slf4j"      % akkaVersion,
        "ch.qos.logback"    %  "logback-classic" % "1.1.3",
        "com.typesafe.akka" %% "akka-testkit"    % akkaVersion   % "test",
        "org.scalatest"     %% "scalatest"       % "2.2.0"       % "test"
      )

      // val akkaVersion = "2.12.5"
      // val latest = "latest.integration"
      /*
      val latest = "2.12.+"

      Seq(
        "com.typesafe.akka" %% "akka-actor"      % latest, 
        "com.typesafe.akka" %% "akka-http-core"  % latest, 
        "com.typesafe.akka" %% "akka-http-experimental"  % latest, 
        "com.typesafe.akka" %% "akka-http-spray-json-experimental"  % latest, 
        "com.typesafe.akka" %% "akka-slf4j"      % latest,
        "ch.qos.logback"    %%  "logback-classic" % latest,
        "com.typesafe.akka" %% "akka-testkit"    % latest   % "test",
        //"org.scalatest"     %% "scalatest"       % "2.2.0"       % "test"
      )
      */
      
    }
  )

// Assembly settings
// mainClass in assembly := Some("com.idle.Main")

// assemblyJarName in assembly := "goticks.jar"