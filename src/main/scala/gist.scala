package com.github.mindosoft.githubScalaAPI

import java.util.Date
import net.liftweb.json._

case class UserGists( gists: List[Gist] )
case class Gist( url: String, id: String, description: String,
  public: Boolean, user: User, files: Map[String, File], comments: Int,
  html_url: String, git_pull_url: String, git_push_url: String,
  created_at: String )
case class User( login: String, id: Int, avatar_url: String,
  gravatar_id: String, url: String )
case class File( size: Int, filename: String, raw_url: String,
  content: Option[String] )
case class GistDetail( url: String, id: String, description: String,
  public: Boolean, user: User, files: Map[String, File], comments: Int,
  html_url: String, git_pull_url: String, git_push_url: String,
  created_at: String, forks: List[Fork] , history: List[Change] )
case class Fork( user: User, url: String, created_at: String )
case class Change( url: String, version: String, user: User,
  change_status: ChangeStatus, committed_at: String )
case class ChangeStatus( deletions: Int, additions: Int, total: Int )

object Gists {
  // For liftweb.json
  implicit val formats = DefaultFormats

  def getUserGists(user: String) = {
    // List a user's gists
    val url = getUserGistsUrl(user)
    // Catch exception java.net.SocketException: Connection reset
    val rawdata = io.Source.fromURL(url).getLines.mkString
    //println(rawdata.getClass)
    // Fix on github response for json.extract to work
    val data = "{\"gists\": " + rawdata + "}"
//    println(data)
    val json = parse(data)
//    println(json)
    val userGists = json.extract[UserGists]
    userGists.gists
  }

  def getUserGistsUrl(user: String) = {
    val url = "https://api.github.com/users/" + user + "/gists"
    url
  }

  def getGistDetail(gistId: String) = {
    val url = getGistDetailUrl(gistId)
    val data = io.Source.fromURL(url).getLines.mkString
    val json = parse(data)
    val gistDetail = json.extract[GistDetail]
    gistDetail
  }

  def getGistDetailUrl(gistId: String) = {
    val url = "https://api.github.com/gists/" + gistId
    url
  }

  def getGistId = {
    
  }

  def main(args: Array[String]) = {
    val userGists = getUserGists("MINDoSOFT")
    userGists.foreach { 
      userGist => println(userGist.url) 
    }
    println(userGists(0))
    println(getGistDetail(userGists(0).id))
  }
}

// vim: set ts=4 sw=4 et:
