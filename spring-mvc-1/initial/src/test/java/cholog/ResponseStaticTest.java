package cholog;

import static org.assertj.core.api.Assertions.assertThat;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ResponseStaticTest {

    /**
     * /static/index.html 정적 페이지를 찾은 이후 존재하지 않으면
     * /template/index. 형식의 템플릿 페이지를 찾는다.
     */
    @Test
    void responseIndexPage() {
        var response = RestAssured
            .given().log().all()
            .when().get("/")
            .then().log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    /**
     * 웰컴 페이지가 아니므로!
     * resources/static/static.html이 존재해야한다.
     */
    @Test
    void responseStaticPage() {
        var response = RestAssured
            .given().log().all()
            .when().get("/static.html")
            .then().log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }
}
