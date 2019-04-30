package environment;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BeforeAfter {
    protected ChromeDriver driver;


    @Before
    public void setUp() {
        // ToDo сделать фабрику драйверов
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void close() {
        driver.quit();
    }

    public static void timeWait(double sec) throws InterruptedException {
        int secWait = (int) (sec * 1000);
        TimeUnit.MILLISECONDS.sleep(secWait);
        System.out.printf("ВЫполнено ожидание %s секунд \n", sec);
    }

}
