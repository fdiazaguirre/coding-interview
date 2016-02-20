/**
 * Created by fdiazaguirre on 2/19/16.
 * Since JS works by reference initial doesn't work with arrays declared as [].
 */
Array.matrix = function(rows, cols) {
    var matrix = [], i, j, columns;

    for (i = 0; i < rows; ++i) {
        // reset for every row.
        columns = [];
        for (j = 0; j < cols; ++j) {
            columns[j] = new Array();
        }
        matrix[i] = columns;
    }

    return matrix;
};
