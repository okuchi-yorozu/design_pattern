package chainOfResponsibility

class LimitSupport(name: String, private val limit: Int) extends Support(name) {
  override def resolve(trouble: Trouble): Boolean = {
    if (trouble.getNumber() < limit) {
      true
    } else {
      false
    }
  }
}
