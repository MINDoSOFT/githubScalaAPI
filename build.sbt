name := "githubScalaAPI"

version := "0.1"

scalaVersion := "2.9.1"

libraryDependencies ++= Seq(
  "net.liftweb" % "lift-json_2.9.1" % "2.4"
)

mainClass in (Compile, run) := Some("com.github.mindosoft.githubScalaAPI.Gists")
