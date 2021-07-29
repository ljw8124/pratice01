package org.pratice.store;

import java.util.Scanner;

public class StoreUI {
    Scanner scanner = new Scanner(System.in);
    StoreService service = new StoreService();

    public StoreDTO fnMenu() {
        System.out.println("메뉴를 고르시오");
        String choice = scanner.nextLine();

        return service.findByMenu(choice);
    }

}
