package se.iths.twentytwo.Labb2;

import java.math.BigDecimal;
import java.util.*;

import static se.iths.twentytwo.Labb2.MainProgram.toAddOrChangeProduct;
import static se.iths.twentytwo.Labb2.PrintingMethods.*;

class ActionMethods {
    public static List<Product> sortAndPrintProductList(List<Product> product) {
        System.out.println("Din varulista: \n");
        printProductList(product.stream()
                .sorted(Comparator.comparing(Product::getProductName))
                .toList());
        return product;

    }

    public static void sortAndPrintCategoryList(List<Product> product) { //syfte om jag inte kan lägga in individuella klategorier eller brands?
        System.out.println("Kategorier: \n");
        product.stream()
                .sorted(Comparator.comparing(Product::getCategory))
                .map(Product::getCategory)
                .distinct()
                .forEach(System.out::println);
    }

    public static void sortAndPrintPriceList(List<Product> product) {
        System.out.println("Varulista sorterad efter lägsta till högsta pris: \n");
        printProductList(product.stream()
                .sorted(Comparator.comparing(Product::getFullPrice))
                .toList());
    }

    public static void sortAndPrintBrandList(List<Product> product) {
        System.out.println("Varumärken: \n");
        product.stream()
                .sorted(Comparator.comparing(Product::getBrand))
                .map(Product::getBrand)
                .distinct()
                .forEach(System.out::println);


    }

    public static void removingMethod(Scanner scan, List<Product> product){
        sortAndPrintProductList(product);
        int choice = scan.nextInt();
        try {
            if (choice >= 0){
                product.remove(choice);
                System.out.println("Ditt val har raderats.");
            }  else {
                printTryAgain();
            }
        } catch (InputMismatchException e){
            printTryAgain();
        }
    }

    public static void editingMethod(Scanner scan, List<Product> product){
        System.out.println("\nVilken vara vill du redigera?");
        sortAndPrintProductList(product);
        int choice = chooseAndPrintChoice(scan, product);
        chooseAndPrintNewInfo(scan, product, choice);
    }
    private static int chooseAndPrintChoice(Scanner scan, List<Product> product) {
        var choice = scan.nextInt()-1;
        if (choice >= 0){
            printChosenProduct(product, choice);
        } else {
            printTryAgain();
        }
        return choice;
    }

    private static void printChosenProduct(List<Product> product, int choice) {
        System.out.println((choice+1) + ". " + product.get(choice).getProductName()+", "+ product.get(choice).getCategory()+
                ", "+ product.get(choice).getFullPrice()+", "+ product.get(choice).getBrand()+", "+ product.get(choice).getEanId()+".");
    }

    private static void chooseAndPrintNewInfo(Scanner scan, List<Product> product, int choice) {
        while(true) {
            printChooseItemToChangeMenu();
            var newChoice = scan.next();
            switch (newChoice){
                case "1" -> {printChangeToQuestion(); product.get(choice).setProductName(scan.next().toLowerCase());}
                case "2" -> {printChangeToQuestion(); product.get(choice).setCategory(scan.next().toLowerCase());}
                case "3" -> {printChangeToQuestion(); product.get(choice).setFullPrice(scan.nextBigDecimal());}
                case "4" -> {printChangeToQuestion(); product.get(choice).setBrand(scan.next().toLowerCase());}
                case "5" -> {printChangeToQuestion(); product.get(choice).setEanId(scan.nextInt());}
                default -> printTryAgain();
            } if (newChoice.equals("e")){
                break;
            }
            printChosenProduct(product, choice);
        }
    }

    public static void monetarySumOfAllProducts(List<Product> product) {
        var sum = product.stream()
                .sorted(Comparator.comparing(Product::getFullPrice))
                .map(Product::getFullPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println("\nDitt lagersaldo är: " + sum + "kr.\n");

    }

    public static void searchAndPrintInterval (Scanner scan, List<Product> product){
        System.out.println("Vilket intervall vill du söka inom?");
        System.out.println("Lägsta värde: ");
        var low = scan.nextInt();
        System.out.println("Högsta Värde: ");
        var high = scan.nextInt();

        for (int i = 0; i < product.size(); i++) {
            var value = product.get(i).getFullPrice().intValue();
            if (value >= low && value <= high)
                System.out.println((i+1) + ". " + product.get(i).getProductName()+", "+ product.get(i).getCategory()+
                        ", "+product.get(i).getFullPrice()+", "+product.get(i).getBrand()+", "+product.get(i).getEanId()+".");
        }
    }
    public static void searchAndPrintCategory(Scanner scan, List<Product> product) {
        System.out.println("Vilken kategori söker du?");
        var searchFor = scan.next().toLowerCase();
        var searchedCategory = product.stream()
                .filter(category -> Objects.equals(category.getCategory(), searchFor))
                .toList();
        printProductList(searchedCategory);

    }

    public static void searchAndPrintBrands(Scanner scan, List<Product> product) {
        System.out.println("Vilket varumärke söker du?");
        var searchFor = scan.next().toLowerCase();
        var searchedBrand = product.stream()
                .filter(brand -> Objects.equals(brand.getBrand(), searchFor))
                .toList();
        printProductList(searchedBrand);
    }

    public static void choiceToChange(Scanner scan, List<Product> product) {
        while(true){
            printWantToChangeMenu();

            String choice = scan.next();
            switch (choice) {
                case "1" -> toAddOrChangeProduct(scan, product);
                default -> printTryAgain();
            } if (Objects.equals(choice, "2")){
                break;
            }
        }
    }


    public static List<Product> printProductList(List<Product> product) {
        for (int i = 0; i < product.size(); i++) {
            System.out.println((i+1) + ". " + product.get(i).getProductName()+", "+ product.get(i).getCategory()+
                    ", "+product.get(i).getFullPrice()+", "+product.get(i).getBrand()+", "+product.get(i).getEanId()+".");
        }
        System.out.println();
        return product;
    }
}