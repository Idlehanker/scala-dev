lazy val root = (project in file("."))
  .settings(
    name := "Hello",
    organization := "com.example",
    scalaVersion := "2.12.4",
    version := "0.1.0-SNAPSHOT",
	/*
	//================================================ demo1
    scalacOptions := {
      val out = streams.value // streams task happens-before scalacOptions
      val log = out.log
      log.info("123")
      val ur = update.value   // update task happens-before scalacOptions
      log.info("456")
	  //Note: below tow lines exec error.
      //ur.allConfigurations.take(3)
	  //ur.allConfigurations.take(3).foldLeft[Seq[String]](Nil)((a, b)=>{(b.name::Nil)++:a})
	  
	  //Note: Below lines run correct
	  ur.allConfigurations.map(_.toString)
	  //ur.allConfigurations.take(3).map(_.toString)
    }
	*/
	//================================================demo inline
	scalacOptions := {
		val x = clean.value
		update.value.allConfigurations.take(3).map(_.toString)
	}
  )
