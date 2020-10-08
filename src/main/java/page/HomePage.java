package page;

import help.NewHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {

    private WebDriver driver;
    public HomePage(WebDriver driver){ this.driver = driver; }

    public SignUpPage openSignInPage() {
        WebElement element = driver.findElement(By.xpath("//a[@class='login']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        return new SignUpPage(driver);

    }

    public SearchPage openSearch() {
        WebElement element = driver.findElement(By.xpath("//input[@id='search_query_top']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
        element.sendKeys("Blouse");
        return new SearchPage(driver);
    }


    public SearchPage buttonClick() {
        WebElement element = driver.findElement(By.xpath("//button[@name='submit_search']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        NewHelper.waitUnEl();
        js.executeScript("arguments[0].click()", element);
        return new SearchPage(driver);
    }

}
