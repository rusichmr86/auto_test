import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href=\"/payments/\"]")
    private WebElement payments;

    void openTinkoffRu(){
        driver.get("https://www.tinkoff.ru/");
        System.out.println("открыта страница тинькофф");
    }

    void openPayments(){
        payments.click();
        System.out.println("выполнено нажатие на платежи");
    }

}

