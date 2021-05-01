package utils;

import pojos.UserRequest;

public class UserGenerator {
    public static UserRequest generateUser(){
        return UserRequest.builder().job("tester").name("Alex").build();
    }
}
