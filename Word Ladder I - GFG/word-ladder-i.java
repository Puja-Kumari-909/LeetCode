//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> set = new HashSet<>();
        
        for(String word : wordList)
            set.add(word);
            
        
        Queue<String> q = new LinkedList<>();
        q.add(startWord);
        set.remove(startWord);
        
        int level = 1;
        boolean found = false;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size-->0){
                String curr = q.poll();
                
                if(curr.equals(targetWord))
                    return level;
                
                for(int i=0; i<curr.length(); i++){
                    for(char c='a'; c<='z'; c++){
                        char[] arr = curr.toCharArray();
                        
                        arr[i] = c;
                        
                        String replacedWord = new String(arr);
                        
                        if(set.contains(replacedWord)){
                            set.remove(replacedWord);
                            q.add(replacedWord);
                        }
                    }
                }
            }
            level++;
        }
        
        return 0;
    }
}