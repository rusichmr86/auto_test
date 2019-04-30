import environment.BeforeAfter;
import org.junit.Test;
import pages.*;

public class Tests extends BeforeAfter {

    // из-за того, что тест бежит слишком быстро, пришлось расставить задержки между шагами

    @Test
    public void test() throws InterruptedException {
        Main main = new Main(driver);
        Payments payments = new Payments(driver);
        JKH jkh = new JKH(driver);
        ZhkuMoskva zhkuMoskva = new ZhkuMoskva(driver);

        main.openTinkoffRu();                            // 1
        main.openPayments();                             // 2
        payments.openJKH();                              // 3
        jkh.necessaryCity("Москве");                     // 4
        jkh.clickFirstCategory();                        // 5
        zhkuMoskva.clickPayZhkuInMoscow();               // 6
        zhkuMoskva.assertErrorFields();                  // 7
        main.openPayments();                             // 8
        payments.searchNamePayment(jkh.getFisrtCategoryName());                 // 9
        payments.elementFirstInSuggest(jkh.getFisrtCategoryName());             // 10
        payments.clickFirstElementInSuggest();                                  // 11
        main.openPayments();                                                    // 12
        timeWait(1);
        payments.openJKH();                                                     // 12
        jkh.necessaryCity("г. Санкт-Петербург");                                // 13
        timeWait(1);
        jkh.assertSearchElementInAllCategories(jkh.getFisrtCategoryName());     // 14
    }

}
