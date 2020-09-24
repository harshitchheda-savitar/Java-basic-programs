package com.example.snake_ladder;

import java.util.Random;

public class SnakeLadderGame {
	public static void main(String[] args) {
		
		Random random = new Random();
		
		int diceValue = random.nextInt(6) + 1;
		System.out.println("Dice rolled and the value was: " + diceValue);
	}
}
