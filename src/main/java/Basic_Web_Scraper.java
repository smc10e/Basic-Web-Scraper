import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.*;

/**
 * Created by smcampbell on 11/3/2015.
 */
public class Basic_Web_Scraper {

    public static void main(String[] args) throws IOException {

        FileWriter outputStream = new FileWriter("output.html");

        WebDriver webDriver = new ChromeDriver();

        webDriver.get("http://teamsideline.com/fsu");

        WebElement element = webDriver.findElement(By.xpath("//div[contains(@class, 'bannerSection')]"));

        String text = element.getAttribute("outerHTML");
        System.out.println(text);
        outputStream.write("<!DOCTYPE html><html><body>");
        outputStream.write(text);
        element = webDriver.findElement(By.xpath("//*[@id=\"contentDiv\"]"));
        outputStream.write("<div style=\"margin-left: auto; margin-right: auto; width: 800px\">");
        text = element.getAttribute("outerHTML");
        outputStream.write(text);
        outputStream.write("</div>");
        outputStream.write("</body></html>");
        outputStream.close();
    }

}
