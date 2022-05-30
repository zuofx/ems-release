/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
/**
 *
 * @author truong
 */
public class FileManager {
    
    private FileWriter textFile;
    private FileWriter rewriterFile;
    public Scanner scanFile;
    public Scanner checkFile;
    public Scanner rewriteFile;
    
    public FileManager() {
        try { // open new text folder, will open an existing one if already exits, or create a new one.
            textFile = new FileWriter("employee-entries.txt", true);
        } catch (IOException e) {
            System.out.println("IO Exception Error while opening data file.");
            e.printStackTrace();
        }
	
    }
    
    public void writeNew(EmployeeInfo newEmployee) {
        try { // open new text folder, will open an existing one if already exits, or create a new one.
            textFile = new FileWriter("employee-entries.txt", true);
        } catch (IOException e) {
            System.out.println("IO Exception Error while opening data file.");
            e.printStackTrace();
        }
		// Write a employee to the text file
        try {
            if (newEmployee instanceof FTE) {
                FTE theFTE = (FTE) newEmployee;
                textFile.append("FTE," + theFTE.employeeNum + "," 
                                + theFTE.firstName + "," 
                                + theFTE.lastName + "," 
                                + theFTE.gender + ","
                                + theFTE.workLoc + ","
                                + theFTE.deductRate + ","
                                + theFTE.yearlySalary + "\n");
            }
            if (newEmployee instanceof PTE) {
                PTE thePTE = (PTE) newEmployee;
                textFile.append("PTE," + thePTE.employeeNum + "," 
                                + thePTE.firstName + "," 
                                + thePTE.lastName + "," 
                                + thePTE.gender + ","
                                + thePTE.workLoc + ","
                                + thePTE.deductRate + ","
                                + thePTE.hourlyWage + ","
                                + thePTE.hoursPerWeek + ","
                                + thePTE.weeksPerYear + "\n");
            }

          } catch (IOException errors) {
            System.out.println("IO Exception error while writing to file.");
            errors.printStackTrace();
          }
		
	}//end of new hire
    
    public Hashtable loadToHash(Hashtable theHT) { // Loads all variables in the text file to the hashtable
        String line;
        try { // Open new text file
            scanFile = new Scanner(new File("employee-entries.txt"));
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
                e.printStackTrace();
            }
        
        boolean errors = false;
        while (scanFile.hasNextLine()) { // If the text file is not empty (has a next line)
            errors = false;
            line = scanFile.nextLine();          
            String[] lineArray = line.split(","); // Split the line by the comma
            String checkVar = lineArray[0];
            int empNum = 0;
            int gender = 0;
            double deductRate = 0;
            
            try {
                empNum = Integer.parseInt(lineArray[1]);
            }catch (Exception e) {
                errors = true;
                System.out.println(e);
                System.out.println("Error parsing EMPLOYEE NUMBER. Check data file.");
            }
            
            try {
                gender = Integer.parseInt(lineArray[4]);
            }catch (Exception e) {
                errors = true;
                System.out.println(e);
                System.out.println("Error parsing GENDER. Check data file.");
            }
            
            try {
                deductRate = Double.parseDouble(lineArray[6]); // 
            }catch (Exception e) {
                errors = true;
                System.out.println(e);
                System.out.println("Error parsing DEDUCTION RATE. Check data file.");
            }
            
            if (checkVar.equals("FTE")) { // If it has FTE indentifier:
                double yearlySalary = 0;//
                
                try {
                    yearlySalary = Double.parseDouble(lineArray[7]);//
                }catch (Exception e) {
                    errors = true;
                    System.out.println(e);
                    System.out.println("Error parsing YEARLY SALARY. Check data file.");
                }
                
                FTE theFTE = new FTE(empNum, lineArray[2], lineArray[3], gender, lineArray[5], deductRate, yearlySalary);
                
                boolean hashCheck = theHT.checkDuplicateNum(empNum);
                if ((hashCheck == false) && (errors == false)) {
                    theHT.add(theFTE); // Add the employee FTE
                }
                if (hashCheck == true) {
                    System.out.println("Did not reload Employee NO. " + empNum + ", found a duplicate already loaded to data.");
                }
            }
            
            if (checkVar.equals("PTE")) {
                double hourlyWage = 0; // 
                double hoursPerWeek = 0; // 
                double weeksPerYear = 0; //
                
                try {
                    hourlyWage = Double.parseDouble(lineArray[7]); // 
                }catch (Exception e) {
                    errors = true;
                    System.out.println(e);
                    System.out.println("Error parsing HOURLY WAGE. Check data file.");
                }
                
                try {
                    hoursPerWeek = Double.parseDouble(lineArray[8]); // 
                }catch (Exception e) {
                    errors = true;
                    System.out.println(e);
                    System.out.println("Error parsing HOURS PER WEEK. Check data file.");
                }
                
                try {
                    weeksPerYear = Double.parseDouble(lineArray[9]); //
                }catch (Exception e) {
                    errors = true;
                    System.out.println(e);
                    System.out.println("Error parsing WEEKS PER YEAR. Check data file.");
                }
                
                PTE thePTE = new PTE(empNum, lineArray[2], lineArray[3], gender, lineArray[5], deductRate, hourlyWage, hoursPerWeek, weeksPerYear);
                
                boolean hashCheck = theHT.checkDuplicateNum(empNum);
                if ((hashCheck == false) && (errors == false)) {
                    theHT.add(thePTE); // Add the employee PTE
                }
                if (hashCheck == true) {
                    System.out.println("Did not reload Employee NO. " + empNum + ", found a duplicate already loaded to data.");
                }
            }
        }
    return theHT;
    }
    
