import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

class MyHashMapTest {
	
	// Tests clear() method on HashMap with values, passes when working
	@Test
	void clearTest1() {
		MyHashMap<String, Integer> hashTableOne = new MyHashMap<>();
		
		hashTableOne.put("Jack", 4237);
		hashTableOne.put("Jill", 4257);
		hashTableOne.put("Pat", 3232);
		hashTableOne.put("Tom", 5784);
		hashTableOne.put("Jan", 2934);
		hashTableOne.put("Maurice", 8735);
		hashTableOne.put("Monica", 8735);
		hashTableOne.put("Mandrake", 8735);
		hashTableOne.put("Mandy", 8735);
		hashTableOne.clear();
		
		MyHashMap<String, Integer> hashTableTwo = new MyHashMap<>();
		
		String expected = hashTableTwo.toString();
		String result = hashTableOne.toString();
		
		assertEquals(expected, result);
	}
	
	// Tests clear() method on empty HashMap, passes when working
	@Test
	void clearTest2() {
		MyHashMap<String, Integer> hashTableOne = new MyHashMap<>();
		
		String expected = hashTableOne.toString();
		hashTableOne.clear();	
		String result = hashTableOne.toString();
		
		assertEquals(expected, result);
	}
	
	// Tests containsKey() method on existing key, passes when working
	@Test
	void containsKey1() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		boolean expected = true;
		boolean result = hashTable.containsKey("Tom");
		
