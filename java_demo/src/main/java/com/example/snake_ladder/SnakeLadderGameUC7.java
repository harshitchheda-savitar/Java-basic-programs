package com.example.snake_ladder;

import java.util.Random;

//SnakeLadderGame class
public class SnakeLadderGameUC7 {
	// Initialize the static content
	final static int START_POSITION = 0;
	final static int WIN_STEP = 100;
	final static int LADDER = 1;
	final static int SNAKE = 2;

	public static void main(String[] args) {
		// Initialize the start position of both the players
		int[] currentPosition = { START_POSITION, START_POSITION };
		SnakeLadderGameUC7.gamePlay(currentPosition);
		// Print the winner's status
		System.out.println("Player " + (currentPosition[0] > currentPosition[1] ? 1 : 2) + " won!!!");
	}

	public static void gamePlay(int[] currentPosition) {
		Random diceValue = new Random();
		Random optionValue = new Random();

		int optionFlag;
		int diceCount;

		int playerChance = 0;

		while (true) {
			// Print the current player's turn
			System.out.println("player : " + (playerChance + 1));
			// Generate a random number for the dice-roll
			diceCount = diceValue.nextInt(6) + 1;
			// Generate a random number for the type of obstacle or movement
			optionFlag = optionValue.nextInt(3);

			System.out.println("dice value: " + diceCount);
			// Check the type of obstacle
			switch (optionFlag) {
			case LADDER:
				// if the final-position exceeds the end-mark then don't move the player else
				// move
				currentPosition[playerChance] += ((currentPosition[playerChance] + diceCount) <= WIN_STEP) ? diceCount
						: 0;
				System.out.println("Found a ladder.... currentPosition : " + currentPosition[playerChance]);
				break;
			case SNAKE:
				// if the final position goes behind the start position then place the player at
				// the start else move the player behind by the number of steps
				currentPosition[playerChance] -= ((currentPosition[playerChance] - diceCount) >= START_POSITION)
						? diceCount
						: currentPosition[playerChance];
				System.out.println("Bitten by a snake.... currentPosition : " + currentPosition[playerChance]);
				break;
			default:
				System.out.println("No movement.... currentPosition : " + currentPosition[playerChance]);
				break;
			}

			System.out.println("-------------------------------------------------");

			// Breaking condition for ending the game
			if (!(currentPosition[playerChance] >= START_POSITION && currentPosition[playerChance] < WIN_STEP
					&& currentPosition[(playerChance + 1) % 2] >= START_POSITION
					&& currentPosition[(playerChance + 1) % 2] < WIN_STEP))
				break;
			// Check the type of obstacle and decide the players turn for the next iteration
			playerChance = optionFlag == LADDER ? playerChance : (playerChance + 1) % 2;
		}

	}
}