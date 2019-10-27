import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import simulation.CsvFeeder
import simulations.{AddPauseTime, CheckResponseBodyAndExtract, CheckResponseCode, CodeReuseWithObject}

object MyGatlingRunner {

  def main(args: Array[String]): Unit = {

    //val simClass = classOf[MyFirstTest].getName
    //val simClass = classOf[AddPauseTime].getName
    //val simClass = classOf[CheckResponseCode].getName
    //val simClass = classOf[CheckResponseBodyAndExtract].getName
    //val simClass = classOf[CodeReuseWithObject].getName
    val simClass = classOf[CsvFeeder].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }

}
