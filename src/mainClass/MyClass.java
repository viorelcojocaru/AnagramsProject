package mainClass;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import constants.Anagrams;

public class MyClass {

	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			String myCurrentDir = System.getProperty("user.dir");
			
			br = new BufferedReader(new FileReader(myCurrentDir + "\\file.txt"));
			
			Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
			String line = br.readLine();
			List<String> list = new ArrayList<String>();

			while (line != null) {
				if (Anagrams.contains(line.toString()))
					list.add(line);

				line = br.readLine();
			}
			map = buildMap(list);
			if(!map.isEmpty()){
				for (List<String> one : map.values()) {
					for (String string : one) {
						System.out.print(string + " ");
					}
					System.out.println();
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static Map<Integer, List<String>> buildMap(List<String> list) {
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for (String string : list) {
			final String srt = string;
			if (!map.containsKey(string.length())) {
				map.put(string.length(), new ArrayList<String>() {{add(srt);}});
			} else {
				map.get(string.length()).add(string);
			}
		}
		return map;
	}

}
