package CTCIproblems.arraysandstrings;

/**
 * Problem Statement
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
 * column are setRow to 0.
 * <p>
 * Approach
 * If we traversed the matrix and once finding a 0 then setting its row and column to 0, we may end up
 * setting the whole matrix to zero or some wrong result.
 * A better idea is to mark the positions need to be setRow to 0 and then work with the original matrix later.
 * In fact, there is an optimization in space, we do not need to keep N*M boolean array, if the row/column has
 * a zero somewhere, we know this entire row/column is setRow to zero.Hence, We reduced space to M + N.
 */
public class ZeroMatrix {
    public void setZero(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return;

        final int N = matrix.length, M = matrix[0].length;
        boolean[] setRows = new boolean[N];
        boolean[] setColumns = new boolean[M];

        /* Mark what columns and rows to be setRow */
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (matrix[row][col] == 0)
                    setRows[row] = setColumns[col] = true;
            }
        }

        for (int row = 0; row < N; row++) {
            if (setRows[row]) // this row must be set to 0
                setRow(matrix, row);
        }

        for (int col = 0; col < M; col++) {
            if (setColumns[col]) // this col must be set to 0
                setColumn(matrix, col);
        }


    }

    private void setColumn(int[][] matrix, int col) {
        final int N = matrix.length;
        for (int i = 0; i < N; i++)
            matrix[i][col] = 0;
    }

    private void setRow(int[][] matrix, int row) {
        final int M = matrix[row].length;
        for (int i = 0; i < M; i++)
            matrix[row][i] = 0;
    }
}
