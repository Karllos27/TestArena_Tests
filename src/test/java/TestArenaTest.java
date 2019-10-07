import org.junit.Test;

public class TestArenaTest extends SelniumTestArenaTest {

    @Test
    public void createProjectTest() {
//      Zaloguje się do TestArena
        LoginPage loginPage = new LoginPage(driver);
        loginPage.userLogin("administrator@testarena.pl", "sumXQQ72$L");

//      Otworzy Admin Panel (przycisk w prawym górnym rogu)
        KokpitPage kokpitPage = new KokpitPage(driver);
        kokpitPage.waitForAdmBtn();
        kokpitPage.admBtnClick();

//      Doda nowy projekt
//        1.Otworzy okno dodawania projektu
        ProjektyPage projektyPage = new ProjektyPage(driver);
        projektyPage.waitForDodajProjBtn();
        projektyPage.dodajProjBtnClick();
//        2.W oknie dodawania projektu - dodaje nowy projekt
        DodajProjektPage dodajProjektPage = new DodajProjektPage(driver);
        dodajProjektPage.waitForFormElements();
        String projName = dodajProjektPage.addNewRndProject();

//      Wejdzie do sekcji Projects (lewe menu)
        dodajProjektPage.activeMenuProjektyClick();

//      Wyszuka nowo utworzony projekt po nazwie
        projektyPage.waitForSearchSection();
        projektyPage.searchForProjekt(projName);

        projektyPage.assertProjName(projName);
    }
}
