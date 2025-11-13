package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestHooks {

    public static WebDriver driver;

    @Before
    public void SetUP()
    {
        driver = new ChromeDriver();

    }

    @After
    public void cleanUP()
    {
        if(driver!=null)
        {
            driver.quit();
        }
    }
}
