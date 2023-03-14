# SchoolEmailGen

I. Introduction
The emailGen class is designed to generate email addresses and passwords for new students or employees. 
The program prompts the user for their name and department and uses that information to create a unique email address and password.

II. Variables and Methods
The emailGen class has the following variables:

firstName: a string that represents the user's first name.
lastName: a string that represents the user's last name.
genEmail: a string that represents the generated email address.
randPassword: a string that represents the generated password.
department: a string that represents the user's chosen department.
The class also has the following methods:

firstName(): prompts the user for their first name and validates that the input contains only letters.
lastName(): prompts the user for their last name and validates that the input contains only letters.
department(): prompts the user to choose a department and returns a string representing the chosen department.
emailGenerator(): generates a unique email address using the user's first name, last name, and department.
passGenerator(int length): generates a random password of a specified length.
III. User Interface
When the program is run, the user is prompted to enter their first name, last name, and department. The program then generates an 
email address and password based on this information. If the user confirms that the information is correct, the program displays 
the email address and password. If the user indicates that the information is incorrect, they are prompted to enter their department again.

Sample Output:
Please provide us with your first name
John
Please enter your last name
Doe
Choose your department

Science Department
Physics Department
English Department
Law Department
1
You chose the following department: Science Department
Is that correct?
1-Yes
2-No
1
Welcome to Kristiania College John Doe
Here is your new e-mail & password
Make sure to not share it with anybody
Your e-mail is: johndoe@sciencedep.kristiania.no
Your password is: H%J8#mZ9

IV. Improvements

Add input validation for the department method to ensure that the user enters a valid option.
Add error handling to prevent the program from crashing if the user enters invalid input.
Add an option for the user to change their department if they entered the wrong one.
V. Conclusion
The emailGen class is a useful tool for generating unique email addresses and passwords for new students or employees. 
With some minor improvements, the program can be even more user-friendly and robust.
