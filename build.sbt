name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.0.0-RC3"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" % "ujson_2.13" % "1.2.3" % Test,
    "org.scalatest" %% "scalatest" % "3.2.8" % Test
  )
}