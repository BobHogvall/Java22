package se.iths.twentytwo.Labb2BobHogvall;

import java.io.Serializable;
import java.util.*;
import static se.iths.twentytwo.Labb2BobHogvall.PrintingMethods.*;
import static se.iths.twentytwo.Labb2BobHogvall.ActionMethods.*;
import static se.iths.twentytwo.Labb2BobHogvall.ReadAndSaveMethods.readFromFile;
import static se.iths.twentytwo.Labb2BobHogvall.ReadAndSaveMethods.saveToFile;


public class MainProgram {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        mainMenu(scan, readFromFile());
    }

    private static void mainMenu(Scanner scan, List<Product> product){
        printWelcome();

        while (true) {
            printIntroMenu();

            String choice = scan.next();
            switch (choice){
                case "1" -> toAddOrChangeProduct(scan, product);
                case "2" -> toExisting(scan, product);
                case "3" -> toShopFromProducts(scan, product);
                case "4" -> saveCurrentData(product);
                case "e" -> saveCurrentDataAndExit(product);
                default -> printTryAgain();
            }
        }
    }



    static void toAddOrChangeProduct(Scanner scan, List<Product> product) {
        while (true) {
            printChangeProductMenu();

            String choice = scan.next();
            switch (choice) {
                case "1" -> addNewProduct(scan, product);
                case "2" -> removeProduct(scan, product);
                case "3" -> editProduct(scan, product);
                case "e" -> {return;}
                default -> printTryAgain();
            }
        }
    }

    private static void addNewProduct(Scanner scan, List<Product> product) {
        System.out.println("Namn: \nKategori: \nFullpris: \nVarumärke: \nEAN-kod:");
        product.add(new Product(scan.next().toLowerCase(), scan.next().toLowerCase(), scan.nextBigDecimal(),
                scan.next().toLowerCase(), scan.nextInt()));
    }
    private static void removeProduct(Scanner scan, List<Product> product) { //just nu sorteras produkterna efter namn
        System.out.println("Vilken vara vill du ta bort?");
        removingMethod(scan, product);
    }
    private static void editProduct(Scanner scan, List<Product> product) {
        editingMethod(scan, product);
    }




    private static void toExisting(Scanner scan, List<Product> product) {
        while(true){
            printToExistingMenu();

            String choice = scan.next();
            switch (choice) {
                case "1" -> showProducts(scan, product);
                case "2" -> showCategories(scan, product);
                case "3" -> showBrands(scan, product);
                case "4" -> showInventoryBalance(scan, product);
                case "5" -> searchInInventory(scan, product);
                case "e" -> {return;}
                default -> printTryAgain();
            }
        }
    }
    private static void showProducts(Scanner scan, List<Product> product) {
        sortAndPrintProductList(product);
        choiceToChange(scan, product);
    }

    private static void showCategories(Scanner scan, List<Product> product) {
        sortAndPrintCategoryList(product);
        choiceToChange(scan, product);
    }

    private static void showBrands(Scanner scan, List<Product> product) {
        sortAndPrintBrandList(product);
        choiceToChange(scan, product);
    }


    private static void showInventoryBalance(Scanner scan, List<Product> product) {
        sortAndPrintPriceList(product);
        monetarySumOfAllProducts(product);
    }




    private static void searchInInventory(Scanner scan, List<Product> product) {
        while(true) {
            printSearchInInventoryMenu();

            String choiceSearch = scan.next();
            switch (choiceSearch) {
                case "1" -> searchPriceInterval(scan, product);
                case "2" -> searchInCategories(scan, product);
                case "3" -> searchInBrands(scan, product);
                default -> printTryAgain();
            } if (Objects.equals(choiceSearch, "e")){
                break;
            }
        }
    }

    private static void searchPriceInterval(Scanner scan, List<Product> product) {
        searchAndPrintInterval(scan, product);

    }

    private static void searchInCategories(Scanner scan, List<Product> product) { // vill jag printa listan?
        sortAndPrintCategoryList(product);
        searchAndPrintCategory(scan, product);

    }

    private static void searchInBrands(Scanner scan, List<Product> product) {
        sortAndPrintBrandList(product);
        searchAndPrintBrands(scan, product);

    }


    private static void toShopFromProducts(Scanner scan, List<Product> product) {
        while(true) {
            printToShopFromProductsMenu();
            String choiceShop = scan.next();
            switch (choiceShop) {
                case "1", "2", "3", "4", "5" -> printNotCurrentlyWorking();
                default -> printTryAgain();
            } if (Objects.equals(choiceShop, "e")){
                break;
            }
        }
    }







    private static void saveCurrentData(List<Product> product) {
        saveToFile(product);
    }
    private static void saveCurrentDataAndExit(List<Product> product) {
        saveToFile(product);
        System.out.println("Tack för idag!");
        System.exit(0);
    }
}