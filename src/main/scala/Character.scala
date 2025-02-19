/**
 * Represents a character in the game.
 *
 * @param name         The name of the character.
 * @param eyeColour    The eye color of the character.
 * @param hairColour   The hair color of the character.
 * @param jumperColour The jumper color of the character.
 * @param isMale       Indicates if the character is male.
 * @param hasGlasses   Indicates if the character has glasses.
 * @param hasBeard     Indicates if the character has a beard.
 * @param hasHat       Indicates if the character has a hat.
 * @param hasPet       Indicates if the character has a pet.
 */
case class Character(name: String, eyeColour: String, hairColour: String, jumperColour: String, isMale: Boolean, hasGlasses: Boolean, hasBeard: Boolean, hasHat: Boolean, hasPet: Boolean) {
  override def toString: String = name
}