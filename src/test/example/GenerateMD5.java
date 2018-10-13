package test.example;

import java.io.File;

import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;

public class GenerateMD5 {

	public static void main(String[] args) {
		try{
			String filename = "/Users/nagaborra/Desktop/images/custodian.png";
		    String checksum = "41ab4ec73dd47d926ee96833e1617e6f";
		    HashCode hash = com.google.common.io.Files.hash(new File(filename), Hashing.md5());
		    String myChecksum = hash.toString();
		    System.out.println(myChecksum);
		    if(checksum.equals(myChecksum)){
		    	System.out.println("IMGS are equal");
		    }else{
		    	System.out.println("IMGs are not equal");
		    }
		}catch(Exception ex){
			
		}
		
	}

}
