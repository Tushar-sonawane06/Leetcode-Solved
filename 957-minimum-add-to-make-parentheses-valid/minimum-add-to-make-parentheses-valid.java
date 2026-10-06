class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push(s.charAt(i));
            }else{
                
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                }else{
                    stack.push(s.charAt(i));
                }
            }
        }
        if(stack.isEmpty()){
            return 0;
        }else{
            return stack.size();
        }
    }
}