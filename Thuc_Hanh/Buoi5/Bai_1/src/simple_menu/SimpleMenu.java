package simple_menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimpleMenu {
    private final List<MenuAction> actions = new ArrayList<>();
    public SimpleMenu addAction(MenuAction action){
        actions.add(action);
        return this;
    }
    public boolean render(){
        System.out.printf("Choose an action:%n");
        for (int i = 0; i < actions.size(); i++){
            System.out.printf("\t%d. %s\n", i, actions.get(i).name());
        }
        System.out.printf("\t%d. %s\n", actions.size(), "Exit");
        System.out.print("\nYour choice: ");
        Scanner scan = new Scanner(System.in);
        int choice = scan.nextInt();
        if (choice > actions.size() || choice < 0) return false;
        if (choice == actions.size()) return true;
        actions.get(choice).action().run();
        return false;
    }
}
