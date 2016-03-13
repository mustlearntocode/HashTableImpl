package net.mv;

public class HashMap {
	private final static int TABLE_SIZE = 128;
	HashEntry[] table;
	/*
	 * A boolean indicates if the table is full
	 */
	private boolean isFull = false;
	
	HashMap(){
		table = new HashEntry[TABLE_SIZE];
		for(int i=0; i<TABLE_SIZE;i++){
			table[i] = null;
		}
	}
	
	public int get(int key){
		int cnt = 0;
		int hash = (key%TABLE_SIZE);
		while(cnt<TABLE_SIZE&&table[hash]!=null&& table[hash].getKey()!=key){
			hash = (hash+1)%TABLE_SIZE;
			cnt++;
		}
			
		/*
		 * The key doesn't exist and the table is full
		 */
		if(cnt>=TABLE_SIZE){
			System.out.println("The key doesn't exist and the table is full");
			isFull=true;
			return -1;
		}
		if(table[hash]==null){
			System.out.println("the value with that key hasn't been stored");
			return -1;
		}
		else
			return table[hash].getValue();
	}
	
	public void put(int key, int value){
		int cnt =0;
		if(key<0){
			System.out.println("Key should be greater than 0");
			return;
		}
		if(isFull){
			System.out.println("Table is full");
			return;
		}
		int hash= (key % TABLE_SIZE);
		if(table[hash]!=null){
			System.out.println("value with" + hash +" as key already exists!");
			System.out.println("And the value is "+ table[hash].getValue());
		}
		while(cnt<TABLE_SIZE&&table[hash]!= null&&table[hash].getKey()!=key){
			hash = (hash+1) % TABLE_SIZE;
			cnt++;
			
		}
			
		/*
		 * Table is full, and no new entries can be added.
		 */
		if(cnt>=TABLE_SIZE){
			System.out.println("The table is full");
			isFull=true;
			return;
		}
		table[hash] = new HashEntry(key, value);
		System.out.println("************");
		System.out.println("new entry added with "+ "key = " + key + "value = " + value + "hash = "+ hash);
		System.out.println("************");
	}
}
