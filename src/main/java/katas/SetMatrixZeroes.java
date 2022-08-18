package katas;

class SetMatrixZeroes {
  public void execute(int[][] matrix) { // in place
    var firstColumnIs0 = false;
    var firstRowIs0 = false;

    for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) { // n
      if (matrix[rowIndex][0] == 0) {
        firstColumnIs0 = true;
        break;
      }
    }

    for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) { // m
      if (matrix[0][columnIndex] == 0) {
        firstRowIs0 = true;
        break;
      }
    }

    for (int rowIndex = 1; rowIndex < matrix.length; rowIndex++) { // n
      for (int columnIndex = 1; columnIndex < matrix[0].length; columnIndex++) { // m
        if (matrix[rowIndex][columnIndex] == 0) {
          matrix[0][columnIndex] = 0;
          matrix[rowIndex][0] = 0;
        }
      }
    }

    for (int rowIndex = 1; rowIndex < matrix.length; rowIndex++) { // n
      for (int columnIndex = 1; columnIndex < matrix[0].length; columnIndex++) { // m
        if (matrix[0][columnIndex] == 0 || matrix[rowIndex][0] == 0) {
          matrix[rowIndex][columnIndex] = 0;
        }
      }
    }

    for (int rowIndex = 0; rowIndex < matrix.length; rowIndex++) { // n
      if (firstColumnIs0) {
        matrix[rowIndex][0] = 0;
      }
    }

    for (int columnIndex = 0; columnIndex < matrix[0].length; columnIndex++) { // m
      if (firstRowIs0) {
        matrix[0][columnIndex] = 0;
      }
    }

  }
}
