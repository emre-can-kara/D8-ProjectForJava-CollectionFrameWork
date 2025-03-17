package org.example.models;
import java.util.*;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }


    public static void addItems(String input) {
        String[] items = input.split(",\\s*"); // Virgül ve boşluk ile ayır
        groceryList.addAll(Arrays.asList(items));
        System.out.println("'" + input + "' listeye eklendi.");
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",\\s*"); // Virgül ve boşluk ile ayır
        for (String item : items) {
            if (checkItemIsInList(item.trim())) {
                groceryList.remove(item.trim());
                System.out.println("'" + item.trim() + "' listeden kaldırıldı.");
            } else {
                System.out.println("'" + item.trim() + "' listede bulunamadı.");
            }
        }
        Collections.sort(groceryList);
    }


    public static void printSorted() {
       Collections.sort(groceryList);
        System.out.println(groceryList);
    }

    public static void startGrocery() {
        Scanner console = new Scanner(System.in);
        int x;

        while (true) {
            System.out.println("\nBir işlem giriniz! 0: Konsolu Kapatır, 1: Eleman ekler, 2: Eleman çıkarır, 3: Listeyi görüntüle");
            x = console.nextInt();
            console.nextLine(); // NextInt sonrası satır sonunu temizle

            if (x == 0) {
                System.out.println("Program kapatılıyor...");
                break;
            } else if (x == 1) {
                System.out.println("Eklenmesini istediğiniz elemanı veya elemanları giriniz (örnek: apple veya apple, banana, cherry):");
                String items = console.nextLine();
                addItems(items);
            } else if (x == 2) {
                System.out.println("Çıkarılmasını istediğiniz elemanı veya elemanları giriniz (örnek: apple veya apple, banana, cherry):");
                String items = console.nextLine();
                removeItems(items);
            } else if (x == 3) {
                printSorted();
            } else {
                System.out.println("Geçersiz giriş! Lütfen 0, 1, 2 veya 3 giriniz.");
            }
        }

        console.close();
    }

}
