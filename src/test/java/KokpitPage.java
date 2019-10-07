import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KokpitPage {

    private WebDriver driver;

    @FindBy(css = "a[href='http://demo.testarena.pl/administration']")
    private WebElement admBtn;

    public KokpitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForAdmBtn() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='http://demo.testarena.pl/administration']")));
    }

    public void admBtnClick() {
        admBtn.click();
    }
}
