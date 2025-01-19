package misc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;


public class BrokenLinksChecker {

    @Test
    public static void checkBrokenLinks() {
        WebDriver driver = new ChromeDriver();

        try {
            // Open the given URL
            driver.get("https://www.frontdoor.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            // Find all <a> tags on the page
            List<WebElement> links = driver.findElements(By.tagName("a"));

            for (WebElement link : links) {
                String url = link.getAttribute("href");

                if (url != null && !url.isEmpty()) {
                    try {
                        // Check the HTTP response code of the link
                        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
                        connection.setRequestMethod("HEAD");
                        connection.connect();

                        int responseCode = connection.getResponseCode();
                        if (responseCode >= 400) {
                            System.out.println("Broken link: " + url + " - Response code: " + responseCode);
                        } else {
                            System.out.println("Valid link: " + url + " - Response code: " + responseCode);
                        }
                    } catch (Exception e) {
                        System.out.println("Error checking link: " + url);
                    }
                } else {
                    System.out.println("Invalid link: " + link.getText());
                }
            }

        } finally {
            driver.quit();
        }
    }
}
