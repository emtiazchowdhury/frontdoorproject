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

public class BrokenImagesChecker {
    @Test
    public static void checkBrokenImages() {
        WebDriver driver = new ChromeDriver();

        try {
            // Open the webpage
            driver.get("https://www.frontdoor.com/");
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            // Find all <img> tags on the page
            List<WebElement> images = driver.findElements(By.tagName("img"));

            for (WebElement img : images) {
                String imageUrl = img.getAttribute("src");

                if (imageUrl != null && !imageUrl.isEmpty()) {
                    try {
                        // Check the HTTP response code of the image URL
                        HttpURLConnection connection = (HttpURLConnection) new URL(imageUrl).openConnection();
                        connection.setRequestMethod("HEAD");
                        connection.connect();

                        int responseCode = connection.getResponseCode();
                        if (responseCode != 200) {
                            System.out.println("Broken image: " + imageUrl + " - Response code: " + responseCode);
                        } else {
                            System.out.println("Valid image: " + imageUrl + " - Response code: " + responseCode);
                        }
                    } catch (Exception e) {
                        System.out.println("Error checking image: " + imageUrl);
                    }
                } else {
                    System.out.println("Invalid image source: " + img.getAttribute("outerHTML"));
                }
            }

        } finally {
            driver.quit();
        }
    }
}
