package se.iths.twentytwo.Labb2;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static se.iths.twentytwo.Labb2.ActionMethods.sortAndPrintProductList;

public class ReadAndSaveMethods {

    public static List<Product> readFromFile() {
        List <Product> product = new ArrayList<>();
        Gson gson = new Gson();

        try (FileReader reader = new FileReader("ProductFiles.json")) {
            product = gson.fromJson(reader, new TypeToken<List<Product>>() {
            }.getType());
            return sortAndPrintProductList(product);
        } catch (IOException e) {
            System.out.println("Ett fel uppstod vid inläsning av fil. En ny fil skapas.");
        }
        return product;
    }

    public static void saveToFile(List<Product> product){
        Gson gson = new Gson();

        try(FileWriter writer = new FileWriter("ProductFiles.json") ){
            gson.toJson(product, writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Dina produkter har sparats.");
    }
}