package simpleAutomation;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class OrderTests{

    @BeforeAll
    public static void createOrder() {
        System.out.println("create order");
    }

    @Test
    public void testCreateOrder (){
        System.out.println("check if order was created");
    }

    @Test
    public void testListOfOrders(){
        System.out.println("list of orders");
        System.out.println("check if orders are displayed");
    }

    @ParameterizedTest
    @ValueSource(strings = {"manager of group", "manager of department", "manager of branch",
    "CEO", "Founder"})
    public void testListOfOrdersAsManager(String role){
        System.out.println("list of orders as " + role);
        System.out.println("check if orders are displayed for " + role);
    }

    @AfterEach
    public void deleteOrder(){
        System.out.println("delete order");
    }

    @AfterAll
    public static void deleteAllOrders(){
        System.out.println("delete all orders");
    }
}
