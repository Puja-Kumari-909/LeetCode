//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    
    static class Pair{
        int first, second;
        
        Pair(int f, int s){
            first = f;
            second = s;
        }
    }

    static int countPaths(int n, List<List<Integer>> roads) {
        
        List<List<Pair>> adj = new ArrayList<>();
        
        for(int i=0; i<n; i++)
            adj.add(new ArrayList<Pair> ());
            
        for(List<Integer> road : roads){
            adj.get(road.get(0)).add(new Pair(road.get(1), road.get(2)));
            adj.get(road.get(1)).add(new Pair(road.get(0), road.get(2)));
        }
        
        int[] dist = new int[n];
        int[] numOfWays = new int[n];
        
        Arrays.fill(dist, 1000000007);
        Arrays.fill(numOfWays, 0);
        
        dist[0] = 0;
        numOfWays[0] = 1;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.second - b.second);
        pq.add(new Pair(0, 0));
        
        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            int currNode = curr.first;
            int currDist = curr.second;
            
            for(Pair it : adj.get(currNode)){
                int newNode = it.first;
                int newDist = it.second;
                
                if(currDist+newDist < dist[newNode]){
                    dist[newNode] = currDist+newDist;
                    pq.add(new Pair(newNode, currDist+newDist));
                    numOfWays[newNode] = numOfWays[currNode];
                }
                
                else if(currDist+newDist == dist[newNode]){
                    numOfWays[newNode] = (numOfWays[newNode] + numOfWays[currNode])%1000000007;
                }
            }
        }
        
        return numOfWays[n-1] % 1000000007;
    }
}
