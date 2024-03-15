package api.test;

import api.endpoints.PetEndPoints;
import api.payload.Category;
import api.payload.Pet;
import api.payload.Tags;
import api.utilities.DataProviders;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class PetTests {
    Logger logger;


    @Test(priority = 1, dataProvider = "CreatePetData", dataProviderClass = DataProviders.class)

    public void createPetToStore(String id,String categoryId,String categoryName, String name, String photoUrls,String tagId, String tagName,String status){
  logger = LogManager.getLogger(this.getClass());
        Pet petPayload = new Pet();
        Category ct = new Category();
        ct.setId(categoryId);
        ct.setName(categoryName);
        Tags t = new Tags();
        t.setId(tagId);
        t.setName(String.valueOf(tagName));
        List<String> l = new ArrayList<>();
        l.add(photoUrls);
        List<Tags> lt = new ArrayList<>();
        lt.add(t);

        petPayload.setId((String.valueOf(id)));
        petPayload.setCategory(ct);
        petPayload.setName(name);
        petPayload.setPhotoUrls(l);
        petPayload.setTags(lt);
        petPayload.setStatus(status);


        Response r = PetEndPoints.createPetToStore(petPayload)
                .then().log().all().extract().response();
        logger.info("Response will be receieved for create pet api");
        System.out.println("Create pet to store response is :"+r.asString());
        Assert.assertEquals(r.getStatusCode(),200);
        logger.info("Assert successful for create pet api");

    }

    @Test(priority = 2, dataProvider = "UpdatePetStoreData", dataProviderClass = DataProviders.class)
    public void updatePetToStore(String id,String categoryId,String categoryName, String name, String photoUrls,String tagId, String tagName,String status){
        Pet petPayload = new Pet();
        Category ct = new Category();
        ct.setId(categoryId);
        ct.setName(categoryName);
        Tags t = new Tags();
        t.setId(tagId);
        t.setName(String.valueOf(tagName));
        List<String> l = new ArrayList<>();
        l.add(photoUrls);
        List<Tags> lt = new ArrayList<>();
        lt.add(t);

        petPayload.setId((String.valueOf(id)));
        petPayload.setCategory(ct);
       petPayload.setName(name);
        petPayload.setPhotoUrls(l);
        petPayload.setTags(lt);
        petPayload.setStatus(status);



     Response rp =   PetEndPoints.updatePetToStore(petPayload).then().log().all().extract().response();
//        System.out.println("Before Updating pet to store response is :"+rp.asString());
       // System.out.println("*************************************");
        petPayload.setName("buzzo");
        Response r =   PetEndPoints.updatePetToStore(petPayload).then().log().all().extract().response();
//        System.out.println("Before Updating pet to store response is :"+rp.asString());
        logger.info("Assert successful for update pet api");
        Assert.assertEquals(rp.getStatusCode(),200);


    }
}
