package com.nilan3.medm.utils

import java.io.FileInputStream
import java.time.ZonedDateTime

object Utilities {

  def loadConfig(args: Array[String]): AppConfig = {
    if (args.length > 0) {
      val config_file = args(0)
      val config = new AppConfig(new FileInputStream(config_file))
      config
    } else {
      print("Yml configuration file isn't defined")
      sys.exit(1)
    }
  }

  /**
    * Get grouped elements from array
    *
    * @param values       initial array with elements
    * @param numberGroups count groups
    * @tparam T type of elements
    * @return list grouped elements
    */
  def groupList[T](values: Array[T], numberGroups: Int): List[Array[T]] = {
    val (quotient, remainder) = (values.length / numberGroups, values.length % numberGroups)
    val (smallPart, bigPart) = values.splitAt(values.length - remainder * (quotient + 1))
    (smallPart.grouped(quotient) ++ bigPart.grouped(quotient + 1)).toList
  }



  private[utils] def resolvePreviousDay(actualDate: ZonedDateTime): ZonedDateTime = actualDate.minusDays(1)


  /**
    * Return actual date for log processing.
    *
    * @return value of LOG_DATE environment variable,
    *         if it is not present will be returned a previous day for system date
    */
  def dateForLogs(): String = {
    Some(sys.env.getOrElse("LOG_DATE", "")) match { // TODO create constants class
      case Some("") =>
        val yesterday = resolvePreviousDay(ZonedDateTime.now())

        def format(value: Int) = s"${"%02d".format(value)}"

        s"${yesterday.getYear}${format(yesterday.getMonth.getValue)}${format(yesterday.getDayOfMonth)}"

      case Some(i) => i // TODO add validate date format in env

    }
  }

}
