package api.PutRequest;

import api.BaseTest;
import api.PutRequest.model.RegresInEditModel;
import api.routes.RegresInRoutes;
import api.service.Service;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class RegresInEditTest extends BaseTest {
    @Test(description = "RegresIn Edit User")
    public void editUser() throws Exception {
        Response response=Service.init().put(RegresInRoutes.REGRESS_IN_API_USER, new HashMap<>()).getResponse();
        RegresInEditModel regresInEditModel=Service.responseToPojo(RegresInEditModel.class,response);

        Assertions.assertThat(response.getStatusCode())
                .as("Response status code for request is 200,and we have %d ", response.getStatusCode())
                .isEqualTo(200);
        String today=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Assertions.assertThat(regresInEditModel.getUpdatedAt())
                .as("Put response should have today date in response")
                .contains(today);
    }
}
