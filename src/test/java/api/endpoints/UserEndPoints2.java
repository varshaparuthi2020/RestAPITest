package api.endpoints;


//This file created to perform CRUD operations on the user API i.e. implementation of endpoints

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ResourceBundle;

import static io.restassured.RestAssured.given;


public class UserEndPoints2 {


    //new mthod used to load properties file and fetch urls

    static ResourceBundle getUrls(){

        ResourceBundle routes = ResourceBundle.getBundle("routes"); //this resourcebundle class load routes .properties file
        return routes;

    }




    public static Response createUser(User payload){

      String postUrl=   getUrls().getString("post_url");
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload).log().all()
                .when()
                .post(postUrl)
                ;
        return response;


    }


    public static Response getUser(String userName){
String getUrl =getUrls().getString("get_url");
        Response response = given().
                pathParam("username",userName).log().all()
                .when()
                .get(getUrl)
                ;
        return  response;
    }

    public static Response updateUser(String userName, User payload){


        String updateUrl= getUrls().getString("update_url");
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username",userName)
                .body(payload).log().all()
                .when()
                .put(updateUrl);
        return response;
    }

    public static Response deleteUser(String userName){
String deleteUrl = getUrls().getString("delete_url");
        Response response = given().
                pathParam("username",userName).log().all()
                .when()
                .delete(deleteUrl)
                ;
        return  response;
    }

}
