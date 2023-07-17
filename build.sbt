name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.1-RC4"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "3.1.2",
    "org.scalatest" %% "scalatest" % "3.2.16" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
