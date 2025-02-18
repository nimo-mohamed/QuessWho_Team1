import scala.util.Random

case class Board(characters: List[Character], player1: Player, player2: Player) {
  private var currentPlayer: Player = _

  initialisePlayers()

  def switchPlayer(): Unit = currentPlayer = currentPlayer.opponent

  def getCurrentPlayerName: String = currentPlayer.name

  private val randomNumGen: Random = new Random()

  private def getRandomCharacter: Character = {
    val randomCharacterIndex: Int = randomNumGen.nextInt(characters.length)
    characters(randomCharacterIndex)
  }

  private def initialisePlayers(): Unit = {
    currentPlayer = player1
    player1.opponent = player2
    player2.opponent = player1
    player1.characterToGuess = getRandomCharacter
    player2.characterToGuess = getRandomCharacter
  }

  def getRandomWrongCharacterName: String =
    if (!currentPlayer.hasUsedWrongCharacterHint) {
      currentPlayer.hasUsedWrongCharacterHint = true
      if (characters.length > 1) {
        val wrongCharacters: List[Character] = characters.filter(character => character != currentPlayer.characterToGuess)
        val randomWrongCharacterIndex: Int = randomNumGen.nextInt(wrongCharacters.length)
        wrongCharacters(randomWrongCharacterIndex).name
      } else "There's only ONE character to guess dummy😒! "
    } else "You already used this hint!"

  def getRandomTraitHint: String = {
    if (!currentPlayer.hasUsedRandomTraitHint) {
      currentPlayer.hasUsedRandomTraitHint = true
      val characterTraits: List[String] = List(
        s"The character has ${currentPlayer.characterToGuess.eyeColour} eyes.",
        s"The character has ${currentPlayer.characterToGuess.hairColour} hair.",
        s"The character has a ${currentPlayer.characterToGuess.jumperColour} jumper.",
        s"The character is ${if (currentPlayer.characterToGuess.isMale) "male" else "not male"}",
        s"The character ${if (currentPlayer.characterToGuess.hasPet) "has" else "does not have"} a pet.",
        s"The character ${if (currentPlayer.characterToGuess.hasHat) "has" else "does not have"} a hat.",
        s"The character ${if (currentPlayer.characterToGuess.hasBeard) "has" else "does not have"} a beard.",
        s"The character ${if (currentPlayer.characterToGuess.hasGlasses) "has" else "does not have"} glasses.",
      )
      val randomTraitIndex: Int = randomNumGen.nextInt(characterTraits.length)
      characterTraits(randomTraitIndex)
    } else "You already used this hint!"
  }

  def guessCharacter(name: String): Boolean = {
    currentPlayer.characterToGuess.name == name
  }

  def askQuestion(userQuestion: String, guess: String = ""): Boolean = {
    if (userQuestion == "male") {
      currentPlayer.characterToGuess.isMale
    } else if (userQuestion == "female") {
      !currentPlayer.characterToGuess.isMale
    } else if (userQuestion == "hair") {
      currentPlayer.characterToGuess.hairColour == guess
    } else if (userQuestion == "eyes") {
      currentPlayer.characterToGuess.eyeColour == guess
    } else if (userQuestion == "jumper") {
      currentPlayer.characterToGuess.jumperColour == guess
    } else if (userQuestion == "glasses") {
      currentPlayer.characterToGuess.hasGlasses
    } else if (userQuestion == "pet") {
      currentPlayer.characterToGuess.hasPet
    } else if (userQuestion == "beard") {
      currentPlayer.characterToGuess.hasBeard
    } else if (userQuestion == "hat") {
      currentPlayer.characterToGuess.hasHat
    } else false
  }
}

