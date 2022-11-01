package composite

object Main {
  def main(args: Array[String]): Unit = {
    try {
      println("Making root entries...")

      val rootdir = new Directory("root")
      val bindir = new Directory("bin")
      val tmpdir = new Directory("tmp")
      val usrdir = new Directory("usr")
      rootdir.add(bindir)
      rootdir.add(tmpdir)
      rootdir.add(usrdir)
      bindir.add(new File("vi", 10000))
      bindir.add(new File("latex", 20000))
      rootdir.printList()

      println("")
      println("Making user entries...")
      val yuki = new Directory("yuki")
      val hanako = new Directory("hanako")
      val tomura = new Directory("tomura")
      usrdir.add(yuki)
      usrdir.add(hanako)
      usrdir.add(tomura)
      yuki.add(new File("diary.html", 100))
      val file = new File("Composite.java", 200)
      yuki.add(file)
      hanako.add(new File("memo.text", 300))
      tomura.add(new File("game.doc", 400))
      tomura.add(new File("junk.mail", 500))
      rootdir.printList()
      println("file = " + file.getFullName())
      println("yuki = " + yuki.getFullName())
    } catch {
      case e: FileTreatmentException => e.printStackTrace()
    }

  }
}
