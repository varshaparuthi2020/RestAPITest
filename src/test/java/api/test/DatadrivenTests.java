package api.test;

import api.endpoints.StoreEndPoints;
import api.endpoints.UserEndPoints;
import api.payload.Store;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class DatadrivenTests{



    @Test(priority = 1, dataProvider = "Data",dataProviderClass= DataProviders.class)
    public void testPostUser(String userId, String userName, String fName,String lName, String email,String password, String phone){

        User userPayload = new User();
    userPayload.setId(Integer.parseInt(userId));
    userPayload.setUsername(userName);
    userPayload.setFirstName(fName);
    userPayload.setLastName(lName);
    userPayload.setEmail(email);
    userPayload.setPassword(password);
    userPayload.setPhone(phone);

    Response response =UserEndPoints.createUser(userPayload);
    response.then().log().all().assertThat().statusCode(200);


    }
@Test(priority=2, dataProvider = "UserNames",dataProviderClass = DataProviders.class)
public void testDeleteUserByUserName(String userName){
        Response resp = UserEndPoints.deleteUser(userName);
    resp.then().log().all().assertThat().statusCode(200);
    Assert.assertEquals(resp.getStatusCode(),200);
}



@Test(priority= 3, dataProvider = "StoreData",dataProviderClass = DataProviders.class)
    public void getStoreData(String id , String petId , String quantity, String shipDate, String status, String complete) throws IOException {
        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    SimpleDateFormat format1 = new SimpleDateFormat(dateFormat);

    format1.setTimeZone(TimeZone.getTimeZone("UTC"));
    final String utcTime = format1.format(new Date());
    Store storePayload = new Store();
    storePayload.setId(Integer.parseInt(id));
    storePayload.setPetId(Integer.parseInt(petId));
    storePayload.setQuantity(Integer.parseInt(quantity));
    storePayload.setDate(String.valueOf(utcTime));
    storePayload.setStatus(status);

    storePayload.setComplete("true");

    Response response= StoreEndPoints.createStore(storePayload);
    response.then().log().all().statusCode(200);
    Assert.assertEquals(response.getStatusCode(),200);

//    Response response1 = StoreEndPoints.getStore();
//    response1.then().log().all().statusCode(200);

}

@Test(priority=4)
    public void getDataOfCreatedStore() throws IOException {


getStoreData("4","104","9","2023-12-27T17:54:56.834Z","placed","true");

        Response response = StoreEndPoints.getStore("4");
        response.then().log().all().statusCode(200);

}

@Test(priority=5, dataProvider = "CreateStoreData", dataProviderClass= DataProviders.class)
    public void deletedataofStore(String id , String petId , String quantity, String shipDate, String status, String complete){
        String dateFormat = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        format.setTimeZone(TimeZone.getTimeZone("UTC"));
        final String utcTime =format.format(new Date());
    Store storePayload = new Store();
    storePayload.setId(Integer.parseInt(id));
    storePayload.setPetId(Integer.parseInt(petId));
    storePayload.setQuantity(Integer.parseInt(quantity));
    storePayload.setDate(String.valueOf(utcTime));
    storePayload.setStatus(status);

    storePayload.setComplete("true");

    Response response = StoreEndPoints.createStore(storePayload);
    response.then().log().all().extract().response();
    Assert.assertEquals(response.getStatusCode(),200);

//    JsonPath jsonPath = new JsonPath(response);
//
int orderId = response.path("id");

   System.out.println("order details: "+orderId);

    Response getStoreResponse = StoreEndPoints.getStore(String.valueOf(orderId));
    getStoreResponse.then().log().all().statusCode(200);

    Response deleteStoreResponse = StoreEndPoints.deleteStore(String.valueOf(orderId));
    deleteStoreResponse.then().log().all().statusCode(200);
}



}

