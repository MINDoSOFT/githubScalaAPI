GithubScalaAPI
==============

This Scala library uses the [github API v3] (http://developer.github.com/v3/) 
to access information on Github.

The information is in JSON format which is parsed using [lift_json] (https://github.com/lift/framework/tree/master/core/json).

Currently Supported Operations:
------------------------------
* List a user's gists
* Get a single gist

Installation
------------

*    Add this to project/build.scala 
`import sbt._
object MyApp extends Build
{
  lazy val root =
    Project("root", file(".")) dependsOn(githubScalaAPI)
  lazy val githubScalaAPI =
    uri("git://github.com/MINDoSOFT/githubScalaAPI")
}`

*    From your scala file do
`import com.github.mindosoft.githubScalaAPI.Gists._`

Usage
-----
See the source code for examples of usage.
