class Node {
    
    Node[] links = new Node[26];
    boolean flag = false;
        
    boolean containsKey(char ch){
        if(links[ch - 'a'] != null)
             return true;
        else
            return false;
    }
       
    Node next(char ch){
        return links[ch - 'a'];
    }
    
    void put(char ch, Node nextNode){
        links[ch-'a'] = nextNode;
    }
    
    void setEnd(){
        flag = true;
    }
        
    boolean isEnd(){
        return flag;
    }
}



class Trie {

    private static Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            if(!curr.containsKey(word.charAt(i))){
                curr.put(word.charAt(i), new Node());
            }
            curr = curr.next(word.charAt(i));
        }
        
        curr.setEnd();
    }
    
    public boolean search(String word) {
        
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            if(!curr.containsKey(word.charAt(i)))
                return false;
            
            curr = curr.next(word.charAt(i));
        }
        
        if(curr.isEnd())
            return true;
        
        return false;
    }
    
    public boolean startsWith(String prefix) {
        
        Node curr = root;
        
        for(int i=0; i<prefix.length(); i++){
            if(!curr.containsKey(prefix.charAt(i)))
                return false;
            curr = curr.next(prefix.charAt(i));
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */