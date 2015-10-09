package main;

import utilities.PDFConverter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static PDFConverter converter = new PDFConverter();
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner (System.in);
        System.out.println("Please enter path for file:");
        String inputPath = sc.nextLine();
        
        System.out.println("Please enter output path for file:");
        String outputPath = sc.nextLine();
        
        sc.close();
        
		//For testing my own pdf file
		//String _stanley_pdf = "/Users/Stanley/Desktop/Test.pdf";
		
		converter.convertToText(inputPath, outputPath);
	}

}
