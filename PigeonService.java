import java.util.Scanner;

import entities.SupplierDto;
import entities.ItemDto;
import entities.CategoryDto;
import entities.UserDto;
import utils.Clearutil;

public class PigeonService {

    static Scanner input = new Scanner(System.in);

    // User DTO
    private static UserDto user = new UserDto("danujav", "1234");

    // sup Dto
    static SupplierDto supplierDto = new SupplierDto();
    
    //sup Array
    static SupplierDto[] suppliers = new SupplierDto[0];

    static String[] categories = new String[0];

    static String[] items = new String[0];

    public static void main(String[] args) {
        loginPage();
    }

    public static void loginPage() {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                       LOGIN PAGE                               |");
        System.out.println("+----------------------------------------------------------------+\n");

        String name = "";

        while (!user.getUsername().equals(name)) {

            System.out.print("User Name: ");
            name = input.nextLine();

            if (!name.equals(user.getUsername())) {
                System.out.println("User name is incorrect. Please try again!\n");
            }
        }

        String pw = "";

        while (!user.getPassword().equals(pw)) {

            System.out.print("Password: ");
            pw = input.nextLine();

            if (!pw.equals(user.getPassword())) {
                System.out.println("Password is invalid. Please try again!\n");
            }
        }

        Clearutil.clearConsole();
        homePage();
    }

    public static void homePage() {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|              WELCOME TO IJSE STOCK MANAGEMENT SYSTEM 	        |");
        System.out.println("+----------------------------------------------------------------+\n");

        System.out.println("[1] Change the Credentials\t\t[2] Supplier Manage\n[3] Stock Manage\t\t\t[4] Log out\n[5] Exit the system\n");

        System.out.print("Enter an option to continue > ");
        byte option = input.nextByte();
        

        Clearutil.clearConsole();

        switch (option) {
            case 1 -> changetheCredentials();
            case 2 -> supplierManage(suppliers);
            case 3 -> stockManagement();
            case 4 -> loginPage();
            case 5 -> System.exit(0);
            default -> {
                System.out.println("Invalid option. Please select again.\n");
                homePage();
            }
        }
    }

    public static void changetheCredentials() {
    System.out.println("+---------------------------------------------------------------+");
    System.out.println("|                 CREDENTIAL MANAGE                             |");
    System.out.println("+---------------------------------------------------------------+");

    System.out.print("Please enter the user name to verify it's you: ");
    String eName = input.next();

        if (!eName.equals(user.getUsername())) {
            System.out.println("Invalid user name. Try again!");
            return;
        } else {
            System.out.println("Hey " + eName + "\n");
        }

        System.out.print("\nEnter your current password: ");
        String ePw = input.next();

        if (!ePw.equals(user.getPassword())) {
            System.out.println("Incorrect password. Try again!");
            homePage();
            return;
        }

        System.out.print("\nEnter your new password: ");
        String newPw = input.next();
        user.setPassword(newPw);
        
        System.out.println("Password changed successfully!");

        System.out.print("Do you want to go to home page (Y/N): ");
        char home = input.next().charAt(0);

        if (home == 'y' || home == 'Y') {
            Clearutil.clearConsole();
            homePage();

        } else {
            Clearutil.clearConsole();
            loginPage();
        }
    }

    public static void supplierManage(SupplierDto[] suppliers){
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                         SUPPLIER MANAGE                        |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.println("[1] Add Supplier\t\t[2] View Supplier\n[3] Update Supplier\t\t[4] Delete Supplier\n[5] Search Supplier\t\t[6] Back to Home\n");

        System.out.print("Enter an option to continue > ");
        byte option = input.nextByte();
        input.nextLine();

        Clearutil.clearConsole();

        switch (option) {
            case 1 -> addSupplier(suppliers);
            case 2 -> viewSuppliers(suppliers);
            case 3 -> updateSuppliers(suppliers);
            case 4 -> deleteSuppliers(suppliers);
            case 5 -> searchSuppliers(suppliers);
            case 6 -> homePage();
            default -> {
                System.out.println("Invalid option. Please select again.\n");
                supplierManage(suppliers);
                Clearutil.clearConsole();
            }
        }
    }

