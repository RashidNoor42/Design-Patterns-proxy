package main;

import java.util.Scanner;

public class ProxyExampleLauncher {

    public static void main(String[] args) {
        WebBrowserProxy webProxy = new WebBrowserProxy();
        Scanner userInput = new Scanner(System.in);
        String url;
        do {
            System.out.println("Which website url do you want to visit? Type 'exit' to quit");
            url = userInput.next();
            try {
                webProxy.goToWebsite(url);
            } catch (Exception exception) {
                System.out.println(exception.getMessage());
            }
        } while (!url.equals("exit"));
    }
}
