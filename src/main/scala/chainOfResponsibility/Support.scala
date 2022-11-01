package chainOfResponsibility

abstract class Support(private val name: String) {
  private var next: Support = null

  def setNext(next: Support): Support = {
    this.next = next
    next
  }

  final def support(trouble: Trouble): Unit = {
    if (resolve(trouble)) {
      done(trouble)
    } else if (next != null) {
      next.support(trouble)
    } else {
      fail(trouble)
    }
  }

  override def toString(): String = "[" + name + "]"

  protected def resolve(trouble: Trouble): Boolean

  protected def done(trouble: Trouble): Unit = {
    println(trouble + " is resolved by " + this + ".")
  }

  protected def fail(trouble: Trouble): Unit = {
    println(trouble + " cannot be resolved.")
  }
}
