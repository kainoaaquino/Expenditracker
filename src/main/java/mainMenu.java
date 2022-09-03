import Service.spendingService;
import util.connectionUtil;

import java.sql.Connection;
import java.util.Scanner;

public class mainMenu {

    public static void main(String[] args) {
        /*
        System.out.println("Gibe da moni: ");
        Scanner in = new Scanner(System.in);
        String moni = in.nextLine();
        System.out.println("Thank u for tha moni, " + moni); */

      //  Connection conn = connectionUtil.getConnection();
        Scanner in = new Scanner(System.in);

        boolean spendingMoni = true;
        spendingService ss = new spendingService();
        while(spendingMoni) {
            System.out.println("Select an option:\n1. new\n2. view\n3. quit");
            String userInput = in.nextLine();
            if(userInput.equals("quit")) {
                spendingMoni = false;
            }
            else if (userInput.equals("new")){
                System.out.println("Enter amount of expenditure: ");
                String amount = in.nextLine();
                System.out.println("Enter date of expenditure (MM/DD): ");
                String date = in.nextLine();

                ss.addEntry(amount, date);
            }
            else if(userInput.equals("view all")) {
                System.out.println(ss.getAllEntries());
            }
            else if (userInput.equals("view by date")) {
                String date;
                System.out.println(ss.getEntriesByDate());
            }
            else {
                System.out.println("Command not found. Please type one of the commands below.");
            }
        }
    }
}
