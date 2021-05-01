import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import pojos.UserRequest;
import pojos.CreateUserResponse;
import pojos.UserFullPojo;
import pojos.UserPojo;
import java.util.List;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;


public class RestTest {
    @Test
    public void getUsers(){
        given().
                baseUri("https://reqres.in/").
                basePath("api/users").
                contentType(ContentType.JSON).
                when().get().
                then().statusCode(200).
                body("data[0].email", equalTo("george.bluth@reqres.in"));
    }

    @Test
    public void getUserGeorgeLambda(){
        given().
                baseUri("https://reqres.in/").
                basePath("api/users").
                contentType(ContentType.JSON).
                when().get().
                then().statusCode(200).
                body("data.find{it.email=='george.bluth@reqres.in'}.first_name", equalTo("George"));
    }

    @Test
    public void getJSONPath(){
        List<String> emails = given().
                baseUri("https://reqres.in/").
                basePath("api/users").
                contentType(ContentType.JSON).
                when().get().
                then().statusCode(200).
                extract().jsonPath().getList("data.email");
    }

   @Test
    public void getUserPojo(){
        List<UserPojo> userPojos = given().
                baseUri("https://reqres.in/").
                basePath("api/users").
                contentType(ContentType.JSON).
                when().get().
                then().statusCode(200).
                extract().jsonPath().getList("data", UserPojo.class);
    }

    @Test
    public void getUserFullPojo(){
        List<UserFullPojo> userFullPojos = given().
                baseUri("https://reqres.in/").
                basePath("api/users").
                contentType(ContentType.JSON).
                when().get().
                then().statusCode(200).
                extract().jsonPath().getList("data", UserFullPojo.class);
    }

    @Test
    public void assertGetUserFullPojo(){
        List<UserFullPojo> userFullPojos = given().
                baseUri("https://reqres.in/").
                basePath("api/users").
                contentType(ContentType.JSON).
                when().get().
                then().statusCode(200).
                extract().jsonPath().getList("data", UserFullPojo.class);
        assertThat(userFullPojos).extracting(UserFullPojo::getEmail).contains("george.bluth@reqres.in");
    }
    @Test
    public void createUser(){
        UserRequest createUserRequest = new UserRequest();
        createUserRequest.setJob("tester");
        createUserRequest.setName("Alex");
        CreateUserResponse createUserResponse = given().
                baseUri("https://reqres.in/").
                basePath("api/users").
                contentType(ContentType.JSON).
                body(createUserRequest).
                when().post().
                then().extract().as(CreateUserResponse.class);
        assertThat(createUserResponse).
                isNotNull().
                extracting(CreateUserResponse::getName).
                isEqualTo(createUserRequest.getName());
    }
}
