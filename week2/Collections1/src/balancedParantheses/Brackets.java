package balancedParantheses;

import java.util.Stack;

public class Brackets {
    public static boolean checkBrackets(String str){
        Stack<Character> s=new Stack<Character>();
        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            if(ch=='(')s.push(ch);
            else{
                if(s.size()==0)return false;
                else s.pop();
            }
        }
        return s.size()==0;
    }
    public static void main(String[] args) {
        System.out.println(checkBrackets("()()())))((())("));
        
    }

}
