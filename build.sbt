name := "scala3.validator"
organization := "objektwerks"
version := "0.1-SNAPSHOT"
scalaVersion := "3.3.2-RC1"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "3.1.3",
    "org.scalatest" %% "scalatest" % "3.2.17" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