    public void save (Hashtable saveHT) {
        rewrite(saveHT);
    }//end of save
    
    public void rewrite(Hashtable rewriteHash) {
        String hashLine = null;
        
        try {
            rewriterFile = new FileWriter("employee-entries.txt", false); 
            // Opens a new text file called rewriter file with the "false" flag which means anything appended to it
            // will completely erase the file for anything appended to it.
        } catch (IOException e) {
            System.out.println("IO Exception Error while opening data file.");
            e.printStackTrace();
        }
        
        try {
            rewriterFile.append(""); // Add nothing to rewriter file, which will 'reset' the file. 
            rewriterFile.close(); // Close rewriter file.
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        // Rewrite portion
        for (int a = 0; a < rewriteHash.buckets.length; a++) { // 'a' represents where in arraylist
            int hashSize = rewriteHash.buckets[a].size();
            for (int b = 0; b < hashSize;b++) { // 'b' represents where in lists
                
                EmployeeInfo grabbed = rewriteHash.buckets[a].get(b);
                FTE theFTE = null;
                PTE thePTE = null;//
                if (grabbed instanceof FTE) {
                    theFTE = (FTE) grabbed;
                    hashLine = ("FTE," + theFTE.employeeNum + "," 
                            + theFTE.firstName + "," 
                            + theFTE.lastName + "," 
                            + theFTE.gender + ","
                            + theFTE.workLoc + ","
                            + theFTE.deductRate + ","
                            + theFTE.yearlySalary + "\n");
                    
                    try {
                        textFile.append(hashLine);
                    }catch (IOException e) {
                        System.out.println(e);
                    }
                }
                
                if (grabbed instanceof PTE) {
                    thePTE = (PTE) grabbed;
                    hashLine = ("PTE," + thePTE.employeeNum + "," 
                                + thePTE.firstName + "," 
                                + thePTE.lastName + "," 
                                + thePTE.gender + ","
                                + thePTE.workLoc + ","
                                + thePTE.deductRate + ","
                                + thePTE.hourlyWage + ","
                                + thePTE.hoursPerWeek + ","
                                + thePTE.weeksPerYear + "\n");
                    try {
                        textFile.append(hashLine);
                    }catch (IOException e) {
                        System.out.println(e);
                    }
                    
                }
            }
        }
        //
        try {
            textFile.close();
        }catch (IOException e) {
            System.out.println(e);
        }
        try { // open new text folder, will open an existing one if already exits, or create a new one.
            textFile = new FileWriter("employee-entries.txt", true);
        } catch (IOException e) {
            System.out.println("IO Exception Error while opening data file.");
            e.printStackTrace();
        }
        
    }
    
    public void finish(FileManager theEnd) { // To close all potentially open text files, just in case they were never closed properly
		
        if (theEnd.textFile != null) {

            try {
                    theEnd.textFile.close();
            } catch (IOException e) {

                    e.printStackTrace();
            }
            try {
                    textFile.close();
            } catch (IOException e) {

                    e.printStackTrace();
            }
        }

        if (theEnd.rewriterFile != null) {

            try {
                    theEnd.rewriterFile.close();
            } catch (IOException e) {

                    e.printStackTrace();
            }
            try {
                    rewriterFile.close();
            } catch (IOException e) {

                    e.printStackTrace();
            }
        }

        if (theEnd.scanFile != null) {

            theEnd.scanFile.close();
            scanFile.close();
        }

        if (theEnd.rewriteFile != null) {

            theEnd.rewriteFile.close();
            rewriteFile.close();
        }

    return;
		
	}// end of finish
}
