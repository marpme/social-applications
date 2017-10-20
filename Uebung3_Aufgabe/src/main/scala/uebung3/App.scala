package uebung3


object Main extends App {


  println(MonteCarlo.calculatePi(10000000))

  // val t = new TestThread
  // t.start()

  println("------------------------------------------------------------------")

  println(MonteCarlo.calculatePiParallel(1000000000))

}
