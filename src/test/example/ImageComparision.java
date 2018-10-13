package test.example;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.File;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageComparision {
	public static void main(String arr[]){
		try{
			//BufferedImage image1 = ImageIO.read(new File("images/logo_1.png"));
			//BufferedImage image2 = ImageIO.read(new File("images/logo_2.png"));
			System.out.println("Started");
			BufferedImage image1 = ImageIO.read(new File("/Users/nagaborra/Desktop/logo_2.jpg"));
			BufferedImage image2 = ImageIO.read(new File("/Users/nagaborra/Desktop/Backup_config/pge-logo.png"));
			
			byte[] pixel1 = ((DataBufferByte) image1.getRaster().getDataBuffer()).getData();
			
			byte[] pixel2 = ((DataBufferByte) image2.getRaster().getDataBuffer()).getData();
			
			if(Arrays.equals(pixel1,pixel2)){
				System.out.println("Images are equal");
			}else{
				System.out.println("Images are not equal");
			}
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	

}	
}
