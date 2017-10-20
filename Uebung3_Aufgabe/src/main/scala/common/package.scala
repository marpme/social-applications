package object common {

  type ??? = Nothing
  type *** = Any

  def ??? : Nothing = throw new Error("an implementation is missing")


}


package object conc {

  def thread(body: => Unit): Thread = {

    val t = new Thread {

      override def run(): Unit = body
    }
    t.start
    t
  }
}

