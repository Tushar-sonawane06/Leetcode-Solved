class Solution {
    public boolean isValid(String s) {
        Stack<Integer> stack=new Stack<>();

        for(int i=0;i<s.length();i++){
            int curr=s.charAt(i);
            if(curr=='('|| curr=='{' || curr=='['){
                stack.push(curr);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                if((stack.peek()=='(' && curr==')') || (stack.peek()=='{' && curr=='}') || (stack.peek()=='[' && curr==']')){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }
}