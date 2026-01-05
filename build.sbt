name := "validation"
organization := "objektwerks"
version := "0.12-SNAPSHOT"
scalaVersion := "3.8.0-RC5"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "4.4.2-RC2",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wunused:all"
)
