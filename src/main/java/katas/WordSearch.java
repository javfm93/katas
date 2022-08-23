package katas;

class WordSearch {
  char[][] board;
  boolean notFound = false;
  boolean found = true;
  char[] wordCharacters;
  char cellVisitedChar = '*';

  public boolean execute(char[][] board, String word) {
    this.board = board;
    this.wordCharacters = word.toCharArray();
    for (var i = 0; i<board.length; i++) {
      for(var j = 0; j <board[0].length; j++) {
        if (board[i][j] == wordCharacters[0]) {
          if (processNode(1, i, j)) {
            return true;
          }

        }
      }
    }

    return notFound;
  }

  private boolean processNode(int pos, int lastHitRow, int lastHitColumn) {
    if (pos == wordCharacters.length) return found;
    if (isWordFoundUsingUpperAdjacent(pos, lastHitRow, lastHitColumn)) return found;
    if (isWordFoundUsingRightAdjacent(pos, lastHitRow, lastHitColumn)) return found;
    if (isWordFoundUsingBottomAdjacent(pos, lastHitRow, lastHitColumn)) return found;
    if (isWordFoundUsingLeftAdjacent(pos, lastHitRow, lastHitColumn)) return found;
    return notFound;
  }

  private boolean isWordFoundUsingLeftAdjacent(int pos, int lastHitRow, int lastHitColumn) {
    var leftAdjacent = getLeftAdjacent(lastHitRow, lastHitColumn);
    if (leftAdjacent != null && wordCharacters[pos] == leftAdjacent) {
      var hitChar = board[lastHitRow][lastHitColumn];
      board[lastHitRow][lastHitColumn] = cellVisitedChar;
      var isSolution = processNode(pos + 1, lastHitRow, lastHitColumn - 1);
      if (isSolution) return true;
      board[lastHitRow][lastHitColumn] = hitChar;
    }
    return false;
  }

  private boolean isWordFoundUsingBottomAdjacent(int pos, int lastHitRow, int lastHitColumn) {
    var bottomAdjacent = getBottomAdjacent(lastHitRow, lastHitColumn);
    if (bottomAdjacent != null && wordCharacters[pos] == bottomAdjacent) {
      var hitChar = board[lastHitRow][lastHitColumn];
      board[lastHitRow][lastHitColumn] = cellVisitedChar;
      var isSolution = processNode(pos + 1, lastHitRow + 1, lastHitColumn);
      if (isSolution) return true;
      board[lastHitRow][lastHitColumn] = hitChar;
    }
    return false;
  }

  private boolean isWordFoundUsingRightAdjacent(int pos, int lastHitRow, int lastHitColumn) {
    var rightAdjacent = getRightAdjacent(lastHitRow, lastHitColumn);
    if (rightAdjacent != null && wordCharacters[pos] == rightAdjacent) {
      var hitChar = board[lastHitRow][lastHitColumn];
      board[lastHitRow][lastHitColumn] = cellVisitedChar;
      var isSolution = processNode(pos + 1, lastHitRow, lastHitColumn + 1);
      if (isSolution) return true;
      board[lastHitRow][lastHitColumn] = hitChar;
    }
    return false;
  }

  private boolean isWordFoundUsingUpperAdjacent(int pos, int lastHitRow, int lastHitColumn) {
    var upperAdjacent = getUpperAdjacent(lastHitRow, lastHitColumn);
    if (upperAdjacent != null && wordCharacters[pos] == upperAdjacent) {
      var hitChar = board[lastHitRow][lastHitColumn];
      board[lastHitRow][lastHitColumn] = cellVisitedChar;
      var isSolution = processNode(pos + 1, lastHitRow - 1, lastHitColumn);
      if (isSolution) return true;
      board[lastHitRow][lastHitColumn] = hitChar;
    }
    return false;
  }

  private Character getUpperAdjacent(int lastHitRow, int lastHitColumn) {
    return lastHitRow > 0 ? board[lastHitRow - 1][lastHitColumn] : null;
  }
  private Character getRightAdjacent(int lastHitRow, int lastHitColumn) {
    return lastHitColumn < board[0].length - 1 ?
        board[lastHitRow][lastHitColumn + 1] : null;
  }
  private Character getBottomAdjacent(int lastHitRow, int lastHitColumn) {
    return lastHitRow < board.length - 1 ? board[lastHitRow + 1][lastHitColumn] : null;
  }
  private Character getLeftAdjacent(int lastHitRow, int lastHitColumn) {
    return lastHitColumn > 0 ? board[lastHitRow][lastHitColumn - 1] : null;
  }
}
