package methodtest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import javax.xml.namespace.QName;
import java.io.IOException;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)

public class Autotests {
    String baseUrl = "https://petstore.swagger.io/v2";
    String inventory = "/store/inventory";
    String order = "/store/order";


/** Получение списка животных и их статуса (инвентаризация) */

    @Test //get
    public void inventory () {
        Response reaction = given().baseUri(baseUrl).basePath(inventory)
                .header("Accept","application/json")
                .when().get().then().extract().response();

        assertEquals(200,reaction.getStatusCode(), "Статус не равен ожидаемому, он равен "+reaction.statusCode());

        System.out.println(inventory);
        System.out.println(reaction.statusCode());
        System.out.println(reaction.getBody().asPrettyString());
    }

/** Оформление заказа на животное(ых) */

    @Test //post
    public void order() throws IOException {

        String body = Helpers.Readfile.readFile("src/test/resources/orderPet.json");

        Response reaction = given().baseUri(baseUrl).basePath(order)
                .header("Accept","application/json").header("Content-Type","application/json")
                .body(body)
                .when().post().then().extract().response();
        assertEquals(200,reaction.getStatusCode(), "Статус не равен ожидаемому, он равен "+reaction.statusCode());

        System.out.println(order);
        System.out.println(reaction.statusCode());
        System.out.println(reaction.getBody().asPrettyString());
    }
}


