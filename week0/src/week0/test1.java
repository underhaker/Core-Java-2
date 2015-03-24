package week0;

import java.util.Arrays;

public class test1 {
    public static boolean isOdd(int n){
        return n%2==1;
    }
    public static boolean isPrime(int N){
        for(int i=2; i*i<=N; i++)
            if(N%i==0)return false;
        return true;
    }
    public static int min(int[] array){
        int min_element=array[0];
        for(int i=1;i<array.length; i++)
        {
            if(array[i]<=min_element)min_element=array[i];
        }
        return min_element;
    }
    public static int kthMin(int k, int[] array){
        Arrays.sort(array);
        return array[k-1];
    }
    public static int getAverage(int[] array){
        int sum=0;
        for(int i=0; i<array.length; i++)
            sum+=array[i];
        return sum/array.length;
    }  
    public static long doubleFac(int n){
        long fact1=1,fact2=1;
        for(int i=2; i<=n; i++)
            fact1*=i;
        fact2=fact1;
        for(int i=n+1; i<=fact1; i++)
            fact2*=i;
        return fact2;
    }
    public static long kthFac(int k, int n){
        long fact1=1;
        for(int i=n; i>0; i-=k)fact1*=i;
        return fact1;
    }
    public static long getSmallestMultiple(int upperBound){
        long  i=upperBound+1;
        boolean flag=true;
        while(true)
        {
            flag=true;
            for(int j=2; j<=upperBound; j++)
            {
                if(i%j!=0){flag=false;break;}
            }
            if(flag==true)return i;
            i++;
        }
    }
    public static long getLargestPalindrome(long N){
        long[] ar=new long[1024];
        long i;
        for(i=N-1; i>=1; i--)
        {
            long k=i,y;
            int j=0;
            //System.out.print(k+" ");
            while(k!=0)
            {
                y=k%10;
                ar[j]=y;
                k/=10;
                j++;
            }
            boolean flag=true;
            //if(j%2==0)
            j--;
            for(int p=0; p<j-p; p++)
            {   //System.out.print(i+" "+p+" "+(j-p));
                //System.out.println();
                if(ar[p]!=ar[j-p]){flag=false;break;}
            }
            if(flag==true)
            {
                
                break;
            }
        }
        return i;
    }
    public static String reverseEveryWord(String arg) {
        int begin_pos=0,end_pos=0;
        begin_pos=0;
        String new_arg="";
        for(int i=0; i<arg.length(); i++)
       // while(end_pos<=arg.length())
        {
            if(arg.charAt(i)==' ')
            {
                //System.out.println(arg.charAt(i-1));
                end_pos=i;
                //System.out.println(begin_pos+" "+end_pos);
                String s=arg.substring(begin_pos, end_pos);
                //System.out.println(s);
                s=new StringBuilder(s).reverse().toString();
                // System.out.println(s);
                begin_pos=i+1;
                new_arg=new_arg+" ";
                new_arg=new_arg+s;
                
            }
        }
        if(begin_pos<=arg.length())
        {
            new_arg=new_arg+" ";
            end_pos=arg.length();
            String s=arg.substring(begin_pos, end_pos);
            s=new StringBuilder(s).reverse().toString();
            // System.out.println(s);
            new_arg=new_arg+s;
        }
        //System.out.println(begin_pos+" "+end_pos);
        return new_arg;
        //what is thiz
    }
    
    public boolean canBalance(int[] array) {
        int sum1=0,sum2=0;
        for(int i=1; i<array.length; i++)
        {
            for(int j=0; j<=i; j++)
                sum1+=array[j];
            for(int j=i; j<array.length; j++)
                sum2+=array[j];
            if(sum1==sum2)return true;
            sum1=sum2=0;
        }
        return false;
    }
        
