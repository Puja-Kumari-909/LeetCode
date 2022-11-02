class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        Set<String> set = new HashSet<>();
        
        for(String valid : bank)
            set.add(valid);
        
        Queue<String> q = new LinkedList<>();
        
        q.add(start);
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            while(size-- > 0){
                String curr = q.poll();

                if(curr.equals(end))
                    return level;

                for(int i=0; i<curr.length(); i++){
                    char[] temp = curr.toCharArray();

                    char[] choices = {'A', 'C', 'G','T'};

                    for(int j=0; j<4; j++){
                        temp[i] = choices[j];
                        String newWord = new String(temp);

                        if(set.contains(newWord)){
                            q.add(newWord);
                            set.remove(newWord);
                        }
                    }
                }
            }
            level++;
        }
        return -1;
    }
}