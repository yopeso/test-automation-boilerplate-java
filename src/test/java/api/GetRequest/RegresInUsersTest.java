package api.GetRequest;


import api.BaseTest;
import api.GetRequest.GetModel.RegresInUsers;
import api.routes.RegresInRoutes;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegresInUsersTest extends BaseTest {
    @Test(description = "RegresIn Get Users")
    public void getAllUsers() throws Exception {
        RegresInUsers regresInUsers=Service.init().get(RegresInRoutes.REGRESS_IN_API_ALL_USERS, new HashMap<>()).responseToPojo(RegresInUsers.class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(regresInUsers.getPage())
                .as("Current page should be 1, and we have %d",regresInUsers.getPage())
                .isEqualTo(1);
        Assertions.assertThat(regresInUsers.getData().get(0).getId())
                .as("Id for first user should be 1, and we have %d",regresInUsers.getData().get(0).getId())
                .isEqualTo(1);
    }
}
