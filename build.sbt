name := "validation"
organization := "objektwerks"
version := "0.12-SNAPSHOT"
scalaVersion := "3.6.2-RC3"
libraryDependencies ++= {
  Seq(
    "com.lihaoyi" %% "ujson" % "4.0.2",
    "org.scalatest" %% "scalatest" % "3.2.19" % Test
  )
}
scalacOptions ++= Seq(
  "-Wall"
)
