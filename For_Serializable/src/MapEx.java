import java.lang.reflect.Array;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MapEx {
	public static void main(String[] args) {
        Map<String, Integer> m = new HashMap<String, Integer>();

        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words:");
        System.out.println(m);
        printMap();
        AbstractMap.SimpleEntry<Integer, String> entry 
        = new AbstractMap.SimpleEntry<>(1, "one");
        Integer key = entry.getKey();
        String value = entry.getValue();
        System.out.println(key+value);
    }
	
	static void printMap() {
		String[] a = {"a","b","a","c"};
		int[] b = {5,2,6,8,1,5,6,8};
//		List account2 = Arrays.asList(1,2,6,5,7);
		int[] c = {99};
		
		Map<String, int[]> arr = new HashMap<>();
//		好像不能寫成<String,Array> use byte[] to be Key will be some problem equals() not be the same 
		for (int i = 0;i<a.length;i++) {
			if (arr.get(a[i])== null){
				arr.put(a[i], b);
			}
			else {
				arr.put(a[i],c);
			}
			
		}
//		print Keys
		for (String key : arr.keySet()) {
		    System.out.println(key+arr.get(key));
		    int[] inList = arr.get(key);
		    System.out.println("This list:" + key);
		    for(Integer i: inList) {
		    	System.out.format("%d ",i);
		    }
		    System.out.println();
		}
//		for (Map.Entry<String, int[]> e : arr.entrySet())
//		    System.out.println(e.getKey() + ": " + e.getValue());
		
//		print values
//		for(int[] v: arr.values()) {
//			System.out.print(v + ", ");
//		}
		
	}
}
