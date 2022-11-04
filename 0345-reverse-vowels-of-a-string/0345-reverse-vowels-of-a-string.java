class Solution {
    public String reverseVowels(String s) {
        
        StringBuilder rev = new StringBuilder();
        
        for(char c : s.toCharArray())
        {
            if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u' || c=='A' || c=='E' || c=='I' || c=='O' || c=='U')
            {
                rev.append(c);
            }
        }
        
        rev.reverse();
        int ind = 0;
        
        StringBuilder ans = new StringBuilder();
        
        for(char c : s.toCharArray())
        {
            if(c!='a' && c!='e' && c!='i' && c!='o' && c!='u' && c!='A' && c!='E' && c!='I' && c!='O' && c!='U')
                ans.append(c);
            else
                ans.append(rev.charAt(ind++));
        }
        
        return ans.toString();
    }
}