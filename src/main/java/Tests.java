import org.junit.Test;

public class Tests extends BeforeAfter {

    // из-за того, что тест бежит слишком быстро, пришлось расставить задержки между шагами

    @Test
    public void test() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        PaymentsPage paymentsPage = new PaymentsPage(driver);
        JKH jkh = new JKH(driver);
        ZhkuMoskva zhkuMoskva = new ZhkuMoskva(driver);

        mainPage.openTinkoffRu();                // 1
        mainPage.openPayments();                 // 2
        paymentsPage.openJKH();                  // 3
        jkh.necessaryCity("Москве");             // 4
        jkh.clickFirstCategory();                // 5
        zhkuMoskva.clickPayZhkuInMoscow();       // 6
        zhkuMoskva.assertErrorFields();          // 7
        mainPage.openPayments();                 // 8
        paymentsPage.searchNamePayment(jkh.fisrtCategoryName);           // 9
        paymentsPage.elementFirstInSuggest(jkh.fisrtCategoryName);       // 10
        paymentsPage.clickFirstElementInSuggest();                       // 11
        mainPage.openPayments();                 // 12
        timeWait(1);
        paymentsPage.openJKH();                  // 12
        jkh.necessaryCity("г. Санкт-Петербург"); // 13
        timeWait(1);
        jkh.assertSearchElementInAllCategories(jkh.fisrtCategoryName);  // 14
    }

}
