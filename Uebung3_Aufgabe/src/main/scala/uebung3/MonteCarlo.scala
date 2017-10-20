package uebung3

import scala.util.Random

object MonteCarlo {

  var x = new Random
  var y = new Random
  var hitties: Array[Double] = Array(0, 0, 0, 0, 0, 0, 0, 0)

  def calculatePiParallel(tries: Int): Double = {
    val perEachTries: Int = tries / 8
    val threads: List[Thread] = List()

    for (i <- 0 to 7) {
      def calcParallel(): Unit = hitted(perEachTries, i)

      threads.+:(runner(calcParallel))
    }

    threads.foreach(thread => thread.join())
    return 4 * (hitties.sum / tries)
  }

  def runner(runMeth: Unit): Unit = {
    val t = new Thread {

      override def run(): Unit = runMeth
    }
    t.start
    t
  }

  def hitted(tries: Int, myThread: Int): Unit = {
    def squared(x: Double): Double = x * x

    def countHits(alreadyTried: Int): Unit = {
      if (alreadyTried == tries) return
      if (squared(x.nextDouble()) + squared(y.nextDouble()) <= 1) {
        hitties(myThread) = hitties(myThread) + 1
        countHits(alreadyTried + 1)
      } else {
        countHits(alreadyTried + 1)
      }
    }

    countHits(0)
  }

  def calculatePi(tries: Int): Double = {
    def squared(x: Double): Double = x * x

    def calc(alreadyTried: Double = 0, hits: Double = 0): Double = {
      if (alreadyTried == tries) return 4 * (hits / alreadyTried)


      if (squared(x.nextDouble()) + squared(y.nextDouble()) <= 1)
        calc(alreadyTried + 1, hits + 1)
      else
        calc(alreadyTried + 1, hits)
    }

    calc()
  }

}
  
  
