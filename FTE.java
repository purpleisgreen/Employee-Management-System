package com.mycompany.finalems;



public class FTE extends EmployeeInfo{
    public double grossSalary;
    
    public FTE(int eN, String fN, String lN, String g, String wL, double dR, int hDM, int hDD, int hDY, double gS){
        super(eN, fN, lN, g, wL, dR, hDM, hDD, hDY);
        grossSalary = gS;
    }
    public double getGrossSalary(){
        return grossSalary;
    }
    public double getNetSalary(){
        return Math.round(grossSalary * (1.0 - deductRate / 100.0) * 100.0) / 100.0;
    }
    public String getAttributes(){
        return("Full ,"+ empNum + "," + firstName + "," + lastName + "," + gender + ","+workLoc+","+deductRate+","+hireDateMonth+ ","+ hireDateDay + ","+ hireDateYear + ","+grossSalary);
    }
}
