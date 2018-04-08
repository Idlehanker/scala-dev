resolvers += Classpaths.typesafeReleases

resolvers += Resolver.url("bintray-sbt-plugins", url("https://dl.bintray.com/eed3si9n/sbt-plugins/"))(Resolver.ivyStylePatterns)
// addSbtPlugin("com.eed3si9n" %% "sbt-assembly" % "0.13.0")
addSbtPlugin("com.eed3si9n" %% "sbt-assembly" % "0.14.6")

// addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.0.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.3.4")
