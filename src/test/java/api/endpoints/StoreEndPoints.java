package api.endpoints;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class StoreEndPoints {


    public static ResourceBundle getUrls (){
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }
    public static Response  createStore(Store storePayload){

        String postStoreUrl = getUrls().getString("post_store_url");
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON).log().all()
                .body(storePayload)
                .when()
                .post(postStoreUrl);
        return response;

    }

    public static Response getStore( String orderId ){
        String getStoreUrl = getUrls().getString("get_store_url");

        Response response= given().log().all()
                //baseUri(postStoreUrl)
               .pathParam("orderId",orderId)
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .when()
                .get(getStoreUrl);

        return response;
    }


public static Response deleteStore(String orderId){

        String deleteStoreUrl = getUrls().getString("delete_store_url");

        Response response= given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("orderId",orderId)
                .when()
                .delete(deleteStoreUrl);
        return response;
}

}
