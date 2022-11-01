package visitor

trait Element {
  def accept(v: Visitor): Unit
}
