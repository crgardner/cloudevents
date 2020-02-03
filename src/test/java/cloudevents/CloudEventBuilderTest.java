package cloudevents;

import io.cloudevents.json.Json;
import io.cloudevents.v1.CloudEventBuilder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;

public class CloudEventBuilderTest {
    static class MyData {
        private final String name;
        private final String value;

        MyData(String name, String value) {
            this.name = name;
            this.value = value;
        }


        @SuppressWarnings("unused")
        public String getName() {
            return name;
        }

        @SuppressWarnings("unused")
        public String getValue() {
            return value;
        }

    }

    @Test
    void hasSource() {
        var myData = new MyData("foo", "bar");
        var event = CloudEventBuilder.<MyData>builder().withId("12345")
                                     .withSource(URI.create("/source"))
                                     .withType("myType")
                                     .withData(myData)
                                     .build();

        var encodedEvent = Json.encode(event);

        System.out.println(encodedEvent);
        Assertions.assertThat(event).isNotNull();
    }
}
