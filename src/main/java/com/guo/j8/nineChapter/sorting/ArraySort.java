package com.guo.j8.nineChapter.sorting;


import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;

/**
 * Given a array , sort it.
 *
 */
public class ArraySort {

  /**
   * O(n log(n))
   */
  public void quickSort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (arr == null || arr.length == 0)
      return;

    if (low >= high)
      return;

    // pick the pivot
    int middle = low + (high - low) / 2;
    int pivot = arr[middle];

    // make left < pivot and right > pivot
    int i = low, j = high;
    while (i <= j) {
      while (arr[i] < pivot) {
        i++;
      }

      while (arr[j] > pivot) {
        j--;
      }

      if (i <= j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
        j--;
      }
    }

    // recursively sort two sub parts
    if (low < j)
      quickSort(arr, low, j);

    if (high > i)
      quickSort(arr, i, high);
  }


  /**
   * O(nlogn)
   * 
   * @param arr
   */
  public void buildInSort(int[] arr) {
    Arrays.sort(arr);
  }

  /**
   * O(nlogn)
   * 
   * @param arr
   */
  public void mergeSort(int[] arr) {
    if (arr == null || arr.length == 0)
      return;
    mergeSort(arr, 0, arr.length - 1);
  }

  private void mergeSort(int[] arr, int l, int r) {
    if (l < r) {
      // Find the middle point
      int m = (l + r) / 2;

      // Sort first and second halves
      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }

  public void merge(int arr[], int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /* Copy data to temp arrays */
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];


    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarry array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }



  @Test
    public void test(){
        int[] unsorted = {4,5,12,45,7,2,67,132,53};
        int[] unsorted1 = {4,5,12,45,7,2,67,132,53};
        int[] unsorted2 = {4,5,12,45,7,2,67,132,53};

        System.out.println("unsorted ---------------:");
        Arrays.stream(unsorted).forEach(i -> System.out.print(i+","));
        Arrays.stream(unsorted1).forEach(i -> System.out.print(i+","));
        Arrays.stream(unsorted2).forEach(i -> System.out.print(i+","));


        mergeSort(unsorted);
        System.out.println("merge sort:");
        Arrays.stream(unsorted).forEach(i -> System.out.print(i+","));
        quickSort(unsorted1);
        System.out.println("quick sort:");
        Arrays.stream(unsorted1).forEach(i -> System.out.print(i+","));
        buildInSort(unsorted2);
        System.out.println("Arrays sort");
        Arrays.stream(unsorted2).forEach(i -> System.out.print(i+","));
    }
}
