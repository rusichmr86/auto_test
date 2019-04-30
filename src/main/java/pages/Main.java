package pages;

import lombok.extern.java.Log;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Log
public class Main extends Abstract {
    public Main(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href=\"/paymentsa/\"]")
    private WebElement payments;

    public void openTinkoffRu() {
        driver.get("https://www.tinkoff.ru/");
        log.info("открыта страница тинькофф");
    }

    public void openPayments() {
        try {
            payments.click();
            log.info("Выполнено нажатие на платежи");
        } catch (NoSuchElementException e) {
            log.info("Не удалось выполнить нажатие на платежи");

        }
    }
}

