package src;

import java.io.BufferedReader;
import java.io.IOException;

public class FileProcessor {

	/**
	 * This method takes the required parameters viz. filename and buffer reader and
	 * returns the current line from the file.
	 * @param fileName
	 * @param bufferReader
	 * @return the current line from the file
	 */
	public String readLineFromFile(String fileName, BufferedReader bufferReader) {
		String currentLine = null;
		try {
			currentLine = bufferReader.readLine();
		} catch (IOException e) {
			System.out.println("Exception: The given file is not found. "
					+ "Please enter amazon.wsdl as your file name");
		}
		return currentLine;
	}
}
