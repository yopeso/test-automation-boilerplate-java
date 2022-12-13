package api.PostRequest;

import api.BaseTest;
import api.PostRequest.model.RegresInCreateModel;
import api.routes.RegresInRoutes;
import api.service.Service;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class RegresInCreateTest extends BaseTest {
    @Test(description = "RegresIn Create User")
    public void createUser() throws Exception {
        Service service=Service.init().post(RegresInRoutes.REGRESS_IN_API_ALL_USERS, new HashMap<>());
        RegresInCreateModel regresInUser=service.responseToPojo(RegresInCreateModel.class);
        Response response=Service.getResponse();

       Assertions.assertThat(response.getStatusCode())
                .as("Response status code for request is 201,and we have %d ", response.getStatusCode())
                .isEqualTo(201);
        Assertions.assertThat(regresInUser.getId())
                        .as("User Id should not be 0")
                                .isNotEqualTo(0);
        String today=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Assertions.assertThat(regresInUser.getCreatedAt())
                .as("Post response have today date in response")
                .contains(today);
    }
}