    public static void stockManagement() {
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|              		STOCK MANAGEMENT 			 	    |");
        System.out.println("+---------------------------------------------------------------+\n");

        System.out.println("[1] Manage Item categories\t\t[2] Add Item\n[3] Get Items Supplier Wise\t\t[4] View Item\n[5] Rank Item Per Unit Price\t\t [6] Home Page\n");

        System.out.print("Enter an option to continue > ");
        byte option = input.nextByte();
        input.nextLine();

        Clearutil.clearConsole();

        switch (option) {
            case 1 -> manageItemCategories();
            case 2 -> addItem();
            case 3 -> getItemsSupplierWise();
            case 4 -> {
                viewAllItems();
                System.out.println("\nPress Enter to return to Stock Management...");
                input.nextLine(); 
                Clearutil.clearConsole();
                stockManagement(); 
            }
            case 5 -> rankItemsPerUnitPrice();
            case 6 -> homePage();
            default -> {
                System.out.println("Invalid option. Please select again.\n");
                homePage();
            }
        }
    }

    public static void manageItemCategories() {
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|              	    MANAGE ITEM CATEGORY 			 	        |");
        System.out.println("+---------------------------------------------------------------+\n");

        System.out.println("[1] Add New Item Category\t\t[2] View All Item Categories\n[3] Update Item Category\t\t[4] Delete Item Category\n[5] Stock Management\n");

        System.out.print("Enter an option to continue > ");
        byte option = input.nextByte();
        input.nextLine();

        Clearutil.clearConsole();

        switch (option) {
            case 1 -> addNewItemCategory();
            case 2 -> {
                viewAllCategories();
                System.out.println("\nPress Enter to return to Item Category Management...");
                input.nextLine(); 
                Clearutil.clearConsole();
                manageItemCategories(); 
            }
            case 3 -> updateItemCategory();
            case 4 -> deleteItemCategory();
            case 5 -> stockManagement();
            default -> {
                System.out.println("Invalid option. Please select again.\n");
                manageItemCategories();
            }
        }
    }

    public static void viewAllCategories() {
    Clearutil.clearConsole();

    System.out.println("+---------------------------------------------------------------+");
    System.out.println("|                  VIEW ALL ITEM CATEGORIES                     |");
    System.out.println("+---------------------------------------------------------------+");

        if (categories.length == 0) {
            System.out.println("No Categories Found!");
        } else {
            System.out.printf("|%-15s %-20s%n", "CATEGORY ID", "CATEGORY NAME");
            System.out.println("+---------------------------------------------------------------+");

            for (int i = 0; i < categories.length; i++) {
                System.out.printf("%-15s %-20s%n", categories[i], categories[i]);
            }
        }

        System.out.print("\nPress Enter to Continue...");
        input.nextLine();

        Clearutil.clearConsole();
        manageItemCategories();
    }

    public static void addNewItemCategory() {
    Clearutil.clearConsole();

    System.out.println("+---------------------------------------------------------------+");
    System.out.println("|                    ADD ITEM CATEGORY                          |");
    System.out.println("+---------------------------------------------------------------+");

    System.out.print("Category ID: ");
    String id = input.nextLine();

        // Check Category ID
        for (int i = 0; i < categories.length; i++) {
            if (categories[i][0].equals(id)) {
                System.out.println("Category ID Already Exists!");
                addNewItemCategory();
                return;
            }
        }

        System.out.print("Category Name: ");
        String cName = input.nextLine();

        for (int i = 0; i < categories.length; i++) {
            if (categories[i][1].equalsIgnoreCase(cName)) {
                System.out.println("Category Name Already Exists!");
                addNewItemCategory();
                return;
            }
        }

        categories = growCategoryArray(categories);

        categories[categories.length - 1][0] = id;
        categories[categories.length - 1][1] = cName;

        System.out.println("Category Added Successfully!");

        System.out.print("Do you want to add another category? (Y/N): ");
        char ch = input.next().charAt(0);
        input.nextLine();

        if (ch == 'Y' || ch == 'y') {
            addNewItemCategory();
        } else {
            Clearutil.clearConsole();
            manageItemCategories();
        }
    }

    private static String[][] growCategoryArray(String[][] categories) {
        String[][] temp = new String[categories.length + 1][2];

        for (int i = 0; i < categories.length; i++) {
            temp[i] = categories[i];
        }
        return temp;
    }
    
