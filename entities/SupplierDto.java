package entities;

import java.util.Scanner;
import utils.Clearutil;

public class SupplierDto {
    private String supId;
    private String supName;

    static Scanner input = new Scanner(System.in);


    SupplierDto() {}

    SupplierDto(String supId, String supName) {
        this.supId = supId;
        this.supName = supName;
    }

    public String getSupId() {
        return supId;
    }

    public void setSupId(String supId) {
        this.supId = supId;
    }

    public String getSupName() {
        return supName;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public String toString() {
        return "Supplier ID   : " + supId +
               "\nSupplier Name : " + supName;
    }


    public static SupplierDto[] addSupplier(SupplierDto[] suppliers) {

        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                        ADD SUPPLIER                            |");
        System.out.println("+----------------------------------------------------------------+");


        System.out.print("Supplier ID: ");
        String id = input.nextLine();

        for (SupplierDto supplier : suppliers) {
            if (supplier.getSupId().equals(id)) {
                System.out.println("Supplier ID already exists!");
                return suppliers;
            }
        }

        System.out.print("Supplier Name: ");
        String name = input.nextLine();

        SupplierDto[] temp = new SupplierDto[suppliers.length + 1];

        for(int i = 0; i < suppliers.length; i++) {
            temp[i] = suppliers[i];
        }

        temp[temp.length - 1] = new SupplierDto(id,name);

        System.out.println("Supplier Added Successfully!");
        return temp;

    }

    public static void viewSuppliers(SupplierDto[] suppliers) {

        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                     VIEW SUPPLIERS                             |");
        System.out.println("+----------------------------------------------------------------+");


        if(suppliers.length == 0){
            System.out.println("No Suppliers Found!");
            return;
        }

        System.out.printf("%-15s %-20s%n","SUPPLIER ID","SUPPLIER NAME");
        System.out.println("---------------------------------------------");

        for(SupplierDto supplier : suppliers){

            System.out.printf("%-15s %-20s%n",
                    supplier.getSupId(),
                    supplier.getSupName());

        }
    }

    public static SupplierDto[] deleteSupplier(SupplierDto[] suppliers,String id){

        SupplierDto[] temp = new SupplierDto[suppliers.length-1];
        int index = 0;

        for(SupplierDto supplier : suppliers){
            if(!supplier.getSupId().equals(id)){
                temp[index] = supplier;
                index++;

            }
        }
        return temp;
    }

    public static void searchSupplier(SupplierDto[] suppliers,String id){

        for(SupplierDto supplier : suppliers){

            if(supplier.getSupId().equals(id)){
                System.out.println("Supplier ID : "+ supplier.getSupId());
                System.out.println("Supplier Name : "+ supplier.getSupName());
                return;
            }
        }
        System.out.println("Supplier Not Found!");
    }

    public static void updateSupplier(SupplierDto[] suppliers,String id,String newName){

        for(SupplierDto supplier : suppliers){

            if(supplier.getSupId().equals(id)){
                supplier.setSupName(newName);
                System.out.println("Supplier Updated Successfully!");
                return;
            }
        }
        System.out.println("Supplier Not Found!");
    }

    public static SupplierDto[] growArray(SupplierDto[] suppliers) {
        SupplierDto[] tempArray = new SupplierDto[suppliers.length + 1];

        for (int i = 0; i < suppliers.length; i++) {
            tempArray[i] = suppliers[i];
        }

        return tempArray;
    }


    public static void updateSuppliers(SupplierDto[] suppliers) {
       Clearutil.clearConsole();

        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                      UPDATE SUPPLIER                           |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.print("Supplier ID: ");
        String id = input.nextLine();

        for (int i = 0; i < suppliers.length; i++) {

            if (suppliers[i].getSupId().equals(id)) {

                System.out.print("Enter New Supplier Name: ");
                String newName = input.nextLine();

                suppliers[i].setSupName(newName);

                System.out.println("Supplier Updated Successfully!");

                System.out.print("Do you want to update another supplier? (Y/N): ");
                char ch = input.next().charAt(0);
                input.nextLine();

                if (ch == 'Y' || ch == 'y') {
                    Clearutil.clearConsole();
                    updateSuppliers(suppliers);
                } else {
                    Clearutil.clearConsole();
                    supplierManage(suppliers);
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
            updateSuppliers(suppliers);
        } else {
            Clearutil.clearConsole();
            supplierManage(suppliers);
        }
    }

    public static void deleteSuppliers(SupplierDto[] suppliers) {
    Clearutil.clearConsole();

    System.out.println("+----------------------------------------------------------------+");
    System.out.println("|                      DELETE SUPPLIER                           |");
    System.out.println("+----------------------------------------------------------------+");

    System.out.print("Supplier ID: ");
    String id = input.nextLine();

    for (int i = 0; i < suppliers.length; i++) {

        if (suppliers[i].getSupId().equals(id)) {

            suppliers = deleteFromArray(suppliers, id);

            System.out.println("Supplier Deleted Successfully!");

            System.out.print("\nDo you want to delete another supplier? (Y/N): ");
            char ch = input.next().charAt(0);
            input.nextLine();

            if (ch == 'Y' || ch == 'y') {
                deleteSuppliers(suppliers);
            } else {
                Clearutil.clearConsole();
                supplierManage(suppliers);
            }

            return;
        }
    }

    System.out.println("Supplier ID Not Found!");

    System.out.print("Do you want to try again? (Y/N): ");
    char ch = input.next().charAt(0);
    input.nextLine();

    if (ch == 'Y' || ch == 'y') {
        deleteSuppliers(suppliers);
    } else {
        Clearutil.clearConsole();
        supplierManage(suppliers);
    }
}

private static SupplierDto[] deleteFromArray(SupplierDto[] suppliers, String id) {

    SupplierDto[] temp = new SupplierDto[suppliers.length - 1];

    int j = 0;

    for (int i = 0; i < suppliers.length; i++) {

        if (!suppliers[i].getSupId().equals(id)) {

            temp[j] = suppliers[i];
            j++;
        }
    }

    return temp;
}

    public static void searchSuppliers(SupplierDto[] suppliers) {
        Clearutil.clearConsole();

        System.out.println("+----------------------------------------------------------------+");
        System.out.println("|                      SEARCH SUPPLIER                           |");
        System.out.println("+----------------------------------------------------------------+");

        System.out.print("Supplier ID: ");
        String id = input.nextLine();


        for (int i = 0; i < suppliers.length; i++) {

            if (suppliers[i].getSupId().equals(id)) {


                System.out.println("\nSupplier Details");
                System.out.println("----------------------------");
                System.out.println("Supplier ID   : " + suppliers[i].getSupId());
                System.out.println("Supplier Name : " + suppliers[i].getSupName());


                System.out.print("\nDo you want to search another supplier? (Y/N): ");
                char ch = input.next().charAt(0);
                input.nextLine();


                if (ch == 'Y' || ch == 'y') {
                    searchSuppliers(suppliers);
                } else {
                    Clearutil.clearConsole();
                    supplierManage(suppliers);
                }

                return;
            }
        }


        System.out.println("Supplier ID Not Found!");


        System.out.print("Do you want to try again? (Y/N): ");
        char ch = input.next().charAt(0);
        input.nextLine();


        if (ch == 'Y' || ch == 'y') {

            searchSuppliers(suppliers);

        } else {

            Clearutil.clearConsole();
            supplierManage(suppliers);
        }
    }
}
