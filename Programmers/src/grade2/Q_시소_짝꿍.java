import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

class Solution {
	public long solution(int[] weights) {
		long answer = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		map = mapping(weights);
		answer = siso(map);
		return answer;
	}

	public HashMap<Integer, Integer> mapping(int[] weights) {
		HashMap<Integer, Integer> w = new HashMap<>();
		for (int i = 0; i < weights.length; i++) {
			w.put(weights[i], w.getOrDefault(weights[i], 0) + 1);
		}
		return w;
	}

	public long siso(HashMap<Integer, Integer> map) {
		ArrayList<Integer> keys = new ArrayList<Integer>();
		long count = 0;
		for (int keyA : sort(map)) {
			long keyA_Value = map.get(keyA);
			count += keyA_Value * (keyA_Value - 1) / 2;
			map.remove(keyA);
			for (int keyB : sort(map)) {
				long keyB_Value = map.get(keyB);
				if (keyA * 2 < keyB) {
					break;
				} else {
					if(plusCount(keyA, keyB)) {
						count += keyA_Value * keyB_Value;
					}
				}
				//System.out.printf("keyA = %d, keyB = %d\n", keyA, keyB);
			} // in for
			//System.out.println("count = " + count);
		} // out for
		return count;
	}

	public ArrayList<Integer> sort(HashMap<Integer, Integer> map) {
		ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		return keySet;
	}

	public boolean plusCount(int keyA, int keyB) {
		int[] s = {2,3,4};
		for(int a : s) {
			for(int b : s) {
				if(keyA * a == keyB * b) {
					return true;
				}
			}
		}
		return false;
	}
}
