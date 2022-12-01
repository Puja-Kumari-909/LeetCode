class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        int count = 0;
        int i = 0;
        int j = s.length()-1;
        
        while(i<j){
            if(vowels.contains(s.charAt(i++)))
                count++;
            if(vowels.contains(s.charAt(j--)))
                count--;
        }
        return count==0;
    }
}