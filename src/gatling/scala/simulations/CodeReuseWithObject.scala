package simulations


import baseConfig.BaseSimulation

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CodeReuseWithObject extends BaseSimulation {
  /*
  val scn = scenario("Video Game DB")
    .exec(http("Get all Video Games")
      .get("videogames")
      .check(status.is(200)))

    .exec(http("Get specific game")
      .get("videogames/1")
      .check(status.in(200 to 210)))

    .exec(http("Get all Video games")
      .get("videogames")
      .check(status.is(200)))

   */




  def getAllVideoGames() = {
    repeat(3) {
      exec(http("Get all Video Games")
        .get("videogames")
        .check(status.is(200)))
    }
  }

  def getSpecificVideoGames() = {
    repeat(5) {
      exec(http("Get specific game")
        .get("videogames/1")
        .check(status.in(200 to 210)))
    }
  }




  /*
  def getAllVideoGames() = {
    exec(http("Get All Video Games")
      .get("videogames")
      .check(status.is(200)))
  }

  def getSpecificVideoGame() = {
    exec(http("Get specific game")
      .get("videogames/1")
      .check(status.in(200 to 210)))
  }

   */




  val scn1 = scenario("Video Game DB")
      .exec(getAllVideoGames())
      .pause(3)
      .exec(getSpecificVideoGames())
      .pause(5)
      .exec(getAllVideoGames())

  setUp(scn1.inject(atOnceUsers(1))).protocols(httpConf)

}