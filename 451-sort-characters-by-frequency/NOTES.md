Map<Character, Integer> hm = new HashMap<>();
for(char c : s.toCharArray()){
hm.put(c, hm.getOrDefault(c, 0) + 1);
}
PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> hm.get(b) - hm.get(a));
for(char c : hm.keySet()){
pq.offer(c);
}
StringBuilder sb = new StringBuilder();
while(!pq.isEmpty()){
char c = pq.poll()
int times = hm.get(c);
while(times>0){
sb.append(letter);
}
}
return sb.toString();