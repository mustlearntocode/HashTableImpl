package net.mv;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap hm = new HashMap();
		hm.put(1,21);
		int res1=hm.get(1);
		System.out.println("res1 is "+res1);
		hm.put(601, -44);
		int res2=hm.get(601);
		System.out.println("res2 is "+res2);
		
		hm.put(1, 21);
		System.out.println(hm.get(2));
		hm.put(129, 123);
		System.out.println(hm.get(129));
		System.out.println(hm.get(2));
		/**
		 * Because the entry stores key-value pairs, so the hash number only 
		 * indicates the storage location, it won't affect the actually key 
		 * stored in the entry
		 */
//		hm.put(-1, 0);
	}

}
