import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.HashMap;
import java.util.Map;

@Path("test")
@Produces("application/json")
public class TestController {

    @GET
    public Map<String, String> getTest(){
        var testMap = new HashMap<String, String>();
        testMap.put("test", "test");

        return testMap;
    }
}
