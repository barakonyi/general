package example

import rx.lang.scala.subscriptions.Subscription
import rx.lang.scala.subscriptions.CompositeSubscription

/**
 * @author Matyas_Barakonyi
 */
object TestSubscription {


  def main(args: Array[String]): Unit = {
    
    val a = Subscription(println("A"))
    val b = Subscription(println("B"))
    
    val composite = CompositeSubscription(a, b)
    
    println("--------------------------")
    
    println(a.isUnsubscribed)
    println(b.isUnsubscribed)
    println(composite.isUnsubscribed)

    println("--------------------------")
    a.unsubscribe()
    
    println(a.isUnsubscribed)
    println(b.isUnsubscribed)
    println(composite.isUnsubscribed)
    
    println("--------------------------")
    composite.unsubscribe()
    
    println(a.isUnsubscribed)
    println(b.isUnsubscribed)
    println(composite.isUnsubscribed)
    
    
    
    
  }
  
}