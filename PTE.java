package com.mycompany.finalems;



public class PTE extends EmployeeInfo{
    public double hourlyWage;
    public double hoursPerWeek;
    public double weeksPerYear;
    
    public PTE(int eN, String fN, String lN, String g, String wL, double dR, int hDM, int hDD, int hDY, double hW, double hPW, double wPY){
        super(eN, fN, lN, g, wL, dR, hDM, hDD, hDY);
        hourlyWage = hW;
        hoursPerWeek = hPW;
        weeksPerYear = wPY;
    }
    public double getHourlyWage(){
        return hourlyWage;
    }
    public double getHoursPerWeek(){
        return hoursPerWeek;
    }
    public double getWeeksPerYear(){
        return weeksPerYear;
    }
    public double getGrossSalary(){
        return(hourlyWage * hoursPerWeek * weeksPerYear);
    }
    public double getNetSalary(){
       return Math.round((hourlyWage * hoursPerWeek * weeksPerYear) * (1.0 - deductRate / 100.0) * 100.0) / 100.0;
    }
    public String getAttributes(){
        return("Part ," + empNum + "," + firstName + "," + lastName + "," + gender + "," + workLoc + "," + deductRate + "," + hireDateMonth + "," + hireDateDay + "," + hireDateYear + ","+ hourlyWage + "," + hoursPerWeek + "," + weeksPerYear);
    }
}