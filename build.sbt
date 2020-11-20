name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.0.0-M1"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" % "ujson_2.13" % "1.2.2" % Test,
    "org.scalameta" %% "munit" % "0.7.18" % Test
  )
}
testFrameworks += new TestFramework("munit.Framework")
parallelExecution in Test := false
semanticdbEnabled := true