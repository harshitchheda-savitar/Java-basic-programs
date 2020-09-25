package com.example.snake_ladder;

import java.util.Random;

//SnakeLadderGame class
public class SnakeLadderGameUC345 {
	public static void main(String[] args) {

		Random diceValue = new Random();
		Random optionValue = new Random();
		// Declare static content
		final int WIN_STEP = 100;
		final int START_POSITION = 0;
		final int LADDER = 1;
		final int SNAKE = 2;
		// Initialize the start position
		int currentPosition = START_POSITION;
		int optionFlag;
		int diceCount;

		System.out.println("currentPosition : " + currentPosition);
		System.out.println("-------------------------------------------------");

		// Iterate until the player reaches the end point
		while (currentPosition >= START_POSITION && currentPosition < WIN_STEP) {
			// Generate a random number for the dice-roll
			diceCount = diceValue.nextInt(6) + 1;
			// Generate a random number for the type of obstacle or movement
			optionFlag = optionValue.nextInt(3);

			System.out.println("dice value: " + diceCount);

			// Check the the type of obstacle and move the position
			switch (optionFlag) {
			case LADDER:
				// if the final-position exceeds the end-mark then don't move the player else
				// move
				currentPosition += ((currentPosition + diceCount) <= WIN_STEP) ? diceCount : 0;
				System.out.println("Found a ladder.... currentPosition : " + currentPosition);
				break;
			case SNAKE:
				// if the final position goes behind the start position then place the player at
				// the start else move the player behind by the number of steps
				currentPosition -= ((currentPosition - diceCount) >= START_POSITION) ? diceCount : currentPosition;
				System.out.println("Bitten by a snake.... currentPosition : " + currentPosition);
				break;
			default:
				System.out.println("No movement.... currentPosition : " + currentPosition);
				break;

			}
			System.out.println("-------------------------------------------------");
		}

	}
}