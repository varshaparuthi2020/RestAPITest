package api.endpoints;
/*
here we maintain url i.e.  baseurl + endpoints  /rooturl i.e. petstore api and other api are endpoints
SwaggerURI : https://petstore.swagger.io/

Create user : https://petstore.swagger.io/v2/user
get user/update user/delete user

Update/get /delete user : https://petstore.swagger.io/v2/user/{username}

 */
public class Routes {


    public static String baseUrl = "https://petstore.swagger.io/v2";


    //user module

public static String post_url= baseUrl + "/user";
public static String get_url = baseUrl + "/user/{username}";
public static String update_url = baseUrl + "/user/{username}";
public static String delete_url = baseUrl + "/user/{username}";


//store module

    //here we can enter all store module  API urls and store here
}
