package springbootdemo.testRestAssured;

//import org.testing.Assert;
import io.restassured.RestAssured;
//import io.restassured.response.Response;

//import static org.hamcrest.CoreMatchers.*;
import static io.restassured.RestAssured.*;
import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;

//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;

//import io.restassured.RestAssured;
import springbootdemo.repository.UserRepository;
import springbootdemo.model.User;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class GetRequestAssuredTest {
   // @LocalServerPort
    private int port = 8080;
    @Autowired
    private UserRepository repository;

    @Before
    public void setup() {

        RestAssured.port = port;
    }

    /*@After
    public void resetDb() {
        repository.deleteAll();
        repository.flush();
    }*/

   @Test
    public void whenCreateUser_thenStatus201() {

       User user = new User("Michail","Ivanov","mean",15L);

        given().log().body()
                .contentType("application/json").body(user)

                .when().post("/user-create")

                .then().log().body()
                .statusCode(HttpStatus.CREATED.value());
    }

  /* @Test
    public void givenUser_whenGetUser_thenStatus200() {

        long id = createTestUsers(2L,"Michail","Ivanov","mean",15L).getId();

        given().pathParam("id", id)

                .when().get("/users/{id}")

                .then().log().body().statusCode(HttpStatus.OK.value())
                .and().body("firstName", equalTo("Michail"));

    }

        @Test
        public void givenNoPerson_whenGetPerson_thenStatus500() {

            given().pathParam("id", 1).when().get("/persons/{id}").then().log().body()
                    .statusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());

        }

        @Test
        public void whenUpdatePerson_thenStatus200() {

            long id = createTestUsers("Nick").getId();
            Person person = new Person("Michail");

            given().pathParam("id", id).log().body().contentType("application/json").body(person).when()
                    .put("/persons/{id}").then().log().body().statusCode(HttpStatus.OK.value()).and()
                    .body("name", equalTo("Michail"));

        }

        @Test
        public void givenPerson_whenDeletePerson_thenStatus200() {

            long id = createTestUsers("Nick").getId();
            given().pathParam("id", id).log().body().contentType("application/json").when().delete("/persons/{id}").then()
                    .log().body().statusCode(HttpStatus.OK.value()).and().body("name", equalTo("Nick"));

        }

        @Test
        public void givenPersons_whenGetPersons_thenStatus200() {
            createTestPerson("Joe");
            createTestPerson("Jane");

            when().get("/persons")
                    .then().log().body()
                    .statusCode(HttpStatus.OK.value())
                    .and().body("get(0).name", equalTo("Joe"))
                    .and().body("get(1).name", equalTo("Jane"))
            ;
        }
    */
 /*  private User createTestUsers(Long id, String firstName, String lastName, String sex, Long age) {
       User emp = new User(id, firstName, lastName, sex, age);
       return repository.saveAndFlush(emp);
   }*/

  /*  @Test

    public void testResponsecode() {


        Response resp = get("https://localhost:8080/users");

        int code = resp.getStatusCode();
        System.out.println(" Status code is " + code);
        Assert.assertEquals(code, 200);
    }*/


}



