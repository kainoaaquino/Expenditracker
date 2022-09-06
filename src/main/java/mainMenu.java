import Service.spendingService;
import util.connectionUtil;

import java.sql.Connection;
import java.util.Scanner;

public class mainMenu {

    public static void main(String[] args) {
        //  Connection conn = connectionUtil.getConnection();


        boolean spendingMoni = true;
        spendingService ss = new spendingService();
        while(spendingMoni) {
            System.out.println("Select an option:\n1. new\n2. view all\n3. view by date\n4. quit");
            Scanner userInput = new Scanner(System.in);
            String line = userInput.nextLine();
            if(line.equals("quit")) {
                spendingMoni = false;
            }
            else if (line.equals("new")){
                System.out.println("Enter amount of expenditure: ");
                String amount = userInput.nextLine();
                System.out.println("Enter date of expenditure (MMDD): ");
                String date = userInput.nextLine();
                System.out.println("Enter category number: ");
                int category = userInput.nextInt();

                ss.addEntry(amount, date, category);
            }
            else if(line.equals("view all")) {
                System.out.println(ss.getAllEntries());
            }
            else if (line.equals("view by date")) {
                System.out.println("Enter date of Entry (MMDD): ");


                String date = userInput.nextLine();
                System.out.println(ss.getEntriesByDate(date));
            }
            else {
                System.out.println("Command not found. Please type one of the commands below.");
            }
        }
    }
}
