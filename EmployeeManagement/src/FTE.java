
public class FTE extends EmployeeInfo{
	
	public double yearlySalary;
	public FTE(int eN, String fN, String lN, int g, String wL, double dR, double yS) {
		super(eN, fN, lN, g, wL, dR);
		yearlySalary = yS;
	}//end of FTE Instantiation
	
	public double calcAnnualSalary() {
		double salary = yearlySalary - (yearlySalary * deductRate);
		//System.out.println("\n" + firstName + "'s salary is $" + salary +".");
		return salary;
	}//end of calc salary

}
