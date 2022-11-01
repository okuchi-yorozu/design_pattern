package chainOfResponsibility

class NoSupport(name: String) extends Support(name) {
  override def resolve(trouble: Trouble): Boolean = false
}
