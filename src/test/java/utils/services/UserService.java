package utils.services;

import io.restassured.http.Cookies;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserFullPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class UserService extends RestService {

    @Override
    protected String getBasePath() {
        return "/users";
    }

    public UserService(Cookies cookies) {
        super(cookies);
    }

    public CreateUserResponse createUser(UserRequest request){
        return given().spec(REQUEST_SPECIFICATION).body(request).post().as(CreateUserResponse.class);
    }

    public List<UserFullPojo> getUsers(){
        return given().spec(REQUEST_SPECIFICATION).
                get().
                jsonPath().
                getList("data", UserFullPojo.class);
    }
}
