/*
* AUTHOR: Amimul Ehsan Zoha
* FILE: MyHashMap.java
* ASSIGNMENT: Programming Assignment 8 - Generic HashMap
* COURSE: CSc 210;  Fall 2021
* PURPOSE: This program implements a generic HashMap using a hash
* table by making using of java array and linked lists. It maintains
* the collisions of the map keys by using the chaining method(by linked list)
* and the hash function creates as unique and distributed indexes as 
* possible (to make a good hash function) and the HashTable 
* is updated for each bucket.
*
* USAGE: 
* java MyHashMap.java
*
* ----------- EXAMPLE COMMANDS -------------
*	HashTable<String, Integer> ht = new HashTable<>();		
*		ht.put("Jack", 4237);
*		ht.put("Jill", 4257);
*		ht.put("Pat", 3232);
*       ht.get("Tom"):
*		          -------
*
* The commands shown above are all of the commands that are supported
* by this program. It is assumed that (except for some specific errors), 
* the input is well-formed, and matches the format shown above.
*/
// import statements 
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
public class MyHashMap<K,V> {

// final static field which makes the HashTable size contant.
	private final static int TABLE_SIZE = 8;
	ArrayList<LinkedList< Node<K,V>>> hashTable = new ArrayList<>(TABLE_SIZE);

	/*
	* Constructor which instantiates a HashTable object
	*
	*/
	public MyHashMap() {
		this.HashTable();
	}
	/*
	* A class that creates a node for keeping both the keys and the 
	* values together in a same unit.
	*
	*/
	private class Node<K,V>
	{
		K key;
		V value;
		public Node(K key, V value)
		{
			this.key = key;
			this.value = value;
		}
	}
	/*
	* A method that creates a bucket (linkedList) 
	* for keeping both the keys and the  values together in 
	* case of collisions in the same index
	*/
	
	public void HashTable(){
		// creating a new linked list obj at each slot of the hash table
		for (int i = 0; i < TABLE_SIZE; i++)
			hashTable.add(new LinkedList<Node<K,V>>());
	}
	/*
	* Hash function method is an important method that does a calculation
	* so that each key to be mapped in the hash map gets a fairly unique
	* and distributed index to be put into the index of the hashtable.
	* @param K, a key of generic type K.
	* @return int, the index produced by the calculation.
	*/	
	private int hash(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % TABLE_SIZE;
		return Math.abs(index);
	}
	/*
	* put method puts(associates) the specified value with the 
	* specified key in the lap.
	* so that each key to be mapped in the hash map gets a fairly unique
	* and distributed index to be put into the index of the hashtable.
	* @param K, Key a key of generic type K.
	* V value, a value to be associated with the key.
	* @return V value, he previous value associated with key, or 
	* null if there was no mapping for key
	*/		
	public V put(K key, V value){
		// generating the index by hash function
		int index = hash(key);
		LinkedList<Node<K,V>> targetLst = hashTable.get(index);
		if (targetLst instanceof LinkedList<?>) {
			//iterates through the bucket(linked list)
			for (int j = 0; j < targetLst.size(); j++) { 
				// updates value if dupicate key
				if  (targetLst.get(j).key.equals(key)) {
					V tempVal = targetLst.get(j).value;
					targetLst.get(j).value = value;
					return tempVal;	
				}
	        }
		}
		// if the key did not exist, creates a new key-value.
		Node<K, V> node = new Node<>(key, value);
		hashTable.get(index).addFirst(node);
		return null;	
	}
	
	/*
	* remove method Removes the mapping for the specified key 
	* from this map if present.	
	* @param K key - whose mapping is to be removed from the map
	* V value, a value to be associated with the key.
	* @return V value, the previous value associated with key, 
	* or null if there was no mapping for key.
	*/		
	public V remove(K key) {
		//iterates through the hash table.
		for (int i = 0; i < TABLE_SIZE; i++) {
			LinkedList<Node<K,V>> targetLst = hashTable.get(i);
				if (targetLst instanceof LinkedList<?>) {
					for (int j = 0; j < targetLst.size(); j++) { 
						// removes the matching key's value
						if  (targetLst.get(j).key.equals(key)) {
							V tempVal = targetLst.get(j).value;
							targetLst.remove(j);
							return tempVal;	
							}
						}
					}		
		}
		return null;
	}
	
	/*
	 * This method prints a representation of the Hashmap and the 
	 * hashtable by including the keys, conflicts in each bucket and also 
	 * the total conflicts.
	 * @return Void, instead using a print statement.
	 * @param none.
	 */
	public void printTable() {
        String str = "";
        // count for total conflicts 
        int totalConflicts = 0;
        for (int i = 0; i < TABLE_SIZE; i++) {
            int bucketConflicts = 0;
            LinkedList<Node<K,V>> lst = hashTable.get(i);
            if (hashTable.get(i) instanceof LinkedList<?>) {
            	// conflicts zero if less than 1 node.
                if (lst.size() == 1 || lst.size() == 0) {
                    bucketConflicts = 0;
                }
                else {
                    totalConflicts += lst.size() - 1;
                    bucketConflicts = lst.size() - 1;
                }
            }
            // proper formatting to match the spec requirement 
            String bucketConflictString = "(" + bucketConflicts 
            		+ " conflicts), ";
            str += "Index " + i + ": " + bucketConflictString + "[";
            LinkedList<Node<K,V>> list = hashTable.get(i);
            for (int j = 0; j < list.size(); j++) {
                str += list.get(j).key + ", ";
            }
            str += "]\n";
        }
        str += "Total # of conflicts: " + totalConflicts;
        System.out.println(str);
    }	
		
