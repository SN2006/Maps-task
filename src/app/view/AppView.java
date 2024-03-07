package app.view;

import java.util.Scanner;

public class AppView {

    private final Scanner SCANNER = new Scanner(System.in);

    public String selectAction(){
        System.out.println("""
                ----------------------------------------------------
                Select an action:
                1 - Show all products
                2 - Show product by id
                ----------------------------------------------------
                """);
        return SCANNER.nextLine().trim();
    }

    public String getId(){
        System.out.println("""
                ----------------------------------------------------
                Enter product id:
                ----------------------------------------------------
                """);
        return SCANNER.nextLine().trim();
    }

    public void getOutput(String output){
        System.out.println("----------------------------------------------------");
        System.out.println(output);
        System.out.println("----------------------------------------------------");
    }

}
