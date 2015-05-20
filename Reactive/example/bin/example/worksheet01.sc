package example

object worksheet01 {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  
  val f: PartialFunction[String, String] = { case "ping" => "pong" }
                                                  //> f  : PartialFunction[String,String] = <function1>
 	f.isDefinedAt("ping")                     //> res0: Boolean = true
 	f.isDefinedAt("abc")                      //> res1: Boolean = false
 	
 	trait Generator[+T] {
 		self =>
 		
 		def generate: T
 		
 		def map[S](f: T => S): Generator[S] = new Generator[S] {
 			def generate = f(self.generate)
 		}
 		
 		def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
 			def generate = f(self.generate).generate
 		}
 		
 	}
 	
 	val integers = new Generator[Int] {
 		def generate = scala.util.Random.nextInt()
 	}                                         //> integers  : example.worksheet01.Generator[Int] = example.worksheet01$$anonfu
                                                  //| n$main$1$$anon$3@68837a77
                                 
	val booleans = integers.map(_ > 0)        //> booleans  : example.worksheet01.Generator[Boolean] = example.worksheet01$$an
                                                  //| onfun$main$1$Generator$1$$anon$1@15975490
 
 	trait Tree
 	
 	class Leaf(val x: Int) extends Tree {
 		override def toString = " Leef-" + x
 	}
 	
 	class Inner(val l: Tree, val r: Tree) extends Tree {
 		override def toString = " Inner (L: " + l + " R: " + r + ")"
 	}
    
  def leafs: Generator[Leaf] = for {
  		x <- integers
  } yield new Leaf(x)                             //> leafs: => example.worksheet01.Generator[example.worksheet01.Leaf]
  
  def inners: Generator[Inner] = for {
  	l <- trees
  	r <- trees
  } yield new Inner(l, r)                         //> inners: => example.worksheet01.Generator[example.worksheet01.Inner]
  	
  def trees: Generator[Tree] = for {
  	isLeaf <- booleans
  	tree <- if (isLeaf) leafs else inners
  } yield tree                                    //> trees: => example.worksheet01.Generator[example.worksheet01.Tree]
  
  
 	trees.generate                            //> res2: example.worksheet01.Tree =  Inner (L:  Leef-919489239 R:  Inner (L:  
                                                  //| Leef-1279145440 R:  Inner (L:  Inner (L:  Leef-346129606 R:  Inner (L:  Lee
                                                  //| f--258410310 R:  Inner (L:  Inner (L:  Inner (L:  Inner (L:  Inner (L:  Lee
                                                  //| f-95005853 R:  Leef--793940632) R:  Inner (L:  Leef-62737875 R:  Inner (L: 
                                                  //|  Inner (L:  Leef-2085037109 R:  Leef-1024530371) R:  Inner (L:  Inner (L:  
                                                  //| Leef--863285612 R:  Leef-1473688099) R:  Leef-650266771)))) R:  Inner (L:  
                                                  //| Leef--429198944 R:  Inner (L:  Leef--892420797 R:  Inner (L:  Leef--1976487
                                                  //| 821 R:  Inner (L:  Leef--1409755651 R:  Leef-806069412))))) R:  Inner (L:  
                                                  //| Leef-1639942017 R:  Leef--369030453)) R:  Leef--622891579))) R:  Inner (L: 
                                                  //|  Leef-2106444816 R:  Inner (L:  Inner (L:  Leef--1021448194 R:  Leef--15693
                                                  //| 79608) R:  Leef-1537803606)))))
  
  
}