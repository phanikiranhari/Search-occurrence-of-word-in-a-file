package src;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Driver {
	public static void main(String[] args) {
		Map<String, Integer> mapOfElementsToOccurences = new LinkedHashMap<String, Integer>();
		if (args.length > 1) {
			System.out.println("Error : Count of command line arguments is incorrect.");
			System.out.println("Exiting");
			System.exit(0);
		} else {
			BufferedReader bufferReader = null;
			try {
				StringOperations stringOperations = new StringOperations();
				FileProcessor fileProcessor = new FileProcessor();
				String currentLine;
				bufferReader = new BufferedReader(new FileReader(args[0]));
				while ((currentLine = fileProcessor.readLineFromFile(args[0], bufferReader)) != null) {
					mapOfElementsToOccurences = stringOperations.createMapOfElementsToOccurences(
									mapOfElementsToOccurences, currentLine);
				}
				String result = stringOperations.findMostFrequentWord(mapOfElementsToOccurences);
				System.out.println(result);
			} catch (FileNotFoundException e) {
				System.out.println("Exception: The given file is not found. " +"Please enter " +
						"amazon.wsdl as your file name");
				System.out.println("Printing the stack trace");
				e.printStackTrace();
			}
			
		}

	}
}
