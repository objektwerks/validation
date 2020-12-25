name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.0.0-M3"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" % "ujson_2.13" % "1.2.2" % Test,
    "org.scalameta" %% "munit" % "0.7.20" % Test,
    "org.scalatest" %% "scalatest" % "3.2.3" % Test
  )
}
testFrameworks += new TestFramework("munit.Framework")
parallelExecution in Test := false