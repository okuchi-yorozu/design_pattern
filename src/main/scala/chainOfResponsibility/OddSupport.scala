package chainOfResponsibility

class OddSupport(name: String) extends Support(name) {
  override def resolve(trouble: Trouble): Boolean = {
    if (trouble.getNumber() % 2 == 1) {
      true
    } else {
      false
    }
  }
}
