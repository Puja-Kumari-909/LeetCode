class Solution {
    
    class Pair{
        int freq;
        char character;
        
        Pair(int f, char c){
            freq = f;
            character = c;
        }
    }
    
    public String frequencySort(String s) {
        
        Map<Character, Integer> hm = new HashMap<>();
            
        for(char c : s.toCharArray()){
            hm.put(c, hm.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        
        for(Map.Entry<Character, Integer> ent : hm.entrySet()){
            int val = ent.getValue();
            char c = ent.getKey();
            
            pq.add(new Pair(val, c));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            Pair temp = pq.poll();
            int times = temp.freq;
            char letter = temp.character;
            
            while(times>0){
                sb.append(letter);
                times--;
            }
        }
        
        return sb.toString();
    }
}

