package com.agt.app.reclyclebin;

import java.util.Iterator;

public class Question2 {

	public static void main(String[] args) {

		System.out.println(findScore("ahhhafjsngvdnndsifnsgbsssfd"));

	}

	private static int findScore(String string) {

		return findScoreOf4(string) + findScoreOf5(string);
	}

	private static int findScoreOf5(String string) {
		int score = 0;
		for (int i = 0; i < string.length() - 5; i++) {

			if (isPalindrome(string.substring(i, i + 5))) {

				score += 10;

			}

		}
		return score;
	}

	private static int findScoreOf4(String string) {
		int score = 0;
		for (int i = 0; i < string.length() - 4; i++) {

			if (isPalindrome(string.substring(i, i + 4))) {

				score += 5;

			}

		}
		return score;
	}

	private static boolean isPalindrome(String substring) {

		for (int i = 0, j = substring.length() - 1; i <= substring.length() / 2; i++, j--) {

			if (substring.charAt(i) != substring.charAt(j)) {

				return false;

			}

		}

		return true;
	}

}
