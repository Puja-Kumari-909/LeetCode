class RandomizedSet {

    ArrayList<Integer> arr;
    Map<Integer, Integer> map;
    java.util.Random rand = new java.util.Random();
    public RandomizedSet() {
        arr = new ArrayList<Integer>();
        map = new HashMap<Integer, Integer>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
            return false;
        
        arr.add(val);
        map.put(val, arr.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val))
            return false;
        
        int index = map.get(val);
        if (index < arr.size() - 1 ) { // not the last one than swap the last one with this val
                    
            int lastEle = arr.get(arr.size()-1);
            arr.set(index , lastEle);
            map.put(lastEle, index);
        }
        map.remove(val);
        arr.remove(arr.size() - 1);
        return true;
    }
    
    public int getRandom() {
         return arr.get( rand.nextInt(arr.size()) );
    }
}