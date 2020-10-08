package page;

import help.NewHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    private WebDriver driver;


    public MyAccountPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "(//a[@rel='nofollow']/span[1])[1]")
    private WebElement newAccount;

    public String getNewAccount(){
        NewHelper.waitUnEl();
        return newAccount.getText();
    }

}
