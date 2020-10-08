package Task6Test;

import fields.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.*;

public class Task6Test {

    private SignUpPage signUpPage;
    private Registration registration;
    private RegistrationPage registrationPage;
    private WebDriver driver;
    private HomePage homePage;
    private MyAccountPage myAccountPage;
    String actualResult;
    String expectedResult;
    private SearchPage searchPage;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://automationpractice.com/");
    }

    @Before
    public void date(){
        registration = new RegistrationBuild()
                .withTitle("Mrs.")
                .withEmail("byaw@urrkr.net")
                .withOneFirstName("Юзер")
                .withOneLastName("User")
                .withPassword("password")
                .withBirthdayDay("27")
                .withBirthdayMonth("9")
                .withBirthdayYear("1998")
                .withFirstName("Юзер")
                .withLastName("User")
                .withCompany("Company")
                .withOneAddress("oneAddress")
                .withTwoAddress("twoAddress2")
                .withCity("City")
                .withState("Alaska")
                .withZipCode("04001")
                .withPhoneMobile("099000000")
                .withPhoneHome("088000000")
                .withAliasAddress("alias")
                .build();
        homePage = new HomePage(driver);
    }

    @Test
    public void canOpenPage() {
        signUpPage = homePage.openSignInPage();
        registrationPage = signUpPage.writeEmailAndClick(registration);
        myAccountPage = registrationPage.writeRegistrationAndClick(registration);

        actualResult = myAccountPage.getNewAccount();
        expectedResult = "Юзер User";

        Assert.assertEquals("Юзер User", expectedResult, actualResult);
    }

    @Test
    public void canSearch() {
        searchPage = homePage.openSearch();
        homePage.buttonClick();
        searchPage.canClicks();

        actualResult = searchPage.getTotalPrice();
        expectedResult = "$56.00";

        Assert.assertEquals("Total Price", expectedResult, actualResult);
    }

    @Test
    public void basket() {
        searchPage = homePage.openSearch();
        homePage.buttonClick();
        searchPage.canClicks();
        searchPage.clickBasket();

        actualResult = searchPage.getDeleteBasket();
        expectedResult = "Your shopping cart is empty.";

        Assert.assertEquals("Total Price", expectedResult, actualResult);

    }

//    @After
//    public void clean(){ this.driver.quit(); }



}
