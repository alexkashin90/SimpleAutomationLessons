package utils.services;

import io.restassured.http.Cookies;
import pojos.UserFullPojo;

import java.util.List;

import static io.restassured.RestAssured.given;

public class OrderService extends RestService{

    @Override
    protected String getBasePath() {
        return "/orders";
    }

    public OrderService(Cookies cookies) {
        super(cookies);
    }

    public List<UserFullPojo> getOrders(){
        return given().spec(REQUEST_SPECIFICATION).
                get().
                jsonPath().
                getList("data", UserFullPojo.class);
    }
}