	/*
	* Returns the value to which the specified key is mapped, 
	* or null if this map contains no mapping for the key
	* @param K,key - the key whose associated value is to be returned
	* V value, a value to be associated with the key.
	* @return V,the value to which the specified key is mapped, 
	* or null if this map contains no mapping for the key
	*/		
	public V get(K key){
		int index = hash(key); 
		LinkedList<Node<K,V>> list = hashTable.get(index);
		for (Node<K,V> n: list)
			if (n.key.equals(key))
				return n.value;	
		return null;
	}
	/*
	* this method returns the boolean result 
	* if a key is contained in the hash table
	* @param K,key- the key to be checked
	* @return boolean ,the result of the search
	*/
	public boolean contains(K key) {
		V value = get(key);
		return value == null ? false : true;		
	}
	
	/*
	 * This method returns the string representation of the
	 * hashMap and the keys in the bucket.
	 * @return String ,the string representation.
	 */
	public String toString(){
		String str = "";
		for (int i = 0; i < TABLE_SIZE; i++) 
		{
			str += i + ": [";
			LinkedList<Node<K,V>> list = hashTable.get(i);
			for(int j = 0; j < list.size(); j++)
				str += list.get(j).key + ", ";

				str += "]\n";
			}
		return str;		
	}
	/*
	* this method Removes all of the mappings from this map.
	* @return  void changed mapping.
	* @param none 
	*/	
	public void clear() {
		//iterating through the hash table
		for (int i = 0; i < TABLE_SIZE; i++) {
			if (hashTable.get(i) instanceof LinkedList<?>) {
				// each index in the hash table points to empty
				// bucket to remove all mappings if exists
				hashTable.set(i, new LinkedList<Node<K,V>>());
				}
			}
	}
	/*
	* this method Returns true if this map contains a mapping
	* for the specified key. False otherwise. 
	* @param K,key - the key whose presence is to be checked
	* @return boolean ,the result of the search
	*/		
	public boolean containsKey(K key){
		for (int i = 0; i < TABLE_SIZE; i++) {
			LinkedList<Node<K,V>> lst = hashTable.get(i);
			if (hashTable.get(i) instanceof LinkedList<?>) {
				for (int j = 0; j < lst.size(); j++) { 
					// comparison check for each node.
					if (lst.get(j).key.equals(key)) {
						return true;	
					}    
		        }
			}
		}
		return false;	
	}
	/*
	* this method  Returns true if this map maps 
	* one or more keys to the specified value
	* @param V,val - the value whose presence is to be checked
	* @return boolean ,the result of the search
	*/
	public boolean containsValue(V val){
		for (int i = 0; i < TABLE_SIZE; i++) {
			LinkedList<Node<K,V>> lst = hashTable.get(i);
			if (hashTable.get(i) instanceof LinkedList<?>) {
				for (int j = 0; j < lst.size(); j++) {
					if (lst.get(j).value.equals(val)) {
						return true;	
					}    
		        }
			}
		}
		
		return false;	
	}
	/*
	* this method Returns true if this map contains
	*  no key-value mappings.
	* @param none
	* @return boolean ,the result of emptiness
	*/
	public boolean isEmpty() {
		// is empty is size is 0.
		return (this.size()== 0);
	}
	/*
	* this method Returns the number of key-value 
	* mappings in this map.
	* @param none
	* @return int count ,the count of mappings
	*/
	public int size() {
		int count = 0;
		for (int i = 0; i < TABLE_SIZE; i++) {
			LinkedList<Node<K,V>> lst = hashTable.get(i);
			if (hashTable.get(i) instanceof LinkedList<?>) {
				for (int j = 0; j < lst.size(); j++) {
					// count is increased for each key.
					count += 1;
					}    
		        }
			}
		return count;
		}
	/*
	* this method Returns a Set view of the keys
	*  contained in this map.
	* @param none
	* @return a set of the keys.
	*/
	public java.util.Set<K> keySet(){
		// using a hashset 
		HashSet<K> kSet  = new HashSet<K>();
		for (int i = 0; i < TABLE_SIZE; i++) {
			LinkedList<Node<K,V>> lst = hashTable.get(i);
			if (hashTable.get(i) instanceof LinkedList<?>) {
				for (int j = 0; j < lst.size(); j++) { 
					// adding keys to the hashset.
					kSet.add(lst.get(j).key);
		        }
			}
		}
		return kSet;
	}
		
}
	
	
	
	
	
	

