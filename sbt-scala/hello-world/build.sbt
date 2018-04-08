import Dependencies._

lazy val commonSettings = Seq(
  organization := "com.example",
  version := "0.1.0",
  // scalaVersion := "2.12.4"
  scalaVersion := "2.12.5"
)

lazy val root = (project in file("."))
.settings(
    commonSettings,
    //other settings
    name := "Hello",
    libraryDependencies += scalaTest % Test
  )
