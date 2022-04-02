package com.invoice;

import com.invoice.models.Database;
import com.invoice.services.InvoiceGenerator;
import com.invoice.services.ReportService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Database database = new Database();
        ReportService reportService = new ReportService(database);
        InvoiceGenerator invoiceGenerator = new InvoiceGenerator(database);

        System.out.println("HI! Please select option: ");
        showOptions();
        boolean quit = false;
        int choice;

        while (!quit){
            choice = scanner.nextInt();
            switch (choice){
                case 0 : showOptions();
                break;
                case 1 :
                    System.out.println(reportService.showAllItems());;
                break;
                case 2 :
                    System.out.println("Enter items id: ");
                    int number = scanner.nextInt();
                    scanner.nextLine();
                    invoiceGenerator.addItemToList(number);
                    break;
                case 3 : invoiceGenerator.showItemsInList();
                break;
                case 9 : quit = true;
                default:
                    System.out.println("Something went wrong...");
                    break;
            }
        }


    }
public static void showOptions(){
    System.out.println("0 - Show options\n1 - Show items\n2 - Add item cart\n3 - Show whats in cart\n9 - quit ");
}

}
