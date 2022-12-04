package com.censeranalyser;

public class CensusAnalyserException extends Exception {

   public enum ExceptionType {
       CENSUS_FILE_PROBLEM, WRONG_FILE_TYPE,WRONG_HEADER,WRONG_DELIMITER
    }

    public ExceptionType type;

    public CensusAnalyserException(String message, ExceptionType type) {
        super(message);
        this.type = type;
        if (type.equals(ExceptionType.CENSUS_FILE_PROBLEM)){
            System.out.println("Wrong Path");
        } else if (type.equals(ExceptionType.WRONG_FILE_TYPE)) {
            System.out.println("Wrong type file");

        }
        else if (type.equals(ExceptionType.WRONG_HEADER)) {
            System.out.println("Wrong Header");

        }
        else if (type.equals(ExceptionType.WRONG_DELIMITER)) {
            System.out.println("File contains Wrong Delimiter");

        }
    }

    public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
        super(message, cause);
        this.type = type;

    }
}