    public static String decodeURL(String input) {
        input=input.replaceAll("%20"," ");
        input=input.replaceAll("%3À",":");
        input=input.replaceAll("%3D","?");
        input=input.replaceAll("%2F","/");
        return input;
    }
    public static int countOcurrences(String needle, String haystack) {
        int k=haystack.length(),counter=0;
        while(true)
        {
            k=haystack.length();
            haystack=haystack.replaceFirst(needle, "");
            if(k!=haystack.length())counter++;
            else break;
        }
        return counter;
    }
    public static int sumOfNumbers(String input) {
        int i=0,sum=0,j=0,num=1;
        String str="";
        while(i<input.length())
        {
            char c=input.charAt(i);
            if((c>='0' && c<='9')|| c=='-')
            {   num=1;
                if(c=='-')num=-1;
                for(j=i+1; j<input.length(); j++)
                {
                    c=input.charAt(j);
                    if(c<'0' || c>'9')break;
                }
                str=new StringBuilder(input.substring(i, j)).toString();
                sum+=Integer.valueOf(str);
                i=j;
            }
            else i++;
        }
        return sum;
    }
    public static boolean areAnagrams(String A, String B) {
        char char_A;
        for(int i=0; i<A.length(); i++)
        {
            char_A=A.charAt(i);
            B=B.replaceFirst(Character.toString(char_A), "");
        }
        if(B.length()==0)
        return true;
        else return false;
    }
    public static boolean hasAnagramOf(String string, String string2) {
        String str1;
        int begin_index=0;
        char char_str;
        while(begin_index+string.length()<=string2.length())
        {
            str1=new StringBuilder(string2.substring(begin_index, begin_index+string.length())).toString();
            //System.out.println(str1);
            for(int i=0; i<string.length(); i++)
            {
                char_str=string.charAt(i);
               // System.out.print(str1+" ");
                str1=str1.replaceFirst(Character.toString(char_str), "");
                //System.out.println(str1);
            }
            //System.out.println(str1.length());
            if(str1.length()==0)return true;
            begin_index++;
            //System.out.println((begin_index+string.length()-1));
        }
        return false;
    }
    public static int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int[][] temp=new int[newWidth][newHeight];
        //if(newWidth>original.length && newHeight>original[0].length){
        double x_ratio=original.length/(double)newWidth;
        double y_ratio=original[0].length/(double)newHeight;
        double px,py;
        //^
        for(int i=0; i<newWidth; i++)
        {
            for(int j=0; j<newHeight; j++)
            {
                px=Math.floor(j*x_ratio);
                py=Math.floor(i*y_ratio);
               // System.out.println(i+" "+j+" "+(int)py+" " + (int)px);
                int sum=0;
                for(int i1=(int)py; i1<(int)py+(int)y_ratio-1; i1++)
                {
                    for(int j1=(int)px; j1<(int)px+(int)x_ratio-1; j1++)
                    {
                        System.out.print(i1+" "+j1);
                        sum+=original[i1][j1];
                    }
                    System.out.println();
                   
                }
                sum/=(newWidth*newHeight);
                
                temp[i][j]=sum;
            }
        }
        //}
        for(int i=0; i<newWidth; i++)
        {
            for(int j=0; j<newHeight; j++) 
            System.out.print(temp[i][j]+" ");
            System.out.println();
        }
        
        return temp;
    }
    //dirac", "libcarid"
    public static void main(String[] args){
        int a[][]=new int[4][4];
        int k=1;
        for(int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++)
            { a[i][j]=k;}
            k++;
        }
       /* for(int i=0; i<4; i++)
        {
            for(int j=0; j<4; j++) 
            System.out.print(a[i][j]+" ");
            System.out.println();
        }*/
        System.out.println(rescale(a,2,2));
       /* System.out.print("1.isOdd:");
        System.out.println(isOdd(4));
        System.out.print("2.min:");
        System.out.println(min(a));
        System.out.print("3.isPrime:");
        System.out.println(isPrime(3));
        System.out.print("4.kthMin:");
        System.out.println(kthMin(1,a));
        System.out.print("5.getAverage:");
        System.out.println(getAverage(a));
        System.out.print("6.kthfac:");
        System.out.println(doubleFac(3));
        System.out.print("7.kthfac:");
        System.out.println(kthFac(2,6));
        System.out.print("8.getSmallestMultiple:");
        System.out.println(getSmallestMultiple(10));
        System.out.print("9.getLargestPalindrome:");
        System.out.println(getLargestPalindrome(5419722));*/
        
        
    }
    
}
