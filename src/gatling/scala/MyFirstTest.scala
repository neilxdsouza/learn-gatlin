import baseConfig.BaseSimulation
import io.gatling.core.Predef._
import io.gatling.http.Predef._

class MyFirstTest extends BaseSimulation {

  // 1 Common HTTP Configuration
  /*
  val httpConf = http
    .baseURL("http://localhost:8080/app/")
    .header("Accept", "application/json")

   */

  // 2 Scenario Definition
  val scn = scenario("My first Test")
    .exec(http("get All games").get("videogames"))

  // 3 Load Scenario
  setUp(scn.inject(atOnceUsers(1))).protocols(httpConf)


}
