import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DodajProjektPage {

    private WebDriver driver;

    @FindBy(id = "name")
    private WebElement name;
    @FindBy(id = "prefix")
    private WebElement prefix;
    @FindBy(id = "save")
    private WebElement saveBtn;
    @FindBy(css = "a[href='http://demo.testarena.pl/administration/projects']")
    private WebElement menuProjektyBtn;


    public DodajProjektPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForFormElements() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("name")));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("prefix")));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("save")));
    }

    public String addNewRndProject() {
        String rndNameGenerate = "Karol_" + RandomStringUtils.randomAlphabetic(5);
        name.sendKeys(rndNameGenerate);
        prefix.sendKeys("KGS" + RandomStringUtils.randomAlphabetic(3));
        saveBtn.click();
        return rndNameGenerate;
    }

    public void activeMenuProjektyClick() {
        menuProjektyBtn.click();
    }
}
