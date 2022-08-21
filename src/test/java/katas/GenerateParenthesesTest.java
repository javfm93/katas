package katas;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest  {

  @Test
  void ShouldResolveWhenNIs1() {
    var generateParentheses = new GenerateParentheses();

    var result = generateParentheses.execute(1);

    var expectedResult = List.of("()");
    assertEquals(expectedResult, result);
  }

  @Test
  void ShouldResolveWhenNIs2() {
    var generateParentheses = new GenerateParentheses();

    var result = generateParentheses.execute(2);

    var expectedResult = List.of("(())", "()()");
    assertEquals(expectedResult, result);
  }
}
