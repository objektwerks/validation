name := "scala3.validator"
organization := "objektwerks"
version := "0.4-SNAPSHOT"
scalaVersion := "3.5.1-RC2"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "4.0.1",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)