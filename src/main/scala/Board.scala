import scala.util.Random

case class Board(characters: List[Character]) {

  private val randomNumGen: Random = new Random()

  private val characterToGuessIndex: Int = randomNumGen.nextInt(characters.length)

  private val characterToGuess: Character = characters(characterToGuessIndex)

  private var hasUsedWrongCharacterHint: Boolean = false

  private var hasUsedRandomTraitHint: Boolean = false

  def getRandomWrongCharacterName: String =
    if (!hasUsedWrongCharacterHint) {
      hasUsedWrongCharacterHint = true
      if (characters.length > 1) {
        var randomIndex: Int = randomNumGen.nextInt(characters.length)
        while (randomIndex == characterToGuessIndex) {
          randomIndex = randomNumGen.nextInt(characters.length)
        }
        characters(randomIndex).name
      } else "There's only ONE character to guess dummy😒! "
    } else "You already used this hint!"

  def getRandomTraitHint: String =
  if (!hasUsedRandomTraitHint) {
    hasUsedRandomTraitHint = true
    val characterTraits: List[String] = List(
      s"The character has ${characterToGuess.eyeColour} eyes.",
      s"The character has ${characterToGuess.hairColour} hair.",
      s"The character has a ${characterToGuess.jumperColour} jumper.",
      s"The character is ${if (characterToGuess.isMale) "male" else "not male"}",
      s"The character ${if (characterToGuess.hasPet) "has" else "does not have"} a pet.",
      s"The character ${if (characterToGuess.hasHat) "has" else "does not have"} a hat.",
      s"The character ${if (characterToGuess.hasBeard) "has" else "does not have"} a beard.",
      s"The character ${if (characterToGuess.hasGlasses) "has" else "does not have"} glasses.",
    )
    val randomTraitIndex: Int = randomNumGen.nextInt(characterTraits.length)
    characterTraits(randomTraitIndex)
  }  else "You already used this hint!"

  def guessCharacter(name: String): Boolean = {
    characterToGuess.name == name
  }

  def askQuestion(userQuestion: String, guess: String = ""): Boolean = {
    if (userQuestion == "male") {
      characterToGuess.isMale
    } else if (userQuestion == "female") {
      !characterToGuess.isMale
    } else if (userQuestion == "hair") {
      characterToGuess.hairColour == guess
    } else if (userQuestion == "eyes") {
      characterToGuess.eyeColour == guess
    } else if (userQuestion == "jumper") {
      characterToGuess.jumperColour == guess
    } else if (userQuestion == "glasses") {
      characterToGuess.hasGlasses
    } else if (userQuestion == "pet") {
      characterToGuess.hasPet
    } else if (userQuestion == "beard") {
      characterToGuess.hasBeard
    } else if (userQuestion == "hat") {
      characterToGuess.hasHat
    } else false
  }
}

