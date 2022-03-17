package drivenData;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import commons.GlobalConstants;

import java.io.File;

public class AspireAppData {

    public static AspireAppData getUserDataTest() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.WORKING_DIR + "/src/main/java/drivenData/dataOnAspireApp.json"),
            		AspireAppData.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}


