import java.util.Arrays;

public class DataСharacter {

    public static Iterable<Object[]> getCharacter() {
        return Arrays.asList(new Object[][]{
                {"#"},
                {"%"},
                {"/"},
                {"*"},
                {"&"},
                {"?"},
                {"["},
                {"]"},
                {"{"},
                {"}"},
                {"|name"},
                {"/name"},
                {"na/me"},
                {"name/"},
                {"%name"},
                {"na%me"},
                {"name%"},
                {","},
                {"!"},
                {"#name"},
                {"na#me"},
                {"name#"},
                {"."},
                {".name"},
                {">"},
                {"<"},
                {"`"},
                {"@"},
                {"|"},
                {"?name"},
                {"na?me"},
                {"name?"}

        });
    }

}
