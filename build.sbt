name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.0-RC6"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "3.1.0",
    "org.scalatest" %% "scalatest" % "3.2.15" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
