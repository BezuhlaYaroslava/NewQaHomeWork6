package page;

import help.NewHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SearchPage {
    private WebDriver driver;

    public SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    @FindBy(xpath = "//i[@class='icon-th-list']")
    private WebElement list;

    public SearchPage clickList() {
        NewHelper.waitUnEl();
        list.click();
        return this;
    }



    @FindBy(xpath = "//a[@title='Add to cart']")
    private WebElement addCard;

    public void clickAddCard() {
        addCard.click();}

    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    private WebElement ProceedCheckout;

    public void clickProceedCheckout() {
        NewHelper.waitUnEl();
        ProceedCheckout.click();}

    @FindBy(xpath = "//i[@class='icon-plus']")
    private WebElement addProduct;

    public void clickAddProduct() {
        addProduct.click();
        NewHelper.waitUnEl();
    }

    @FindBy(xpath = "//span[@id='total_price']")
    private WebElement totalPrice;

    public String getTotalPrice(){
        return totalPrice.getText();

    }

    @FindBy(xpath = "//a[@title='Delete']")
    private WebElement basket;

    public void clickBasket() {
        basket.click();
    }

    @FindBy(xpath = "//p[@class='alert alert-warning']")
    private WebElement deleteBasket;

    public String getDeleteBasket(){
        NewHelper.waitUnEl();
        return deleteBasket.getText();
    }

    public void canClicks() {
        clickList();
        clickAddCard();
        clickProceedCheckout();
        clickAddProduct();
        }

}


