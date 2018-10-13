package test.example;

import java.util.Arrays;

public class AbsExtensionEx extends AbstractClassEx{
	
	public static void main(String ag[]){
		int[] ar = {7,8,1,2,4,6,10,5,3,15,9};
		Arrays.sort(ar);
		int ln = ar.length;
		for(int i=0;i<ln-1;i++){
			int tmp=ar[i+1]-ar[i];
			if(tmp>1){
				System.out.println((ar[i+1]+ar[i])/2);	
				break;
			}
		}
		
	}
}
