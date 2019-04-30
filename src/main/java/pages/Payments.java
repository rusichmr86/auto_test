package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Payments extends Abstract {
    public Payments(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@href=\"/payments/categories/kommunalnie-platezhi/\"]/..")
    private WebElement jkh;

    @FindBy(xpath = "//input[@data-qa-file=\"SearchInput\"]")
    private WebElement searchTitleOrINN;

    @FindBy(xpath = "//div[@data-qa-file=\"SearchSuggest\"]/div[1]/div/div/div[1]")
    private WebElement suggestSearchFirstElement;

    public void openJKH() {
        jkh.click();
        System.out.println("выполнено нажатие на ЖКХ");
    }

    public void searchNamePayment(String fisrtCategoryName) {
        searchTitleOrINN.sendKeys(fisrtCategoryName);
        System.out.println("Заполнил поиск значением " + fisrtCategoryName);
    }

    public void elementFirstInSuggest(String element) {
        Assert.assertTrue(suggestSearchFirstElement.getText().contains(element));
        System.out.println(element + " в списке первый");
    }

    public void clickFirstElementInSuggest() {
        suggestSearchFirstElement.click();
        System.out.println("нажал на первый элемент в саджесте");
    }

}
