class Solution {
    public boolean isValid(String s) {
        Stack<Character> sk=new Stack<>();

        for(int i=0;i<s.length();i++){
            char curr = s.charAt(i);

            if(curr=='('||curr=='['||curr=='{'){
                sk.push(curr);
            }else{
                if(sk.isEmpty()){
                    return false;
                }
                if(sk.peek()=='(' && curr== ')' || sk.peek()=='[' && curr==']' || sk.peek()=='{' && curr=='}'){
                    sk.pop();
                }else{
                    return false;
                }
            }

        }
        if(sk.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}