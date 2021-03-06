package object spandoc extends Encoders with Decoders {
  import cats.data.Xor
  import io.circe._
  import io.circe.jawn._

  def transformStdin(transform: Pandoc => Pandoc): Unit =
    transformString(transform)(scala.io.Source.stdin.mkString)
      .fold(Console.err.println, Console.out.println)

  def transformString(transform: Pandoc => Pandoc)(input: String): Xor[Error, String] =
    parse(input).flatMap(transformJson(transform)).map(_.noSpaces)

  def transformJson(transform: Pandoc => Pandoc)(json0: Json): Xor[Error, Json] =
    Decoder[Pandoc].apply(json0.hcursor)
      .map(pandoc => Encoder[Pandoc].apply(transform(pandoc)))
}
