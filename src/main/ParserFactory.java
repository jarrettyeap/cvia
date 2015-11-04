package main;

import parser.DateParser;
import parser.Dictionary;
import parser.EduParser;
import parser.LanguageParser;
import parser.WorkExpParser;

public class ParserFactory {
    
    DateParser dateParser;
    EduParser eduParser;
    WorkExpParser workExpParser;
    LanguageParser languageParser;
    
    Dictionary fosDictionary;
    Dictionary jobTitleDictionary;
    Dictionary languageDictionary;

    private static final String FILENAME_DICTIONARY_FIELD = "./FieldsDictionary.txt";
    private static final String FILENAME_DICTIONARY_JOB = "./JobsDictionary.txt";
    private static final String FILENAME_DICTIONARY_LANGUAGE = "./LanguageDictionary.txt";
    
    public ParserFactory() {
        produceParsers();
    }
    
    private void produceParsers() {
        dateParser = new DateParser();
        
        fosDictionary = new Dictionary(FILENAME_DICTIONARY_FIELD);
        eduParser = new EduParser(dateParser, fosDictionary);
        
        jobTitleDictionary = new Dictionary(FILENAME_DICTIONARY_JOB);
        workExpParser = new WorkExpParser(dateParser, jobTitleDictionary);
        
        languageDictionary = new Dictionary(FILENAME_DICTIONARY_LANGUAGE);
        languageParser = new LanguageParser(languageDictionary);
        
    }
    
    public DateParser getDateParser() {
        return dateParser;
    }
    
    public EduParser getEduParser() {
        return eduParser;
    }
    
    public WorkExpParser getWorkParser() {
        return workExpParser;
    }
    
    public LanguageParser getLanguageParser() {
        return languageParser;
    }

}
