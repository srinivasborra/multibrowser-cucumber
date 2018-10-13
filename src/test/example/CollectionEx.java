package test.example;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CollectionEx {

	public static void main(String[] args) {
		
		Set<String> hashSet = new HashSet<String>();
		hashSet.add("Yabh");
		hashSet.add("Abh");
		hashSet.add("Cash");
		hashSet.add("Xabh");
		
		Iterator itr= hashSet.iterator();
		
		while(itr.hasNext()){
			String s =(String) itr.next();
			System.out.println(s);
			
		}
	}

}
