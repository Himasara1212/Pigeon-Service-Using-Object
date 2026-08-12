import entities.CategoryDto;
import entities.ItemDto;
import entities.SupplierDto;
import entities.UserDto;

import java.util.Scanner;

public class PigeonService {

    static Scanner input = new Scanner(System.in);

    static UserDto user = new UserDto("danujav", "1234");

    static SupplierDto[] suppliers = new SupplierDto[0];

    static CategoryDto[] categories = new CategoryDto[0];

    static ItemDto[] items = new ItemDto[0];

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
        clearConsole();
        homePage();
    }

    public static void homePage() {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|              WELCOME TO IJSE STOCK MANAGEMENT SYSTEM           |");
        System.out.println("+----------------------------------------------------------------+\n");

        System.out.println("[1] Change the Credentials\t\t[2] Supplier Manage\n[3] Stock Manage\t\t\t[4] Log out\n[5] Exit the system\n");
        System.out.print("Enter an option to continue > ");
        byte option = input.nextByte();
        input.nextLine();

        clearConsole();
        switch (option) {
            case 1 -> changetheCredentials();
            case 2 -> supplierManage();
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
            return;
        }

        System.out.print("\nEnter your new password: ");
        String newPw = input.next();

        user.setPassword(newPw);
        System.out.println("Password changed successfully!");

        System.out.print("Do you want to go to home page (Y/N): ");

        char home = input.next().charAt(0);
        if (home == 'y' || home == 'Y') {
            clearConsole();
            homePage();
        } else {
            clearConsole();
            loginPage();
        }
    }

    public static void supplierManage() {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                         SUPPLIER MANAGE                        |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.println("[1] Add Supplier\t\t[2] View Supplier\n" +"[3] Update Supplier\t\t[4] Delete Supplier\n" +"[5] Search Supplier\t\t[6] Back to Home\n");
        System.out.print("Enter an option to continue > ");

        byte option = input.nextByte();
        input.nextLine();
        clearConsole();

        switch (option) {
            case 1 -> addSupplier();
            case 2 -> viewSuppliers();
            case 3 -> updateSuppliers();
            case 4 -> deleteSuppliers();
            case 5 -> searchSuppliers();
            case 6 -> homePage();
            default -> {
                System.out.println("Invalid option. Please select again.\n");
                supplierManage();
                clearConsole();
            }
        }
    }

    public static void addSupplier() {
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                         ADD SUPPLIER                           |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.print("Supplier ID: ");
        String id = input.nextLine().trim();

        // Check ID already exists
        for (int i = 0; i < suppliers.length; i++) {
            if (suppliers[i].getSupId().equals(id)) {
                System.out.println("Supplier ID already exists. Try another Supplier ID.");
                addSupplier();
                return;
            }
        }

        System.out.print("Supplier Name: ");
        String name = input.nextLine();

        growSupplierArray();

        suppliers[suppliers.length - 1] = new SupplierDto(id, name);
        System.out.println("Supplier added successfully!");
        System.out.print("Do you want to add another supplier? (Y/N): ");

        char another = input.next().charAt(0);
        input.nextLine();

        if (another == 'Y' || another == 'y') {
            clearConsole();
            addSupplier();
        } else {
            clearConsole();
            supplierManage();
        }
    }

    public static void growSupplierArray() {
        SupplierDto[] tempArray =new SupplierDto[suppliers.length + 1];

        for (int i = 0; i < suppliers.length; i++) {
            tempArray[i] = suppliers[i];
        }
        suppliers = tempArray;
    }

    public static void updateSuppliers() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                      UPDATE SUPPLIER                           |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.print("Supplier ID: ");
        String id = input.nextLine();

        for (int i = 0; i < suppliers.length; i++) {

            if (suppliers[i].getSupId().equals(id)) {
                System.out.print("Enter New Supplier Name: ");

                suppliers[i].setSupName(input.nextLine());
                System.out.println("Supplier Updated Successfully!");

                System.out.print("Do you want to update another supplier? (Y/N): ");
                char ch = input.next().charAt(0);
                input.nextLine();

                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    updateSuppliers();
                } else {
                    clearConsole();
                    supplierManage();
                }
                return;
            }
        }
        System.out.println("Supplier ID Not Found!");
        System.out.print("Do you want to try again? (Y/N): ");

        char ch = input.next().charAt(0);
        input.nextLine();

        if (ch == 'Y' || ch == 'y') {
            clearConsole();
            updateSuppliers();
        } else {
            supplierManage();
            clearConsole();
        }
    }

    public static void deleteSuppliers() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                      DELETE SUPPLIER                           |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.print("Supplier ID: ");
        String id = input.nextLine();

        for (int i = 0; i < suppliers.length; i++) {

            if (suppliers[i].getSupId().equals(id)) {
                suppliers = deleteFromSupplierArray(suppliers, id);
                System.out.println("Supplier Deleted Successfully!");

                System.out.print("Do you want to delete another supplier? (Y/N): ");

                char ch = input.next().charAt(0);
                input.nextLine();

                if (ch == 'Y' || ch == 'y') {
                    deleteSuppliers();

                } else {
                    clearConsole();
                    supplierManage();
                }
                return;
            }
        }

        System.out.println("Supplier ID Not Found!");

        System.out.print("Do you want to try again? (Y/N): ");

        char ch = input.next().charAt(0);
        input.nextLine();

        if (ch == 'Y' || ch == 'y') {

            deleteSuppliers();

        } else {

            clearConsole();
            supplierManage();
        }
    }

    private static SupplierDto[] deleteFromSupplierArray(SupplierDto[] suppliers,String id) {
        SupplierDto[] temp =new SupplierDto[suppliers.length - 1];

        int j = 0;

        for (int i = 0; i < suppliers.length; i++) {

            if (!suppliers[i].getSupId().equals(id)) {
                temp[j] = suppliers[i];
                j++;
            }
        }
        return temp;
    }

    public static void viewSuppliers() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                         VIEW SUPPLIERS                         |");
        System.out.println("+----------------------------------------------------------------+\n");

        if (suppliers.length == 0) {
            System.out.println("No Suppliers Found!");
        } else {
            System.out.println("-----------------------------------------");
            System.out.printf("%-15s %-20s\n","SUPPLIER ID","SUPPLIER NAME\t\t|");
            System.out.println("-----------------------------------------");

            for (int i = 0; i < suppliers.length; i++) {
                System.out.printf("|%-15s %-20s\n",suppliers[i].getSupId(),suppliers[i].getSupName());
            }
        }
        System.out.print("\nGo to Supplier Manage Page? (Y/N): ");
        char ch = input.next().charAt(0);
        input.nextLine();

        clearConsole();
        if (ch == 'Y' || ch == 'y') {
            clearConsole();
            supplierManage();
        } else {
            clearConsole();
            homePage();
        }
    }

    public static void searchSuppliers() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                      SEARCH SUPPLIER                           |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.print("Supplier ID: ");
        String id = input.nextLine();

        for (int i = 0; i < suppliers.length; i++) {
            if (suppliers[i].getSupId().equals(id)) {
                    System.out.println("Supplier ID   : " +suppliers[i].getSupId());
                    System.out.println("Supplier Name : " +suppliers[i].getSupName());

                System.out.print("\nDo you want to search another supplier? (Y/N): ");
                char ch = input.next().charAt(0);
                input.nextLine();

                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    searchSuppliers();
                } else {
                    clearConsole();
                    supplierManage();
                }
                return;
            }
        }
        System.out.println("Supplier ID Not Found!");

        System.out.print("Do you want to try again? (Y/N): ");
        char ch = input.next().charAt(0);
        input.nextLine();

        if (ch == 'Y' || ch == 'y') {
            clearConsole();
            searchSuppliers();
        } else {
            clearConsole();
            supplierManage();
        }
    }

    public static void stockManagement() {
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                  STOCK MANAGEMENT                             |");
        System.out.println("+---------------------------------------------------------------+\n");

        System.out.println("[1] Manage Item categories\t\t[2] Add Item\n[3] Get Items Supplier Wise\t\t[4] View Item\n[5] Rank Item Per Unit Price\t\t [6] Home Page\n");
        System.out.print("Enter an option to continue > ");
        byte option = input.nextByte();
        input.nextLine();

        clearConsole();
        switch (option) {
            case 1 -> manageItemCategories();
            case 2 -> addItem();
            case 3 -> getItemsSupplierWise();
            case 4 -> { viewAllItems();
                System.out.println("\nPress Enter to return to Stock Management...");
                input.nextLine();
                clearConsole();
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
        System.out.println("|                    MANAGE ITEM CATEGORY                       |");
        System.out.println("+---------------------------------------------------------------+\n");

        System.out.println("[1] Add New Item Category\t\t[2] View All Item Categories\n[3] Update Item Category\t\t[4] Delete Item Category\n[5] Stock Management\n");
        System.out.print("Enter an option to continue > ");
        byte option = input.nextByte();
        input.nextLine();

        clearConsole();
        switch (option) {
            case 1 -> addNewItemCategory();
            case 2 -> { viewAllCategories();
                System.out.println("\nPress Enter to return to Item Category Management...");
                input.nextLine();
                clearConsole();
                manageItemCategories();
            }
            case 3 -> updateItemCategory();
            case 4 -> deleteItemCategory();
            case 5 -> stockManagement();
            default -> { System.out.println("Invalid option. Please select again.\n");
                manageItemCategories();
            }
        }
    }

    public static void viewAllCategories() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                  VIEW ALL ITEM CATEGORIES                     |");
        System.out.println("+---------------------------------------------------------------+");

        if (categories.length == 0) {
            System.out.println("No Categories Found!");
        } else {
            System.out.println("\n+---------------------------------------------------------------+");
            System.out.printf("|%-15s %-20s%n","CATEGORY ID","CATEGORY NAME");
            System.out.println("+---------------------------------------------------------------+");

            for (int i = 0; i < categories.length; i++) {

                System.out.printf("%-15s %-20s%n",
                        categories[i].getCategoryId(),
                        categories[i].getCategoryName()
                );
            }
        }
        System.out.print("\nPress Enter to Continue...");
        input.nextLine();
        clearConsole();
        manageItemCategories();
    }

    public static void addNewItemCategory() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                    ADD ITEM CATEGORY                          |");
        System.out.println("+---------------------------------------------------------------+");

        System.out.print("Category ID: ");
        String id = input.nextLine();

        // Check Category ID
        for (int i = 0; i < categories.length; i++) {

            if (categories[i].getCategoryId().equals(id)) {
                System.out.println("Category ID Already Exists!");
                addNewItemCategory();
                return;
            }
        }

        System.out.print("Category Name: ");
        String cName = input.nextLine();

        for (int i = 0; i < categories.length; i++) {

            if (categories[i].getCategoryName().equalsIgnoreCase(cName)) {
                System.out.println("Category Name Already Exists!");
                addNewItemCategory();
                return;
            }
        }

        categories = growCategoryArray(categories);

        categories[categories.length - 1] = new CategoryDto(id, cName);
        System.out.println("Category Added Successfully!");

        System.out.print("Do you want to add another category? (Y/N): ");
        char ch = input.next().charAt(0);
        input.nextLine();

        if (ch == 'Y' || ch == 'y') {
            addNewItemCategory();
        } else {
            clearConsole();
            manageItemCategories();
        }
    }

    private static CategoryDto[] growCategoryArray(CategoryDto[] categories) {
        CategoryDto[] temp = new CategoryDto[categories.length + 1];

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

                if (categories[i].getCategoryId().equals(categoryToDelete)) {
                    categories = deleteCategory(categories,categoryToDelete);

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

            if (choice.equalsIgnoreCase("n")) {
                clearConsole();
                stockManagement();
            }
        }
    }

    private static CategoryDto[] deleteCategory(CategoryDto[] categories,String categoryToDelete) {
        CategoryDto[] temp = new CategoryDto[categories.length - 1];

        int j = 0;

        for (int i = 0; i < categories.length; i++) {

            if (!categoryToDelete.equals(categories[i].getCategoryId())) {
                temp[j] = categories[i];
                j++;
            }
        }
        return temp;
    }

    public static void updateItemCategory() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                  UPDATE ITEM CATEGORY                         |");
        System.out.println("+---------------------------------------------------------------+");

        System.out.print("Enter the category id to update: ");
        String id = input.nextLine();

        for (int i = 0; i < categories.length; i++) {

            if (categories[i].getCategoryId().equals(id)) {
                System.out.print("Enter New Category Name: ");
                String newName = input.nextLine();

                // Check duplicate category name
                for (int j = 0; j < categories.length; j++) {

                    if (categories[j].getCategoryName().equalsIgnoreCase(newName)) {
                        System.out.println("Category Name Already Exists!");
                        updateItemCategory();
                        return;
                    }
                }

                categories[i].setCategoryName(newName);
                System.out.println("Category Updated Successfully!");

                System.out.print("Do you want to update another category? (Y/N): ");
                char ch = input.next().charAt(0);
                input.nextLine();

                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    updateItemCategory();
                } else {
                    clearConsole();
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
        clearConsole();
        System.out.println("\n+---------------------------------------------------------------------+");
        System.out.println("|                              ADD ITEM                               |");
        System.out.println("+---------------------------------------------------------------------+\n");

        if (categories.length == 0) {
            System.out.println("OOPS! No item categories available.\n");

            System.out.print("Do you want to add a new item category? (Y/N): ");
            String choice = input.next();

            if (choice.equalsIgnoreCase("Y")) {
                clearConsole();
                manageItemCategories();
            } else {
                clearConsole();
                stockManagement();
            }
            return;
        }

        if (suppliers.length == 0) {
            System.out.println("OOPS! No suppliers available.\n");

            System.out.print("Do you want to add a new supplier? (Y/N): ");
            String choice = input.next();

            if (choice.equalsIgnoreCase("Y")) {
                clearConsole();
                supplierManage();
            } else {
                clearConsole();
                stockManagement();
            }
            return;
        }

        String itemCode;
        while (true) {
            System.out.print("Item Code: ");
            itemCode = input.nextLine().trim();

            boolean exists = false;

            for (int i = 0; i < items.length; i++) {

                if (items[i].getItemCode().equalsIgnoreCase(itemCode)) {
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
        System.out.println("\nSupplier List:");
        System.out.println("+-----+----------------+----------------------+");
        System.out.println("|  #  | SUPPLIER ID    | SUPPLIER NAME        |");
        System.out.println("+-----+----------------+----------------------+");

        for (int i = 0; i < suppliers.length; i++) {
            System.out.printf("| %-3d | %-14s | %-20s |%n",(i + 1),
                    suppliers[i].getSupId(),
                    suppliers[i].getSupName());
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
            System.out.printf("| %-3d | %-14s | %-20s |%n",(i + 1),
                    categories[i].getCategoryId(),
                    categories[i].getCategoryName());
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

        suppliers[supplierNumber - 1] = suppliers[supplierNumber - 1];
        categories[categoryNumber - 1] = categories[categoryNumber - 1];

        items = growItemArray(items);
        int index = items.length - 1;

        items[index] = new ItemDto(itemCode,suppliers[supplierNumber - 1],categories[categoryNumber - 1],description,unitPrice,quantity);
        System.out.println("\nItem Added Successfully!");

        System.out.print("\nDo you want to add another item? (Y/N): ");
        String choice = input.next();
        input.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            clearConsole();
            addItem();
        } else {
            clearConsole();
            stockManagement();
        }
    }

    public static void allSuppliers() {
        clearConsole();
        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                        VIEW SUPPLIERS                          |");
        System.out.println("+----------------------------------------------------------------+");

        if (suppliers.length == 0) {
            System.out.println("No Suppliers Found!");
            return;
        }

        System.out.printf("%-15s %-20s%n","SUPPLIER ID","SUPPLIER NAME");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < suppliers.length; i++) {

            System.out.printf("%-15s %-20s%n",
                    suppliers[i].getSupId(),
                    suppliers[i].getSupName()
            );
        }
    }

    private static ItemDto[] growItemArray(ItemDto[] items) {
        ItemDto[] temp = new ItemDto[items.length + 1];

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
                clearConsole();
                addNewItemCategory();
            } else {
                clearConsole();
                stockManagement();
            }
            return false;
        }

        if (suppliers.length == 0) {
            System.out.print("No Suppliers Found. Add Now? (Y/N): ");
            char ch = input.next().charAt(0);
            input.nextLine();

            if (ch == 'Y' || ch == 'y') {
                clearConsole();
                addSupplier();
            } else {
                clearConsole();
                stockManagement();
            }
            return false;
        }
        return true;
    }

    public static void getItemsSupplierWise() {
        clearConsole();
        System.out.println("+---------------------------------------------------------------+");
        System.out.println("|                  SEARCH SUPPLIER WISE                         |");
        System.out.println("+---------------------------------------------------------------+");

        System.out.print("Enter Supplier ID: ");
        String id = input.nextLine();

        for (int i = 0; i < suppliers.length; i++) {

            if (suppliers[i].getSupId().equalsIgnoreCase(id)) {
                System.out.println("Supplier Name : " + suppliers[i].getSupName());

                System.out.println("+--------+----------------------+------------+-------------+------------+------------+");
                System.out.println("| CODE   | DESCRIPTION          | UNIT PRICE | QTY ON HAND | CATEGORY   | SUPPLIER   |");
                System.out.println("+--------+----------------------+------------+-------------+------------+------------+");

                boolean found = false;

                for (int j = 0; j < items.length; j++) {

                    if (items[j].getSupplier().getSupId().equalsIgnoreCase(id)) {
                        found = true;

                        System.out.printf("| %-6s | %-20s | %-10.2f | %-11d | %-10s | %-10s |%n",
                                items[j].getItemCode(),
                                items[j].getDescription(),
                                items[j].getUnitPrice(),
                                items[j].getQuantity(),
                                items[j].getCategory().getCategoryId(),
                                items[j].getSupplier().getSupId()
                        );
                    }
                }
                if (!found) {
                    System.out.println("|                        No Items Found For This Supplier                        |");
                }
                System.out.println("+--------+----------------------+------------+-------------+------------+------------+");

                System.out.print("Do you want to search another supplier? (Y/N): ");
                char ch = input.next().charAt(0);
                input.nextLine();

                if (ch == 'Y' || ch == 'y') {
                    clearConsole();
                    getItemsSupplierWise();
                } else {
                    clearConsole();
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
            clearConsole();
            getItemsSupplierWise();
        } else {
            clearConsole();
            stockManagement();
        }
    }

    public static void viewAllItems() {
        System.out.println("+-------------------------------------------------------------------------------------------------+");
        System.out.println("|                                            VIEW ITEMS                                           |");
        System.out.println("+-------------------------------------------------------------------------------------------------+");

        if (items == null || items.length == 0) {
            System.out.println("No items found.\n");
            return;
        }
        System.out.printf("%-12s %-12s %-12s %-20s %-10s %-10s%n","Item Code","Supplier ID","Category ID","Description","Price","Quantity");
        System.out.println("+-------------------------------------------------------------------------------------------------+");

        for (ItemDto item : items) {
            System.out.printf("%-12s %-12s %-12s %-20s %-10.2f %-10d%n",
                    item.getItemCode(),
                    item.getSupplier().getSupId(),
                    item.getCategory().getCategoryId(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQuantity()
            );
        }
        System.out.println("+-------------------------------------------------------------------------------------------------+");
    }

    public static void rankItemsPerUnitPrice() {
        System.out.println("+-------------------------------------------------+");
        System.out.println("|              RANKED UNIT PRICE                 |");
        System.out.println("+-------------------------------------------------+");

        if (items == null || items.length == 0) {
            System.out.println("No items found.");
            return;
        }

        ItemDto[] sItems = new ItemDto[items.length];

        for (int i = 0; i < items.length; i++) {
            sItems[i] = items[i];
        }

        for (int i = 0; i < sItems.length - 1; i++) {

            for (int j = 0; j < sItems.length - 1 - i;j++) {
                double price1 = sItems[j].getUnitPrice();
                double price2 = sItems[j + 1].getUnitPrice();

                if (price1 > price2) {
                    ItemDto temp = sItems[j];
                    sItems[j] = sItems[j + 1];
                    sItems[j + 1] = temp;
                }
            }
        }
        System.out.println("+-------+--------+----------------------+----------+--------+-----------+");
        System.out.println("| SID   | CODE   | DESC                 | PRICE    | QTY    | CATEGORY  |");
        System.out.println("+-------+--------+----------------------+----------+--------+-----------+");

        for (ItemDto item : sItems) {

            System.out.printf("| %-5s | %-6s | %-20s | %-8.2f | %-6d | %-9s |%n",
                    item.getSupplier().getSupId(),
                    item.getItemCode(),
                    item.getDescription(),
                    item.getUnitPrice(),
                    item.getQuantity(),
                    item.getCategory().getCategoryId()
            );
        }
        System.out.println("+-------+--------+----------------------+----------+--------+-----------+");

        System.out.print("Do you want to go stock manage page? (Y/N): ");
        String choice = input.nextLine();

        if (choice.equalsIgnoreCase("Y")) {
            clearConsole();
            stockManagement();
        } else {
            System.out.println("Exiting...");
            System.exit(0);
        }
    }

    private final static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Could not clear screen");
        }
    }
}