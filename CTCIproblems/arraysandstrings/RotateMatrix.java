package CTCIproblems.arraysandstrings;

/**
 * Problem Statement
 * Given an image represented by an NxN matrix, where each pixel in the image is 4
 * bytes, write a method to rotate the image by 90 degrees. Can you do this in place?
 * <p>
 * Approach
 * consider 3x3 matrix:
 * 1 2 3              7 4 1
 * 4 5 6  result ---> 8 5 2
 * 7 8 9              9 6 3
 * if we observed, we replace rows with columns, i.e. row 0 -> col 0 ...etc.
 * but this will take O(n) space, we need an additional array to hold the overwritten row/col
 * we can do better, by rotating layer by layer from outside to inside. For instance,
 * 1 2 3
 * 4 - 6 this layer 0 , 5 is layer 1.
 * 7 8 9
 * for each layer, we swap corners, i.e.
 * top-left -> top-right,
 * top-right -> bottom-right,
 * bottom-right -> bottom-left,
 * bottom-left -> top-left
 * and repeat this process with next elements.
 */
public class RotateMatrix {

    public void rotate(int[][] matrix) {
        /* don't work with empty or non-squared matrices. */
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) return;

        final int N = matrix.length;
        for (int layer = 0; layer < N / 2; layer++) {
            int last = N - layer - 1; // last index in the current layer
            for (int i = layer; i < last; i++) {
                int offset = i - layer; // top-left + offset=1 --> the element next to top-left, etc.

                // store top-left
                int top = matrix[layer][i];
                // bottom-left -> top-left
                matrix[layer][i] = matrix[last - offset][layer];
                // bottom-right -> bottom-left
                matrix[last - offset][layer] = matrix[last][last - offset];
                // top-right -> bottom-right
                matrix[last][last - offset] = matrix[i][last];
                // stored top-left -> bottom-right
                matrix[i][last] = top;
            }
        }
    }
}
