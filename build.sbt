name := "validation"
organization := "objektwerks"
version := "0.12-SNAPSHOT"
scalaVersion := "3.7.4"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "4.4.1",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
