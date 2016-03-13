package net.mv;

public class HashMap {
	private final static int TABLE_SIZE = 128;
	HashEntry[] table;
	
	HashMap(){
		table = new HashEntry[TABLE_SIZE];
		for(int i=0; i<TABLE_SIZE;i++){
			table[i] = null;
		}
	}
	
	public int get(int key){
		int hash = (key%TABLE_SIZE);
		while(table[hash]!=null&& table[hash].getKey()!=key)
			hash = (hash+1)%TABLE_SIZE;
		if(table[hash]==null){
			System.out.println("the value with that key hasn't been stored");
			return -1;
		}
		else
			return table[hash].getValue();
	}
	
	public void put(int key, int value){
		if(key<0){
			System.out.println("Key should be greater than 0");
			return;
		}
		int hash= (key % TABLE_SIZE);
		if(table[hash]!=null){
			System.out.println("value with" + hash +" as key already exists!");
			System.out.println("And the value is "+ table[hash].getValue());
		}
		while(table[hash]!= null&&table[hash].getKey()!=key)
			hash = (hash+1) % TABLE_SIZE;
		table[hash] = new HashEntry(key, value);
		System.out.println("************");
		System.out.println("new entry added with "+ "key = " + key + "value = " + value + "hash = "+ hash);
		System.out.println("************");
	}
}
