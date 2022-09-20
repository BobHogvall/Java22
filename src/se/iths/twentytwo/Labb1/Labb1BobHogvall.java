package se.iths.twentytwo.Labb1;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Labb1BobHogvall {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] timeAndPriceInput = new int[24];


        while (true) {
            System.out.println("Elpriser");
            System.out.println("=======");
            System.out.println("1. Inmatning");
            System.out.println("2. Min, Max och Medel");
            System.out.println("3. Sortera");
            System.out.println("4. Bästa laddningstiden (4h)");
            System.out.println("e. Avsluta");

            String choice = scan.next();
            if (Objects.equals(choice, "1")) {
                getTimeAndPriceInput(timeAndPriceInput, scan);
                System.out.println("Inmatning klar. Välj ett nytt alternativ från menyn: \n");
            } else if (Objects.equals(choice, "2")) {
                calculateAndPrintMinMaxPrice(timeAndPriceInput);  // gör om till två metoder?
                calculateAndPrintAveragePrice(timeAndPriceInput);
                System.out.println("\nInmatning klar. Välj ett nytt alternativ från menyn: \n");
            } else if (Objects.equals(choice, "3")) {
                sortAndPrintHourAndPriceCheapToExpensive(timeAndPriceInput);
                System.out.println("Inmatning klar. Välj ett nytt alternativ från menyn: \n");
            } else if (Objects.equals(choice, "4")) {
                fourHours(timeAndPriceInput);
                System.out.println("Inmatning klar. Välj ett nytt alternativ från menyn: \n");
            } else if (Objects.equals(choice, "E") || Objects.equals(choice, "e")) {
                System.out.println("Programmet har avslutats.");
                break;
            } else {
                System.out.println("Vänlig välj någon av alternativen från menyn:");
            }
        }
    }

    public static void getTimeAndPriceInput(int[] timeAndPriceInput, Scanner scan) {
        System.out.println("\nVänligen mata in örespriset för vardera timme, programmet startar med timmen mellan 00-01");

        for (int i = 0; i < 24; i++) {
            System.out.println("Timme " + i);
            timeAndPriceInput[i] = scan.nextInt();
        }
    }
    
    public static void calculateAndPrintMinMaxPrice(int[] timeAndPriceInput) {

        int min, max;
        min = max = timeAndPriceInput[0];
        int minTime = 0;
        int maxTime = 0;
        for (int i = 0; i < 24; i++) {
            if (timeAndPriceInput[i] < min) {
                min = timeAndPriceInput[i];
                minTime = i;
            }
            if (timeAndPriceInput[i] > max) {
                max = timeAndPriceInput[i];
                maxTime = i;
            }
        }
        System.out.println("\nLägsta kostnaden är klockan " + minTime + ": " + min + " öre/kWh" + "\nHögsta kostnaden är klockan " + maxTime + ": " + max + " öre/kWh");            //vilken timme är de?
    }

    public static void calculateAndPrintAveragePrice ( int[] timeAndPriceInput){
            int length = timeAndPriceInput.length;
            int sum = 0;
            for (int j = 0; j < timeAndPriceInput.length; j++) {
                sum += timeAndPriceInput[j];
            }
            double averageValue = (double) sum / length;
            System.out.format("Medelpriset under dygnet är: %.2f öre/kWh", averageValue);  //%.f gör att averageValue blir med 2 decimaler

    }

    public static void sortAndPrintHourAndPriceCheapToExpensive(int[] timeAndPriceInput){
        int[] copyTimeAndPriceInput = Arrays.copyOf(timeAndPriceInput, timeAndPriceInput.length);
        int[] timeArray = new int[timeAndPriceInput.length];
        for (int i = 0; i < timeArray.length; i++) {
            timeArray[i] = i;
        }

        int a, b, tempPrice, tempTime;
        for (a = 0; a < copyTimeAndPriceInput.length; a++)
            for (b = 0; b < copyTimeAndPriceInput.length - 1; b++) {
                if (copyTimeAndPriceInput[b] > copyTimeAndPriceInput[b+1]) {
                    tempPrice = copyTimeAndPriceInput[b+1];
                    copyTimeAndPriceInput[b+1] = copyTimeAndPriceInput[b];
                    copyTimeAndPriceInput[b] = tempPrice;

                    tempTime = timeArray[b+1];
                    timeArray[b+1] = timeArray[b];
                    timeArray[b] = tempTime;
                }
            }

        System.out.print("\nKostnaderna sorterade från billigaste timmen till dyraste:\n");
        for (int i = 0; i < copyTimeAndPriceInput.length; i++) {
            System.out.println(copyTimeAndPriceInput[i] + " öre/kWh, klockan " + timeArray[i]);
        }
    }

    public static void fourHours(int[] timeAndPriceInput) {

        int sumOfFourPrices, averageOfFour = 0, lowestSumOfFourPrices = Integer.MAX_VALUE, bestTime = 0;
        for (int i = 0; i < timeAndPriceInput.length - 3; i++) {
            sumOfFourPrices = timeAndPriceInput[i] + timeAndPriceInput[i + 1] + timeAndPriceInput[i + 2] + timeAndPriceInput[i + 3];
            if (sumOfFourPrices < lowestSumOfFourPrices){
                lowestSumOfFourPrices = sumOfFourPrices;
            averageOfFour = lowestSumOfFourPrices / 4;
            bestTime = i;}
        }
        System.out.println("\nMedelpriset av de fyra billigaste sammanhängande timmarna är: " + averageOfFour + " öre/kWh klockan " + bestTime + "-"+ (bestTime+4));

    }
}


