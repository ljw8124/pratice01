package org.pratice.store;

import org.pratice.ex3.service.StoreService;

import java.util.Scanner;

public class StoreUI {
    Scanner scanner = new Scanner(System.in);
    StoreService service = new StoreService();

    public StoreDTO fnMenu() {
        System.out.println("메뉴를 고르시오");
        String choice = this.scanner.nextLine();

        return service.findByMenu(choice);
    }

}
