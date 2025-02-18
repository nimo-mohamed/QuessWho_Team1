# QuessWho_Team1

## Introduction
QuessWho is a Scala-based command-line game inspired by the classic "Guess Who?" board game. Players attempt to identify a hidden character by asking yes/no questions about their attributes. The game is implemented using functional and object-oriented programming principles in Scala.

## Features
- A list of predefined characters with unique attributes.
- A random character selection mechanism.
- Question-based elimination system.
- Hint system providing additional clues.
- Interactive command-line gameplay.

## Installation
### Prerequisites
- Ensure you have Scala installed on your system. You can download it from [Scala's official site](https://www.scala-lang.org/download/).
- Install [sbt](https://www.scala-sbt.org/) for managing dependencies and running the project.

### Clone the Repository
```sh
git clone https://github.com/YourGitHubUsername/QuessWho.git
cd QuessWho
```

### Running the Game
```sh
sbt run
```

## How to Play
1. The game will randomly select a character from the list.
2. Players can:
   - **Ask a question** about an attribute of the hidden character.
   - **Make a guess** if they think they know the character.
   - **Request a hint** for additional clues.
3. The game continues until the player correctly guesses the character.

## Game Characters
Below is a list of available characters and their attributes:

| Name    | Eye Color | Hair Color | Jumper Color | Gender | Glasses | Beard | Hat | Pet |
|---------|----------|------------|--------------|--------|---------|-------|-----|-----|
| Alice   | Blue     | Blonde     | Red          | Female | Yes     | No    | No  | Yes |
| Bob     | Brown    | Black      | Blue         | Male   | No      | Yes   | Yes | No  |
| Charlie | Green    | Brown      | Green        | Male   | Yes     | No    | No  | Yes |
| Diana   | Hazel    | Red        | Yellow       | Female | No      | No    | Yes | No  |
| Eve     | Blue     | Black      | Purple       | Female | Yes     | No    | No  | Yes |
| Frank   | Brown    | Blonde     | Orange       | Male   | No      | Yes   | Yes | No  |
| Grace   | Green    | Brown      | Pink         | Female | Yes     | No    | No  | Yes |
| Hank    | Hazel    | Red        | Blue         | Male   | No      | Yes   | Yes | No  |
| Ivy     | Blue     | Black      | Green        | Female | Yes     | No    | No  | Yes |
| Jack    | Brown    | Blonde     | Yellow       | Male   | No      | Yes   | Yes | No  |

## Gameplay Options
### 1. Guessing a Character
Players can attempt to guess the hidden character by entering a name.

### 2. Asking Questions
Players can ask yes/no questions to narrow down the possibilities. Example questions:
- "Is the character male?"
- "Does the character have glasses?"
- "What is the character's hair color?"

### 3. Requesting Hints
Players can use hints to:
- Get a random fact about the character.
- Remove a wrong character from the board.

## Code Structure
### Main Components
- `Character.scala` - Defines the character attributes.
- `Board.scala` - Handles the game logic, random selection, and answering questions.
- `GameLogic.scala` - Implements the interactive CLI game loop.
- `BoardSpec.scala` - Unit tests for the game logic.

## Testing
The game logic is tested using **ScalaTest**.
Run the tests using:
```sh
sbt test
```

## Future Enhancements
- Adding more characters and attributes.
- Implementing a GUI for a better user experience.
- Multiplayer functionality for online play.

## License
This project is open-source and available under the [MIT License](LICENSE).

## Contributions
Contributions are welcome! Feel free to submit issues or pull requests.

---
### Author
**Tudor Dura**
**Ash George**
**Nimo Mohamed**


