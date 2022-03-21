import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class API_Test
{
	//@Test
	public void Testcase1() {
		RequestSpecification request = RestAssured.given();
		RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
		Object email = given().when().get("/posts/1/comments").
				then().extract().response().body().path("[0].email");
		System.out.println("Email:- "+email);
		ValidatableResponse resp = given().
				param("userId", 1).
				when().get("https://jsonplaceholder.typicode.com/posts/").then();


		List<Integer> ids = new ArrayList<Integer>();
		int size = resp.extract().jsonPath().getList("$").size();
		for (int i = 0; i < size; i++) {
			int id = resp.extract().path("[" + i + "].id");
			if (id >= 1 && id <= 100) {
				ids.add(id);
			}

		}
	}
	//@Test
	public void testcase2()
	{
		RequestSpecification request1 = RestAssured.given();
		JSONObject requestParams = new JSONObject();
		requestParams.put("userId", "1");
		requestParams.put("title", "New Post");
		requestParams.put("body", "New post Body");
		request1.body(requestParams.toJSONString());
		Response response= request1.post("/posts");
		response.then().assertThat().statusCode(201);


	}
}
