package example

import rx.lang.scala.Subscription
import rx.lang.scala.subscriptions.CompositeSubscription

object TestSubscription {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(179); 
  println("Welcome to the Scala worksheet");$skip(40); 
  
  val a = Subscription(println("A"));System.out.println("""a  : <error> = """ + $show(a ));$skip(40); 
  
  val b = Subscription(println("B"));System.out.println("""b  : <error> = """ + $show(b ));$skip(49); 
  
  val composite = CompositeSubscription(a, b);System.out.println("""composite  : rx.lang.scala.subscriptions.CompositeSubscription = """ + $show(composite ))}
  
  
}
