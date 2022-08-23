package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

  @Test
  void shouldFindALetterInA1x1Board() {
    var wordSearch = new WordSearch();
    var board = new char[][] {new char[] {'a'}};

    var result = wordSearch.execute(board, "a");

    assertTrue(result);
  }

  @Test
  void shouldFindA2CharactersWordAtTheBeginningOfTheBoard() {
    var wordSearch = new WordSearch();
    var board = new char[][] {new char[] {'a', 'b'}};

    var result = wordSearch.execute(board, "ab");

    assertTrue(result);
  }

  @Test
  void shouldFindAMultiCharacterWordAtTheBeginningOfTheBoard() {
    var wordSearch = new WordSearch();
    var board = new char[][] {new char[] {'a', 'b', 'c'}, new char[] {'d', 'e', 'f'}, new char[] {'h', 'i', 'j'}};

    var result = wordSearch.execute(board, "abefj");

    assertTrue(result);
  }

  @Test
  void shouldNotFindAWorldIfItIsNotInTheMatrix() {
    var wordSearch = new WordSearch();
    var board = new char[][] {new char[] {'a', 'b', 'c'}, new char[] {'d', 'e', 'f'}, new char[] {'h', 'i', 'j'}};

    var result = wordSearch.execute(board, "abffj");

    assertFalse(result);
  }

  @Test
  void shouldBacktrackOtherOptionsWhenWordIsAtTheBeginningOfTheBoard() {
    var wordSearch = new WordSearch();
    var board = new char[][] {
        new char[] {'a', 'b', 'c'},
        new char[] {'b', 'e', 'f'},
        new char[] {'h', 'i', 'j'}};

    var result = wordSearch.execute(board, "abhij");

    assertTrue(result);
  }

  @Test
  void shouldBacktrackOtherOptionsWhenWordIsInTheMiddleOfTheBoard() {
    var wordSearch = new WordSearch();
    var board = new char[][] {
        new char[] {'a', 'b', 'c'},
        new char[] {'b', 'e', 'f'},
        new char[] {'h', 'i', 'j'}};

    var result = wordSearch.execute(board, "ebabcfj");

    assertTrue(result);
  }

  @Test
  void acceptanceTest() {
    var wordSearch = new WordSearch();
    var board = new char[][] {
        new char[] {'A','B','C','E'},
        new char[] {'S','F','C','S'},
        new char[] {'A','D','E','E'}};

    var result = wordSearch.execute(board, "SEE");

    assertTrue(result);
  }




  // not matches in the first position
  // multiple starting points (second matches)

}
