package days

class Day1 extends Day[Seq[Int], Int, Int] {
  override def parseInput(input: List[String]): Seq[Int] = {
    input.map(_.toInt)
  }

  override def part1(frequencies: Seq[Int]): Int = {
    frequencies.sum
  }

  override def part2(drifts: Seq[Int]): Int = {
    var foundFrequencies: Set[Int] = Set.empty
    var currentFrequency = 0

    while(true) {
      for (drift <- drifts) {
        currentFrequency += drift
        if (foundFrequencies contains currentFrequency) return currentFrequency
        else foundFrequencies += currentFrequency
      }
    }

    0
  }
}
