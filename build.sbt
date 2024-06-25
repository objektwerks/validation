name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.5.0-RC2"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "3.3.1",
    "org.scalatest" %% "scalatest" % "3.2.18" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
