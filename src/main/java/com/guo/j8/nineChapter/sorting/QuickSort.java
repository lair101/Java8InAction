package com.guo.j8.nineChapter.sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Quick Sort
 */
public class QuickSort {

	public void quickSort(int[] arr) {
		if (arr.length < 2)
			return;
		sort(arr, 0, arr.length - 1);
	}

	private void sort(int[] arr, int start, int end) {
		if (start < end) {
			int pi = partition(arr, start, end);
			sort(arr, start, pi - 1);
			sort(arr, pi + 1, end);
		}
	}

	/*
	 * This function takes last element as pivot, places the pivot element at
	 * its correct position in sorted array, and places all smaller (smaller
	 * than pivot) to left of pivot and all greater elements to right of pivot
	 */
	private int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int i = (low - 1); // index of smaller element
		for (int j = low; j < high; j++)
		{
			// If current element is smaller than or
			// equal to pivot
			if (arr[j] <= pivot)
			{
				i++;

				// swap arr[i] and arr[j]
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}

		// swap arr[i+1] and arr[high] (or pivot)
		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		arr[high] = temp;

		return i + 1;
	}

	@Test
	public void test() {
		int[] arr = { 4, 2, 1, 65, 32, 23, 546, 123, 45, 12, 45, 23, 20 };

		QuickSort q = new QuickSort();
		q.quickSort(arr);
		Arrays.stream(arr).forEach(i -> {
			System.out.print(i + "-");
		});
	}

}
