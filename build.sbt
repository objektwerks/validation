name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.1.1-RC1"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "1.4.3" % Test,
    "org.scalatest" %% "scalatest" % "3.2.10" % Test
  )
}