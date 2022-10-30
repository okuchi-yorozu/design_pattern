package sterategy

import scala.collection.mutable.ListBuffer

class QuickSorter extends Sorter {
  var data: ListBuffer[String] = null

  override def sort(data: ListBuffer[String]): Unit = {
    this.data = data
    qsort(0, data.length - 1)
  }

  private def qsort(pre: Int, post: Int): Unit = {
    var mutable_pre = pre
    var mutable_post = post
    val saved_pre = pre
    val saved_post = post
    val mid = data((mutable_pre + mutable_post) / 2)

    do {
      while (data(mutable_pre).compareTo(mid) < 0) {
       mutable_pre += 1
      }
      while (mid.compareTo(data(mutable_post)) < 0) {
        mutable_post -= 1
      }
      if (mutable_pre <= mutable_post) {
        val tmp = data(mutable_pre)
        data(mutable_pre) = data(mutable_post)
        data(mutable_post) = tmp
        mutable_pre += 1
        mutable_post -= 1
      }

    } while (mutable_pre <= mutable_post)

    if (saved_pre < mutable_post) {
      qsort(saved_pre, mutable_pre)
    }
    if (mutable_pre < saved_post) {
      qsort(mutable_pre, saved_post)
    }
  }
}
