import scala.util.Random

/**
 * Represents a game board with characters and players.
 *
 * @param characters List of characters available in the game.
 * @param player1    The first player.
 * @param player2    The second player.
 */
case class Board(characters: List[Character], player1: Player, player2: Player) {
  /**
   * The current player.
   */
  private var currentPlayer: Player = player1

  /**
   * Random number generator.
   */
  private val randomNumGen: Random = new Random()

  /**
   * Initializes the players by setting their opponents and assigning random characters to guess.
   */
  private def initialisePlayers(): Unit = {
    player1.opponent = player2
    player2.opponent = player1
    player1.characterToGuess = getRandomCharacter
    player2.characterToGuess = getRandomCharacter
    player1.remainingCharacters = characters
    player2.remainingCharacters = characters
  }

  initialisePlayers()

  /**
   * Switches the current player to the opponent.
   */
  def switchPlayer(): Unit = currentPlayer = currentPlayer.opponent

  /**
   * Gets the name of the current player.
   *
   * @return The name of the current player.
   */
  def getCurrentPlayerName: String = currentPlayer.name

  /**
   * Gets a random character from the list of characters.
   *
   * @return A random character.
   */
  private def getRandomCharacter: Character = {
    val randomCharacterIndex: Int = randomNumGen.nextInt(characters.length)
    characters(randomCharacterIndex)
  }

  /**
   * Filters the remaining characters for the current player based on the question they asked.
   *
   * @param userQuestion The question to ask.
   * @param guess        The guess for the question (optional).
   * @param negate       Whether to negate the condition.
   * @return A list of characters that match the criteria.
   */
  private def filterCurrentPlayerCharacters(userQuestion: String, guess: String = "", negate: Boolean = false): List[Character] = {
    currentPlayer.remainingCharacters.filter(character => {
      val condition = userQuestion match {
        case "male" => character.isMale
        case "female" => !character.isMale
        case "glasses" => character.hasGlasses
        case "pet" => character.hasPet
        case "beard" => character.hasBeard
        case "hat" => character.hasHat
        case "name" => character.name == guess
        case "hair" => character.hairColour == guess
        case "eyes" => character.eyeColour == guess
        case "jumper" => character.jumperColour == guess
        case _ => false
      }
      if (negate) !condition else condition
    })
  }

  /**
   * Narrows down the remaining characters for the current player based on the question they asked.
   *
   * @param userQuestion The question to ask.
   * @param guess        The guess for the question (optional).
   * @param negate       Whether to negate the condition.
   */
  def narrowCurrentPlayerRemainingCharacters(userQuestion: String, guess: String = "", negate: Boolean = false): Unit = {
    currentPlayer.remainingCharacters = filterCurrentPlayerCharacters(userQuestion, guess, negate)
  }

  /**
   * Gets a random wrong character name for the current player.
   * Removes the wrong character from the remaining characters list for the current player.
   *
   * @return A random wrong character name or a message if the hint has already been used.
   */
  def getRandomWrongCharacterName: String =
    if (!currentPlayer.hasUsedWrongCharacterHint) {
      currentPlayer.hasUsedWrongCharacterHint = true
      if (characters.length > 1) {
        val wrongCharacters: List[Character] = currentPlayer.remainingCharacters.filter(character => character != currentPlayer.characterToGuess)
        val randomWrongCharacterIndex: Int = randomNumGen.nextInt(wrongCharacters.length)
        val wrongCharacterName: String = wrongCharacters(randomWrongCharacterIndex).name
        narrowCurrentPlayerRemainingCharacters("name", wrongCharacterName, negate = true)
        wrongCharacterName
      } else "There's only ONE character to guess dummy😒! "
    } else "You already used this hint!"

  /**
   * Gets a random trait hint for the current player's character to guess.
   * Narrows down the remaining characters list for the current player.
   *
   * @return A random trait hint or a message if the hint has already been used.
   */
  def getRandomTraitHint: String = {
    if (!currentPlayer.hasUsedRandomTraitHint) {
      currentPlayer.hasUsedRandomTraitHint = true
      val characterTraits: List[String] = List(
        "male", "female", "glasses", "pet", "beard", "hat", "hair", "eyes", "jumper"
      )
      val randomTraitIndex: Int = randomNumGen.nextInt(characterTraits.length)
      characterTraits(randomTraitIndex)
      val randomTrait: String = characterTraits(randomTraitIndex)
      val (traitMessage, traitValue, negate): (String, String, Boolean) = randomTrait match {
        case "male" =>
          val isMale: Boolean = currentPlayer.characterToGuess.isMale
          (s"The character ${if (isMale) "is" else "is not"} a male", "", !isMale)
        case "female" =>
          val isFemale: Boolean = !currentPlayer.characterToGuess.isMale
          (s"The character ${if (isFemale) "is" else "is not"} a female", "", !isFemale)
        case "glasses" =>
          val hasGlasses = currentPlayer.characterToGuess.hasGlasses
          (s"The character ${if (hasGlasses) "has" else "does not have"} glasses", "", !hasGlasses)
        case "pet" =>
          val hasPet: Boolean = currentPlayer.characterToGuess.hasPet
          (s"The character ${if (hasPet) "has" else "does not have"} a pet", "", !hasPet)
        case "beard" =>
          val hasBeard: Boolean = currentPlayer.characterToGuess.hasBeard
          (s"The character ${if (hasBeard) "has" else "does not have"} a beard", "", !hasBeard)
        case "hat" =>
          val hasHat: Boolean = currentPlayer.characterToGuess.hasHat
          (s"The character ${if (hasHat) "has" else "does not have"} a hat", "", !hasHat)
        case "hair" =>
          val hairColour: String = currentPlayer.characterToGuess.hairColour
          (s"The character has $hairColour hair", hairColour, false)
        case "eyes" =>
          val eyeColour: String = currentPlayer.characterToGuess.eyeColour
          (s"The character has $eyeColour eyes", eyeColour, false)
        case "jumper" =>
          val jumperColour: String = currentPlayer.characterToGuess.jumperColour
          (s"The character has a $jumperColour jumper", jumperColour, false)
      }

      narrowCurrentPlayerRemainingCharacters(randomTrait, traitValue, negate = negate)
      traitMessage
    } else "You already used this hint!"
  }

  /**
   * Checks if the given name matches the current player's character to guess.
   *
   * @param name The name to check.
   * @return True if the name matches, false otherwise.
   */
  def guessCharacter(name: String): Boolean = {
    currentPlayer.characterToGuess.name == name
  }

  /**
   * Prints the remaining characters for the current player.
   */
  def printCurrentPlayerRemainingCharacters(): Unit =
    println(currentPlayer.remainingCharacters.mkString(" "))

  /**
   * Asks a question about the current player's character to guess.
   *
   * @param userQuestion The question to ask.
   * @param guess        The guess for the question (optional).
   * @return True if the guess is correct, false otherwise.
   */
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
