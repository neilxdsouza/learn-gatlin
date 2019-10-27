package simulations

import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CheckResponseBodyAndExtract extends BaseSimulation {

  val scn = scenario("Video Game DB")
    .exec(http("Get Specific Game")
    .get("videogames/1")
    .check(jsonPath("$.name").is("Resident Evil 4")))

  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)

}