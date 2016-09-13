package src;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

public class StringOperations {

	private static final String NAME = "name";
	private static final String SPACE = " ";
	private static final String EQUAL_TO = "=";
	private static final String ELEMENT_ATTRIBUTE = "<xs:element";
	
	/**
	 * This method creates a map and add key value pairs into it. If the map doesn't have
	 * the required key it puts the key into the map else if the map already has the key
	 * we just increment the value by 1 for the corresponding key.
	 * 
	 * @param mapOfElementsToOccurences
	 * @param currentLine
	 * @return updatedMap incrementing the occurrences
	 */
	public Map<String, Integer> createMapOfElementsToOccurences(Map<String, Integer> mapOfElementsToOccurences, String currentLine) {
		String[] presentLine = currentLine.split(SPACE);
		for (String s : presentLine) {
			boolean contains = s.contains(ELEMENT_ATTRIBUTE);
			if (contains) {
				int preIndex = Arrays.asList(presentLine)
						.indexOf(ELEMENT_ATTRIBUTE);
				String[] splitingNameElement = Arrays.asList(presentLine)
						.get(preIndex + 1).split(EQUAL_TO);
				String stringBeforeEqualSign = Arrays.asList(splitingNameElement).get(0);
				if (stringBeforeEqualSign.equals(NAME)) {
					if (!mapOfElementsToOccurences.containsKey(Arrays.asList(
							splitingNameElement).get(1))) {
						mapOfElementsToOccurences.put(
								Arrays.asList(splitingNameElement).get(1), 1);
					} else {
						mapOfElementsToOccurences.put(
								Arrays.asList(splitingNameElement).get(1),
								mapOfElementsToOccurences.get(Arrays.asList(
										splitingNameElement).get(1)) + 1);
					}
				}
			}
		}
		return mapOfElementsToOccurences;
	}

	/**
	 * This method finds the key from the map which has the maximum value.
	 * @param mapOfWordToOccurrences
	 * @return Most Frequent Word
	 */
	public String findMostFrequentWord(Map<String, Integer> resultMap) {
		String keyForMaximumOccurrenceWord = "";
		Integer maximumEntry = 0;
		for(Entry<String,Integer> entry : resultMap.entrySet()) {
		    if (entry.getValue() > maximumEntry) {
		        maximumEntry = entry.getValue();
		        keyForMaximumOccurrenceWord = entry.getKey();
		    }
		}
		return "The most frequently occurring " +
				"element is "+keyForMaximumOccurrenceWord +". It occurs "+maximumEntry+" times";
	}
}
