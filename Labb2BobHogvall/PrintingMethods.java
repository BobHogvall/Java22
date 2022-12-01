package se.iths.twentytwo.Labb2BobHogvall;



public class PrintingMethods {
    public static void printWelcome(){
        System.out.println("""
                
                Välkommen till ditt produktsorteringsprogram.
                Vill du:""");
    }
    public static void printIntroMenu(){
        System.out.println("""
                    1. Skapa eller ändra en produkt. 
                    2. Se Befintligt.
                    3. Plocka ut.
                    4. Spara.
                    e. Spara och avsluta programmet.
                    """);
    }
    public static void printChangeProductMenu(){
        System.out.println("""
                    Vad vill du göra?
                    1. Lägg till
                    2. Radera
                    3. Redigera
                    e. Återgå till föregående.
                    """);
    }
    public static void printToExistingMenu(){
        System.out.println("""
                    Vad vill du se?
                    1. Lista på varor.
                    2. Lista på Kategorier.
                    3. Lista på varumärken.
                    4. Lagersaldo.
                    5. Sök inom programmet.
                    e. Återgå till huvudmeny.
                    """);
    }
    public static void printSearchInInventoryMenu(){
        System.out.println("""
                    Vad vill du söka efter?
                    1. Varor inom ett visst prisintervall.
                    2. Varor inom en viss kategori.
                    3. Varor inom ett visst varumärke.
                    e. Återgå till delmenyn.
                    """);
    }
    public static void printToShopFromProductsMenu(){
        System.out.println("""
                    Vilka varor vill du plocka ut?
                    1. Välj varor
                    2. se vilka varor som valts, ta bort varor?
                    3. se pris och slutsumma
                    4. rabatter
                    5. kvitto som sparas
                    e. Återgå till huvudmenyn.
                    """);
    }

    public static void printWantToChangeMenu(){
        System.out.println("""
                
                Vill du ändra något i Lista?
                1. Ja
                2. Nej
                """);
    }

    public static void printChooseItemToChangeMenu(){
        System.out.println("""
                Vill du ändra 
                1. Produktnamnet
                2. Kategorinamnet
                3. Priset
                4. Varumärket
                5. EAN-koden
                e. avbryt""");
    }
    public static void printTryAgain(){
        System.out.println("""
               Var vänlig välj ett av alternativen.""");
    }

    public static void printWriteAgain(){
        System.out.println("""
                Var vänlig se över stavningen och prova igen""");
    }

    public static void printChangeToQuestion(){
        System.out.println("""
                Vänligen skriv in det nya: """);
    }

    public static void printNotCurrentlyWorking() {
        System.out.println("""
                Beklagar, denna funktion funkar tyvärr inte ännu.""");
    }
}

