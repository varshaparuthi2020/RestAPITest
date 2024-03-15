package api.endpoints;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;

public class PetEndPoints {

static ResourceBundle getUrls(){
   ResourceBundle routes = ResourceBundle.getBundle("routes");
   return routes;
}


   public static Response createPetToStore(Pet petPayload){

    String postPetURL = getUrls().getString("post_pet_url");
      Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(petPayload)
                .when()
                .post(postPetURL);
       return response;
    }



    public static Response updatePetToStore(Pet petPayload){

String updatePetUrl = getUrls().getString("put_pet_url");
       Response  response= given().contentType(ContentType.JSON)
               .accept(ContentType.JSON)
               .body(petPayload).log().all()
               .when()
               .put(updatePetUrl);
       return response;
    }
}
