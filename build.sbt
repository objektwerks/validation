name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.2.1"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "2.0.0" % Test,
    "org.scalatest" %% "scalatest" % "3.2.14" % Test
  )
}
