class Solution {
    public void reverseString(char[] s) {
        reverse(s,0,s.length-1);
    }

    public char[] reverse(char[] s,int i, int j){
        if(i>=j){
            return s;
        }

        char temp= s[i];
        s[i]=s[j];
        s[j]=temp;

        return reverse(s,i+1,j-1);
    }
}