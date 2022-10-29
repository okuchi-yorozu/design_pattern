package builder

class Director(private val builder: Builder) {
  def construct(): Unit = {
    builder.makeTitle("Greeting")
    builder.makeString("朝から昼にかけて")
    builder.makeItems(List[String]("おはようございます。", "こんにちは。"))
    builder.makeString("夜に")
    builder.makeItems(List[String]("こんばんは","おやすみなさい","さようなら。"))
    builder.close()
  }
}
