package Manipulation;

import java.util.*;

public class StringUtils {

    public static Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'o', 'u', 'i'));

    public static int countVowels(String input) {
        if(input == null)
            return 0;

        int count = 0;

        for(char ch : input.toLowerCase().toCharArray()) {
            if(vowels.contains(ch))
                count++;
        }

        return count;
    }

    public static String reversString(String input) {
        if(input == null)
            return "";

        StringBuilder reversed = new StringBuilder();

        for(int i = input.length() - 1; i >= 0; i--)
            reversed.append(input.charAt(i));

        return reversed.toString();
    }

    /*
     * This approach requires more space and less code.
     */
    public static String reverseStringWithStack(String input) {
        if(input == null)
            return "";

        Stack<Character> stack = new Stack<>();
        StringBuilder reversed = new StringBuilder();

        for(char ch : input.toCharArray()) {
            stack.push(ch);
        }

        while(!stack.empty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static String reverseWords(String input) {
        if(input == null)
            return "";

        String[] words = input.trim().split(" ");
        StringBuilder reversed = new StringBuilder();

        for(int i = words.length - 1; i >= 0; i--) {
            reversed.append(words[i] + " ");
        }

        return reversed.toString().trim(); // To remove the last space
    }

    public static String reverseWordsWithCollectionUtils(String input) {
        if(input == null)
            return "";

        String[] words = input.trim().split(" ");
        Collections.reverse(Arrays.asList(words));

        return String.join(" ", words);
    }

    public static boolean isRotation(String source, String target) {
        if(source == null || target == null)
            return false;

        return (source.length() == target.length() && (source + source).contains(target));
    }

    public static String removeDuplicates(String input) {
        if(input == null) {
            return "";
        }

        Set<Character> characters = new HashSet<>();
        StringBuilder result = new StringBuilder();

        for(char ch: input.toCharArray()) {
            if(!characters.contains(ch)) {
                result.append(ch);
                characters.add(ch);
            }
        }

        return result.toString();
    }
    /*
     * There is an implementation using an array, if our array has only ASCII characters.
     */
    public static char getMostRepeatedChar(String input) {
        if(input == null || input.isEmpty())
            throw new IllegalArgumentException();

        Hashtable<Character, Integer> occurrences = new Hashtable<>();

        for(char ch : input.toCharArray()) {
            if(!occurrences.containsKey(ch)){
                occurrences.put(ch, 1);
            } else {
                occurrences.replace(ch, occurrences.get(ch) + 1);
            }
        }

        int max = 0;
        char result = Character.MIN_VALUE;
        for(char ch : occurrences.keySet()) {
            if(occurrences.get(ch) > max) {
                result = ch;
                max = occurrences.get(ch);
            }
        }

        return result;
    }

    public static String sentenceCapitalization(String input) {
        if(input == null || input.trim().isEmpty())
            return "";

        String[] words = input
                .trim()
                .replaceAll(" +", " ") //Removing one or more whitespaces with only one
                .split(" ");

        for(int i = 0; i < words.length; i++)
            words[i] = words[i].substring(0,1).toUpperCase() + words[i].substring(1).toLowerCase();

        return String.join(" ", words);
    }

    // O(n log n)
    public static boolean isAnagram(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() != str2.length())
            return false;

        char[] array1 = str1.toCharArray();
        char[] array2 = str2.toCharArray();

        Arrays.sort(array1);
        Arrays.sort(array2);

        return Arrays.equals(array1, array2);
    }

    // Case insensitive
    public static boolean isPalindrome(String input) {
        if(input == null)
            return false;

        int left = 0;
        int right = input.length() - 1;

        while(left < right) {
            if (input.charAt(left) != input.charAt(right))
                return false;
            left++;
            right--;
        }

        return true;
    }


}