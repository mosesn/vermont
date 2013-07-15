import sbt._
import Keys._

object Vermont extends Build {

  val sharedSettings = Seq(
    name := "vermont",
    organization := "com.mosesn",
    version := "0.0.1-SNAPSHOT",
    scalaVersion := "2.10.2",
    crossScalaVersions := Seq("2.9.3", "2.10.2")
  )

  lazy val vermont = Project(
    id = "vermont",
    base = file(".")
  )
  .settings(sharedSettings: _*)
  .aggregate(core)

  lazy val core = Project(
    id = "vermont-core",
    base = file("vermont-core")
  )
  .settings(sharedSettings: _*)
}
