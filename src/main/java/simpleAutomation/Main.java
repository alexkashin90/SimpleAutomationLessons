package simpleAutomation;

public class Main {
    private static final  String EXISTING_USER = "existing user";
    private static final  String NON_EXISTING_USER = "non existing user";

    public static void main(String[] args) {
        new AuthorizationTests().testLogin();
        OrderTests orderTests = new OrderTests();
        orderTests.testCreateOrder();
        orderTests.testListOfOrders();

    }

}
