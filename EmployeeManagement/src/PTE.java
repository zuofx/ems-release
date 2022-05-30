
public class PTE extends EmployeeInfo{
	
	public double hourlyWage;
	public double hoursPerWeek;
	public double weeksPerYear;
	
	public PTE(int eN, String fN, String lN, int g, String wL, double dR, double hW, double hPW, double wPY) {
		
		super(eN, fN, lN, g, wL, dR);
		hourlyWage = hW;
		hoursPerWeek = hPW;
		weeksPerYear = wPY;
                workLoc = wL;
		firstName = fN;
		lastName = lN;
		employeeNum = eN;
	}// end of PTE instantiation
	
	public double calcAnnualSalary() {
		
		double salary = ((hourlyWage * hoursPerWeek * weeksPerYear) - (hourlyWage * hoursPerWeek * weeksPerYear * deductRate));
		//System.out.println("\n" + firstName + "'s salary is " + salary + ".");
		return salary;
	}// end of calc salary

}//end of PTE class
