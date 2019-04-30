package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class JKH extends Abstract {
    public JKH(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@data-qa-file=\"PaymentsCatalogHeader\"]//span[@role=\"button\"]")
    private WebElement JKHin;

    @FindBy(xpath = "//div[@data-qa-file=\"UIRegions\"]//input")
    private WebElement regionInput;

    @FindBy(xpath = "//ul[@data-qa-file=\"UIScrollList\"]/li[1]")  // todo седлать через коллекцию
    private WebElement firstCategory;

    @FindBy(xpath = "//ul[@data-qa-file=\"UIScrollList\"]")
    private WebElement allCategories;

    @FindBy(xpath = "//div[@data-qa-file=\"UIRegions\"]//div[@data-qa-file=\"Text\"]/span")
    private WebElement firstCityRegion;

    private String fisrtCategoryName;

    public String getFisrtCategoryName(){
        return fisrtCategoryName;
    }


    public void necessaryCity(String city) {  // если город по умолчанию отличается от нужного, то вводим нужный
        if (!isJKHin(city)) {
            JKHin.click();
            regionInput.sendKeys(city);
            String selectCity = firstCityRegion.getText();
            firstCityRegion.click();
            System.out.println("Выбран город " + selectCity);
        }
    }


    public void clickFirstCategory() {
        saveNameFirstCategoryName();
        firstCategory.click();
    }

    private boolean isJKHin(String city) {
        return JKHin.getText().equals(city);
    }

    private void saveNameFirstCategoryName() {
        fisrtCategoryName = firstCategory.getText();
    }

    public void assertSearchElementInAllCategories(String element) {
        Assert.assertFalse(allCategories.getText().contains(element));
    }
}
