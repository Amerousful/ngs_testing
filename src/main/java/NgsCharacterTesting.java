import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class NgsCharacterTesting {



    @Parameterized.Parameters(name = "character: {0}")
        public static Iterable<Object[]> testData() {
        return DataСharacter.getCharacter();
    }

    private String character;


    public NgsCharacterTesting(String character) {
        this.character = character;

    }


    @BeforeClass
    static public void goDriver() {
        Do.startDriver();
        Do.goToPage(Locators.getUrlProject());

    }
/*
    @Ignore
    public void checkWithCharInProject() {
        Do.clickTheButton(Locators.getNewprojectbutton());
        Do.fillField(Locators.getProjectnamefiled(), character);
        Do.clickTheButton(Locators.getCreateButton());
        Do.fillField(Locators.getNamefield(), samplename);
        Do.clickTheButton(Locators.getUploadbutton());
        Do.uploadFile(Locators.getSelectfilebutton(), Locators.getFilelocation());
        Do.clickTheButton(Locators.getStartuploadbutton());
        Do.clickTheNotClikableButton(Locators.getSavebutton());
        Do.clickTheButton(Locators.getStartanalysisbutton());
        Do.clickTheButton(Locators.getChoseworkflowradio());
        Do.clickTheNotClikableButton(Locators.getCreateanalysisbutton());
        Do.clickTheButton(Locators.getRunanalysisbutton());
        Assert.assertTrue(Do.complitedAnalysis());
    }
*/
    @Test
    public void checkCreateNewProjectWithBadChar() {
        Do.clickTheButton(Locators.getNewprojectbutton());
        Do.fillField(Locators.getProjectnamefiled(), character);
        Do.clickTheButton(Locators.getCreateButton());
        Assert.assertTrue(Do.badSymbolsMessage());


    }

    @After
    public void goToStartPage() {
        Do.goToPage(Locators.getUrlProject());
    }

    /* @After
    public void killAnalysis() {
        Do.clickTheButton(Locators.getChoseanalysis());
        Do.clickTheButton(Locators.getDeleteanalysis());
        Do.clickTheButton(Locators.getYesdeleteanalysis());
    }
    */


    @AfterClass
    static public void killerDriver() {
        Do.exitDriver();
    }


}
