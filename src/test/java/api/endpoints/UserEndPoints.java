package api.endpoints;


//This file created to perform CRUD operations on the user API i.e. implementation of endpoints

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;


public class UserEndPoints {


    public static Response createUser(User payload){
       Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload).log().all()
                .when()
                .post(Routes.post_url)
                ;
        return response;


    }


    public static Response getUser(String userName){

        Response response = given().
                pathParam("username",userName).log().all()
                .when()
                .get(Routes.get_url)
                ;
        return  response;
    }

    public static Response updateUser(String userName, User payload){

       Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload).log().all()
                .when()
                .put(Routes.update_url);
       return response;
    }

    public static Response deleteUser(String userName){

        Response response = given().
                pathParam("username",userName).log().all()
                .when()
                .delete(Routes.delete_url)
                ;
        return  response;
    }

}
