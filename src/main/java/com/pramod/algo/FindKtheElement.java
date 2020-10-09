package com.pramod.algo;

import java.util.stream.IntStream;

public class FindKtheElement {
	
	public static void main(String args[]) {
		Integer arr[] = { 1, 2, 3, 4, 1, 11,2,1,12,11,7 };  
		
		FindKtheElement fs = new FindKtheElement();
		int k = findKthElementByQuickSelect(arr, 0, arr.length-1, 4);
		System.out.print(k);

	}


	

	
	
	public static  int	  findKthElementByQuickSelect(Integer[] arr, int left, int right, int k) {
	    if (k >= 0 && k <= right - left + 1) {
	        int pos = partition(arr, left, right);
	        if (pos - left == k) {
	            return arr[pos];
	        }
	        if (pos - left > k) {
	            return findKthElementByQuickSelect(arr, left, pos - 1, k);
	        }
	        return findKthElementByQuickSelect(arr, pos + 1,
	          right, k - pos + left - 1);
	    }
	    return 0;
	}

	public static int partition(Integer[] arr, int left, int right) {
	    int pivot = arr[right];
	    Integer[] leftArr;
	    Integer[] rightArr;
	 
	    leftArr = IntStream.range(left, right)
	      .filter(i -> arr[i] < pivot)
	      .map(i -> arr[i])
	      .boxed()
	      .toArray(Integer[]::new);
	 
	    rightArr = IntStream.range(left, right)
	      .filter(i -> arr[i] > pivot)
	      .map(i -> arr[i])
	      .boxed()
	      .toArray(Integer[]::new);
	 
	    int leftArraySize = leftArr.length;
	    System.arraycopy(leftArr, 0, arr, left, leftArraySize);
	    arr[leftArraySize+left] = pivot;
	    System.arraycopy(rightArr, 0, arr, left + leftArraySize + 1,
	      rightArr.length);
	 
	    return left + leftArraySize;
	}
	
	
	public static int partitionIterative(Integer[] arr, int left, int right) {
	    int pivot = arr[right], i = left;
	    for (int j = left; j <= right - 1; j++) {
	        if (arr[j] <= pivot) {
	            swap(arr, i, j);
	            i++;
	        }
	    }
	    swap(arr, i, right);
	    return i;
	}
	
	public static void swap(Integer[] arr, int n1, int n2) {
	    int temp = arr[n2];
	    arr[n2] = arr[n1];
	    arr[n1] = temp;
	}
}
