package main;

import parser.ResumeParser;
import parser.Section;
import parser.EduParser;
import parser.WorkExpParser;
import utilities.PDFConverter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static PDFConverter converter = new PDFConverter();
	
	
	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner (System.in);
        System.out.println("Please enter path for file:");
        String inputPath = sc.nextLine();
        sc.close();
        
        String outputPath = "plaintext.txt";
		converter.convertToText(inputPath, outputPath);
		
		File file = new File(outputPath);
		ResumeParser parser = new ResumeParser(file);
		//parser.printAllSections();
		ArrayList<Section> sections = parser.getSections();
		for (Section section : sections) {
		    if (section.getType().equals("WORK")) {
		        WorkExpParser workParser = new WorkExpParser(section);
		        workParser.printAllWorkExp();
		    } else if (section.getType().equals("EDU")) {
		        EduParser eduParser = new EduParser(section);
		        eduParser.printEduDetails();
		    }
		    
		}
		
	}
}