		assertEquals(expected, result);
	}
	
	// Tests containsKey() method on non-existent key, passes when working
	@Test
	void containsKey2() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		boolean expected = false;
		boolean result = hashTable.containsKey("Robert");
		
		assertEquals(expected, result);
	}
	
	// Tests containsValue() method on existing value, passes when working
	@Test
	void containsValue1() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		boolean expected = true;
		boolean result = hashTable.containsValue(5784);
		
		assertEquals(expected, result);
	}
	
	// Tests containsValue() method on non-existent value, passes when working
	@Test
	void containsValue2() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		boolean expected = false;
		boolean result = hashTable.containsValue(5361);
		
		assertEquals(expected, result);
	}
	
	// Tests containsValue() method on null value, passes when working
	@Test
	void containsValue3() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		boolean expected = false;
		boolean result = hashTable.containsValue(null);
		
		assertEquals(expected, result);
	}
	
	// Tests get() method on existing key, passes when working
	@Test
	void get1() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		int expected = 3232;
		int result = hashTable.get("Pat");
		
		assertEquals(expected, result);
	}
	
	// Tests get() method on non-existent key, passes when working
	@Test
	void get2() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		Object expected = null;
		Object result = hashTable.get("John");
		
		assertEquals(expected, result);
	}
	
	// Tests isEmpty() method on a non-empty HashTable, passes when working
	@Test
	void isEmpty1() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		boolean expected = false;
		boolean result = hashTable.isEmpty();
		
		assertEquals(expected, result);
	}
	
	// Tests isEmpty() method on an empty HashTable, passes when working
	@Test
	void isEmpty2() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		boolean expected = true;
		boolean result = hashTable.isEmpty();
		
		assertEquals(expected, result);
	}
	
	// Tests isEmpty() method on cleared HashTable, passes when working
	@Test
	void isEmpty3() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		hashTable.clear();
		
		boolean expected = true;
		boolean result = hashTable.isEmpty();
		
		assertEquals(expected, result);
	}
	
	// Tests keySet() method on HashTable with values, passes when working
	@Test
	void keySet1() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		Set<String> expected = new HashSet<String>();
		expected.add("Jack");
		expected.add("Jill");
		expected.add("Pat");
		expected.add("Tom");
		expected.add("Jan");
		expected.add("Maurice");
		expected.add("Monica");
		expected.add("Mandrake");
		expected.add("Mandy");

		Set<String> result = hashTable.keySet();
		//System.out.println("Expected:" + expected);
		//System.out.println("Result  :" + result);
		assertEquals(expected, result);
	}
	
	// Tests keySet() method on empty HashTable, passes when working
	@Test
	void keySet2() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		Set<String> expected = new HashSet<String>();

		Set<String> result = hashTable.keySet();
		//System.out.println("Expected: " + expected);
		//System.out.println("Result  : " + result);
		assertEquals(expected, result);
	}
	
	// Tests put() method on HashTable with values, compare toString() outputs
	@Test
	void put1() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		String old = hashTable.toString();	
		hashTable.put("John", 7281);
		String updated = hashTable.toString();
		
		System.out.println(old + "\n" + updated);
	}
	
	// Tests put() method to check if new value inserted exists, passes when working
	@Test
	void put2() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		int expected = 7281;	
		hashTable.put("John", 7281);
		int result = hashTable.get("John");
		
		assertEquals(expected, result);
	}
	
	// Tests remove() method to remove existing key, passes when working
	@Test
	void remove1() {
		MyHashMap<String, Integer> hashTableOne = new MyHashMap<>();
		
		hashTableOne.put("Jack", 4237);
		hashTableOne.put("Jill", 4257);
		hashTableOne.put("Pat", 3232);
		hashTableOne.put("Tom", 5784);
		hashTableOne.put("Jan", 2934);
		hashTableOne.put("Maurice", 8735);
		hashTableOne.put("Monica", 8735);
		hashTableOne.put("Mandrake", 8735);
		hashTableOne.put("Mandy", 8735);
		
		MyHashMap<String, Integer> hashTableTwo = new MyHashMap<>();
		
		hashTableTwo.put("Jack", 4237);
		hashTableTwo.put("Jill", 4257);
		hashTableTwo.put("Pat", 3232);
		hashTableTwo.put("Jan", 2934);
		hashTableTwo.put("Maurice", 8735);
		hashTableTwo.put("Monica", 8735);
		hashTableTwo.put("Mandrake", 8735);
		
		hashTableOne.remove("Tom");
		hashTableOne.remove("Mandy");
		
		String expected = hashTableTwo.toString();
		String result = hashTableOne.toString();
		
		assertEquals(expected, result);
	}
	
	// Tests remove() method to remove non-existent key, passes when working
	@Test
	void remove2() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		Object expected = null;
		Object result = hashTable.remove("Jim");
		
		assertEquals(expected, result);
	}
	
	// Tests remove() method to check return value on removed node, passes when working
	@Test
	void remove3() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		int expected = 5784;
		int result = hashTable.remove("Tom");
		
		assertEquals(expected, result);
	}
	
	// Tests size() method on HashMap with non-default nodes, passes when working
	@Test
	void size1() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		int expected = 9;	
		int result = hashTable.size();
		
		assertEquals(expected, result);
	}
	
	// Tests size() method on empty HashMap, passes when working
	@Test
	void size2() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		int expected = 0;	
		int result = hashTable.size();
		
		assertEquals(expected, result);
	}
	
	// Tests size() method on HashMap with inserted value, passes when working
	@Test
	void size3() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		hashTable.put("John", 8735);
		
		int expected = 10;	
		int result = hashTable.size();
		
		assertEquals(expected, result);
	}
	
	// Tests size() method on HashMap with two removed values, passes when working
	@Test
	void size4() {
		MyHashMap<String, Integer> hashTable = new MyHashMap<>();
		
		hashTable.put("Jack", 4237);
		hashTable.put("Jill", 4257);
		hashTable.put("Pat", 3232);
		hashTable.put("Tom", 5784);
		hashTable.put("Jan", 2934);
		hashTable.put("Maurice", 8735);
		hashTable.put("Monica", 8735);
		hashTable.put("Mandrake", 8735);
		hashTable.put("Mandy", 8735);
		
		hashTable.remove("Monica");
		hashTable.remove("Tom");
		
		int expected = 7;	
		int result = hashTable.size();
		
		assertEquals(expected, result);
	}
	
}
