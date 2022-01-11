import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;
import static org.testng.Assert.assertEquals;

public class ApiTest {

    @Test
    public void priceTest() {
        Response response = when()
                .get("https://public-mdc.trendyol.com/discovery-web-websfxproductrecommendation-santral/api/v1/product/81492615/" +
                        "recommendation?size=20&version=2&page=0&stamp=TypeA&storefrontId=1&culture=tr-TR")
                .then()
                .extract()
                .response();

        float value = response.jsonPath().get("result.content[0].price.sellingPrice.value");
        Assert.assertEquals(String.format("%.2f", value), "94.70"); // fiyatta bir değişiklik olursa bu test hata verir.
    }

    @Test
    public void statusTest() {
        Response response = when()
                .get("https://public-mdc.trendyol.com/discovery-web-websfxproductrecommendation-santral/api/v1/product" +
                        "/81492615/recommendation?size=20&version=2&page=0&stamp=TypeA&storefrontId=1&culture=tr-TR")
                .then()
                .extract()
                .response();

        int result = response.jsonPath().get("statusCode");

            assertEquals(result, 200);

    }

}
