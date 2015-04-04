package calculator;
import java.util.*;
public class RPN {
public static int priority(char x){
    int result=0;
    if(x=='(')result=0;
    else if(x=='+' || x=='-') result= 1;
    else if(x=='/' || x=='*') result= 2;
    return result;
}
public static String rpn(String str){
    Stack<Character> s=new Stack<Character>();
    String RPN="";
    boolean isnegative=false;
    int j=0;
    for(int i=0; i<str.length(); i++){
        Character ch=str.charAt(i);
        //System.out.println(s.size());
        //if(ch==' ')continue;
        if(i==0 && ch=='-'){isnegative=true;continue;}
        else
            if(ch=='-' && (str.charAt(i-1)<'0' || str.charAt(i-1)>'9')){isnegative=true;continue;}
        if(ch>='0' && ch<='9'){
            for(j=i; j<str.length(); j++){
                //if(ch=='-')continue;
                ch=str.charAt(j);
                if(ch<'0'|| ch>'9')
                    break;
            }
            //if(str.charAt(i-1)=='-')
            //    RPN+=new StringBuffer("-" + str.substring(i, j) + " ").toString();
            if(isnegative==true){RPN+=new StringBuffer(str.substring(i-1,j)+" ").toString();isnegative=false;i=j-1;}
            else
            { RPN+=new StringBuffer(str.substring(i, j)+" ").toString();i=j-1;}
            //System.out.println(str.substring(i-1,j));
            
            continue;
        }
        //System.out.println(ch);
        if(ch=='('){
            
            s.push(ch);
            continue;
        }
        //System.out.println(ch);
        if(ch==')'){
            //System.out.println(s.peek());
            while(true){
                if(s.size()==0)break;
                if(s.peek()=='('){s.pop();break;}
                //System.out.println(s.size());
                RPN=RPN+new StringBuffer((String.valueOf(s.peek()))).toString();
                
                s.pop();
                //System.out.println(s.size());
            }
            continue;
        }
        int k1,k2;
        k1=priority(ch);
        if(s.size()!=0)
            k2=priority(s.peek());
        while(!s.empty()){
            k2=priority(s.peek());
            if(k1<=k2){RPN+=new StringBuffer((String.valueOf(s.peek()))).toString();s.pop();}
            else break;
        }
        s.push(ch);
        /*else k1=0;
        if(k1>k2){s.push(ch);continue;}
        else{
            while(k<=k1){
                RPN+=new StringBuffer((String.valueOf(s.peek()))).toString();
                s.pop();
                if(s.size()==0)break;
            }
            s.push(ch);
        }*/
    }
    if(s.size()!=0){
        while(!s.empty()){
            RPN+=new StringBuffer(String.valueOf(s.peek())).toString();
            s.pop();
        }
    }
    return RPN;
}
public static void calculate(String str){
    double result=0;
    boolean changed=false;
    boolean isnegative=false;
    int j=0;
    Stack<Double> s=new Stack<Double>();
   // str=str.replaceAll(" ", "");
    for(int i=0; i<str.length(); i++){
        char ch=str.charAt(i);
        if(ch==' ')continue;
        if(i==0 && ch=='-'){isnegative=true;continue;}
        else
        if(ch=='-' && (str.charAt(i-1)<'0' || str.charAt(i-1)>'9')){isnegative=true;continue;}
        if(ch>='0' && ch<='9'){
            for(j=i; j<str.length(); j++){
                ch=str.charAt(j);
                
                if(ch<'0'|| ch>'9')
                    break;
            }
            if(isnegative==true){s.push(Double.parseDouble(str.substring(i-1,j)));isnegative=false;i=j-1;}
            else
            { s.push(Double.parseDouble(str.substring(i, j)));i=j-1;}
            
            continue;
        }
        else{
        double num1,num2;
       switch(ch){
           
           case '+':{
               num2=s.pop();
               num1=s.pop();
               result=num1+num2;
               s.push(result);
               changed=true;
           }
           break;
           case '-':{
               num2=s.pop();
               num1=s.pop();
               result=num1-num2;
               s.push(result);
               changed=true;
           }
           break;
           case '*':{
               num2=s.pop();
               num1=s.pop();
               result=num1*num2;
               s.push(result);
               changed=true;
           }
           break;
           case '/':{
               num2=s.pop();
               num1=s.pop();
               result=num1/num2;
               s.push(result);
               changed=true;
           }
           break;
           default: result=s.pop();
           break;
       }}
    }
    if(changed==false)result=s.peek();
    System.out.println(result);
}
public static void main(String[] args) {
    
    
    //str1="3 + (-5 + 9*7 + 9)";
    //String str1="-57*5";
    //str1=str1.replaceAll(" ", "");
    //String str2=rpn(str1);
    //System.out.println(str2);
    //System.out.println(str1);
    //str1="3+(5+9*7+9)";
    //System.out.println(rpn(str1));
    
    //System.out.println(str2);
    //calculate(str2);
    
    
    Scanner in = new Scanner(System.in);
    String input;
    System.out.println("Hello!");
    while(true){
        System.out.println("Enter expression:> ");
        input = new StringBuilder(in.nextLine()).toString();
        if(input.equals("exit"))break;
        input=input.replaceAll(" ", "");
        String str_result=rpn(input);
        System.out.println("Output:> ");
        calculate(str_result);
    }
    
}
}