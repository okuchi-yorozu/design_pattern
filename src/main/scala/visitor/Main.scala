package visitor

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
      rootdir.accept(new ListVisitor())

      println("")
      println("Making user entries...")
      val yuki = new Directory("yuki")
      val hanako = new Directory("hanako")
      val tomura = new Directory("tomura")
      usrdir.add(yuki)
      usrdir.add(hanako)
      usrdir.add(tomura)
      yuki.add(new File("diary.html", 100))
      yuki.add(new File("Composite.java", 200))
      hanako.add(new File("memo.tex", 300))
      hanako.add(new File("index.html", 350))
      tomura.add(new File("game.doc", 400))
      tomura.add(new File("junk.mail", 500))
      rootdir.accept(new ListVisitor())

      val ffv = new FileFindVisitor(".html")
      rootdir.accept(ffv)

      println("HTML files are:")
      val it = ffv.getFoundFiles()
      while (it.hasNext()) {
        val file = it.next()
        println(file.toString())
      }

      val list = new ElementArrayList()
      list.add(yuki)
      list.add(hanako)
      list.add(tomura)
      list.accept(new ListVisitor())
    } catch {
      case e: FileTreatmentException => e.printStackTrace()
    }
  }
}
