import java.util.Scanner;
public class emailGen {
        private String firstName;
        private String lastName;
        private String genEmail;
        private String randPassword;
        private String department;


        //constractor

        public emailGen(){

            this.firstName= firstName();
            System.out.println("----------------------------------------------------------------------------------------");

            this.lastName= lastName();
            System.out.println("-----------------------------------------------------------------------------------------");

            System.out.println(" Welcome "+ " " + this.firstName +" " + this.lastName);
            System.out.println("-----------------------------------------------------------------------------------------");

            this.department=department();
            System.out.println("You chose the following dep. ********** " + this.department);


            boolean confirmed=false;
            while(!confirmed) {
                System.out.println("Is that correct?");
                System.out.println("1-Yes \n2-No");
                Scanner scanBol = new Scanner(System.in);
                int answer = scanBol.nextInt();
                if (answer == 1) {
                    emailGenerator();
                    confirmed= true;
                    System.out.println("Welcome to Kristiania College"+" "+ this.firstName);
                    System.out.println(" ----------------------------------------------------------------");
                    System.out.println("Here is your new e-mail & password");
                    System.out.println("Make sure -to not share it with anybody");
                    System.out.println(" ----------------------------------------------------------------");
                } else if (answer == 2) {
                    System.out.println("Try again");
                    department();

                }else {
                    System.out.println("Invalid");
                }

            }
            this.genEmail= emailGenerator();
            System.out.println("Your e-mail is: " + this.genEmail);
            this.randPassword= passGenerator(8);
            System.out.println("Your password is: "+ this.randPassword);
            System.out.println(" ----------------------------------------------------------------");
            System.out.println("Feel free to contact us if you have any question regarding your e-mail setup");
        }


        public String firstName(){
            System.out.println("Please provide us with your first name");
            Scanner scanfName= new Scanner(System.in);
            String fN= scanfName.nextLine();
            while (!fN.matches("[a-zA-Z]+")) {
                System.out.println("Invalid first name input. Please enter only letters.");
                fN = scanfName.nextLine();
            }
            return fN;

        }

        public String lastName(){
            System.out.println("Please enter your last name");
            Scanner scanLName= new Scanner(System.in);
            String lN= scanLName.nextLine();
            while(!lN.matches("[a-zA-Z]+")){
                System.out.println("Invalid last name input. Please enter only letters");
                lN=scanLName.nextLine();
            }
            return lN;
        }
        public String department(){
            System.out.println("Choose your department \n1.Science Department\n2 Physics Department \n3 English Department " +
                    "\n4 law Department");

            Scanner scan= new Scanner(System.in);
            int inP=scan.nextInt();


            if(inP==1){
                return ("ScienceDep");
            } else if (inP==2) {
                return ("PhysicsDep");
            } else if (inP==3) {
                return ("EnglishDep");
            } else if (inP==4) {
                return ("LawDep");
            }
            return "";
        }

        public String emailGenerator(){
            String email= this.firstName.toLowerCase() + this.lastName.toLowerCase() +"@"+this.department.toLowerCase() +
                    "kristiania.no";
            return email;
        }

        public String passGenerator(int length){
            String passCollection= "1234567890ABCDEFGHIGKLMNOPQRSTUVWXYZ#%&-_";
            char [] generatedPass= new char[length];
            for(int i=0; i<length; i++){
                int rand= (int)(Math.random()*passCollection.length());
                generatedPass[i]=passCollection.charAt(rand);
            }
            return new String(generatedPass);
        }

    public static void main(String[] args) {
        emailGen newEm= new emailGen();
    }
}


