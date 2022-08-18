package katas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class GroupAnagrams {
  public List<List<String>> execute(String[] strs) {
    var anagramIndex = new HashMap<String, List<String>>();
    for (String word : strs) { // n
      var unorderedWord = word.toCharArray();
      Arrays.sort(unorderedWord); // k
      var orderedWord = String.valueOf(unorderedWord);
      if (!anagramIndex.containsKey(orderedWord)) {
        anagramIndex.put(orderedWord, new ArrayList<>());
      }
      anagramIndex.get(orderedWord).add(word);
    }

    return anagramIndex.values().stream().toList();
  }
}
