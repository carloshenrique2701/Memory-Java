package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class Program {
	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Map<String, Integer> candidates = new HashMap<>();

		String path = "file.csv";
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String lineStr;
			
			while ((lineStr  = br.readLine()) != null) {
				
				String[] line = lineStr.split(",");
				int newVotes = Integer.parseInt(line[1]);
				if (candidates.containsKey(line[0])) {
					int votes = candidates.get(line[0]);
					candidates.put(line[0], votes + newVotes);
				} else {
					candidates.put(line[0], newVotes);
				}				
			}
			
			//Todo esse rolê para organizar pelo valor e não pela key
			Map<String, Integer> sortedCandidates = candidates.entrySet()
					.stream()
					.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
					.collect(Collectors.toMap(
							Map.Entry::getKey,
							Map.Entry::getValue,
							(e1, e2) -> e1, LinkedHashMap::new));
			
			for (String candidate : sortedCandidates.keySet()) {
				System.out.println(candidate + ": " + sortedCandidates.get(candidate));
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Error: " + e.getMessage());
		}
		
	}
}
