import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;


@RunWith(Parameterized.class)
public class NgsCharacterTesting {



    @Parameterized.Parameters(name = "character: {0}, index: {1}")
        public static Iterable<Object[]> testData() {
        return DataСharacter.getCharacter();
    }

    private String character;
    private String index;


    public NgsCharacterTesting(String character, String index) {
        this.character = character;
        this.index = index;

    }


    @BeforeClass
    static public void goDriver() {
        Do.startDriver();
        Do.goToPage(Locators.getUrlProject());

    }

    @Test
    public void checkCreateNewSampleWithBadChar() {
        // must be created project with name "project"
      Do.clickTheButton(Locators.getGotoproject());
      Do.clickTheButton(Locators.getAddsamplebutton());
      Do.fillField(Locators.getNamefield(), character);
      Do.clickTheButton(Locators.getSavebutton());
      Assert.assertTrue(Do.badSymbolsMessage());

    }

    @Test
    public void checkCreateNewProjectWithBadChar() {
        Do.clickTheButton(Locators.getNewprojectbutton());
        Do.fillField(Locators.getProjectnamefiled(), character);
        Do.clickTheButton(Locators.getCreateButton());
        Assert.assertTrue(Do.badSymbolsMessage());
    }


    @Test
    public void checkWithCharacterInGroupName() {
        // must be created project with name "project"
        Do.clickTheButton(Locators.getGotoproject());
        Do.clickTheButton(Locators.getStartanalysisbutton());
        Do.clickTheButton(Locators.getChoseworkflowradio());
        Do.clickTheButton(Locators.getCreateanalysisbutton());
        Do.clearField(Locators.getAnalysisnamefield());
        Do.fillField(Locators.getAnalysisnamefield(), index);
        Do.clearField(Locators.getGroupnamefield());
        Do.fillField(Locators.getGroupnamefield() , character);
        Do.clickTheButton(Locators.getRunanalysisbutton());
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
