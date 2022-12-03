class Solution {
    
    class Pair{
        Character c;
        int freq;
        
        Pair(char ch, int f){
            c = ch;
            freq = f;
        }
    }
    
    public String frequencySort(String s) {
        if(s.length()==1)
            return s;
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);
        
        for(Map.Entry<Character, Integer> ent : map.entrySet()){
            char ch = ent.getKey();
            int frequency = ent.getValue();
            
            pq.add(new Pair(ch, frequency));
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()){
            char curr = pq.peek().c;
            int times = pq.peek().freq;
            
            while(times-->0){
                sb.append(curr);
            }
            
            pq.poll();
        }
        
        return sb.toString();
    }
}