package singleton

class Triple private(private val id: Int) {
  println("The instance " + id + " is created.")

  override def toString(): String = "[Triple id=" + id + "]"
}

object Triple {
   val triple = Array[Triple] (
     new Triple(0),
     new Triple(1),
     new Triple(2)
   )

  def getInstance(id: Int) = triple(id)
}
