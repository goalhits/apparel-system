package com.socgen;

import java.io.PrintStream;

/**
 * @author Kaushal Soni
 * This prints the results
 */
public class ResultsPrinter {
	private PrintStream printStream;

	public ResultsPrinter(PrintStream printStream) {
		this.printStream = printStream;
	}

	public void printResult(Integer result) {
		printStream.println(result);
	}
}
