lazy val projA = (project in file("a"))
    .settings(
        name := {
            "foo-" + (packageBin / scalaVersion).value
        },
        scalaVersion := "2.12.5"
    )