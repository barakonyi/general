package quickcheck

import common._
 
import org.scalacheck._
import Arbitrary._
import Gen._
import Prop._

abstract class QuickCheckHeap extends Properties("Heap") with IntHeap {

  property("minOfOneElement") = forAll { a: Int =>
    val h = insert(a, empty)
    findMin(h) == a
  }

  property("minOfTwoElements") = forAll { (a: Int, b: Int) =>
    val h = insert(b, insert(a, empty))
    if (a < b) findMin(h) == a else findMin(h) == b
  }

  property("mintwiceSame") = forAll { a: Int =>
    val h = insert(a, empty)
    val h2 = insert(a, h)
    findMin(h2) == a
    findMin(deleteMin(h2)) == a
  }
  
  property("emptyAfterRemoveOnlyOne") = forAll { a: Int =>
    val h = deleteMin(insert(a, empty))
    isEmpty(h)
  }

  property("gen1") = forAll { (h: H) =>
    val m = if (isEmpty(h)) 0 else findMin(h)
    findMin(insert(m, h)) == m
  }

  // Given any heap, you should get a sorted sequence of elements when continually finding and deleting minimal. 
  // (Hint: recursion and helper functions are your friends.)
  property("deletedSequence") = forAll { (h: H) =>

    def removeAndCheckMinimal(heap: H, prevMinimal: Int): Boolean = {
      if (isEmpty(heap)) true else {
        val currentMinimal = findMin(heap)
        if (currentMinimal >= prevMinimal) removeAndCheckMinimal(deleteMin(heap), currentMinimal) else false
      }
    }

    removeAndCheckMinimal(h, findMin(h))
  }

  property("meldHeapWithEmpty") = forAll { (h : H) =>
    val melding1 = meld(h, empty)
    val melding2 = meld(empty, h)
    
    melding1 == h
    melding2 == h
  }
  
  property("meldingHeapsMinimum") = forAll { (h1: H, h2: H) =>
    val h1Min = findMin(h1)
    val h2Min = findMin(h2)
    val meldingMin = findMin(meld(h1, h2))
    
    if (h1Min < h2Min) h1Min == meldingMin else h2Min == meldingMin
  }
  
  // ---------------------------------

//  property("hint3") = forAll { (h: H) =>
//    
//    def isSorted(h: H): Boolean =
//      if (isEmpty(h)) true
//      else {
//        val m = findMin(h)
//        val h2 = deleteMin(h)
//        if (isEmpty(h2)) true
//        else { m <= findMin(h2) && isSorted(h2) }
//      }
//    
//    isSorted(h)
//  }
 
  property("heapAfterDeleteMin") = forAll { (a :Int, b:Int, c: Int) =>

    // naturally sorted list of three elements
    val list: List[Int] = List(a, b, c).sorted

    def addElemsToHeap(heap: H, l: List[Int]): H = {
      l match {
        case x::xs => {
          addElemsToHeap(insert(x, heap), xs)
        }
        case Nil =>
          heap
      }
    }
    
    val fullHeap = addElemsToHeap(empty, list)
    val withoutMinHeap = addElemsToHeap(empty, list.tail)    
    
    deleteMin(fullHeap) == withoutMinHeap
    
  }

  
  lazy val genHeap: Gen[H] = for {
    n <- arbitrary[Int]
    h <- frequency((1, empty), (9, genHeap))
  } yield insert(n, h)

  implicit lazy val arbHeap: Arbitrary[H] = Arbitrary(genHeap)

}
