import scala.util.Random

case class Board(characters: List[Character]) {

  private val randomNumGen: Random = new Random()

  private val characterToGuessIndex: Int = randomNumGen.nextInt(characters.length)

  private val characterToGuess: Character = characters(characterToGuessIndex)

  def getRandomWrongCharacterIndex: Int = {
    var randomIndex: Int = randomNumGen.nextInt(characters.length)
    while (randomIndex == characterToGuessIndex) {
      randomIndex = randomNumGen.nextInt(characters.length)
    }
    randomIndex
  }

  private val wrongCharacterIndex: Int = getRandomWrongCharacterIndex

  val wrongCharacter: Character = characters(wrongCharacterIndex)

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

