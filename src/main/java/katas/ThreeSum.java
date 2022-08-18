package katas;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ThreeSum {
  public List<List<Integer>> execute(int[] nums) {
    var candidates = Arrays.stream(nums).sorted().toArray();
    Set<List<Integer>> results  = new HashSet<>();
    for (int i = 0; i < candidates.length - 2; i++) { // n
      if (i!= 0 && candidates[i] == candidates[i - 1]) continue;
      Map<Integer, Integer> candidatesIndex = new HashMap<>();
      var fixedCandidate = candidates[i];

      for(int j = i+1; j < candidates.length; j++) { // n
        var numberRequiredForTriplet = -fixedCandidate - candidates[j];
        var tentativeCandidateIndex = candidatesIndex.get(numberRequiredForTriplet);
        var isAValidCandidate = tentativeCandidateIndex != null && !tentativeCandidateIndex.equals(i) && !tentativeCandidateIndex.equals(j);

        if (isAValidCandidate) {
          var tentativeResult = Stream.of(candidates[i], candidates[j], numberRequiredForTriplet).sorted().toList();
          results.add(tentativeResult);
          while (j + 1 < candidates.length && candidates[j+1] == candidates[j]) ++j;
        }
        candidatesIndex.put(candidates[j], j);
      }
    }
    return results.stream().toList();

  }
}
