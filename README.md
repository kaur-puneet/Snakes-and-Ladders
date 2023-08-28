# Snakes and Ladders Java Game

This Java program simulates the classic Snakes and Ladders game. It uses a 2D array for the game board, manages player movements, and handles snakes and ladders interactions.

## Highlights

- **Gameplay:** Players take turns rolling dice and moving on the board (Currently set to both players automated).
- **Chutes & Ladders:** Board includes snakes and ladders for added excitement.
- **Turn Management:** Alternating player turns with randomized outputs of dice rolls.
- **Winning Condition:** The first player to reach 100 wins.

## How to Run

1. Compile the `SnakesAndLadders.java` file.
2. Run the compiled Java program.

## Key Methods

- `intBoard()`: Creates the game board's integer representation.
- `createBoard()`: Forms the initial game board layout.
- `finalBoard()`: Adds chutes and ladders for a complete board.
- `updateBoard()`: Tracks player positions on the board.
- `determineFirst()`: Decides the starting player based on dice rolls.
- `playerPosition()`: Calculates new player positions.
- `chuteLadderUpdate()`: Handles snakes and ladders movement.
- `diceGeneratorSix()`: Generates dice rolls, considering repeated 6s.

## Enjoy the Classic

Play the Snakes and Ladders game in Java to experience the timeless thrill of luck and strategy!
