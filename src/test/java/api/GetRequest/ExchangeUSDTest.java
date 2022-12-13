package api.GetRequest;


import api.BaseTest;
import api.GetRequest.GetModel.ExchangeModel;
import api.routes.OpenEnAirRoutes;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;

public class ExchangeUSDTest extends BaseTest {
    @Test(description = "Get Exchange USD")
    public void getUSDExchange() throws Exception {
        ExchangeModel exchangeModel=Service.init().get(OpenEnAirRoutes.OPEN_ER_AIR_USD, new HashMap<>()).responseToPojo(ExchangeModel.class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
        Assertions.assertThat(exchangeModel.getRates().get("USD"))
                .as("Exchange model USD rate for USD should be 1,and we have %s ", exchangeModel.getRates().get("USD"))
                .isEqualTo("1");
    }
}
