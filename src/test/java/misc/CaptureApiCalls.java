package misc;

import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v129.network.Network;
import org.testng.annotations.Test;

import java.util.Optional;

public class CaptureApiCalls {

    @Test
    public static void apiCallTest() {
        WebDriver driver = new ChromeDriver();

        // Enable DevTools
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();

        // Enable network monitoring
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        // Listen for network requests
        devTools.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("API Call: " + request.getRequest().getUrl());
        });

        // Navigate to the page
        driver.get("https://www.frontdoor.com/");

        // Perform actions to trigger API calls

        // Wait for some time to capture traffic
        try {
            Thread.sleep(5000); // Adjust as necessary
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.quit();
    }
}