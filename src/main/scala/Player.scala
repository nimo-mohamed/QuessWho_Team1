case class Player(name: String) {

  var opponent: Player = _

  var characterToGuess: Character = _

  var hasUsedWrongCharacterHint: Boolean = false

  var hasUsedRandomTraitHint: Boolean = false

}
