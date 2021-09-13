package epam.training.hw3;

import java.util.ArrayList;
import java.util.List;

public class DataClass {

    public static final List<String> BENEFIT_INDEX_PAGE_TEXT = new ArrayList<>(
            List.of(
                    "To include good practices\n"
                            +
                            "and ideas from successful\n"
                            +
                            "EPAM project",
                    "To be flexible and\n"
                            +
                            "customizable",
                    "To be multiplatform",
                    "Already have good base\n"
                            +
                            "(about 20 internal and\n"
                            +
                            "some external projects),\n"
                            +
                            "wish to get more…"));


    public static final List<String> CHECKBOX_TEXT = new ArrayList<>(
            List.of("Water", "Earth",  "Wind", "Fire"));

    public static final String CHECKBOX_LOG = ": condition changed to true";


    public static final List<String> RADIO_TEXT = new ArrayList<>(
            List.of("Gold", "Silver",  "Bronze", "Selen"));

    public static final String RADIO_LOG = "metal: value changed to";


    public static final List<String> DROPDOWN_TEXT = new ArrayList<>(
            List.of("Red", "Green",  "Blue", "Yellow"));

    public static final String DROPDOWN_LOG = "Colors: value changed to";

}
