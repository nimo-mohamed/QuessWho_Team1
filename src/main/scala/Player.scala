/**
 * Represents a player in the game.
 *
 * @param name The name of the player.
 */
case class Player(name: String) {

  /** The opponent player. */
  var opponent: Player = _

  /** The character that the player needs to guess. */
  var characterToGuess: Character = _

  var remainingCharacters: List[Character] = _

  /** Indicates if the player has used the wrong character hint. */
  var hasUsedWrongCharacterHint: Boolean = false

  /** Indicates if the player has used the random trait hint. */
  var hasUsedRandomTraitHint: Boolean = false

}
