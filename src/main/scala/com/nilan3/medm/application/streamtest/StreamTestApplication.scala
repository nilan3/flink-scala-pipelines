package com.nilan3.medm.application.streamtest

import com.nilan3.medm.utils.{AppConfig, Utilities}

class StreamTestApplication {

}

object StreamTestApplication {

  def main(args: Array[String]): Unit = {
    val configuration: AppConfig = Utilities.loadConfig(args)
    println(configuration.getString("flink.appName"))
  }
}