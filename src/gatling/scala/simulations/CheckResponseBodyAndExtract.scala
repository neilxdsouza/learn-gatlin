package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckResponseBodyAndExtract extends BaseSimulation {

  val scn = scenario("Video Game DB")
    .exec(http("Get Specific Game")
      .get("videogames/1")
      .check(jsonPath("$.name").is("Resident Evil 4")))

    .exec(http("Get all Video games - 2nd call")
      .get("videogames")
      .check(jsonPath("$[1].id").saveAs("gameId")))
    .exec { session => println(session); session}

    .exec(http("get Specific Game - 2nd call with Parameter")
      .get("videogames/${gameId}")
      .check(jsonPath("$.name").is("Gran Turismo 3"))
      .check(bodyString.saveAs("responseBody")))
      .exec { session => println(session("responseBody").as[String]); session }

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)

}