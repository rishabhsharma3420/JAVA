package hashmap;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Set;

public class Hashmap_client {

	public static void main(String[] args) {
		// String str = "aabbccddaa";
		// System.out.println(maxfreqchar(str));
		int[] arr1 = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
		// int[] arr2 = { 1, 2, 3, 4, 5 };
		// intersection(arr1, arr2);
		findlonginter(arr1);
	}

	public static Character maxfreqchar(String str) {
		HashMap<Character, Integer> hello = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			Character ch = str.charAt(i);
			if (hello.containsKey(ch)) {
				hello.put(ch, hello.get(ch) + 1);
			} else {
				hello.put(ch, 1);
			}
		}
		Character maxc = ' ';
		int maxcf = -1;
		ArrayList<Character> keys = new ArrayList<>(hello.keySet());
		for (Character key : keys) {
			int freq = hello.get(key);
			if (freq > maxcf) {
				maxcf = freq;
				maxc = key;
			}
		}
		return maxc;
	}

	public static ArrayList<Integer> intersection(int[] arr1, int[] arr2) {
		HashMap<Integer, Integer> hm = new HashMap<>();
		HashMap<Integer, Integer> hm1 = new HashMap<>();
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < arr1.length; i++) {
			int x = arr1[i];
			if (hm.containsKey(x)) {
				hm.put(x, hm.get(x) + 1);
			} else {
				hm.put(arr1[i], 1);
			}
		}
		for (int i = 0; i < arr2.length; i++) {
			int x = arr2[i];
			if (hm1.containsKey(x)) {
				hm1.put(x, hm.get(x) + 1);
			} else {
				hm1.put(x, 1);
			}
		}
		HashMap<Integer, Integer> ans = new HashMap<>();

		return arr;
	}

	public static void findlonginter(int[] arr) {
		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int val : arr) {
			hm.put(val, true);
		}

		for (int val : arr) {
			if (hm.containsKey(val - 1) == true) {
				hm.put(val, false);
			}
		}

		int maxsq = 0;
		int maxval = 0;

		for (int val : arr) {
			if (hm.get(val) == true) {
				int count = 0;
				while (hm.containsKey(val + count) == true) {
					count++;
				}
				if (maxsq < count) {
					maxsq = count;
					maxval = val;
				}
			}
		}

		for (int i = 0; i < maxsq; i++) {
			System.out.print(maxval + i + "\t");
		}

	}

	public static void match(int a[], int b[]) {
		HashMap<Integer, Integer> h = new HashMap<>();
		HashMap<Integer, Integer> h2 = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (!h.containsKey(a[i]))
				h.put(a[i], 1);
		}
		for (int i = 0; i < b.length; i++) {
			if (h.containsKey(b[i]))
				h2.put(b[i], 2);
		}
		ArrayList<Integer> kjk = new ArrayList<>(h2.keySet());
		for (int i = 0; i < kjk.size(); i++) {
			System.out.println(kjk.get(i));
		}
	}

	public static void match2(int a[], int b[]) {
		HashMap<Integer, Integer> h = new HashMap<>();
		for (int i = 0; i < (a.length > b.length ? b.length : a.length); i++) {
			if (a[i] == b[i] && h.containsKey(a[i]))
				h.put(a[i], h.get(a[i]) + 1);
			else if (a[i] == b[i])
				h.put(a[i], 1);
		}
		ArrayList<Integer> kjk = new ArrayList<>(h.keySet());
		for (int i = 0; i < kjk.size(); i++) {
			for (int j = 0; j < h.get(kjk.get(i)); j++)
				System.out.println(kjk.get(i));
		}
	}

}
