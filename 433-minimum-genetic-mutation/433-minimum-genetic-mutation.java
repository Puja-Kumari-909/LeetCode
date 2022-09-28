class Solution {
    public int minMutation(String start, String end, String[] bank) {

        Set<String> set = new HashSet<>();
        
        for(String valid : bank)
            set.add(valid);
        
        Queue<String> q = new LinkedList<>();
        
        q.add(start);
        int level = 0;
        
        set.remove(start);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size -- > 0){
                String curr = q.poll();
                
                if(curr.equals(end))
                    return level;
                
                for(int i=0; i<curr.length(); i++){
                    char[] temp = curr.toCharArray();
                    
                    temp[i] = 'A';
                    String replacedWord = new String(temp);
                    
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(replacedWord);
                    }
                    
                    temp[i] = 'C';
                    replacedWord = new String(temp);
                    
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(replacedWord);
                    }
                    
                    temp[i] = 'G';
                    replacedWord = new String(temp);
                    
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(replacedWord);
                    }
                    
                    temp[i] = 'T';
                    replacedWord = new String(temp);
                    
                    if(set.contains(replacedWord)){
                        set.remove(replacedWord);
                        q.add(replacedWord);
                    }
                }
            }
            
            level++;
        }
        
        return -1;
    }
}