import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentsPage extends AbstractPage {
    PaymentsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@href=\"/payments/categories/kommunalnie-platezhi/\"]/..")
    private WebElement jkh;

    void openJKH() {
        jkh.click();
        System.out.println("выполнено нажатие на ЖКХ");
    }

}
