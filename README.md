# Quess Who 🔎 - Mini Project

## Introduction
"Guess Who?" is a classic deduction game where players ask yes-or-no questions to eliminate characters and identify the opponent’s character. This project implements the backend logic for the game in **Scala**.

## Features
- **Random Character Selection**: Each player is assigned a secret character.
- **Question-based Deduction**: Players can ask predefined questions about their opponent’s character traits.
- **Hints System**: Players can use hints to get clues about the hidden character.
- **Two-Player Turn-Based Logic**: Players take turns asking questions and guessing characters.

## How It Works
1. At the start of the game, each player is assigned a random character.
2. Players take turns asking questions about the opponent’s character (e.g., "Does the character have glasses?").
3. Based on the answers, players eliminate characters.
4. Players can use hints to narrow down the options.
5. The game continues until a player correctly guesses the opponent’s character.

## Installation & Running the Game
### Prerequisites
- Scala installed (`scala -version` to check)

## Characters Table
Below is a list of characters and their traits:

| Name    | Eye Colour | Hair Colour | Jumper Colour | Male | Glasses | Beard | Hat | Pet |
|---------|-----------|-------------|---------------|------|---------|-------|-----|-----|
| Alice   | Blue      | Blonde      | Red           | No   | Yes     | No    | No  | Yes |
| Bob     | Brown     | Black       | Blue          | Yes  | No      | Yes   | Yes | No  |
| Charlie | Green     | Brown       | Green         | Yes  | Yes     | No    | No  | Yes |
| Diana   | Hazel     | Red         | Yellow        | No   | No      | No    | Yes | No  |
| Eve     | Blue      | Black       | Purple        | No   | Yes     | No    | No  | Yes |
| Frank   | Brown     | Blonde      | Orange        | Yes  | No      | Yes   | Yes | No  |
| Grace   | Green     | Brown       | Pink          | No   | Yes     | No    | No  | Yes |
| Hank    | Hazel     | Red         | Blue          | Yes  | No      | Yes   | Yes | No  |
| Ivy     | Blue      | Black       | Green         | No   | Yes     | No    | No  | Yes |
| Jack    | Brown     | Blonde      | Yellow        | Yes  | No      | Yes   | Yes | No  |

## Game Flow
1. Players are assigned a random character.
2. Player 1 starts by asking a yes-or-no question.
3. Player 2 responds, and Player 1 eliminates characters based on the response.
4. Player 2 takes their turn.
5. Players can use hints to get additional clues.
6. Players can attempt to guess the opponent’s character at any time.
7. The first player to correctly guess the character wins.

## Future Enhancements
- Add a frontend for a graphical interface.
- Implement networked multiplayer functionality.
- Improve AI-based questioning logic.

## License
This project is licensed under the **MIT License**.

---
Enjoy playing **Guess Who?**!

---
### Author
**Tudor Dura**

**Ash George**

**Nimo Mohamed**


