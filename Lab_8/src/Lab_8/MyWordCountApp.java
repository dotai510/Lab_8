package Lab_8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	// <word, its occurences>
	private Map<String, Integer> map = new HashMap<String, Integer>();

	public MyWordCountApp() throws FileNotFoundException {
		this.loadData();
	}

	// Load data from fileName into the above map (containing <word, its
	// occurences>)
	// using the guide given in TestReadFile.java
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		while (input.hasNext()) {
			String word = input.next();
			map.put(word, map.getOrDefault(word, 0) + 1);

		}
		System.out.println(map);
	}

	public int countDistinct() {
		// TODO
		return this.map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		// TODO
		Map<String, Integer> wc = new HashMap<>();
		Scanner scanner = new Scanner(new File("data/hamlet.txt"));
		
		while (scanner.hasNext()) {
			String word = scanner.next().toLowerCase();
			wc.put(word, wc.getOrDefault(word, 0) + 1);
		}
		scanner.close();
		
		for (Map.Entry<String, Integer> entry : wc.entrySet()) {
			System.out.println(entry.getKey() + " :" + entry.getValue());
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		// TODO
		TreeMap<String, Integer> treeMap = new TreeMap<>(map);
		
		for (Map.Entry<String, Integer> entry 	 : treeMap.entrySet()) {
			System.out.println(entry.getKey() + " :" + entry.getValue());
		}
		
		
	}

}
