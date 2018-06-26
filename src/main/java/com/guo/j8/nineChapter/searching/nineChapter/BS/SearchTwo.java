package com.guo.j8.nineChapter.searching.nineChapter.BS;


import org.junit.jupiter.api.Test;

/***
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 *     Integers in each row are sorted from left to right.
 *     The first integer of each row is greater than the last integer of the previous row.
 *
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 *
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 */
public class SearchTwo {

    //if we flat the matrix, it is a n x m array
    //and it is sorted.
    //search in a sorted array. ---> binary search~
    public boolean searchMatrix(int[][] matrix, int target) {

        //old way, binary search cols and then search row
        int start = 0;
        int end = matrix.length;
        int mid;

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;


        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (matrix[mid][0] == target) return true;
            if (matrix[mid][0] > target) {
                end = mid;
            } else {
                start = mid;
            }

        }

        //when it comes to here, the target only can be at row[start]
        //do BS for row[start]
        int row = start;
        start = 0;
        end = matrix[row].length;
        while (start + 1 < end) {
            mid = start + (end - start) / 2;
            if (matrix[row][mid] == target) return true;
            if (matrix[row][mid] > target) {
                end = mid;
            } else {
                start = mid;
            }
        }

        return matrix[row][start] == target ? true : false;

    }


    @Test
    public void test() {
        SearchTwo s = new SearchTwo();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};

        System.out.println(s.searchMatrix(matrix, 3));
    }
}
