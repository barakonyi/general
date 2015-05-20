package example

object worksheet01 {;import org.scalaide.worksheet.runtime.library.WorksheetSupport._; def main(args: Array[String])=$execute{;$skip(81); 
  println("Welcome to the Scala worksheet");$skip(75); 
  
  
  val f: PartialFunction[String, String] = { case "ping" => "pong" };System.out.println("""f  : PartialFunction[String,String] = """ + $show(f ));$skip(24); val res$0 = 
 	f.isDefinedAt("ping");System.out.println("""res0: Boolean = """ + $show(res$0));$skip(23); val res$1 = 
 	f.isDefinedAt("abc")
 	
 	trait Generator[+T] {
 		self =>
 		
 		def generate: T
 		
 		def map[S](f: T => S): Generator[S] = new Generator[S] {
 			def generate = f(self.generate)
 		}
 		
 		def flatMap[S](f: T => Generator[S]): Generator[S] = new Generator[S] {
 			def generate = f(self.generate).generate
 		}
 		
 	};System.out.println("""res1: Boolean = """ + $show(res$1));$skip(394); 
 	
 	val integers = new Generator[Int] {
 		def generate = scala.util.Random.nextInt()
 	};System.out.println("""integers  : example.worksheet01.Generator[Int] = """ + $show(integers ));$skip(70); 
                                 
	val booleans = integers.map(_ > 0)
 
 	trait Tree
 	
 	class Leaf(val x: Int) extends Tree {
 		override def toString = " Leef-" + x
 	}
 	
 	class Inner(val l: Tree, val r: Tree) extends Tree {
 		override def toString = " Inner (L: " + l + " R: " + r + ")"
 	};System.out.println("""booleans  : example.worksheet01.Generator[Boolean] = """ + $show(booleans ));$skip(310); 
    
  def leafs: Generator[Leaf] = for {
  		x <- integers
  } yield new Leaf(x);System.out.println("""leafs: => example.worksheet01.Generator[example.worksheet01.Leaf]""");$skip(96); 
  
  def inners: Generator[Inner] = for {
  	l <- trees
  	r <- trees
  } yield new Inner(l, r);System.out.println("""inners: => example.worksheet01.Generator[example.worksheet01.Inner]""");$skip(119); 
  	
  def trees: Generator[Tree] = for {
  	isLeaf <- booleans
  	tree <- if (isLeaf) leafs else inners
  } yield tree;System.out.println("""trees: => example.worksheet01.Generator[example.worksheet01.Tree]""");$skip(23); val res$2 = 
  
  
 	trees.generate;System.out.println("""res2: example.worksheet01.Tree = """ + $show(res$2))}
  
  
}
