import org.junit.Test;

public class Tests extends BeforeAfter {

    // из-за того, что тест бежит слишком быстро, пришлось расставить задержки между шагами

    @Test
    public void test() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        PaymentsPage paymentsPage = new PaymentsPage(driver);
        JKH jkh = new JKH(driver);

        mainPage.openTinkoffRu();    // 1
        mainPage.openPayments();     // 2
        paymentsPage.openJKH();      // 3
        jkh.necessaryCity("Москве"); // 4

    }

}
