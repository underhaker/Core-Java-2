package com.hackbulgaria.corejava;

import java.util.Arrays;

public class Problems2Impl implements Problems2 {

    @Override
    public boolean isOdd(int number) {
         return number%2==1;
    }

    @Override
    public boolean isPrime(int number) {
        for(int i=2; i*i<=number; i++)
            if(number%i==0)return false;
        return true;
    }

    @Override
    public int min(int... array) {
        int min_element=array[0];
        for(int i=1;i<array.length; i++)
        {
            if(array[i]<=min_element)min_element=array[i];
        }
        return min_element;
    }

    @Override
    public int kthMin(int k, int[] array) {
        Arrays.sort(array);
        return array[k-1];
    }

    @Override
    public float getAverage(int[] array) {
        float sum=0;
        for(int i=0; i<array.length; i++)
            sum+=array[i];
        return sum/array.length;
    }

    @Override
    public long getSmallestMultiple(int upperBound) {
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

    @Override
    public long getLargestPalindrome(long N) {
        long[] ar=new long[1024];
        long i;
        for(i=N-1; i>=1; i--)
        {
            long k=i,y;
            int j=0;
           
            while(k!=0)
            {
                y=k%10;
                ar[j]=y;
                k/=10;
                j++;
            }
            boolean flag=true;
            
            j--;
            for(int p=0; p<j-p; p++)
            {   
                if(ar[p]!=ar[j-p]){flag=false;break;}
            }
            if(flag==true)
            {
                
                break;
            }
        }
        return i;
    }

    @Override
    public int[] histogram(short[][] image) {
        int[] result=new int[256];
        for(int k=0; k<=255; k++)
        {
            for(int i=0; i<image.length; i++)
                for(int j=0; j<image[i].length; j++)
                    if(image[i][j]==k)result[k]++;
        }
        return result;
    }

    @Override
    public long doubleFac(int n) {
        long fact1=1,fact2=1;
        for(int i=2; i<=n; i++)
            fact1*=i;
        fact2=fact1;
        for(int i=n+1; i<=fact1; i++)
            fact2*=i;
        return fact2;
    }

    @Override
    public long kthFac(int k, int n) {
        long fact1=1;
        for(int i=n; i>0; i-=k)fact1*=i;
        return fact1;
    }

    @Override
    public int getOddOccurrence(int[] array) {
        Arrays.sort(array);
        int counter=1,i;
        for(i=0; i<array.length-1; i++)
        {
            if(array[i]==array[i+1])
                counter++;
            else
            {
                if(counter%2==1)break;
                counter=1;
            }
        }
        return array[i];
    }

    @Override
    public long pow(int a, int b) {
        
        if(b==0) return 1;
        if(b%2==0)return pow(a,b/2)*pow(a,b/2);
        else return a*pow(a,b-1);
    }

    @Override
    public long maximalScalarSum(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int sum=0;
        for(int i=a.length-1; i>=0; i--)
        sum+=a[i]*b[i];
        return sum;
    }

    @Override
    public int maxSpan(int[] array) {
        int span=1,maxspan=1;
        for(int i=0; i<array.length-1; i++)
        {
            for(int j=i+1; j<array.length; j++)
            {
                if(array[i]==array[j])span=j-i+1;
            }
            if(span>maxspan)maxspan=span;
        }
        return maxspan;
    }

    @Override
    public boolean canBalance(int[] array) {
        int sum1=0,sum2=0;
        for(int i=1; i<array.length; i++)
        {
            for(int j=0; j<i; j++)
                sum1+=array[j];
            for(int j=i; j<array.length; j++)
                sum2+=array[j];
            if(sum1==sum2)return true;
            sum1=sum2=0;
        }
        return false;
    }

    @Override
    public int[][] rescale(int[][] original, int newWidth, int newHeight) {
        int[][] temp=new int[newWidth][newHeight];
        double x_ratio=original.length/newWidth;
        double y_ratio=original.length/newHeight;
        double px,py;
        for(int i=0; i<newWidth; i++)
        {
            for(int j=0; j<newHeight; j++)
            {
               px=j*x_ratio;
               py=i*y_ratio;
               //temp[(i*newWidth)+j] = pixels[(int)((py*w1)+px)] ;
            }
        }
        return null;
    }

    @Override
    public String reverseMe(String argument) {
        return new StringBuilder(argument).reverse().toString();
    }

    @Override
    public String copyEveryChar(String input, int k) {
        String newStr="";
        for(int i=0; i<input.length(); i++)
        {
            for(int j=1; j<=k; j++)
                newStr=newStr+input.charAt(i);
        }
        return newStr;
    }

    @Override
    public String reverseEveryWord(String arg) {
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
                
                if(begin_pos!=0)
                new_arg=new_arg+" ";
                new_arg=new_arg+s;
                begin_pos=i+1;
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
        
    }

    @Override
    public boolean isPalindrome(String argument) {
        return argument.equals(new StringBuilder(argument).reverse().toString());
    }

    @Override
    public boolean isPalindrome(int number) {
        int k=number,y=0,j=0;
        int[] ar=new int[101];
        boolean flag=true;
        while(k!=0)
        {
            y=k%10;
            ar[j]=y;
            k/=10;
            j++;
        }
        j--;
        for(int p=0; p<j-p; p++)
        {   
            if(ar[p]!=ar[j-p]){return false;}
        }
        return true;
    }

    @Override
    public int getPalindromeLength(String input) {
        int p=input.lastIndexOf('*');
        int beginIndex=0,endIndex=input.length();
        while(true)
        {
            String s=input.substring(beginIndex, endIndex);
            if(s.equals(new StringBuilder(s).reverse().toString()))
                    return (s.length()-1)/2;
            beginIndex++;
            endIndex--;
            //argument.equals(new StringBuilder(argument).reverse().toString());
        }
    }

    @Override
    public int countOcurrences(String needle, String haystack) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public String decodeURL(String input) {
        
        return input.replaceAll("%3A",":").replaceAll("%20", " ").replaceAll("%3D", "?").replaceAll("%2F", "/");
    }

    @Override
    public int sumOfNumbers(String input) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public boolean areAnagrams(String A, String B) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean hasAnagramOf(String string, String string2) {
        // TODO Auto-generated method stub
        return false;
    }

}
