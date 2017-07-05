name := "item-api"

version := "1.0"

lazy val `item-api` = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.11.6"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  jdbc,
  javaJpa,
  "mysql" % "mysql-connector-java" % "5.1.21",
  "com.h2database" % "h2" % "1.4.194",
  "com.google.code.gson" % "gson" % "2.3.1"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

routesGenerator := InjectedRoutesGenerator
