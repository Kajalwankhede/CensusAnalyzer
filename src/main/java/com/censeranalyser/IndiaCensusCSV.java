package com.censeranalyser;

import com.opencsv.bean.CsvBindByName;

public class IndiaCensusCSV {
    @CsvBindByName(column = "SerialNo", required = true)
    public int serialno;
    @CsvBindByName(column = "State", required = true)
    public String state;

    @CsvBindByName(column = "Population", required = true)
    public int population;

    @CsvBindByName(column = "AreaInSqKm", required = true)
    public int areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    public int densityPerSqKm;
    @CsvBindByName(column = "StateCode", required = true)
    public int statecode;

    @Override
    public String toString() {
        return "IndiaCensusCSV{" +
                "SerialNo='" + serialno + '\'' +
                "State='" + state + '\'' +
                ", Population='" + population + '\'' +
                ", AreaInSqKm='" + areaInSqKm + '\'' +
                ", DensityPerSqKm='" + densityPerSqKm + '\'' +
                ", StateCode='" + statecode + '\'' +
                '}';
    }
}
