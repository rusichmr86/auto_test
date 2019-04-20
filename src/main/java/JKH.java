import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JKH extends AbstractPage {
    public JKH(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-qa-file=\"PaymentsCatalogHeader\"]//span[@role=\"button\"]")
    private WebElement JKHin;

    @FindBy(xpath = "//div[@data-qa-file=\"UIRegions\"]//input")
    private WebElement regionInput;


    void necessaryCity(String city){  // если город по умолчанию отличается от нужного, то вводим нужный
        if(!isJKHin(city)){
            JKHin.click();
            regionInput.sendKeys(city);
        }
    }

    boolean isJKHin(String city) {
        return JKHin.getText().equals(city);
    }

}
