package epam.training.hw5.context;

import java.util.HashMap;
import java.util.Map;

public class TestContext {

    private static TestContext instance;
    private final Map<String, Object> context = new HashMap<>();

    private TestContext() {
    }

    public static TestContext getInstance() {
        if (instance == null) {
            instance = new TestContext();
        }
        return instance;
    }

    public TestContext putObject(String key, Object object) {
        context.put(key, object);
        return this;
    }

    public <T> T getObject(String key) {
        return (T) context.get(key);
    }


    public void clear() {
        context.clear();
        instance = null;
    }
}
