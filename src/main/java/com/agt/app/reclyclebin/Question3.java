package com.agt.app.reclyclebin;

import java.util.Iterator;

public class Question3 {

	public static void main(String[] args) {
		
		int []arr = new int[]{1,1,1,1,1};
		
		int n = arr.length;
		
		System.out.println(findProduct(arr,n));
		
		
	}

	private static int findProduct(int[] arr, int n) {

		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			sum+=arr[i];
		}
		
		return sum*n;
	}
	
}
