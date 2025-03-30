package com.mycompany.finalems;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.*;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;
import java.util.Collections;

public class HomeScreen extends javax.swing.JFrame {
    public MyHashTable mastHashTable;
    MyHashTable currentlyDisplayed = new MyHashTable(10);
    private DefaultTableModel tableModel;
    boolean flag = false;
    public String fileName;
    public HomeScreen() {
        initComponents();
        
        String [] columnNames = {"First Name", "Last Name", "Employee Number", "Employee Type", "Work Location", "Gender", "Gross Salary", "Deduction Rate", "Net Salary", "Edit"};
        
        tableModel = new DefaultTableModel(columnNames, 0);
        
        display.setModel(tableModel);
        
        display.getColumn("Edit").setCellRenderer(new ButtonRenderer());
        display.getColumn("Edit").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        display.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        resizeColumnsBasedOnContent();
    }
    
    public void setMastHashTable(MyHashTable theRefValue){
        mastHashTable = theRefValue;
    }
    
   public void errorCall(int num){
           ErrorScreen errorScreen = new ErrorScreen();
           errorScreen.setVisible(true);
           errorScreen.displayError(num);
    }

    public void displayEmployee(FTE theFTE){
            Object[] newRow = {theFTE.getFirstName(), theFTE.getLastName(), theFTE.getEmpNum(), "Full Time", theFTE.getWorkLoc(), theFTE.getGender(), theFTE.getGrossSalary(), theFTE.getDeductRate(), theFTE.getNetSalary()};
            tableModel.addRow(newRow);
    }
    public void displayEmployee(PTE thePTE){
        Object[] newRow = {thePTE.getFirstName(), thePTE.getLastName(), thePTE.getEmpNum(), "Part Time", thePTE.getWorkLoc(), thePTE.getGender(), thePTE.getGrossSalary(), thePTE.getDeductRate(), thePTE.getNetSalary()};
        tableModel.addRow(newRow);
        //ADD BUTTONS FOR GO FOR THE SEARCH FUNCTIONS
    
    }
    public void masterDisplay(MyHashTable theRefValue){
        tableModel.setRowCount(0);
        clearCurrentlyDisplayed();
           for(int i = 0; i<mastHashTable.buckets.length; i++){
               for(int j = 0; j<mastHashTable.buckets[i].size(); j++){
                   EmployeeInfo theEmp = mastHashTable.buckets[i].get(j);
                   if(theEmp instanceof FTE){
                        FTE theFTE = (FTE) theEmp;
                        currentlyDisplayed.addEmployee(theFTE);
                   }
                   else if(theEmp instanceof PTE){
                       PTE thePTE = (PTE) theEmp;
                       currentlyDisplayed.addEmployee(thePTE);
                   }
               }
           } 
           displayCurrentlyDisplayed();
    }
    public void displayCurrentlyDisplayed(){
        tableModel.setRowCount(0);
           for(int i = 0; i<currentlyDisplayed.buckets.length; i++){
               for(int j = 0; j<currentlyDisplayed.buckets[i].size(); j++){
                   EmployeeInfo theEmp = currentlyDisplayed.buckets[i].get(j);
                   if(theEmp instanceof FTE){
                        FTE theFTE = (FTE) theEmp;
                        displayEmployee(theFTE);
                   }
                   else if(theEmp instanceof PTE){
                       PTE thePTE = (PTE) theEmp;
                       displayEmployee(thePTE);
                   }
               }
           }     
    }
    
    
  public void clearCurrentlyDisplayed(){
         for(int i = 0; i<currentlyDisplayed.buckets.length; i++){
               for(int j = 0; j<currentlyDisplayed.buckets[i].size(); j++){
                   EmployeeInfo theEmp = currentlyDisplayed.buckets[i].get(j);
                   currentlyDisplayed.removeEmployee(theEmp.getEmpNum());
               }
           }    
  }
  
