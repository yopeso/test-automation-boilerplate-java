package api.GetRequest;


import api.BaseTest;
import api.GetRequest.GetModel.ExchangeModel;
import api.routes.OpenEnAirRoutes;
import api.service.Service;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.util.HashMap;


public class ExchangeEURTest extends BaseTest {
    @Test(description = "Get Exchange EUR")
    public void getEURExchange() throws Exception {
        Service service=Service.init().get(OpenEnAirRoutes.OPEN_ER_AIR_EUR, new HashMap<>());
        ExchangeModel exchangeModel=service.responseToPojo(ExchangeModel.class);
        Assertions.assertThat(Service.getResponse().getStatusCode())
                .as("Response status code for request is 200,and we have %d ", Service.getResponse().getStatusCode())
                .isEqualTo(200);
      Assertions.assertThat(exchangeModel.getRates().get("EUR"))
            .as("Exchange model EUR rate for EUR should be 1,and we have %s ", exchangeModel.getRates().get("EUR"))
            .isEqualTo("1");
        }
    }
