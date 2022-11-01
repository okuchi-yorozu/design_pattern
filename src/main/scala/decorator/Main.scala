package decorator

object Main {
  def main(args: Array[String]): Unit = {
    val b1 = new StringDisplay("Hello, world.")
    val b2 = new SideBorder(b1, '#')
    val b3 = new FullBorder(b2)
    b1.show()
    b2.show()
    b3.show()
    val b4 = new SideBorder(
      new FullBorder(
        new FullBorder(
          new SideBorder(
            new FullBorder(
              new StringDisplay("こんにちは")
            ), '*'
          )
        )
      ), '/'
    )
    b4.show()
    val b5 = new UpDownBorder(b1, '-')
    b5.show()
    val b6 = new FullBorder(
      new UpDownBorder(
        new SideBorder(
          new UpDownBorder(
            new SideBorder(
              new StringDisplay("こんにちは。"), '*'
            ), '='
          ), '|'
        ), '/'
      )
    )
    b6.show()
    val md = new MultiStringDisplay()
    md.add("おはようございます。")
    md.add("こんにちは。")
    md.add("おやすみなさい、また明日。")

    val d7 = new SideBorder(md, '#')
    d7.show()
    val d8 = new FullBorder(md)
    d8.show()
  }

}
