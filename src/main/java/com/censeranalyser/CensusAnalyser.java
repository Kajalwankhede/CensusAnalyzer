package com.censeranalyser;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class CensusAnalyser {
    public int loadIndiaCensusData(String csvFilePath, CensusAnalyserException.ExceptionType type) throws CensusAnalyserException {
        Iterator<IndiaCensusCSV> censusCSVIterator = null;
        try {
           Reader reader = Files.newBufferedReader(Paths.get(csvFilePath));
//         CsvToBeanBuilder<IndiaCensusCSV> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
//         csvToBeanBuilder.withType(IndiaCensusCSV.class);
//         csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
//         CsvToBean<IndiaCensusCSV> csvToBean = csvToBeanBuilder.build();
            Iterator<IndiaCensusCSV> indiaCensusCSVIterator= getCSVIterator(reader,IndiaCensusCSV.class);
//            int numOfRecords=0;
//           while (indiaCensusCSVIterator.hasNext()){
//             numOfRecords++;
//               IndiaCensusCSV indiaCensusCSV=indiaCensusCSVIterator.next();
//
//           }return numOfRecords;
            return getCount(indiaCensusCSVIterator);
        } catch (Exception e) {
            throw new CensusAnalyserException(e.getMessage(),type);
        }
    }
    private <E> Iterator getCSVIterator(Reader reader, Class csvClass) {
        CsvToBeanBuilder<E> csvCsvToBeanBuilder = new CsvToBeanBuilder<>(reader);
        csvCsvToBeanBuilder.withType(csvClass);
        csvCsvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
        CsvToBean<E> csvToBean = csvCsvToBeanBuilder.build();
        return csvToBean.iterator();
    }


    private <E> int getCount(Iterator<E> indiaCensusCSVIterator) { // method for count records
        Iterable<E> csvIterator = () -> indiaCensusCSVIterator;
        int numOfRecord = (int) StreamSupport.stream(csvIterator.spliterator(), true).count();
        return numOfRecord;
    }

}

