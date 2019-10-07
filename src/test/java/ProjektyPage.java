import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjektyPage {

    private WebDriver driver;

    @FindBy(css = "a[href='http://demo.testarena.pl/administration/add_project']")
    private WebElement dodajProjBtn;
    @FindBy(id = "search")
    private WebElement searchInputText;
    @FindBy(id = "j_searchButton")
    private WebElement searchBtn;


    public ProjektyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForDodajProjBtn() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("a[href='http://demo.testarena.pl/administration/add_project']")));
    }

    public void waitForSearchSection() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("search")));
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("j_searchButton")));
    }

    public void dodajProjBtnClick() {
        dodajProjBtn.click();
    }

    public void searchForProjekt(String projName){
        searchInputText.sendKeys(projName);
        searchBtn.click();
    }

    public void assertProjName(String projName) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("tbody>tr")));
        String findedProjName = driver.findElement(By.cssSelector("tbody>tr>td>a")).getText();
        Assertions.assertThat(findedProjName).isEqualTo(projName);
    }
}
