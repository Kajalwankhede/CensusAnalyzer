package com.censusanalyzer;

import com.censeranalyser.CensusAnalyser;
import com.censeranalyser.CensusAnalyserException;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import static junit.framework.Assert.assertEquals;

public class IndianCensusAnalyzerTest {
    private static final String INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\hp\\IdeaProjects\\CensusAnalyzerProject\\target\\IndiaStateCensusData.csv";
    private static final String WRONG_INDIA_CENSUS_CSV_FILE_PATH = "C:\\Users\\hp\\main\\IndiaStateCensusData.csv";
    @Test
    public void givenIndianCensusCSVFileReturnsCorrectRecords() {
        try {
            CensusAnalyser censusAnalyser = new CensusAnalyser();
            int numOfRecords = censusAnalyser.loadIndiaCensusData(INDIA_CENSUS_CSV_FILE_PATH);
            assertEquals(20,numOfRecords);
        } catch (CensusAnalyserException e) { }
    }
    @Test
    public void givenIndianCensusCSVWithWrongFileShouldReturnException(){
            try {
                CensusAnalyser censusAnalyser = new CensusAnalyser();
                ExpectedException exceptionRule = ExpectedException.none();
                exceptionRule.expect(CensusAnalyserException.class);
                censusAnalyser.loadIndiaCensusData(WRONG_INDIA_CENSUS_CSV_FILE_PATH);
            } catch (CensusAnalyserException e) {
                assertEquals(CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM,e.type);
            }
        }
    }
