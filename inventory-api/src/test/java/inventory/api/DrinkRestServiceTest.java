package inventory.api;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import inventory.api.dto.DrinkType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(value = "/inventory-api-beans.xml")
class DrinkRestServiceTest {

    private static final int PORT = 8080;

    private static WireMockServer wireMockServer;

    @Autowired
    @Qualifier("inventory.api.drinkRestService")
    private DrinkRestService drinkRestService;

    @BeforeAll
    public static void setUp() {
        wireMockServer = new WireMockServer(new WireMockConfiguration().port(PORT));
        wireMockServer.start();
    }

    @AfterAll
    public static void tearDown() {
        wireMockServer.stop();
    }

    @Test
    public void getDrinkCountShouldReturnResponse() {
        wireMockServer.stubFor(get(urlPathEqualTo("/inventory/drink/count/COLA"))
                                   .willReturn(aResponse().withStatus(200)
                                                          .withBody("2")
                                                          .withHeader("content-type", "application/json")));

        int count = drinkRestService.getDrinkCount(DrinkType.COLA);

        assertThat(count, is(2));
    }
}