package simpleAutomation;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

@Smoke
public class OrderTests{

    @BeforeAll
    public static void createOrder() {
        System.out.println("create order");
    }

    @Tag("smoke")
    @Test
    public void testCreateOrder (){
        System.out.println("check if order was created");
    }

    @Tag("smoke")
    @Test
    public void testListOfOrders(){
        System.out.println("list of orders");
        System.out.println("check if orders are displayed");
    }

    @ParameterizedTest
    @Tag("orderTest")
    @ValueSource(strings = {"manager of group", "manager of department", "manager of branch",
    "CEO", "Founder"})
    public void testListOfOrdersAsManager(String role){
        System.out.println("list of orders as " + role);
        System.out.println("check if orders are displayed for " + role);
    }

    @ParameterizedTest
    @EnumSource
    @Tag("orderTest")
    public void testListOfOrdersAsEnumManager(Roles role){
        System.out.println("list of orders as " + role.getDescription() + " Enum");
        System.out.println("check if orders are displayed for " + role.getDescription() + " Enum");
    }
    enum Roles {
        MANAGEROFAGROUP("manager of group"),
        MANAGEROFDEPARTMENT("manager of department"),
        MANAGEROFBRANCH("manager of branch"),
        CEO("CEO"),
        FOUNDER("Founder");

        Roles(String description) {
            this.description = description;
        }

        private String description;

        public String getDescription() {
            return description;
        }
    }

    @ParameterizedTest
    @Tag("orderTest")
    @MethodSource("getRoles")
    public void testListOfOrdersAsStreamManager(Roles role){
        System.out.println("list of orders as " + role.getDescription() + " Stream");
        System.out.println("check if orders are displayed for " + role.getDescription() + " Stream");
    }

    static Stream<Roles> getRoles(){
        return Stream.of(Roles.MANAGEROFDEPARTMENT, Roles.MANAGEROFAGROUP,
                Roles.MANAGEROFBRANCH, Roles.CEO, Roles.CEO, Roles.FOUNDER);
    }

    @AfterEach
    public void deleteOrder(){
        System.out.println("delete order");
        System.out.println("_____________");
    }

    @AfterAll
    public static void deleteAllOrders(){
        System.out.println("delete all orders");
    }
}
