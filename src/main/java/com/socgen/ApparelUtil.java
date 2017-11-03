package com.socgen;

import java.util.Scanner;

import org.springframework.util.StringUtils;

public class ApparelUtil {
	public static String readNextLine(Scanner scanner) {
		String input;
		//Ignore empty lines
		do {
			input = scanner.nextLine();
		} while (!StringUtils.hasText(input));
		return input;
	}
}
