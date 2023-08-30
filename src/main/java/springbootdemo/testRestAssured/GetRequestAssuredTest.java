package springbootdemo.testRestAssured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import springbootdemo.repository.UserRepository;
import springbootdemo.model.User;
import springbootdemo.dto.CreateUserRequestDTO;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class GetRequestAssuredTest {
    @LocalServerPort
    private int port;
    //private int port = 8080;
    @Autowired
    private UserRepository repository;

    @Before
    public void setup() {

        RestAssured.port = port;
    }

    @After
    public void resetDb() {
        repository.deleteAll();
        repository.flush();
    }

   @Test
    public void whenCreateUser_thenStatus201() {

       CreateUserRequestDTO dto;
       dto = new CreateUserRequestDTO("Michail","Ivanov","mean",15L);

       given().log().body()
                .contentType("application/json").body(dto)

                .when().post("/user-create")

                .then().log().body()
                .statusCode(HttpStatus.CREATED.value());
    }

  @Test
    public void givenUser_whenGetUser_thenStatus200() {

        long id = createTestUsers(1L,"Michail","Ivanov","mean",15L).getId();


        given().pathParam("id", id)

                .when().get("/users/{id}")

                .then().log().body().statusCode(HttpStatus.OK.value())
                .and().body("firstName", equalTo("Michail"));

    }

        @Test
        public void whenUpdatePerson_thenStatus200() {

                long id = createTestUsers(1L,"Nikita","Sidorov","mean",16L).getId();
                CreateUserRequestDTO userDto = new CreateUserRequestDTO("Michail","Ivanov","mean",15L);
                given().pathParam("id", id).log().body().contentType("application/json").body(userDto).when()
                        .put("/user-update/{id}").then().log().body().statusCode(HttpStatus.OK.value()).and()
                        .body("FirstName", equalTo("Michail"));
            }

        @Test
        public void givenPerson_whenDeletePerson_thenStatus200() {

            long id = createTestUsers(1L,"Nikita","Sidorov","mean",16L).getId();
            given().pathParam("id", id).log().body().contentType("application/json").when().delete("/user-delete/{id}").then()
                    .log().body().statusCode(HttpStatus.OK.value()).and().body("FirstName ", equalTo("Nikita"));

        }


    @Test
    public void givenPersons_whenGetPersons_thenStatus200() {
        long id = createTestUsers(0L,"Nikita","Sidorov","mean",16L).getId();
        //createTestUsers(1L,"Michail","Ivanov","mean",15L);
        given().pathParam("id", id)
                .when().get("/users/{id}")
                .then().log().body()
                .statusCode(HttpStatus.OK.value())
                .and().body("get(0).firstName ", equalTo("Nikita "));
                //.and().body("get(1).FirstName ", equalTo("Michail "));
    }


    private User createTestUsers(Long id, String firstName, String lastName, String sex, Long age) {
            User emp = new User(id, firstName, lastName, sex, age);
            return repository.saveAndFlush(emp);
        }
}



