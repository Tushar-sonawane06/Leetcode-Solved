class Solution {
    public boolean validPalindrome(String s){
        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return ifPalindrome(s,i+1,j) || ifPalindrome(s,i,j-1);
            }

            i++;
            j--;
        }
        return true;
    }

    public static boolean ifPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    
}