package com.lucaslouca.other;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumbers {

	private static Map<Character, List<Character>> pad = new HashMap<Character, List<Character>>();

	private static void solve(String number, int i, int len, String word) {
		if (i == len) {
			System.out.println(word);
		} else {
			Character digit = number.charAt(i);
			List<Character> chars = pad.get(digit);

			if (!chars.isEmpty()) {
				for (Character c : chars) {
					solve(number, (i + 1), len, (word + c));
				}
			} else {
				solve(number, (i + 1), len, word);
			}
		}

	}

	public static void main(String[] args) {
		pad.put('0', new ArrayList<Character>());
		pad.put('1', new ArrayList<Character>());
		pad.put('2', Arrays.asList('A', 'B', 'C'));
		pad.put('3', Arrays.asList('D', 'E', 'F'));
		pad.put('4', Arrays.asList('G', 'H', 'I'));
		pad.put('5', Arrays.asList('J', 'K', 'L'));
		pad.put('6', Arrays.asList('M', 'N', 'O'));
		pad.put('7', Arrays.asList('P', 'Q', 'R', 'S'));
		pad.put('8', Arrays.asList('T', 'U', 'V'));
		pad.put('9', Arrays.asList('W', 'X', 'Y', 'Z'));

		String phone = "2345678";
		solve(phone, 0, phone.length(), "");
	}

}
