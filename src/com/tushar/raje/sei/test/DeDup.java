/**
 * 
 */
package com.tushar.raje.sei.test;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;


/**
 * @author Tushar
 * Tech Lead Candidate Problem Set for SEI Inc
 *
 */
public class DeDup {

	public int[] randomIntegers = {1,2,34,34,25,1,45,3,26,85,4,34,86,25,43,2,1,10000,11,16,19,1,18,4,9,3,
			20,17,8,15,6,2,5,10,14,12,13,7,8,9,1,2,15,12,18,10,14,20,17,16,3,6,19,
			13,5,11,4,7,19,16,5,9,12,3,20,7,15,17,10,6,1,8,18,4,14,13,2,11};   

	public static void main(String [] args) {

		DeDup objDeDup = new DeDup();

		
		
		//remove duplicates for looping 2 times
		objDeDup.remDupsWithDoubleFOR(objDeDup.randomIntegers.clone());
		
		//Sort integer array using Array.sort() and remove duplicates
		objDeDup.remDupsArraySort(objDeDup.randomIntegers.clone());		
		
		//Remove duplicates using collection framework API and retain original order
		objDeDup.remDupsLinkedHashSet(objDeDup.randomIntegers);		

	}

	/**
	 * remDupsWithDoubleFOR(int[])
	 * Advantages:
	 * 1.) This is most Simplest method to remove duplicate integers from an array of integers.
	 * 2.) For training purpose to Beginner Developer
	 * 
	 * DisAdvantages:
	 * 1.) This method will always have time complexity of O(n^2). 
	 * 2.) Does not retain Insertion Order.
	 * 3.) This method is good for small set of array, but would hamper the performance on large set of data
	 * 
	 * Best Suited for small arrays where Insertion order is not necessary and for beginner learners of programming.
	 * 
	 * @param numbers an array of integers
	 */
	public void remDupsWithDoubleFOR(int[] inputRandomIntegers)
	{
    	try {
    		long lStartTime,lEndTime,difference;
    		lStartTime = new Date().getTime();
    		
			int arrLen = inputRandomIntegers.length;
			for (int i = 0; i < arrLen; i++) 
			{
				for (int j = i+1; j < arrLen; j++) 
				{
					if(inputRandomIntegers[i]==inputRandomIntegers[j]){
						//replace the Duplicate element to last element
						inputRandomIntegers[j]=inputRandomIntegers[arrLen-1];
						arrLen--;
						j--;
					}					
					
				}				
			}   

			int[] uniArray = new int[arrLen];
			
			//Copy only till unique element
			System.arraycopy(inputRandomIntegers, 0, uniArray, 0, arrLen);
							
			displayUniqueNum(uniArray);
			
			lEndTime = new Date().getTime();
			difference = lEndTime - lStartTime;
			System.out.println("Time taken for remDupsWithDoubleFOR Method in millisecond : " + difference);
		} catch (Exception e) {
			e.printStackTrace();
		}     
	}
	
