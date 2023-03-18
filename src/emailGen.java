import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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

        private int expiredate;


        //constractor

        public emailGen(String fN,String lN,int expiredate){

            this.firstName=fN;
            this.lastName=lN;
            this.expiredate= expDate(expiredate);
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
            System.out.println("Your email will be deactivated in "+ this.expiredate+" days!");
            System.out.println("=====================================================================================");
            System.out.println("Feel free to contact us if you have any question regarding your e-mail setup");
            System.out.println("=====================================================================================");

        }

    private  String getfirstName() {
            return firstName;
    }

    private String getLastName(){
            return lastName;
    }

    private int getParkingLot(){
            return parkingLot;
    }

    private int getExpiredate(){
            return expiredate;
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




    public int expDate(int expiredate) {
        LocalDate expireDate = LocalDate.of(expiredate / 10000, (expiredate / 100) % 100,
                expiredate % 100);
        long daysUntilExpiration = ChronoUnit.DAYS.between(LocalDate.now(), expireDate);
        return (int) daysUntilExpiration;

    }
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
        emailGen[] emailArray = new emailGen[5]; // create an array of emailGen objects with a length of 5
        emailArray[0] = new emailGen("Ef","Mark",20240331);
        emailArray[1] = new emailGen("Nar", "John",20240930);
        emailArray[2] = new emailGen("Lion","Joel",20240130);
        emailArray[3] = new emailGen("James","Rog",20240530);
        emailArray[4] = new emailGen("Alex","P",20260330);


        for (int i=0; i< emailArray.length; i++){
            emailGen email=emailArray[i];
            System.out.println("Full Name :"+ email.getfirstName() +" "+ email.getLastName()+ " "+"Parkinglot Nr. : "+
                    email.getParkingLot() + " Email- Expiredate in " +email.getExpiredate()+ " days!");
        }


    }
}


