package epam.training.jdihomework.entities;

import com.epam.jdi.tools.DataClass;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class MetalColorsEntity extends DataClass<MetalColorsEntity> {
    private List<Integer> summary;
    private List<String> elements;
    private String color;
    private String metals;
    private List<String> vegetables;

    public List<String> getEntitytAsListString() {
        int sum = summary.get(0) + summary.get(1);
        return new ArrayList<>(
                List.of(
                "Summary: " + sum,
                "Elements: " + StringUtils.join(elements,", "),
                "Color: " + color,
                "Metal: " + metals,
                "Vegetables: " + StringUtils.join(vegetables,", ")
         ));
    }
}

