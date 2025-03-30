package com.mycompany.finalems;



public class EmployeeInfo {
     //Attributes 
        public int empNum;
        public String firstName;
        public String lastName;
        public String gender;
        public String workLoc;
        public double deductRate;
        public int hireDateMonth;
        public int hireDateDay;
        public int hireDateYear;
        
    //Constructor 
        public EmployeeInfo(int eN, String fN, String lN, String g, String wL, double dR, int hDM, int hDD, int HDY){
            empNum = eN;
            firstName = fN;
            lastName = lN;
            gender = g;
            workLoc = wL;
            deductRate = dR;
            hireDateMonth = hDM;
            hireDateDay = hDD;
            hireDateYear = HDY;
        }
        
    //Methods
        public int getEmpNum(){
            return empNum;
        }
        public String getFirstName(){
            return firstName;
        }
        public String getLastName(){
            return lastName;
        }
        public String getGender(){
            return gender;
        }
        public double getDeductRate(){
            return deductRate;
        }
        public String getWorkLoc(){
            return workLoc;
        }
        public int getHireDateMonth(){
            return hireDateMonth;
        }
        public int getHireDateDay(){
            return hireDateDay;
        }
        public int getHireDateYear(){
            return hireDateYear;
        }
}