	/**
	 * remDupsArraySort(int[]):
	 * Advantages: 
	 * 1.) This is most efficient method to remove duplicate integers from an array of integers.
	 * 2.) This method doesn't use extra memory space. This method uses java.util.Array.sort() method to sort the array of integers.
	 * 3.) The sorting algorithm is a Dual-Pivot Quicksort and offers O(n Log(n) performances on average case.
	 * 
	 * DisAdvantages:
	 * 1.) Does not retain Insertion Order.
	 * 2.) Performance might be o(n^2) for worst case scenario.
	 * 
	 * Best Suited for large arrays where Insertion order is not necessary.
	 * 
	 * @param numbers an array of integers
	 */
	public void remDupsArraySort(final int[] randNumbers) {

		//Sorting integer array using java.util.Arrays.sort()
		/*Sorts the specified array into ascending numerical order. 
		Implementation note: 
		The sorting algorithm is a Dual-Pivot Quicksort by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch.
		This algorithm offers O(n log(n)) performance on many data sets that cause other quicksorts to degrade to quadratic performance,
		and is typically faster than traditional (one-pivot) Quicksort implementations.*/

		try {
			long lStartTime,lEndTime,difference;
    		lStartTime = new Date().getTime();
    		
			Arrays.sort(randNumbers);

			
			int[] uniArray = removeDuplicates(randNumbers);
								
			displayUniqueNum(uniArray);
			
			lEndTime = new Date().getTime();
			difference = lEndTime - lStartTime;
			System.out.println("Time taken for remDupsArraySort Method in millisecond : " + difference);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	/**
	 * This method removes duplicate integers from an array of integers
	 * 
	 * @param numbers an array of integers
	 * @return an array of integers
	 */
	private int[] removeDuplicates(int[] randNumbers) {

		try {
    		
			int[] tempIntArray = new int[randNumbers.length];
			int count = 1;
			int prevNumber = randNumbers[0];

			tempIntArray[0] = prevNumber;// = randNumbers[0];

			//Removing duplicate numbers in the integer array
			for (int i = 1; i < randNumbers.length; ++i) {

				if (randNumbers[i] != prevNumber) {
					tempIntArray[count] = randNumbers[i];
					count++;
				}

				prevNumber = randNumbers[i];
			}

			//Create new integer array to copy the unique integers.
			final int[] retNumbers = new int[count];
			System.arraycopy(tempIntArray, 0, retNumbers, 0, count);

			return retNumbers;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}


	
	
	/**
	 * remDupsLinkedHashSet(int[])
	 * Remove duplicates using collection framework API and retain original order
	 * This method retains original order of the integer array.
	 * LinkedHashSet can have Null value. 
	 * Advantages:
	 * 1.)code is more compact as it uses java collection(LinkedHashSet).
	 * 2.) Retains Insertion Order
	 * 4.) LinkedHashSet has time complexity of o(n) for insertion in case of distinguished hashcode values
	 * 
	 * DisAdvantages:
	 * 
	 * 1.)Don't use this method if you have memory constraint, as this method internally uses HashTable + LinkedList.
	 * LinkedHashSet has overhead of maintaining doubly linked list when an element is inserted or deleted.
	 * 2.) Worst case time complexity is O(n*m) complexity (O(n)*O(m)) where n is the number of elements in your ArrayList 
	 *  and m being the number of elements on average in each LinkedHashSet.
	 *  
	 *  Best Suited for large arrays where Insertion order is necessary
	 * 
	 * @param numbers an array of integers
	 */
	public void remDupsLinkedHashSet(final int[] randNumbers){

		long lStartTime,lEndTime,difference;
		lStartTime = new Date().getTime();
		int i = 0;
		int[] uniArray = null;
		Set<Integer> setNumbers = new LinkedHashSet<Integer>();

		//Add integer array to LinkedHashSet
		for(int num : randNumbers){
			setNumbers.add(num);
		}

		uniArray = new int[setNumbers.size()];

		//convert LinkedHashSet to integer array
		for (Iterator<Integer> iterator = setNumbers.iterator(); iterator.hasNext();) {
			uniArray[i++] = iterator.next();
		}

		
		displayUniqueNum(uniArray);
		
		lEndTime = new Date().getTime();
		difference = lEndTime - lStartTime;
		System.out.println("Time taken for remDupsLinkedHashSet Method in millisecond : " + difference);
	}

	

	/**
	 * Display integer array on console in a single line
	 * 
	 * @param uniqueNumbers an array of integers
	 */
	private void displayUniqueNum(int[] intUnique) {
		
		if(intUnique==null){
			System.out.println("\nNo Numbers to Display");
		}

		System.out.println("");
		for (int i : intUnique) {
			System.out.print(i+", ");
		}

		System.out.println("");
	}
}
