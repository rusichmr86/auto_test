package pages;

import environment.BeforeAfter;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ZhkuMoskva extends Abstract {

    public ZhkuMoskva(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-qa-file=\"UIIsland\"]/strong[1]")
    private WebElement onlinePayJKU;

    @FindBy(xpath = "//ul[@data-qa-file=\"Tabs\"]/li[2]")
    private WebElement payZhkuInMoscow;

    @FindBy(xpath = "//input[@name=\"provider-payerCode\"]")
    private WebElement payerCode;

    @FindBy(xpath = "//input[@name=\"provider-payerCode\"]/ancestor::div[@data-qa-file=\"FormFieldWrapper\"]/div[@data-qa-file=\"UIFormRowError\"]")
    private WebElement payerCodeErorr;

    @FindBy(xpath = "//input[@name=\"provider-period\"]")
    private WebElement providerPeriod;

    @FindBy(xpath = "//input[@name=\"provider-period\"]/ancestor::div[@data-qa-file=\"FormFieldWrapper\"]/div[@data-qa-file=\"UIFormRowError\"]")
    private WebElement providerPeriodErorr;

    @FindBy(xpath = "//form[@class=\"ui-form\"]/div[3]//input")
    private WebElement sumInsurance;

    @FindBy(xpath = "//form[@class=\"ui-form\"]/div[3]//input/ancestor::div[@data-qa-file=\"FormFieldWrapper\"]/div[@data-qa-file=\"UIFormRowError\"]")
    private WebElement sumInsuranceErorr;

    @FindBy(xpath = "//form[@class=\"ui-form\"]/div[4]//input")
    private WebElement sumPay;

    @FindBy(xpath = "//form[@class=\"ui-form\"]/div[4]//input/ancestor::div[@data-qa-file=\"FormFieldWrapper\"]/div[@data-qa-file=\"UIFormRowError\"]")
    private WebElement sumPayErorr;


    private String textPayerCodeErorr = "Поле неправильно заполнено";
    private String textProviderPeriodErorr = "Поле заполнено некорректно";
    private String textSumInsurance = "Поле заполнено неверно";
    private String textSumPayErorr = "Поле заполнено неверно";

    public void clickPayZhkuInMoscow() {
        payZhkuInMoscow.click();
    }

    // через onlinePayJKU.click() увожу фокус из поля, чтобы ошибка появилась сразу
    public void assertErrorFields() throws  InterruptedException {

        BeforeAfter.timeWait(1);  // из-за того, что тест бежит слишком быстро, пришлось поставить ожидаение

        payerCode.sendKeys("1");
        onlinePayJKU.click();
        Assert.assertEquals(payerCodeErorr.getText(), textPayerCodeErorr);
        providerPeriod.sendKeys("1");
        onlinePayJKU.click();
        Assert.assertEquals(providerPeriodErorr.getText(), textProviderPeriodErorr);
        sumInsurance.sendKeys("+-");
        onlinePayJKU.click();
        Assert.assertEquals(sumInsuranceErorr.getText(), textSumInsurance);
        sumPay.sendKeys("()");
        onlinePayJKU.click();
        Assert.assertEquals(sumPayErorr.getText(), textSumPayErorr);
        System.out.println("Чекнул ошибки");
    }
}
