package katas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GroupAnagramsTest {

  @Test
  void shouldNotGroupDifferentAnagrams() {
    var groupAnagrams = new GroupAnagrams();
    var input = new String[] {"eat", "tin"};

    var result = groupAnagrams.execute(input);

    var expectedResult = List.of(List.of("eat"), List.of("tin"));
    assertEquals(expectedResult.toString(), result.toString());
  }

  @Test
  void shouldGroup2Anagrams() {
    var groupAnagrams = new GroupAnagrams();
    var input = new String[] {"eat", "ate"};

    var result = groupAnagrams.execute(input);

    var expectedResult = List.of(List.of("eat", "ate"));
    assertEquals(expectedResult.toString(), result.toString());
  }

  @Test
  void shouldAcceptEmptyString() {
    var groupAnagrams = new GroupAnagrams();
    var input = new String[] {""};

    var result = groupAnagrams.execute(input);

    var expectedResult = List.of(List.of(""));
    assertEquals(expectedResult.toString(), result.toString());
  }

}
