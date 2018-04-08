
val scalacOptions = taskKey[Seq[String]]("Options for the Scala compiler.")
val checksums = settings[Seq[String]]("The list of checksums to generate and to verify for dependencies.")

lazy val root = (project in file("."))
.settings(
    name := "sbt-demo2",
    organization := "com.idle",
    scalaVersion := "2.12.5",
    version := "0.1",
    scalacOptions := List(
        "-encoding",
        "utf-8",
        "-Xfatal-warnings",
        "-deprecation",
        "-unchecked"
    ),
    scalacOptions := {
        val old = scalacOptions.value
        scalaBinaryVersion.value match {
            case "2.12" => old
            case _ => old filterNot (Set(
                "-Xfatal-warnings",
                "-deprecation"
            ).apply)
        }
    }
)