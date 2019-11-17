package HashTables;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommonQuestions {

    // Find the first non repeated character on a string
    public static char FirstNonRepeatedCharacter(String string) {
        Map<Character, Integer> hastTable = new HashMap<>();

        var chars = string.toCharArray();
        for(char value : chars) {
            var count = hastTable.containsKey(value) ? hastTable.get(value) : 0;
            hastTable.put(value, count + 1);
        }

        for(char value : chars)
            if(hastTable.get(value) == 1)
                return value;

        return Character.MIN_VALUE;
    }

    // Find the first repeated character on a string
    public static char FirstRepeatedCharacter(String string) {
        Set<Character> set = new HashSet<>();

        var chars = string.toCharArray();
        for(char value : chars) {
            if(set.contains(value)) {
                return value;
            } else {
                set.add(value);
            }
        }
        return Character.MIN_VALUE;
    }
}
