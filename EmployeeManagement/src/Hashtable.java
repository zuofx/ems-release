import java.util.ArrayList;

public class Hashtable {
	
    public ArrayList<EmployeeInfo>[] buckets;
    public int arraySize;

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Hashtable(int listSize) {

            arraySize = 0;
            buckets = new ArrayList[listSize]; //WARNING
//Type safety: The expression of type ArrayList[] needs unchecked conversion to conform to ArrayList<SI>

            for (int i = 0; i < listSize; i++) { //
                    buckets[i] = new ArrayList();  // Instantiate the ArrayList for bucket i. // WARNING:
            }//Type safety: The expression of type ArrayList needs unchecked conversion to conform to ArrayList<SI>

    }//Warnings Supressed because yellows lines are ugly and it hasn't broke yet.

    public void add(EmployeeInfo theEmployee) {

            int idTag = (theEmployee.employeeNum % 10);
            buckets[idTag].add(theEmployee);
            //System.out.println("\nAdded employee with number " + theEmployee.employeeNum +": " + theEmployee.lastName + ", " 
            //+ theEmployee.firstName + ".");
            arraySize ++;

    }// end of add

    public EmployeeInfo remove(int theEmployee) {

            int idTag = (theEmployee % 10);

            if (buckets[idTag].size() == 0) {
                    System.out.println("\nCould not find specified employee (Employee NO. " + theEmployee
                                     + ")");
            }

            for (int e = 0; e < buckets[idTag].size(); e++) { // cycle

                    EmployeeInfo reference = buckets[idTag].get(e);
                    if ((reference.employeeNum == theEmployee) && (reference != null)) { //find a matching variable
                            //System.out.println("\nRemoved "+ reference.firstName +" "+ reference.lastName + " "
                            //                + "with employee ID. " + reference.employeeNum);
                            buckets[idTag].remove(reference);
                            arraySize --;
                            return reference;
                    }

                    System.out.println("\nCould not find specified employee (Employee NO. " + reference.employeeNum
                                     + ")");

            }// end of cycle for statement
            return null;

    }// end of remove

    public int calcBucket(EmployeeInfo theEmployee) {
            return (theEmployee.employeeNum % 10);
    } // end of calcBucket

    public EmployeeInfo retrieve(int employeeNum) {

            EmployeeInfo returnVar = null;
            int idTag = employeeNum % 10;
            int hashSize = buckets[idTag].size();

            if (hashSize == 0) { // is there anything in the bucket
                    System.out.println("\nNothing in the bucket.");
                    return null;
            }

            if (hashSize > arraySize) { // range check
                    System.out.println("\nOut of range of table.");
                    return null;
            }

            for (int e = 0; e < hashSize; e++) { // cycle through indexed list

                    EmployeeInfo reference = buckets[idTag].get(e);
                    if ((reference.employeeNum == employeeNum) && (reference != null)) { //find a matching variable

                            returnVar = reference;

                    }

            }// end of cycle for statement

            if (returnVar == null) { // variable was not found
                    System.out.println("\nNo such value found.");
                    return null;

            }

            System.out.println("\nRetrieved " + returnVar.firstName + " with Employee Number " + returnVar.employeeNum);
            return returnVar;
    }// end of retrieve

    public void display() {

            System.out.println("\nDisplaying the Hashtable from the start:");

            for (int a = 0; a < buckets.length; a++) { // 'a' represents where in arraylist

                    int hashSize = buckets[a].size();
                    if (buckets[a].size() != 0) {

                            System.out.println("\nTable " + a + ":");

                    }else {

                            System.out.println("\nNothing in Table " + a + ".");

                    }

                    for (int b = 0; b < hashSize;b++) { // 'b' represents where in lists

                            EmployeeInfo grabbed = buckets[a].get(b);
                            //
                            System.out.println("Index " + b + "; " + grabbed.firstName + " "
                            + grabbed.lastName + ", Employee No. " + grabbed.employeeNum + "");
                            //
                    }

            }

    }//end of display

    public boolean checkHash(String hashLine) {

        System.out.println("\nChecking Hash.");
        boolean duplicate;
        duplicate = false;

        for (int a = 0; a < buckets.length; a++) { // 'a' represents where in arraylist

            int hashSize = buckets[a].size();

            for (int b = 0; b < hashSize;b++) { // 'b' represents where in lists

                EmployeeInfo grabbed = buckets[a].get(b);
                //
                if (grabbed instanceof FTE) {
                    FTE theFTE = (FTE) grabbed;
                    String checkString = ("FTE," + theFTE.employeeNum + "," 
                                        + theFTE.firstName + "," 
                                        + theFTE.lastName + "," 
                                        + theFTE.gender + ","
                                        + theFTE.workLoc + ","
                                        + theFTE.deductRate + ","
                                        + theFTE.yearlySalary);

                    if (hashLine.equals(checkString)) {
                        duplicate = true;
                        break;
                    }
                }

                if (grabbed instanceof PTE) {
                    PTE thePTE = (PTE) grabbed;
                    String checkString = ("PTE," + thePTE.employeeNum + "," 
                                        + thePTE.firstName + "," 
                                        + thePTE.lastName + "," 
                                        + thePTE.gender + ","
                                        + thePTE.workLoc + ","
                                        + thePTE.deductRate + ","
                                        + thePTE.hourlyWage + ","
                                        + thePTE.hoursPerWeek + ","
                                        + thePTE.weeksPerYear);

                    if (hashLine.equals(checkString)) {
                        duplicate = true;
                        break;
                        }
                    }
                }
            }
            return duplicate;
    }//end of display
    
    public boolean checkDuplicateNum(int empNum) {
        boolean check = false;
        
        for (int a = 0; a < buckets.length; a++) { // 'a' represents where in arraylist

            int hashSize = buckets[a].size();

            for (int b = 0; b < hashSize;b++) { // 'b' represents where in lists

                    EmployeeInfo grabbed = buckets[a].get(b);
                    //
                    if (grabbed.employeeNum == empNum) {
                        check = true;
                    }
                }

            }
        
        return check;
    }

    public int getNumInHashtable() {
        return arraySize;
    }

    //ALIAS' ***        
    public void addToTable(EmployeeInfo theEmployee) {
            add(theEmployee);
    }

    public EmployeeInfo removeFromTable(int theEmployee) {
            return remove(theEmployee);
    }

    public EmployeeInfo getFromTable(Hashtable table, int employeeNum) {
            EmployeeInfo returnVar = retrieve(employeeNum);
            return returnVar;
    }

    public void displayTable() {
            display();
    }

    public EmployeeInfo fire(int theEmployee) {
            return remove(theEmployee);
    }

    //END OF ALIAS'S

}//end of class ***
