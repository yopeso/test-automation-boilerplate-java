package api.PutRequest;

import api.BaseTest;
import api.PutRequest.model.HttpBinPutModel;
import api.routes.OpenHttpRoutes;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class HttpBinPutTest extends BaseTest {
    @Test(description = "PostRequest")
    public void doPutRequest() throws Exception {
        Service service = Service.init().queryParam("aa", "bb");
        service.put(OpenHttpRoutes.OPEN_HTTP_BIN_PUT, new HashMap<>());
        HttpBinPutModel putModel = service.responseToPojo(HttpBinPutModel.class);


        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(putModel.getArgs().get("aa"))
                .as("Put response have query param aa=bb")
                .isEqualTo("bb");
    }
}
