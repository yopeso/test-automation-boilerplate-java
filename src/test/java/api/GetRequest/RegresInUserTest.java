package api.GetRequest;


import api.BaseTest;
import api.GetRequest.GetModel.RegresInUser;
import api.routes.RegresInRoutes;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegresInUserTest extends BaseTest {
    @Test(description = "RegresIn Get User")
    public void getUser() throws Exception {
        RegresInUser regresInUser=Service.init().get(RegresInRoutes.REGRESS_IN_API_USER, new HashMap<>()).responseToPojo(RegresInUser.class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(regresInUser.getData().getId())
                .as("Id for user number 2 should be 2, and we have %d",regresInUser.getData().getId())
                .isEqualTo(2);

    }
}
