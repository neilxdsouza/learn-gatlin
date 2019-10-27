import io.gatling.app.Gatling
import io.gatling.core.config.GatlingPropertiesBuilder
import simulations.{AddPauseTime, CheckResponseCode}

object MyGatlingRunner {

  def main(args: Array[String]): Unit = {

    //val simClass = classOf[MyFirstTest].getName
    //val simClass = classOf[AddPauseTime].getName
    val simClass = classOf[CheckResponseCode].getName

    val props = new GatlingPropertiesBuilder
    props.simulationClass(simClass)

    Gatling.fromMap(props.build)
  }

}
