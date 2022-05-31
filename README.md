# ems-release
GRD. 12 COM SCI // ICS4U0 // SEMESTER 2 // EMPLOYEE-MANGEMENT SYSTEM // FINAL PROJECT <br/>
<br/>
<br/>
---------- "EMPLOYEE-ENTRIES" DATA FILE DOCUMENTATION ----------<br/>

Format (Part-Time Employee): <br/>
PTE,433829,James,Surray,1,Ontario,0.16,14.0,20.0,45.0<br/>
PTE, Employee Number, First Name, Last Name, Gender (0/1/2), Location, Deduction Rate, Hourly Wage, Hours Per Week, Weeks Per Year<br/>
<br/>
Format (Full-Time Employee): <br/>
FTE,238459,Martha,Selvic,2,PEI,0.09,197500.0<br/>
FTE, Employee Number, First Name, Last Name, Gender (0/1/2), Location, Deduction Rate, Yearly Salary <br/>
<br/>
Gender (0,1,2): <br/>
0 = male <br/>
1 = female <br/>
2 = other <br/>
<br/>
Important Formatting Notes: <br/>
1. Ensure there is an empty line at the end of text file.<br/>
2. Edit text file through the EMS, editting the data file directly could cause it to not load correctly.<br/>
3. If an employee entry in the text file has an invalid value, the program will either load null or 0 in place of the invalid value; original value will be overwritten when the program saves to null or 0. <br/>

<br/>Data File Saving Mechanism:<br/>
SAVE Button:<br/>
Will take Hashtable data and rewrite the text file in accordance with the Hashtable.<br/>

SAVE & QUIT Button:<br/>
Same as save, just closes everything after. <br/>

RELOAD Button: <br/>
Runs through the text file, any new entries will be added to the Hashtable data.<br/>
Reload will also undo any changes made to Employee data in the current session.<br/>

---------- END OF DATA FILE DOCUMENTATION ---------<br/>
