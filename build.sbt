name := "item-api"

version := "1.0"

lazy val `item-api` = (project in file(".")).enablePlugins(PlayJava, PlayEbean)

scalaVersion := "2.12.2"

libraryDependencies ++= Seq(
  javaJdbc,
  ehcache,
  javaWs,
  guice,
  jdbc,
  "mysql" % "mysql-connector-java" % "5.1.18",
  "com.h2database" % "h2" % "1.4.194"
)

unmanagedResourceDirectories in Test <+=  baseDirectory ( _ /"target/web/public/test" )  

resolvers += "scalaz-bintray" at "https://dl.bintray.com/scalaz/releases"

routesGenerator := InjectedRoutesGenerator
