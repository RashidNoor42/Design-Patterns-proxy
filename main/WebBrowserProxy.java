package main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;


public class WebBrowserProxy implements WebBrowser {
    private String[] bannedDomains = {"instagram", "facebook", "linkedin"};
    private WebBrowser browser;


    WebBrowserProxy() {
        browser = new WebBrowserService();
    }

    @Override
    public void goToWebsite(String url) throws Exception {
        if (url.equals("exit")) {
            System.out.println("Bye");
        } else if (!isValid(url)) {
            throw new Exception("");
        } else if (urlContainsBannedDomain(url, bannedDomains)) {
            throw new Exception(url + " Access denied");
        } else {
            browser.goToWebsite(url);
        }
    }


    // Valid url format
    private static boolean isValid(String url) {
        try {
            new URL(url).openStream().close();
        } catch (MalformedURLException e) {
            System.out.println("You must add protocol http: // or https: //");
            return false;
        } catch (IOException e) {
            System.out.println(e + " Try again.");
            return false;
        }

        return true;
    }

    // Check for banned domain
    private static boolean urlContainsBannedDomain(String url, String[] bannedDomains) {
        return Arrays.stream(bannedDomains).parallel().anyMatch(url::contains);
    }
}
