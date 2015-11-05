package job;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;
import java.lang.Double;
import java.lang.Integer;

import main.ParserFactory;

public class JobDesc {
	private double workDuration;
	private double educationCap;
	private int educationLevel;
	private String educationTitle;
	private String jobTitle;
	
	private HashSet<String> languages;
	private HashSet<String> skillSets;
	private ArrayList<String> others;

	private int eduWeightage;
	private int workWeightage;
	private int languageWeightage;
	private int otherWeightage;
	private int skillsetWeightage;
	
	private ParserFactory parserFactory;
	
	public JobDesc(ParserFactory parserFactory){
		languages = new HashSet<String>();
		skillSets = new HashSet<String>();
		this.parserFactory = parserFactory;
	}

	public double getWorkDuration() {
		return workDuration;
	}
	public void setWorkDuration(String workDuration) {
		String [] duration = workDuration.split("[,\\s]+");
		String durationString;
		double totalDuration = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i<duration.length; i++) {
			for (char c : duration[i].toCharArray()) {
				if (Character.isDigit(c)) {
					sb.append(c);
				} else {
					sb.append(" ");
				}
			}
		}
		durationString = sb.toString().trim();
		if (!durationString.equals("")) {
			String durationStringArray [] = durationString.split("[,\\s]+");
			for (String data : durationStringArray) {
				totalDuration += Double.parseDouble(data);
			}
		
			this.workDuration = totalDuration / durationStringArray.length;
			System.out.println("Work Duration: " + this.workDuration);
		} else {
			this.workDuration = 0;
			System.out.println("Work Duration: " + this.workDuration);
		}
		
	}
	public double getEducationCap() {
		return educationCap;
	}
	public void setEducationCap(String educationCap) {
		this.educationCap = Double.parseDouble(educationCap);
	}
	public int getEducationLevel() {
		return educationLevel;
	}
	public void setEducationLevel(String educationLevel) {
		this.educationLevel = Integer.parseInt(educationLevel);
	}
	public String getEducationTitle() {
		return educationTitle;
	}
	public void setEducationTitle(String educationTitle) {
		this.educationTitle = educationTitle.toLowerCase();
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
//		jobTitle = jobTitle.toLowerCase();
		this.jobTitle = parserFactory.getJobTitleDictionary().contains(jobTitle.toLowerCase());
	}
	public HashSet<String> getLanguages() {
		return languages;
	}
	public void setLanguages(String language) {
		// this.languages = languages;
		language = language.toLowerCase();
		String[] languageList = language.split("[,\\s]+");
		for(String lang : languageList) {
			languages.add(lang.toLowerCase());
		}
	}
	public HashSet<String> getskillSets() {
		return skillSets;
	}
	public void setSkillSets(String skillset) {
		skillset = skillset.toLowerCase();
		String[] skills = skillset.split("[,\\s]+");
		for(String skill : skills) {
			skillSets.add(skill.toLowerCase());
		}
	}
	public ArrayList<String> getOthers() {
		return others;
	}
	public void setOthers(String other) {
		//		this.others = others;
		String[] otherList = other.split("[,\\s]+");
		for(String random : otherList) {
			others.add(random.toLowerCase());
		}
	}
	public int getEduWeightage() {
		return eduWeightage;
	}
	public void setEduWeightage(String eduWeightage) {
		this.eduWeightage = Integer.parseInt(eduWeightage);
	}
	public int getWorkWeightage() {
		return workWeightage;
	}
	public void setWorkWeightage(String workWeightage) {
		this.workWeightage = Integer.parseInt(workWeightage);
	}
	public int getLanguageWeightage() {
		return languageWeightage;
	}
	public void setLanguageWeightage(String languageWeightage) {
		this.languageWeightage = Integer.parseInt(languageWeightage);
	}
	public int getOtherWeightage() {
		return otherWeightage;
	}
	public void setOtherWeightage(String otherWeightage) {
		this.otherWeightage = Integer.parseInt(otherWeightage);
	}
	public int getSkillsetWeightage() {
		return skillsetWeightage;
	}
	public void setSkillsetWeightage(String skillsetWeightage) {
		this.skillsetWeightage = Integer.parseInt(skillsetWeightage);
	}
	
//	public void workExp(String workExp) {
//	String[] work = workExp.split("[,\\s]+");
//	StringBuilder sb = new StringBuilder();
//	String yearString;
//	boolean numFlag = false;
//	double years = 0;
//	boolean found = false;
//
//	//To determine work experience
//	for (int i = 0; i<work.length; i++) {
//		if (Pattern.compile("year|years").matcher(work[i]).find()) { //Located year or years in word[i]
//			for (char c : work[i].toCharArray()) {
//				if (Character.isDigit(c)) {
//					sb.append(c);
//					found = true;
//					numFlag = true;
//				} else if (found) {
//					sb.append(" ");
//					found = false;
//				}
//
//				if (numFlag) {
//					yearString = sb.toString().trim();
//
//					//years of experience if only 1 number provided. Eg 2years
//					if (yearString.split("[,\\s]+").length == 1) {
//						years = Double.parseDouble(yearString); 
//					} else if (yearString.split("[,\\s]+").length > 1) {       //Average years of experience if 2 numbers are provided. Eg 2or3years
//						String [] yearStringArray =yearString.split("[,\\s]+");
//						for (int j = 0; j<yearStringArray.length; j++) {
//							years += Double.parseDouble(yearStringArray[j]);
//						}
//						years /= yearStringArray.length;
//					}
//				} else {
//					for (char ch : work[i-1].toCharArray()) {
//						if (Character.isDigit(ch)) {
//							sb.append(ch);
//							found = true;
//							numFlag = true;
//						} else if (found) {
//							sb.append(" ");
//							found = false;
//						}
//					}
//					yearString = sb.toString().trim();
//					//years of experience if only 1 number provided. Eg 2years
//					if (yearString.split("[,\\s]+").length == 1) {
//						years = Double.parseDouble(yearString); 
//					} else if (yearString.split("[,\\s]+").length > 1) {       //Average years of experience if 2 numbers are provided. Eg 2or3years
//						String [] yearStringArray =yearString.split("[,\\s]+");
//						for (int j = 0; j<yearStringArray.length; j++) {
//							years += Double.parseDouble(yearStringArray[j]);
//						}
//						years /= yearStringArray.length;
//					}
//				}
//			}
//		}
//		
//		setWorkDuration (years);
//	}
//
//}

}
