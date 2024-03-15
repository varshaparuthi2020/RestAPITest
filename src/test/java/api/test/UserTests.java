package api.test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserTests {
    User userPayload;

    Faker faker;

    public Logger logger;
    @BeforeClass
    public void setupData(){
        faker= new Faker();
        userPayload = new User();
        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());

        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setFirstName(faker.internet().password(5,10));
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        logger = LogManager.getLogger(this.getClass());

    }

    @Test(priority=1)
    public void testPostUser(){
        logger.info("**************Creating user****************");
        Response response = UserEndPoints.createUser(userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("**************User created****************");
    }



    @Test(priority=2)
    public void testGetUser(){
        logger.info("**************Getting user****************");
        Response response = UserEndPoints.getUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("**************User details fetched****************");
    }

    @Test(priority = 3)
    public void testUpdateUser(){
        logger.info("**************Updating user****************");
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());




        Response response = UserEndPoints.updateUser(this.userPayload.getUsername(),userPayload);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);

        // Check updateed dta using get call
        Response getupdatedResponse = UserEndPoints.getUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(getupdatedResponse.getStatusCode(),200);
        logger.info("**************User updated successfully****************");
    }

    @Test(priority = 4)
    public void testdeleteUser(){
        logger.info("**************Deleting user****************");
        Response response =UserEndPoints.deleteUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);


        // Check delete dta using get call
        Response getupdatedResponse = UserEndPoints.getUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(getupdatedResponse.getStatusCode(),404);
        logger.info("**************User deleted successfully****************");
    }


}