    public static void deleteItemCategory() {
        while (true) {
            System.out.println("+---------------------------------------------------------------+");
            System.out.println("|                   DELETE ITEM CATEGORY                        |");
            System.out.println("+---------------------------------------------------------------+\n");

            System.out.print("Enter the category id to delete: ");
            String categoryToDelete = input.nextLine();

            boolean found = false;
            for (int i = 0; i < categories.length; i++) {
                if (categories[i][0].equals(categoryToDelete)) {
                    categories = deleteCategory(categories, categoryToDelete);
                    System.out.println("deleted successfully! \n");
                    viewAllCategories();
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("can't find category. try again!");
            }
            System.out.print("Do you want to delete another category? (Y/N): ");
            String choice = input.nextLine().trim();

            if(choice.equals("n") || choice.equals("N")) {
                Clearutil.clearConsole();
                stockManagement();
            }
        }
    }

    private static String[][] deleteCategory(String[][] categories, String categoryToDelete) {
        String[][] temp = new String[categories.length-1][2];

        int j = 0;
        for (int i = 0; i < categories.length; i++) {
            if(!categoryToDelete.equals(categories[i][0])) {
                temp[j] = categories[i];
                j++;
            }
        }
        return temp;
    }

    public static void updateItemCategory() {

    Clearutil.clearConsole();

    System.out.println("+---------------------------------------------------------------+");
    System.out.println("|                  UPDATE ITEM CATEGORY                         |");
    System.out.println("+---------------------------------------------------------------+");

    System.out.print("Enter the category id to update: ");
    String id = input.nextLine();

    for (int i = 0; i < categories.length; i++) {

        if (categories[i][0].equals(id)) {

            System.out.print("Enter New Category Name: ");
            String newName = input.nextLine();

            // Check duplicate category name
            for (int j = 0; j < categories.length; j++) {
                if (categories[j][1].equalsIgnoreCase(newName)) {
                    System.out.println("Category Name Already Exists!");
                    updateItemCategory();
                    return;
                }
            }

            categories[i][1] = newName;

            System.out.println("Category Updated Successfully!");

            System.out.print("Do you want to update another category? (Y/N): ");
            char ch = input.next().charAt(0);
            input.nextLine();

                if (ch == 'Y' || ch == 'y') {
                    Clearutil.clearConsole();
                    updateItemCategory();
                } else {
                    Clearutil.clearConsole();
                    manageItemCategories();
                }
                return;
            }
        }

        System.out.println("Category ID Not Found!");

        System.out.print("Do you want to try again? (Y/N): ");
        char ch = input.next().charAt(0);
        input.nextLine();

        if (ch == 'Y' || ch == 'y') {
            clearConsole();
            updateItemCategory();
        } else {
            clearConsole();
            manageItemCategories();
        }
    }

    public static void addItem() {
    Clearutil.clearConsole();

    System.out.println("\n+---------------------------------------------------------------------+");
    System.out.println("|                              ADD ITEM                               |");
    System.out.println("+---------------------------------------------------------------------+\n");


        if (categories.length == 0) {
            System.out.println("OOPS! No item categories available.\n");

            System.out.print("Do you want to add a new item category? (Y/N): ");
            String choice = input.next();

            if (choice.equalsIgnoreCase("Y")) {
                Clearutil.clearConsole();
                manageItemCategories();
            } else {
                Clearutil.clearConsole();
                stockManagement();
            }
            return;
        }

        if (suppliers.length == 0) {

            System.out.println("OOPS! No suppliers available.\n");

            System.out.print("Do you want to add a new supplier? (Y/N): ");
            String choice = input.next();

            if (choice.equalsIgnoreCase("Y")) {
                Clearutil.clearConsole();
                supplierManage(suppliers);
            } else {
                Clearutil.clearConsole();
                stockManagement();
            }
            return;
        }

        // item code
        String itemCode;

        while (true) {
            System.out.print("Item Code: ");
            itemCode = input.nextLine().trim();

            boolean exists = false;

            for (int i = 0; i < items.length; i++) {
                if (items[i] != null && items[i].equalsIgnoreCase(itemCode)) {
                    exists = true;
                    break;
                }
            }

            if (exists) {
                System.out.println("Item Code Already Exists! Try another code.\n");
            } else {
                break;
            }
        }

        // Supplier List
        System.out.println("\nSupplier List:");

        System.out.println("+-----+----------------+----------------------+");
        System.out.println("|  #  | SUPPLIER ID    | SUPPLIER NAME        |");
        System.out.println("+-----+----------------+----------------------+");


        for (int i = 0; i < suppliers.length; i++) {
            System.out.printf("| %-3d | %-14s | %-20s |%n",
                    (i + 1),
                    suppliers[i],
                    suppliers[i]
            );
        }
        System.out.println("+-----+----------------+----------------------+");

        int supplierNumber;

        while (true) {
            System.out.print("Enter supplier number: ");
            supplierNumber = input.nextInt();

            if (supplierNumber >= 1 && supplierNumber <= suppliers.length) {
                break;
            } else {
                System.out.println("Invalid supplier number!");
            }
        }

        System.out.println("\nCategory List:");

        System.out.println("+-----+----------------+----------------------+");
        System.out.println("|  #  | CATEGORY ID    | CATEGORY NAME        |");
        System.out.println("+-----+----------------+----------------------+");


        for (int i = 0; i < categories.length; i++) {
            System.out.printf(
                    "| %-3d | %-14s | %-20s |%n",
                    (i + 1),
                    categories[i],
                    categories[i]
            );
        }
        System.out.println("+-----+----------------+----------------------+");

        int categoryNumber;

        while (true) {
            System.out.print("Enter category number: ");
            categoryNumber = input.nextInt();

            if (categoryNumber >= 1 && categoryNumber <= categories.length) {
                break;
            } else {
                System.out.println("Invalid category number!");
            }
        }

        input.nextLine();

        System.out.print("Description: ");
        String description = input.nextLine();

        double unitPrice;

        while (true) {
            System.out.print("Unit Price: ");

            if (input.hasNextDouble()) {
                unitPrice = input.nextDouble();
                if (unitPrice > 0) {
                    break;
                }
                System.out.println("Price must be greater than 0!");
            } else {
                System.out.println("Invalid price!");
                input.next();
            }
        }

        int quantity;

        while (true) {
            System.out.print("Quantity: ");

            if (input.hasNextInt()) {
                quantity = input.nextInt();

                if (quantity >= 0) {
                    break;
                }
                System.out.println("Quantity cannot be negative!");

            } else {
                System.out.println("Invalid quantity!");
                input.next();
            }
        }

        input.nextLine();

        items = growItemArray(items);

        int index = items.length - 1;

        items[index][0] = itemCode;
        items[index][1] = supplier[supplierNumber - 1];
        items[index][2] = categories[categoryNumber - 1];
        items[index][3] = description;
        items[index][4] = String.valueOf(unitPrice);
        items[index][5] = String.valueOf(quantity);

        System.out.println("\nItem Added Successfully!");

        System.out.print("\nDo you want to add another item? (Y/N): ");
        String choice = input.next();

        input.nextLine(); 

        if (choice.equalsIgnoreCase("Y")) {
            Clearutil.clearConsole();
            addItem();
        } else {
            Clearutil.clearConsole();
            stockManagement();
        }
    }
   
    public static void allSuppliers() {
    Clearutil.clearConsole();

    System.out.println("+----------------------------------------------------------------+");
    System.out.println("|                        VIEW SUPPLIERS                          |");
    System.out.println("+----------------------------------------------------------------+");

    if (suppliers.length == 0) {
        System.out.println("No Suppliers Found!");
        return;
    }
    System.out.printf("%-15s %-20s%n", "SUPPLIER ID", "SUPPLIER NAME");
    System.out.println("----------------------------------------------------");

        for (int i = 0; i < suppliers.length; i++) {
            System.out.printf("%-15s %-20s%n", suppliers[i], suppliers[i]);
        }
    }

    private static String[][] growItemArray(String[][] items) {
        String[][] temp = new String[items.length+1][6];
        for (int i = 0; i < items.length; i++) {
            temp[i] = items[i];
        }
        return temp;
    }

    public static boolean isOkSupplersAndCategories() {

        if (categories.length == 0) {

            System.out.print("No Item Categories Found. Add Now? (Y/N): ");
            char ch = input.next().charAt(0);
            input.nextLine();

            if (ch == 'Y' || ch == 'y') {
                Clearutil.clearConsole();
                addNewItemCategory();
            } else {
                Clearutil.clearConsole();
                stockManagement();
            }

            return false;
        }

        if (suppliers.length == 0) {

            System.out.print("No Suppliers Found. Add Now? (Y/N): ");
            char ch = input.next().charAt(0);
            input.nextLine();

            if (ch == 'Y' || ch == 'y') {
                Clearutil.clearConsole();
                addSupplier();
            } else {
                Clearutil.clearConsole();
                stockManagement();
            }
            return false;
        }
        return true;
    }

   public static void getItemsSupplierWise() {
    Clearutil.clearConsole();

    System.out.println("+---------------------------------------------------------------+");
    System.out.println("|                  SEARCH SUPPLIER WISE                         |");
    System.out.println("+---------------------------------------------------------------+");

    System.out.print("Enter Supplier ID: ");
    String id = input.nextLine();

    for (int i = 0; i < suppliers.length; i++) {
        if (suppliers[i].equalsIgnoreCase(id)) {

            System.out.println("Supplier Name : " + suppliers[i]);

            System.out.println("+--------+----------------------+------------+-------------+------------+------------+");
            System.out.println("| CODE   | DESCRIPTION          | UNIT PRICE | QTY ON HAND | CATEGORY   | SUPPLIER   |");
            System.out.println("+--------+----------------------+------------+-------------+------------+------------+");

            boolean found = false;

            for (int j = 0; j < items.length; j++) {
                if (items[j][1].equalsIgnoreCase(id)) {

                    found = true;

                    System.out.printf(
                            "| %-6s | %-20s | %-10s | %-11s | %-10s | %-10s |%n",
                            items[j][0],   // Item Code
                            items[j][3],   // Description
                            items[j][4],   // Unit Price
                            items[j][5],   // Quantity
                            items[j][2],   // Category ID
                            items[j][1]    // Supplier ID
                    );
                }
            }

            if (!found) {
                System.out.println("|               No Items Found For This Supplier                |");
            }
            System.out.println("+--------+----------------------+------------+-------------+------------+------------+");

            System.out.print("Do you want to search another supplier? (Y/N): ");
            char ch = input.next().charAt(0);
            input.nextLine();

            if (ch == 'Y' || ch == 'y') {
                Clearutil.clearConsole();
                getItemsSupplierWise();
            } else {
                Clearutil.clearConsole();
                stockManagement();
            }
            return;
        }
    }

    System.out.println("Supplier ID Not Found!");

    System.out.print("Do you want to try again? (Y/N): ");
    char ch = input.next().charAt(0);
    input.nextLine();

        if (ch == 'Y' || ch == 'y') {
            Clearutil.clearConsole();
            getItemsSupplierWise();
        } else {
            Clearutil.clearConsole();
            stockManagement();
        }
    }

    public static void viewAllItems() {
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                           VIEW ITEMS                          |");
        System.out.println("+---------------------------------------------------------------+");

        if (items == null || items.length == 0) {
            System.out.println("No items found.\n");
            return;
        }

        System.out.printf("%-12s %-12s %-12s %-20s %-10s %-10s%n",
                "Item Code","Supplier ID","Category ID","Description","Price","Quantity");
        System.out.println("--------------------------------------------------------------------------------");

        for (String[] item : items) {
            System.out.printf("%-12s %-12s %-12s %-20s %-10s %-10s%n",
                    item[0],   // Item Code
                    item[1],   // Supplier ID
                    item[2],   // Category ID
                    item[3],   // Description
                    item[4],   // Price
                    item[5]    // Quantity
            );
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public static void rankItemsPerUnitPrice() {
        System.out.println("+-------------------------------------------------+");
        System.out.println("|              RANKED UNIT PRICE                  |");
        System.out.println("+-------------------------------------------------+");

        if (items == null || items.length == 0) {
            System.out.println("No items found.");
            return;
        }

        String[][] sItems = new String[items.length][items[0].length];

        for (int i = 0; i < items.length; i++) {
            System.arraycopy(
                    items[i],
                    0,
                    sItems[i],
                    0,
                    items[i].length);
        }

        for (int i = 0; i < sItems.length - 1; i++) {
            for (int j = 0; j < sItems.length - 1 - i; j++) {

                double price1 = Double.parseDouble(sItems[j][4]);
                double price2 = Double.parseDouble(sItems[j + 1][4]);

                if (price1 > price2) {
                    String[] temp = sItems[j];
                    sItems[j] = sItems[j + 1];
                    sItems[j + 1] = temp;
                }
            }
        }

        System.out.println("+-------+--------+----------------------+----------+--------+-----------+");
        System.out.println("| SID   | CODE   | DESC                 | PRICE    | QTY    | CATEGORY  |");
        System.out.println("+-------+--------+----------------------+----------+--------+-----------+");

        for (String[] item : sItems) {
            System.out.printf("| %-5s | %-6s | %-20s | %-8s | %-6s | %-9s |\n",
                    item[1],   // Supplier ID
                    item[0],   // Item Code
                    item[3],   // Description
                    item[4],   // Unit Price
                    item[5],   // Quantity
                    item[2]    // Category ID
            );
        }
        System.out.println("+-------+--------+----------------------+----------+--------+-----------+");

        System.out.print("Do you want to go stock manage page? (Y/N): ");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            Clearutil.clearConsole();
            stockManagement();
        } else {
            System.out.println("Exiting...");
            System.exit(0);

        }
    }
}