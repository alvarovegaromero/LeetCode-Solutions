//https://leetcode.com/problems/isomorphic-strings

// First approach
// Time Complexity: O(n) - Space Complexity: O(n)
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Constraint given. No need to check
        // if(s.length() == 0 && s.length() != t.length())
        //    return false;
        
        Map<Character, Character> isomorphicTransformation = new HashMap<>();

        StringBuilder isomorphicT = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {
            if(!isomorphicTransformation.containsKey(s.charAt(i))) {
                if(isomorphicTransformation.containsValue(t.charAt(i)))
                    return false;

                isomorphicTransformation.put(s.charAt(i), t.charAt(i));
            }
    
            isomorphicT.append(isomorphicTransformation.get(s.charAt(i)));
        }

        if(!t.equals(isomorphicT.toString()))
            return false;

        return true;
    }
}

// Second approach removing the need of a StringBuilder
// Time Complexity: O(n) - Space Complexity: O(n)

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> isomorphicTransformation = new HashMap<>();

        char sCharacter, tCharacter;

        for(int i = 0; i < s.length(); i++) {
            sCharacter = s.charAt(i);
            tCharacter = t.charAt(i);

            if(!isomorphicTransformation.containsKey(sCharacter)) {
                if(isomorphicTransformation.containsValue(tCharacter))
                    return false;

                isomorphicTransformation.put(sCharacter, tCharacter);
            }

            if(tCharacter != isomorphicTransformation.get(sCharacter))
                return false;
        }

        return true;
    }
}

// Third approach using two HashMaps
// Time Complexity: O(n) - Space Complexity: O(n)
// But faster as containsValue is not used (and it is O(n))
class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> transformationST = new HashMap<>();
        Map<Character, Character> transformationTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            Character sCharTransformed = transformationST.get(sChar);

            if(sCharTransformed == null) {
                if(transformationTS.containsKey(tChar))
                    return false;

                transformationST.put(sChar, tChar);
                transformationTS.put(tChar, sChar);
            } else if(!sCharTransformed.equals(tChar))
                return false;
        }

        return true;
    }
}

// Fourth approach using two arrays
// Time Complexity: O(n) - Space Complexity: O(1)
// Faster than the previous one as it uses arrays instead of HashMaps
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // ASCII interval is [0, 127]
        int[] mapST = new int[128];
        int[] mapTS = new int[128];

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (mapST[sChar] == 0 && mapTS[tChar] == 0) {
                mapST[sChar] = tChar;
                mapTS[tChar] = sChar;
            } else if (mapST[sChar] != tChar)
                return false;
        }
        return true;
    }
}