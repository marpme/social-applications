package uebung3

class TestThread extends Thread {
  override def run(): Unit = {
    for (i <- 1 to 100) {
      println(i)
    }
  }
}
