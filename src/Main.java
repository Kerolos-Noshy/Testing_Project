import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        ArrayList<Account> accounts = new ArrayList<>();
        for(int i = 0 ; i < 3 ; i ++) {
            System.out.println("Enter a username: ");
            String username = input.nextLine();

            System.out.println("Enter a password: ");
            String password = input.nextLine();
//            while(password.length() < 8){
//                System.out.println("Password less than 8 chars.\nEnter Password again:");
//                password = input.nextLine();
//            }
            try {
                Account user1 = new Account(username, password, "Checking");
                accounts.add(user1);
            } catch (Exception e){

            }

        }
        for(int i = 0 ;  i < 3 ; i++)
            System.out.println(accounts.get(i).getAccountID());


    }
}
