class MyCalendar {

    TreeSet<int[]> entries;
    
    public MyCalendar() {
        entries = new TreeSet<int[]> ((int[] a, int[] b) -> a[0] - b[0]);
    }
    
    public boolean book(int start, int end) {
        
        int[] entry = new int[2];
        entry[0] = start;
        entry[1] = end;
        
        int[] floor = entries.floor(entry);
        int[] ceiling = entries.ceiling(entry);
        
        if(floor != null && start < floor[1]) 
            return false;
        
        if(ceiling != null && end >ceiling[0])
            return false;
        
        entries.add(entry);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */