package iterator

trait Aggregate[T] {
  def iterator(): Iterator[T]
}
