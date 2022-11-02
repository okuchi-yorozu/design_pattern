package observer

trait Observer {
  def update(generator: NumberGenerator): Unit
}
