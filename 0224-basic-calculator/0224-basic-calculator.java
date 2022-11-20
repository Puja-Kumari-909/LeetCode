class Solution {
    public int calculate(String s) {
        
        int len = s.length();
        int sign = 1;
        int ans = 0;
        int currNo = 0;
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0; i<len; i++){
            if(Character.isDigit(s.charAt(i))){
                currNo = s.charAt(i) - '0';
                
                while(i+1<len && Character.isDigit(s.charAt(i+1))){
                    currNo = currNo * 10 + s.charAt(i+1) - '0';
                    i++;
                }
                
                currNo = currNo * sign;
                ans = ans + currNo;
                currNo = 0;
                sign = 1;
            }
            else if(s.charAt(i)=='+')
                sign = 1;
            else if(s.charAt(i)=='-')
                sign = -1;
            else if(s.charAt(i)=='('){
                st.push(ans);
                st.push(sign);
                ans = 0;
                sign = 1;
            }
            else if(s.charAt(i)==')'){
                int prevSign = st.pop();
                ans = prevSign * ans;
                int prevAns = st.pop();
                ans += prevAns;
            }
        }
        
        return ans;
    }
}