package example

import rx.lang.scala.Observable
import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import rx.lang.scala.Subscription

object ObservableA {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(228); 
  println("Welcome to the Scala worksheet");$skip(92); 

  val ticks: Observable[Long] = Observable.interval(Duration(1000, TimeUnit.MILLISECONDS));System.out.println("""ticks  : rx.lang.scala.Observable[Long] = """ + $show(ticks ));$skip(45); 
	val even = ticks.filter { x => (x%2 == 0) };System.out.println("""even  : rx.lang.scala.Observable[Long] = """ + $show(even ));$skip(59); 
  val s: Subscription = even.subscribe { x => println(x) };System.out.println("""s  : rx.lang.scala.Subscription = """ + $show(s ))}
 
  
}
