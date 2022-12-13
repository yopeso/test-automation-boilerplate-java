package api.PatchRequest;

import api.BaseTest;
import api.PatchRequest.model.RegresInPatchModel;
import api.routes.RegresInRoutes;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


public class RegresInPatchTest  extends BaseTest {
    @Test(description = "RegresIn Patch User")
    public void patchUser() throws Exception {
        RegresInPatchModel regresInUser=Service.init().patch(RegresInRoutes.REGRESS_IN_API_USER, new HashMap<>()).responseToPojo(RegresInPatchModel.class);

        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        String today=new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime());
        Assertions.assertThat(regresInUser.getUpdatedAt())
                        .as("Patch response should and have today date in response.")
                                .contains(today);
    }
}
