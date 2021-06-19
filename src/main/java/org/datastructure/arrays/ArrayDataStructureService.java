package org.datastructure.arrays;

import org.springframework.stereotype.Service;

@Service
public class ArrayDataStructureService {

    public Integer[] getEvenArray(Integer[] array){
        int j=0;
        for (Integer integer : array) {
            if (integer % 2 == 0) {
                j++;
            }
        }
        Integer[] array2 = new Integer[j];
        for (int i=0, k=0;i< array.length;i++) {
            if(array[i]%2 == 0){
                array2[k++] = array[i];
            }
        }
        int lastIndex = Integer.MAX_VALUE;
        for (int i= array.length-1; i>=0;i--) {
            if(array[i]%2 == 0 && lastIndex==Integer.MAX_VALUE){
             lastIndex = i;
            }
            if(array[i]%2 != 0 && lastIndex==Integer.MAX_VALUE){
                array[i] = null;
            } else if(array[i]%2 != 0){
                int value = array[lastIndex];
                array[lastIndex]= null;
                array[i] = value;
                lastIndex = Integer.MAX_VALUE;
            }
        }

        return array;
    }

    public Integer[] mergeArrays(Integer[] arrayLeft, Integer[] arrayRight){
        Integer[] mergeResultArray = new Integer[arrayLeft.length+arrayRight.length];
        int k=0;
        int i=0;
        int j=0;
        while(i<arrayLeft.length && j<arrayRight.length){
            if(arrayLeft[i]>=arrayRight[j]){
                mergeResultArray[k++]=arrayRight[j++];
            } else {
                mergeResultArray[k++]=arrayLeft[i++];
            }
        }
        while(i<arrayLeft.length){
            mergeResultArray[k++]=arrayLeft[i++];
        }
        while(j<arrayRight.length){
            mergeResultArray[k++]=arrayRight[j++];
        }
        return mergeResultArray;
    }

    public Integer[] rearrangePosNegArray(Integer[] inputArray) {
        int i=0, j=inputArray.length-1;
        while(i<j){
            if(inputArray[j]>0)
                j--;
            if(inputArray[i]<0)
                i++;
            if(inputArray[i]>0 && inputArray[j]<0)
            {
                int value = inputArray[i];
                inputArray[i] = inputArray[j];
                inputArray[j]= value;
                i++;
                j--;
            }
        }
        return inputArray;
    }
    public Integer[] rearrangeMaxMin(Integer[] inputArray){
        int val = inputArray[inputArray.length-1];
        int val1 = 0;
        for(int i=0,j=inputArray.length-1/2;i<inputArray.length;i++) {
            inputArray[i] = val;
            inputArray[i+1] = val1;
            val1 = inputArray[i+1];
//            val =
        }
        return inputArray;
    }
}
