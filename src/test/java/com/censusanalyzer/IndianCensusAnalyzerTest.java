package com.censusanalyzer;

import com.censeranalyser.CensusAnalyser;
import com.censeranalyser.CensusAnalyserException;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static com.censeranalyser.CensusAnalyserException.ExceptionType.*;
import static junit.framework.Assert.assertEquals;

public class IndianCensusAnalyzerTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\hp\\IdeaProjects\\CensusAnalyzerProject\\target\\IndiaStateCensusData.csv";
    private static final String WRONG_INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\hp\\main\\IndiaStateCensusData.csv";
    private static final String CENSUS_CSV_FILE_PATH_WITH_WRONG_FILETYPE="C:\\Users\\hp\\IdeaProjects\\CensusAnalyzerProject\\target\\IndiaStateCensusData.pdf";
    private static final String FILE_PATH_WITH_CSV_DELIMITER="C:\\Users\\hp\\IdeaProjects\\CensusAnalyzerProject\\target\\IndiaStateCensusDataDelimiter.csv";
    private static final String FILE_PATH_WITH_WRONG_HEADER   ="C:\\Users\\hp\\IdeaProjects\\CensusAnalyzerProject\\target\\IndiaStateCensusDataWrongHeader.csv";
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH,CENSUS_FILE_PROBLEM);
            Assertions.assertEquals(20,numOfRecords);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void givenIndianCensusCSVWithWrongFileShouldReturnException(){
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                ExpectedException exceptionRule = ExpectedException.none();
                exceptionRule.expect(CensusAnalyserException.class);
                censusAnalyser.loadIndiaCensusData(WRONG_INDIA_CENSUS_CSV_FILE_PATH,CENSUS_FILE_PROBLEM);
            } catch (CensusAnalyserException e) {
                Assertions.assertEquals(CENSUS_FILE_PROBLEM,e.type);
            }
        }

    @Test
    public void givenIndianCensusCSVFileReturnsInCorrectRecords() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            int numOfRecord = censusAnalyzer.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH,CENSUS_FILE_PROBLEM);
            Assertions.assertNotEquals(15, numOfRecord);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenIndianCensusCSVFileReturnsIncorrectFileTypeButPathShouldCorrect() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadIndiaCensusData(CENSUS_CSV_FILE_PATH_WITH_WRONG_FILETYPE,WRONG_FILE_TYPE);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(WRONG_FILE_TYPE,e.type);
        }

    }


    @Test
    public void givenIndianCensusCSVFileReturnsIncorrectDelimiter() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadIndiaCensusData(FILE_PATH_WITH_CSV_DELIMITER,WRONG_DELIMITER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(WRONG_DELIMITER,e.type);
        }
    }

    @Test
    public void givenIndianCensusCSVFileShouldHaveIncorrectHeader() {
        CensusAnalyser censusAnalyzer = new CensusAnalyser();
        try {
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyzer.loadIndiaCensusData(FILE_PATH_WITH_WRONG_HEADER,WRONG_HEADER);
        } catch (CensusAnalyserException e) {
            Assertions.assertEquals(WRONG_HEADER,e.type);
        }

        }
    }


