package com.pramod.sorting;

import java.util.Arrays;

public class QuickSort {

    public static void main(String args[]){
        int []array = {100, 20, -500, 10, 2, 3};

        quickSort(array,0,array.length-1);
        Arrays.stream(array).forEach(System.out::println);


    }

    public static void quickSort(int [] input , int start ,int end){

        if(end-start <2)
                return;


        int pivot = partition(input,start,end);
        quickSort(input, start, pivot);
        quickSort(input, pivot+1, end);



    }


    private static int partition(int[] input, int start, int end) {

        int pivot = input[start];
        int low = start;
        int high = end;

        while(low<high){
            while(input[low]<=pivot && low<high)
            {
                low++;
            }

            while(input[high]>pivot){
                high--;
            }

            if(low<high){
                swap(input,low,high);
            }

            swap(input,start,high);


        }

        return high;


    }
    
    private static int updated_partition(int[] input, int start, int end) {
    	
    	
    	int low = start;
    	int high = end;
    	
    	int pivotElement = input[start];
    	
        while(low<high){
        	
        	while(input[++low]<=pivotElement) {
        		if(low ==end) {
        			break;
        			
        		}
        	}
        	
        	
        	while(pivotElement<=input[--high]) {
        		if(high ==start) {
        			break;
        			
        		}
        	}
        	
        	if(low>=high) {
        		break;
        	}
            swap(input,start,high);


        }
    	return high;
    }

    private static void swap(int[] input, int start, int high) {

       int temp = input[start];
        input[start] = input[high];
        input[high]= temp;

    }


}
