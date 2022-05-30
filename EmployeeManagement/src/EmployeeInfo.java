
public class EmployeeInfo {
	
    public int employeeNum;
    public String firstName;
    public String lastName;
    public int gender; // encode e.g. 0 for M, 1 for F, etc.
    public String workLoc; // encode e.g. 0 for Mississauga, etc.
    public double deductRate; // e.g. 0.21 for 21%
    
    public EmployeeInfo(int eN, String fN, String lN, int g, String wL, double dR) {
    	employeeNum = eN;
    	firstName = fN;
    	lastName = lN;
    	gender = g;
    	workLoc = wL;
    	deductRate = dR;
    }
    
    public int getEmpNum() {
    	return employeeNum;
    }
    
    public String getFirstName() {
    	return firstName;
    }
    
    public String getLastName() {
    	return lastName;
    }
    
    public String getWorkLoc() {
        return workLoc;
    }

}
