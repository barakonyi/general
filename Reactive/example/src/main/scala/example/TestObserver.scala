package example

import rx.lang.scala.Observable
import scala.concurrent.duration.Duration
import java.util.concurrent.TimeUnit
import rx.lang.scala.Subscription
import scala.language.postfixOps

/**
 * @author Matyas_Barakonyi
 */
object TestObserver {

  def main(args: Array[String]): Unit = {

    val ticks: Observable[Long] = Observable.interval(Duration(1000, TimeUnit.MILLISECONDS))
    val evens: Observable[Long] = ticks.filter { x => (x % 2 == 0) }
    val buff: Observable[Seq[Long]] = evens.buffer(2, 1)
    val s: Subscription = buff.subscribe { x => println(x) }

    readLine()
    
    s.unsubscribe()
    
  }

}