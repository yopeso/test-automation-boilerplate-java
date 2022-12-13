package api.DeleteRequest;

import api.BaseTest;

import api.routes.RegresInRoutes;
import api.service.Service;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class RegresInDeleteTest extends BaseTest {
        @Test(description = "RegresIn Delete User")
        public void deleteUser() throws Exception {
            Response response=Service.init().delete(RegresInRoutes.REGRESS_IN_API_USER, new HashMap<>()).getResponse();
            Assertions.assertThat(response.getStatusCode())
                    .as("Response status code for delete request is 204,and we have %d ", response.getStatusCode())
                    .isEqualTo(204);
        }
    }
