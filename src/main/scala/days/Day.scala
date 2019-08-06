package days

import scala.io.Source

trait Day[I, S1, S2] {
  def parseInput(input: List[String]): I

  def part1(input: I): S1
  def part2(input: I): S2

  def solve(resourcePath: String): (S1, S2) = {
    val input = parseInput(Source.fromFile(resourcePath).getLines.toList)
    (part1(input), part2(input))
  }
}
