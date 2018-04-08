import Dependencies._

enablePlugins(JavaServerAppPackaging)

lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.idle",
      scalaVersion := "2.11.8",
      // scalaVersion := "2.12.4",
      version      := "0.1.0-SNAPSHOT"
    )),
    

    name := "inaction-projx0",
    //libraryDependencies += scalaTest % Test
    libraryDependencies ++= {

      // val akkaVersion = "2.5.0"
      // val akkaHttpVersion = "10.0.6"

      Seq(
        "com.typesafe.akka" %% "akka-actor"      % "2.4.11", 

        "com.typesafe.akka" %% "akka-http-core"  % "2.4.11",  
        "com.typesafe.akka" %% "akka-http-experimental"  % "2.4.11", 
        "com.typesafe.akka" %% "akka-http-spray-json-experimental"  % "2.4.11", 
          
        "com.typesafe.akka" %% "akka-slf4j"       %  "2.4.11",
        "ch.qos.logback"    %  "logback-classic"  % "1.2.3",
        "com.typesafe.akka" %% "akka-testkit"     % "2.5.9"   % "test",
        "org.scalatest"     %% "scalatest"        % "3.0.5"       % "test"
      )
    }
  )

// Assembly settings
mainClass in assembly := Some("com.idle.Main")
assemblyJarName in assembly := "goticks.jar"