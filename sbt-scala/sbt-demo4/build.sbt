lazy val root = (project in file("."))
    .settings(
        inThisBuild(
            List(
                organization := "com.idle",
                scalaVersion := "2.12.5",
                version := "1.0"
            )
        ),
        name := "sbt-demo4",
        publish := ((): Unit),
        publishLocal := ((): Unit)
    )

    lazy val core = (project in file("core"))
        .settings(
            // other setttings
        )

    lazy val util = (project in file("util"))
        .settings(
            // other settings
        )