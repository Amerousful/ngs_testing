import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class Ngs {



        @Parameterized.Parameters(name = "project name: {0}")
        public static Iterable<Object[]> testData() {
            return Data.getTestData();
        }


        private String projectname;

        public Ngs(String projectname) {
            this.projectname = projectname;
        }


    @BeforeClass
    static public void goToSite() {
            Action.startDriver();
            Action.goToPage();
    }

    @Test
    public void createProject() {
            Action.clickTheButton(Locators.getNewprojectbutton());
            Action.fillField(Locators.getProjectnamefiled(), projectname);
            Action.clickTheButton(Locators.getCreateButton());
            Action.goToPage();
            Assert.assertTrue(Action.confirmCreationProject());
    }

    @After
    public void deleteProject() {
            Action.killProject();
    }


    @AfterClass
    static public void killerDriver() {
        Action.exitDriver();
    }

}