  public void setFileName(String s){
      fileName = s;
  }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        filterByMaleCheckBox1 = new javax.swing.JCheckBox();
        employeesLabel = new javax.swing.JLabel();
        searchByLabel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        saveDataButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        searchByNumberTextField = new javax.swing.JTextField();
        searchByFirstNameTextField = new javax.swing.JTextField();
        searchByLastNameTextField = new javax.swing.JTextField();
        filterByFullTimeCheckBox = new javax.swing.JCheckBox();
        filterByPartTimeCheckBox = new javax.swing.JCheckBox();
        filterByFemaleCheckBox = new javax.swing.JCheckBox();
        filterByMaleCheckBox = new javax.swing.JCheckBox();
        locationComboBox = new javax.swing.JComboBox<>();
        clearDataButton = new javax.swing.JButton();
        loadDataButton = new javax.swing.JButton();
        addEmployeeButton2 = new javax.swing.JButton();
        allEmployeesButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        display = new javax.swing.JTable();
        searchByNumberButton = new javax.swing.JButton();
        searchByFirstNameButton = new javax.swing.JButton();
        searchByLastNameButton = new javax.swing.JButton();
        filterButton = new javax.swing.JButton();
        filterByOtherCheckBox = new javax.swing.JCheckBox();

        jButton3.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        jButton3.setText("Go");
        jButton3.setPreferredSize(new java.awt.Dimension(72, 18));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        filterByMaleCheckBox1.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        filterByMaleCheckBox1.setText("Male");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        employeesLabel.setFont(new java.awt.Font("Georgia", 0, 24)); // NOI18N
        employeesLabel.setText("Employees");

        searchByLabel.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        searchByLabel.setText("Search By");

        jLabel4.setFont(new java.awt.Font("Georgia", 0, 18)); // NOI18N
        jLabel4.setText("Filter By");

        saveDataButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        saveDataButton.setText("Save Data");
        saveDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveDataButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel1.setText("Number:");

        jLabel5.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel5.setText("First Name:");

        jLabel6.setFont(new java.awt.Font("Georgia", 0, 14)); // NOI18N
        jLabel6.setText("Last Name:");

        searchByNumberTextField.setMinimumSize(new java.awt.Dimension(150, 18));
        searchByNumberTextField.setPreferredSize(new java.awt.Dimension(150, 18));

        searchByFirstNameTextField.setMinimumSize(new java.awt.Dimension(150, 18));
        searchByFirstNameTextField.setPreferredSize(new java.awt.Dimension(150, 18));

        searchByLastNameTextField.setMinimumSize(new java.awt.Dimension(150, 18));
        searchByLastNameTextField.setPreferredSize(new java.awt.Dimension(150, 18));

        filterByFullTimeCheckBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        filterByFullTimeCheckBox.setText("Full Time");

        filterByPartTimeCheckBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        filterByPartTimeCheckBox.setText("Part Time");

        filterByFemaleCheckBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        filterByFemaleCheckBox.setText("Female");

        filterByMaleCheckBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        filterByMaleCheckBox.setText("Male");

        locationComboBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        locationComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No Location Selected", "Mississauga ", "Toronto", "Oakville" }));

        clearDataButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        clearDataButton.setText("Clear Data");
        clearDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDataButtonActionPerformed(evt);
            }
        });

        loadDataButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        loadDataButton.setText("Load Data");
        loadDataButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadDataButtonActionPerformed(evt);
            }
        });

        addEmployeeButton2.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        addEmployeeButton2.setText("Add Employee");
        addEmployeeButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addEmployeeButton2ActionPerformed(evt);
            }
        });

        allEmployeesButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        allEmployeesButton.setText("Display All Employees");
        allEmployeesButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allEmployeesButtonActionPerformed(evt);
            }
        });

        display.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        display.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        jScrollPane2.setViewportView(display);

        searchByNumberButton.setFont(new java.awt.Font("Georgia", 0, 10)); // NOI18N
        searchByNumberButton.setText("Go");
        searchByNumberButton.setPreferredSize(new java.awt.Dimension(72, 18));
        searchByNumberButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByNumberButtonActionPerformed(evt);
            }
        });

        searchByFirstNameButton.setFont(new java.awt.Font("Georgia", 0, 10)); // NOI18N
        searchByFirstNameButton.setText("Go");
        searchByFirstNameButton.setPreferredSize(new java.awt.Dimension(72, 18));
        searchByFirstNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByFirstNameButtonActionPerformed(evt);
            }
        });

        searchByLastNameButton.setFont(new java.awt.Font("Georgia", 0, 10)); // NOI18N
        searchByLastNameButton.setText("Go");
        searchByLastNameButton.setPreferredSize(new java.awt.Dimension(72, 18));
        searchByLastNameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchByLastNameButtonActionPerformed(evt);
            }
        });

        filterButton.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        filterButton.setText("Filter");
        filterButton.setPreferredSize(new java.awt.Dimension(72, 18));
        filterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterButtonActionPerformed(evt);
            }
        });

        filterByOtherCheckBox.setFont(new java.awt.Font("Georgia", 0, 12)); // NOI18N
        filterByOtherCheckBox.setText("Other");
        filterByOtherCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterByOtherCheckBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(employeesLabel)
                        .addGap(279, 279, 279)
                        .addComponent(allEmployeesButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(clearDataButton)
                            .addGap(43, 43, 43)
                            .addComponent(saveDataButton)
                            .addGap(43, 43, 43)
                            .addComponent(loadDataButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(addEmployeeButton2))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(searchByFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(filterByFemaleCheckBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(searchByLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(filterByPartTimeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(filterByMaleCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(searchByLabel)
                                    .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(searchByNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(searchByNumberButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchByFirstNameButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(searchByLastNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(locationComboBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(filterButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(filterByFullTimeCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(filterByOtherCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(searchByLabel)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(searchByNumberTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByNumberButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(searchByFirstNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(searchByFirstNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(searchByLastNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchByLastNameButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterByFullTimeCheckBox)
                            .addComponent(filterByPartTimeCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(filterByFemaleCheckBox)
                            .addComponent(filterByOtherCheckBox)
                            .addComponent(filterByMaleCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(locationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeesLabel)
                            .addComponent(allEmployeesButton))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveDataButton)
                    .addComponent(clearDataButton)
                    .addComponent(loadDataButton)
                    .addComponent(addEmployeeButton2))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveDataButtonActionPerformed
         FileWriter file = null;
        try{
            file = new FileWriter("src/UserData.txt");
            BufferedWriter output = new BufferedWriter(file);
            for(int i = 0; i < mastHashTable.buckets.length;i++){
                for(int j = 0; j < mastHashTable.buckets[i].size();j++){
                    EmployeeInfo theEmp = mastHashTable.buckets[i].get(j);
                    if (theEmp instanceof FTE){
                        FTE theFTE = (FTE) theEmp;
                        output.write(theFTE.getAttributes()+"\n");
                    }
                    if (theEmp instanceof PTE){
                        PTE thePTE = (PTE) theEmp;
                        output.write(thePTE.getAttributes()+"\n");
                    }
                }
            }
            output.close();
            errorCall(27);
        }
        catch(Exception e){
            errorCall(25);
        }
        
    }//GEN-LAST:event_saveDataButtonActionPerformed

    private void clearDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataButtonActionPerformed
        ConfirmationScreen1 comScreen = new ConfirmationScreen1();
        comScreen.setMasterHashTable(mastHashTable);
        comScreen.setVisible(true);
        
        comScreen.messageUpdate("Are you use you would like to remove all employees?");
        clearCurrentlyDisplayed();
        masterDisplay(mastHashTable);
    }//GEN-LAST:event_clearDataButtonActionPerformed

    private void loadDataButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadDataButtonActionPerformed
          FileReader file  = null;
          try{
            file = new FileReader("src/UserData.txt");
            BufferedReader input = new BufferedReader(file);
            String line = input.readLine();
            while(line != null){
                String[] attributes = line.split(",");
                for(int i = 0; i<attributes.length; i++){
                    attributes[i] = attributes[i].strip();
                }
                if ("Full".equals(attributes[0])){
                    FTE theFTE = new FTE(Integer.valueOf(attributes[1]), attributes[2], attributes[3], attributes[4], attributes[5], Double.valueOf(attributes[6]), Integer.valueOf(attributes[7]), Integer.valueOf(attributes[8]), Integer.valueOf(attributes[9]), Double.valueOf(attributes[10]));
                    mastHashTable.addEmployee(theFTE);
                }
                if ("Part".equals(attributes[0])){
                    PTE thePTE = new PTE(Integer.valueOf(attributes[1]), attributes[2], attributes[3], attributes[4], attributes[5], Double.valueOf(attributes[6]), Integer.valueOf(attributes[7]), Integer.valueOf(attributes[8]), Integer.valueOf(attributes[9]), Double.valueOf(attributes[10]), Double.valueOf(attributes[11]), Double.valueOf(attributes[12]));
                    mastHashTable.addEmployee(thePTE);
                }
                line = input.readLine();
            }
          input.close();
          errorCall(28);
        }
        catch(Exception e){
            errorCall(26);
        }
    }//GEN-LAST:event_loadDataButtonActionPerformed

    private void addEmployeeButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addEmployeeButton2ActionPerformed
        AddEmployee addEmp = new AddEmployee();
        addEmp.setVisible(true);
        addEmp.setMasterHashTable(mastHashTable);
    }//GEN-LAST:event_addEmployeeButton2ActionPerformed

    private void allEmployeesButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allEmployeesButtonActionPerformed
        for(int m = 0; m<2; m++){
        masterDisplay(mastHashTable); 
        }
    }//GEN-LAST:event_allEmployeesButtonActionPerformed

    private void searchByNumberButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByNumberButtonActionPerformed
        for(int m = 0; m<2; m++){    
        String searchingFor = searchByNumberTextField.getText();
            searchingFor = searchingFor.strip();
            if(searchingFor.equals("")){
                errorCall(29);
            }
            else{
                clearCurrentlyDisplayed();
                for(int i = 0; i<mastHashTable.buckets.length; i++){
                     for(int j = 0; j<mastHashTable.buckets[i].size(); j++){
                        EmployeeInfo theEmp = mastHashTable.buckets[i].get(j);
                        String theEmpNum = String.valueOf(theEmp.getEmpNum());
                        if(theEmpNum.contains(searchingFor)){
                            currentlyDisplayed.addEmployee(theEmp);
                        }
               }
           }   
               displayCurrentlyDisplayed();
            }  
        }
    }//GEN-LAST:event_searchByNumberButtonActionPerformed

    private void searchByFirstNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByFirstNameButtonActionPerformed
        for(int m = 0; m<2; m++){   
        String searchingFor = searchByFirstNameTextField.getText();
           searchingFor = searchingFor.strip();
           if(searchingFor.equals("")){
                errorCall(29);
            }
            else{
                clearCurrentlyDisplayed();
                for(int i = 0; i<mastHashTable.buckets.length; i++){
                     for(int j = 0; j<mastHashTable.buckets[i].size(); j++){
                        EmployeeInfo theEmp = mastHashTable.buckets[i].get(j);
                        String theFirstName = theEmp.getFirstName();
                        if(theFirstName.toLowerCase().contains(searchingFor.toLowerCase())){
                            currentlyDisplayed.addEmployee(theEmp);
                        }
               }
           }   
               displayCurrentlyDisplayed();
            }  
    }//GEN-LAST:event_searchByFirstNameButtonActionPerformed
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void searchByLastNameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchByLastNameButtonActionPerformed
        for(int m = 0; m<2; m++){   
        String searchingFor = searchByLastNameTextField.getText();
           searchingFor = searchingFor.strip();
           if(searchingFor.equals("")){
                errorCall(29);
            }
            else{
                clearCurrentlyDisplayed();
                for(int i = 0; i<mastHashTable.buckets.length; i++){
                     for(int j = 0; j<mastHashTable.buckets[i].size(); j++){
                        EmployeeInfo theEmp = mastHashTable.buckets[i].get(j);
                        String theFirstName = theEmp.getLastName();
                        if(theFirstName.toLowerCase().contains(searchingFor.toLowerCase())){
                            currentlyDisplayed.addEmployee(theEmp);
                        }
               }
           }   
               displayCurrentlyDisplayed();
            }  
    }//GEN-LAST:event_searchByLastNameButtonActionPerformed
    }
    private void filterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterButtonActionPerformed
       for(int m = 0; m<2;m++){
        boolean isFullTime = filterByFullTimeCheckBox.isSelected();
        boolean isPartTime = filterByPartTimeCheckBox.isSelected();
        boolean isFemale = filterByFemaleCheckBox.isSelected();
        boolean isMale = filterByMaleCheckBox.isSelected();
        boolean isOther = filterByOtherCheckBox.isSelected();
        String location = locationComboBox.getSelectedItem().toString();
        location = location.toLowerCase().strip();
        //Full Time
           clearCurrentlyDisplayed();
    for (int i = 0; i < mastHashTable.buckets.length; i++) {
        for (int j = 0; j < mastHashTable.buckets[i].size(); j++) {
            EmployeeInfo theEmp = mastHashTable.buckets[i].get(j);
            if (theEmp instanceof FTE && isFullTime) {
                currentlyDisplayed.addEmployee(theEmp);
            }
            // Part-Time filter
            else if (theEmp instanceof PTE && isPartTime) {
                currentlyDisplayed.addEmployee(theEmp);
            }
            // Female filter
            else if (theEmp.getGender().toLowerCase().strip().equals("female") && isFemale) {
                currentlyDisplayed.addEmployee(theEmp);
            }
            // Male filter (fixed typo here)
            else if (theEmp.getGender().toLowerCase().strip().equals("male") && isMale) {
                currentlyDisplayed.addEmployee(theEmp);
            }
            // Other gender filter
            else if (theEmp.getGender().toLowerCase().strip().equals("other") && isOther) {
                currentlyDisplayed.addEmployee(theEmp);
            }
            // Location filter
            else if (location.equals(theEmp.getWorkLoc().toLowerCase().strip())){
                currentlyDisplayed.addEmployee(theEmp);
            }
        }
    }
    // Display the filtered list
    displayCurrentlyDisplayed();
       }
    }//GEN-LAST:event_filterButtonActionPerformed

    private void filterByOtherCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterByOtherCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterByOtherCheckBoxActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addEmployeeButton2;
    private javax.swing.JButton allEmployeesButton;
    private javax.swing.JButton clearDataButton;
    private javax.swing.JTable display;
    private javax.swing.JLabel employeesLabel;
    private javax.swing.JButton filterButton;
    private javax.swing.JCheckBox filterByFemaleCheckBox;
    private javax.swing.JCheckBox filterByFullTimeCheckBox;
    private javax.swing.JCheckBox filterByMaleCheckBox;
    private javax.swing.JCheckBox filterByMaleCheckBox1;
    private javax.swing.JCheckBox filterByOtherCheckBox;
    private javax.swing.JCheckBox filterByPartTimeCheckBox;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton loadDataButton;
    private javax.swing.JComboBox<String> locationComboBox;
    private javax.swing.JButton saveDataButton;
    private javax.swing.JButton searchByFirstNameButton;
    private javax.swing.JTextField searchByFirstNameTextField;
    private javax.swing.JLabel searchByLabel;
    private javax.swing.JButton searchByLastNameButton;
    private javax.swing.JTextField searchByLastNameTextField;
    private javax.swing.JButton searchByNumberButton;
    private javax.swing.JTextField searchByNumberTextField;
    // End of variables declaration//GEN-END:variables

    private void resizeColumnsBasedOnContent() {
        // Check if the table has any rows (data)
        if (display.getRowCount() == 0) {
            // Set the column widths based on the column titles
            for (int columnIndex = 0; columnIndex < display.getColumnCount(); columnIndex++) {
                TableColumn column = display.getColumnModel().getColumn(columnIndex);
                String columnHeader = display.getColumnName(columnIndex); // Get column title
                column.setPreferredWidth(columnHeader.length() * 10);  // Adjust width based on header length (with padding)
            }
        } else {
            // Loop through columns and calculate based on data
            for (int columnIndex = 0; columnIndex < display.getColumnCount(); columnIndex++) {
                int maxWidth = 0;
                // Loop through each row to find the maximum length in this column
                for (int rowIndex = 0; rowIndex < display.getRowCount(); rowIndex++) {
                    Object cellValue = display.getValueAt(rowIndex, columnIndex);
                    if (cellValue != null) {
                        int cellWidth = cellValue.toString().length();
                        maxWidth = Math.max(maxWidth, cellWidth);
                    }
                }
                // Set the preferred width of the column
                TableColumn column = display.getColumnModel().getColumn(columnIndex);
                column.setPreferredWidth(maxWidth * 10);  // Multiply by factor for padding
            }
        }
    }
      // Custom TableCellRenderer for rendering buttons
    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText("Click Me");
            return this;
        }
    }

    // Custom TableCellEditor for handling button clicks
    class ButtonEditor extends DefaultCellEditor {
        private String label;
        private JButton button;
        private boolean isPushed;
        private int row;  // Store the row number

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);

            // Action listener for the button click
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Get data from the second column in the same row
                    Object dataFromColumn2 = tableModel.getValueAt(row, 2);  // Get data from the second column
                    String empNum = dataFromColumn2.toString();
                    int theEmpNum = Integer.parseInt(empNum);
                    EditEmployee editEmployee = new EditEmployee();
                    editEmployee.setVisible(true); 
                    editEmployee.setMasterHashTable(mastHashTable);
                    editEmployee.displayOldInfo(theEmpNum);
                    //JOptionPane.showMessageDialog(button, "Button clicked in row " + row + ". Data from Column 2: " + dataFromColumn2);
                    fireEditingStopped();  // Stop editing (close the editor)
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            button.setText("Click Me");
            this.row = row;  // Save the row index
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            if (isPushed) {
                // Return any value if needed
                return label;
            }
            return null;
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
    }

}
