package chainOfResponsibility

class SpecialSupport(name: String, private val number: Int) extends Support(name) {
  override def resolve(trouble: Trouble): Boolean = {
    if (trouble.getNumber() == number) {
      true
    } else {
      false
    }
  }
}
