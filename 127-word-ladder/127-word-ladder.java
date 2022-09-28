class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            
        Set<String> set = new HashSet<>();
        
        for(String word : wordList)
            set.add(word);
        
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        
        set.remove(beginWord);
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            while(size-- > 0){
                
                String currWord = q.poll();
                System.out.print(currWord+" ");
                
                if(currWord.equals(endWord))
                    return level;
                
                for(int i=0; i<currWord.length(); i++){
                    for(char c='a'; c<='z'; c++){
                        char[] temp = currWord.toCharArray();
                        
                        temp[i] = c;
                        
                        String replacedWord = new String(temp);
                        
                        if(set.contains(replacedWord) == true){
                            set.remove(replacedWord);
                            q.add(replacedWord);
                        }
                    }
                }
            }
            System.out.println();
            
            level++;
        }
        
        return 0;
    }
}