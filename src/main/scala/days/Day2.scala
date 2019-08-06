package days

import Function.tupled

class Day2 extends Day[Seq[String], Int, Option[String]] {
  override def parseInput(input: List[String]): Seq[String] = {
    input
  }

  override def part1(ids: Seq[String]): Int = {
    val charCounts = ids.map(getCharacterCounts).map(m => m.values)
    val twoLetterCount = charCounts.count(charCount => charCount.exists(_ == 2))
    val threeLetterCount = charCounts.count(charCount => charCount.exists(_ == 3))

    twoLetterCount * threeLetterCount
  }

  override def part2(ids: Seq[String]): Option[String] = {
    for (i <- 0 until ids.size) {
      for (j <- 1 until ids.size) {
        if (hammingDistance(ids(i), ids(j)) == 1) return Some(commonCharacters(ids(i), ids(j)))
      }
    }

    None
  }

  def getCharacterCounts(id: String): Map[Char, Int] = {
    id.toCharArray
      .groupBy(identity)
      .mapValues(_.length)
      .toMap
    //    var charCounts: Map[Char, Int] = Map.empty
    //
    //    for (char <- id.toCharArray) {
    //      val count = charCounts.getOrElse(char, 0) + 1
    //      charCounts += (char -> count)
    //    }
    //
    //    charCounts
  }

  def hammingDistance(s1: String, s2: String): Int = {
    s1 zip s2 map tupled { (c1, c2) => c1 == c2 } count(_ == false)
  }

  def commonCharacters(s1: String, s2: String): String = {
    s1 zip s2 filter tupled { (c1, c2) => c1 == c2 } map tupled { (c1, _) => c1 } mkString
  }
}
