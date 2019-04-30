package environment;

import lombok.extern.java.Log;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

@Log
public class WebDriverLogger extends AbstractWebDriverEventListener {


    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        LOGGER.info("WebDriver navigated to '" + url + "'");
    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        LOGGER.info("WebDriver click on element - "
                + elementDescription(element));
    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File file = new File("target", "sccreen-" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, file);
        } catch (IOException e) {
            e.printStackTrace();
            log.error(file.getAbsolutePath());
        }
    }

    private String elementDescription(WebElement element) {
        String description = "tag:" + element.getTagName();
        if (element.getAttribute("id") != null) {
            description += " id: " + element.getAttribute("id");
        }
        else if (element.getAttribute("name") != null) {
            description += " name: " + element.getAttribute("name");
        }

        description += " ('" + element.getText() + "')";

        return description;
    }
}