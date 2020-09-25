package com.example.snake_ladder;

import java.util.Random;

//SnakeLadderGame class
public class SnakeLadderGameUC2 {
	public static void main(String[] args) {

		Random random = new Random();
		// Generate a random number for the dice-roll
		int diceValue = random.nextInt(6) + 1;
		System.out.println("Dice rolled and the value was: " + diceValue);
	}
}