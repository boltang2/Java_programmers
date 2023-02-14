package experiment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Experiment {
	public static void main(String[] args) {
		int[] data = {4,3,2,1,5,2,3,2,5,1,5};
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, Integer> tmp = new HashMap<Integer, Integer>();
		map.put(2,2);
		map.put(3,3);
		map.put(4,4);
		
		ArrayList<Integer> keys = new ArrayList<Integer>();
		for(int key : map.keySet()) {
			keys.add(key);
		}
		System.out.println(keys);
		for (int keyA : keys) {
			map.remove(keyA);
			for(int keyB : map.keySet()) {
				System.out.print(keyA + " ");
				System.out.println(keyB);
			}
		}
		
		String a = "aavvcc";
		System.out.println(a);
		 = "d";
		System.out.println(a);
	}
}

