import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class emailGen {

        private String firstName;
        private String lastName;
        private String genEmail;
        private String randPassword;
        private String department;
        private int parkingLot;


        //constractor

        public emailGen(String fN,String lN){

            this.firstName=fN;
            this.lastName=lN;
            this.parkingLot= generateParkingLotNumber();

            System.out.println("Welcome "+ " " + this.firstName +" " + this.lastName);
            System.out.println("=====================================================================================");

            this.department=department();
            System.out.println("You chose the following department: " + this.department);
            System.out.println("=====================================================================================");



            boolean confirmed=false;
            while(!confirmed) {
                System.out.println("Is that correct?");
                System.out.println("1-Yes \n2-No");
                System.out.println("=====================================================================================");

                Scanner scanBol = new Scanner(System.in);
                int answer = scanBol.nextInt();
                if (answer == 1) {
                    emailGenerator();
                    confirmed= true;
                    System.out.println("Welcome to Kristiania College"+" "+ this.firstName);
                    System.out.println("=============================================================================");
                    System.out.println("Here is your new e-mail & password");
                    System.out.println("Make sure -to not share it with anybody");
                    System.out.println("=============================================================================");
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
            System.out.println("Your parkingLot Nr is: " + this.parkingLot);
            System.out.println("=====================================================================================");
            System.out.println("Feel free to contact us if you have any question regarding your e-mail setup");
            System.out.println("=====================================================================================");

        }


/*
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

 */
        public String department() {
            System.out.println("Choose your department \n1.Science Department\n2 Physics Department \n3 English Department " +
                    "\n4 law Department");

            Scanner scan = new Scanner(System.in);
            int inP = scan.nextInt();


            if (inP == 1) {
                return ("ScienceDep");
            } else if (inP == 2) {
                return ("PhysicsDep");
            } else if (inP == 3) {
                return ("EnglishDep");
            } else if (inP == 4) {
                return ("LawDep");
            } else {
                System.out.println("-------------------------------------------------------------");
                System.out.println("Department doesn`t exist! Please chose the right department!");
                System.out.println("-------------------------------------------------------------");

                return department();
            }
        }
        public String emailGenerator(){
            String email= this.firstName.toLowerCase()+"." + this.lastName.toLowerCase()+"."+ this.department.
                    toLowerCase() + "@kristiania.no";
            return email;
        }


   public static Set<Integer> assignedParkingLots = new HashSet<>(); // declare a Set to keep track of assigned parking lot numbers

        public int generateParkingLotNumber() {

            int[] park = {1001, 1002, 1003, 1004,1005,1006,1007,1008};
            int rand = (int) (Math.random() * park.length);
            int parkingLotNumber = park[rand];
            while (assignedParkingLots.contains(parkingLotNumber)) { // check if the parking lot number has already been assigned
                rand = (int) (Math.random() * park.length);
                parkingLotNumber = park[rand];
            }
            assignedParkingLots.add(parkingLotNumber); // add the assigned parking lot number to the Set
            return parkingLotNumber;
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
            emailGen email1= new emailGen( "Efrem","Mickael");
            emailGen email2= new emailGen("Natasha", "Kayeyi");
            emailGen email3= new emailGen("Liam","Mickael");
            emailGen email4= new emailGen("Nahom","Gizachew");
            emailGen email5= new emailGen("Mehret","Aregawi");
    }
}


