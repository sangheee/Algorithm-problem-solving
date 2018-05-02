import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class LeftRotation {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        int start=n-k%n;
        for(int i=0; i < n; i++,start++){
        		if(start>=n)start=0;
            a[start] = in.nextInt();
        }
        for(int val:a) {
        		System.out.print(val+" ");
        }
    }
}
