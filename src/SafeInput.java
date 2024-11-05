import java.util.Scanner;

public class SafeInput {
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = ""; // Set this to zero length. Loop runs until it isn't
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = pipe.nextLine();
        }while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int myInt =0;
        boolean done=false;
        do {
            System.out.print("\n"+prompt+": ");
            if(pipe.hasNextInt()){
                myInt = pipe.nextInt();
                done=true;
            } else {
                System.out.print("Please enter a valid input");
            }
            pipe.nextLine();
        }while(!done);
        return myInt;
    }

    public static double getDouble(Scanner pipe, String prompt){
        double myDouble=0;
        boolean done=false;
        do{
            System.out.print("\n"+prompt+": ");
            if (pipe.hasNextDouble()){
                myDouble= pipe.nextDouble();
                done=true;
            }
            else{
                System.out.print("Please enter a valid input");
            }
            pipe.nextLine();
        }while(!done);
        return myDouble;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int myInt=0;
        boolean done=false;
        do{
            System.out.print("\n"+prompt+ " ["+low+" - "+high+"] ");
            if(pipe.hasNextInt()){
                myInt=pipe.nextInt();
                if (myInt>=low && myInt<=high){
                    done=true;
                }else{
                    System.out.print("Please enter a value in between "+low+" and "+high);
                }
            }else{
                System.out.print("Please enter a valid input");
                pipe.nextLine();
            }
        }while(!done);
        pipe.nextLine();
        return myInt;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double myDouble = 0;
        boolean done = false;
        do {
            System.out.print("\n" + prompt + " [ " + low + " - " + high + " ] ");
            if (pipe.hasNextDouble()) {
                myDouble = pipe.nextDouble();
                if (myDouble >= low && myDouble <= high) {
                    done = true;
                } else {
                    System.out.print("Please enter a value in between " + low + " and " + high);
                }
            } else {
                System.out.print("Please enter a valid input");
            }
            pipe.nextLine();
        } while (!done);
        return myDouble;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean result = false;
        boolean done = false;
        String userResponse = "";

        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            if (pipe.hasNextLine()) {
                userResponse = pipe.nextLine();
                if (userResponse.equalsIgnoreCase("y")) {
                    result = true;
                    done = true;
                } else if (userResponse.equalsIgnoreCase("n")) {
                    result = false;
                    done = true;
                } else {
                    System.out.println("Error: Please enter a valid input [Y/N]");
                }
            }
        } while (!done);
        return result;
    }
}
