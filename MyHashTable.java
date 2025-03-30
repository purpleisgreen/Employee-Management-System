package com.mycompany.finalems;


import java.util.*;

public class MyHashTable {
    //Attributes 
        public ArrayList<EmployeeInfo> [] buckets;
            //buckets is an array of Arraylists 
            //each slot in buckets(an array) holds the reference value of an ArrayList
            //the ArrayLists hold the reference value of students depending on their student numbers 
            //open hasing closed addressing 
        public int numInHashTable;
            //counts the number of students currently in the hashtable 
    //Constructor
        public MyHashTable(int howManyBuckets){
            buckets = new ArrayList[howManyBuckets]; //Array buckets of size howManyBuckets
            for(int i = 0; i<howManyBuckets; i++){
                buckets[i] = new ArrayList();
            }
        }
    //Methods 
        public int getNumInHashTable(){
            return numInHashTable;
        }
        public int calcBucket(int eN){
            return(eN % buckets.length);
        }
    //Add Employee Method
        public int addEmployee(EmployeeInfo theEmployee){ //int instead of boolean so that different error messages can be displayed 
            // 0 - not added; EmployeeInfo provided was null
            // 1 - not added; employee number provided already exists 
            // 2 - added
            // 3 - not added; unknown reason 
            if(theEmployee == null){
                return 0;
            }
            else{
                if(doesEmployeeExist(theEmployee.getEmpNum()) == true){
                    return 1; //Not added because employee number already exists 
                }
                else{
                    int spot = calcBucket(theEmployee.getEmpNum());
                    
                    boolean status = buckets[spot].add(theEmployee);
                    numInHashTable++;
                    if(status == true){
                        return 2;
                    }
                    else{
                        return 4;
                    }
                }
            }
        }
    //Remove Employee Method 
        public EmployeeInfo removeEmployee(int eN){
            int spot = calcBucket(eN);
            int length = buckets[spot].size();
            for(int i = 0; i<length; i++){
                if(buckets[spot].get(i).getEmpNum() == eN){
                    numInHashTable--;
                    return buckets[spot].remove(i);
                }
            } 
            return null;
        }
    //Supporting Methods        
        public boolean doesEmployeeExist(int eN){
            int spot = calcBucket(eN);
            int length = buckets[spot].size();
            for(int i = 0; i<length; i++){
                if(buckets[spot].get(i).getEmpNum() == eN){
                    return true;
                }
            }
            return false;
        }
    //Methods to Help With Functionality
        public EmployeeInfo getEmployee(int eN){ //Used for the search by employee number function 
            int spot = calcBucket(eN);
            int length = buckets[spot].size();
            for(int i = 0; i<length; i++){
                if(buckets[spot].get(i).getEmpNum() == eN){
                    return buckets[spot].get(i);
                }
            }
            return null;
        }
}
