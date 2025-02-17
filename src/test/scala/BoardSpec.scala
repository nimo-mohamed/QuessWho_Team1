
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

class BoardSpec extends AnyWordSpec with Matchers {
  val character = Character("Nemo", "pink", "brown", "black", isMale = false, hasGlasses = true, hasBeard = false, hasHat = false, hasPet = false)
  val characterList: List[Character] = List(character)
  val boardTest = Board(characterList)

  "guessCharacter" should {
    "return true" when {
      "the name matches the name of the character guessed" in {
        val input = boardTest.guessCharacter("Nemo")
        val expectedResult = true
        input shouldBe expectedResult
      }
    }

    "return false" when {
      "the name doesn't match the name of the character guessed" in {
        val input = boardTest.guessCharacter("Tudor")
        val expectedResult = false
        input shouldBe expectedResult
      }
    }
  }

  "askQuestion" should {
    "return true" when {
      "userQuestion is female and the gender of character is female" in {
        val input = boardTest.askQuestion("female")
        val expectedResult = true
        input shouldBe expectedResult
      }

      "userQuestion is about hair colour and guess is correct" in {
        val input = boardTest.askQuestion("hair", "black")
        val expectedResult = true
        input shouldBe expectedResult
      }

      "userQuestion is about eye colour and guess is correct" in {
        val input = boardTest.askQuestion("eyes", "brown")
        val expectedResult = true
        input shouldBe expectedResult
      }

      "userQuestion is about jumper colour and guess is correct" in {
        val input = boardTest.askQuestion("jumper", "pink")
        val expectedResult = true
        input shouldBe expectedResult
      }

      "userQuestion is about whether they have glasses and they do" in {
        val input = boardTest.askQuestion("glasses")
        val expectedResult = true
        input shouldBe expectedResult
      }

      "userQuestion is about whether they have a pet and they do" in {
        val input = !boardTest.askQuestion("pet")
        val expectedResult = true
        input shouldBe expectedResult
      }

      "userQuestion is about whether they have a beard and they do" in {
        val input = !boardTest.askQuestion("beard")
        val expectedResult = true
        input shouldBe expectedResult
      }

      "userQuestion is whether they have a hat and they don't" in {
        val input = !boardTest.askQuestion("hat")
        val expectedResult = true
        input shouldBe expectedResult
      }
    }

    "return false" when {
      "userQuestion is male and the gender of character is female" in {
        val input = boardTest.askQuestion("male")
        val expectedResult = false
        input shouldBe expectedResult
      }

      "userQuestion is about hair colour and guess is incorrect" in {
        val input = boardTest.askQuestion("hair", "blonde")
        val expectedResult = false
        input shouldBe expectedResult
      }

      "userQuestion is about eye colour and guess is incorrect" in {
        val input = boardTest.askQuestion("eyes", "green")
        val expectedResult = false
        input shouldBe expectedResult
      }

      "userQuestion is about jumper colour and guess is incorrect" in {
        val input = boardTest.askQuestion("jumper", "blue")
        val expectedResult = false
        input shouldBe expectedResult
      }

      "userQuestion is about whether they have glasses and they don't" in {
        val input = !boardTest.askQuestion("glasses")
        val expectedResult = false
        input shouldBe expectedResult
      }

      "userQuestion is about whether they have a pet and they don't" in {
        val input = boardTest.askQuestion("pet")
        val expectedResult = false
        input shouldBe expectedResult
      }

      "userQuestion is about whether they have a beard and they don't" in {
        val input = boardTest.askQuestion("beard")
        val expectedResult = false
        input shouldBe expectedResult
      }

      "userQuestion is whether they have a hat and they do" in {
        val input = boardTest.askQuestion("hat")
        val expectedResult = false
        input shouldBe expectedResult
      }
    }
  }
}
