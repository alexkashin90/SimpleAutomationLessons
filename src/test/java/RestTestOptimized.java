import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pojos.CreateUserResponse;
import pojos.UserFullPojo;
import pojos.UserRequest;
import utils.RestWrapper;
import utils.UserGenerator;
import utils.services.UserService;

import static org.assertj.core.api.Assertions.assertThat;

public class RestTestOptimized {
    private static RestWrapper api;

    @BeforeAll
    public static void prepareClient(){
        api = RestWrapper.loginAs("eve.holt@reqres.in", "cityslicka");
    }

    @Test
    public void getUsers(){
        assertThat(new UserService(api.getCookies()).getUsers()).
                extracting(UserFullPojo::getEmail).
                contains("george.bluth@reqres.in");
    }

    @Test
    public void createUser(){
        UserRequest request = UserGenerator.generateUser();
        CreateUserResponse response = api.user.createUser(request);

        assertThat(response).
                isNotNull().
                extracting(CreateUserResponse::getName).
                isEqualTo(request.getName());
    }
}
