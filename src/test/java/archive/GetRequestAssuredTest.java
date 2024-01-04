package archive;

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
import archive.dto.CreateUserResponseDTO;
import archive.repository.UserRepository;
import archive.model.User;
import archive.dto.CreateUserRequestDTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class GetRequestAssuredTest {
    @LocalServerPort
    private int port;

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
        dto = new CreateUserRequestDTO("Michail", "Ivanov", "mean", 15L);

        given().log().body()
                .contentType("application/json").body(dto)
                .when().post("/user-create")
                .then().log().body()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    public void givenUser_whenGetUser_thenStatus200() {

        long id = createTestUsers(1L, "Michail", "Ivanov", "mean", 15L).getId();
        given().pathParam("id", id)
                .when().get("/users/{id}")
                .then().log().body().statusCode(HttpStatus.OK.value())
                .and().body("firstName", equalTo("Michail"));

    }

    @Test
    public void whenUpdateUser_thenStatus200() {

        long id = createTestUsers(1L, "Nikita", "Sidorov", "mean", 16L).getId();
        CreateUserResponseDTO userDto = new CreateUserResponseDTO(2L, "Michail", "Ivanov", "mean", 15L);
        given().pathParam("id", id).log().body().contentType("application/json").body(userDto).when()
                .put("/user-update/{id}").then().log().body().statusCode(HttpStatus.OK.value()).and()
                .body("firstName", equalTo("Michail"));
    }

    @Test
    public void givenPerson_whenDeleteUser_thenStatus200() {

        long id = createTestUsers(1L, "Nikita", "Sidorov", "mean", 16L).getId();
        given().pathParam("id", id).log().body().contentType("restfullapi/json").when().delete("/user-delete/{id}").then()
                .log().body().statusCode(HttpStatus.OK.value());
    }


    @Test
    public void givenPersons_whenGetUserPersons_thenStatus200() {

        long id = createTestUsers(0L, "Nikita", "Sidorov", "mean", 16L).getId();
        given().pathParam("id", id)
                .when().get("/users/{id}")
                .then().log().body()
                .statusCode(HttpStatus.OK.value())
                .and().body("firstName", equalTo("Nikita"));
    }


    private User createTestUsers(Long id, String firstName, String lastName, String sex, Long age) {

        User emp = new User(id, firstName, lastName, sex, age);
        return repository.saveAndFlush(emp);
    }
}



