package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Main extends Abstract {
    public Main(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href=\"/payments/\"]")
    private WebElement payments;

    public void openTinkoffRu(){
        driver.get("https://www.tinkoff.ru/");
        System.out.println("открыта страница тинькофф");
    }

    public void openPayments(){
        payments.click();
        System.out.println("выполнено нажатие на платежи");
    }

}

