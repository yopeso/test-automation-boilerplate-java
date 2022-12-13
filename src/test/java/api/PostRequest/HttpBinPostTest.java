package api.PostRequest;

import api.BaseTest;
import api.PostRequest.model.HttpBinPostModel;
import api.routes.OpenHttpRoutes;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class HttpBinPostTest extends BaseTest {
    @Test(description = "PostRequest")
    public void doPostRequest() throws Exception {
        Service service = Service.init().queryParam("aa", "bb").post(OpenHttpRoutes.OPEN_HTTP_BIN_POST, new HashMap<>());
        HttpBinPostModel postModel = service.responseToPojo(HttpBinPostModel.class);


        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(postModel.getArgs().get("aa"))
                        .as("Post response have query param aa=bb")
                                .isEqualTo("bb");
    }
}
