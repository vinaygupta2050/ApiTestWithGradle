package com.api.tests;

import com.api.entities.booking.request.CreateBookingRequest;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.testng.Reporter;

import static com.api.util.Configuration.getConfiguration;
import static com.jayway.restassured.RestAssured.given;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class BookingResource {
    public Response returnCreateBookingIdResponse(CreateBookingRequest createBookingRequest) {
        RequestSpecification specification = given().request().with()
                .header("Content-Type", "application/json")
                .body(createBookingRequest);
        Response response = specification.when().post(getConfiguration().getBookingUrl());
        String str = response.asString().toString();
        System.out.println(str);
        return response;
    }
    public Response returnUpdateBookingIdResponse(CreateBookingRequest createBookingRequest,int bookingId) {
        RequestSpecification specification = given().request().with()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .body(createBookingRequest);
        Response response = specification.when().put(getConfiguration().getBookingUrl()+"/"+bookingId);
        String str = response.asString().toString();
        System.out.println(str);
        return response;
    }
    public Response returnListOfBookingIds() {
        String url = getConfiguration().getBookingUrl();
        RequestSpecification specification = given().request();
        Response response = specification.when().get(url);
        return response;
    }
    public Response returnBookingInformationOfBookingIds(int bookingId) {
        String url = getConfiguration().getBookingUrl();
        RequestSpecification specification = given().request();
        Response response = specification.when().get(url+"/"+bookingId);
        return response;
    }
    public Response retunDeleteBookingResponse(int bookingId) {
        String url = getConfiguration().getBookingUrl();
        RequestSpecification specification = given().request().with()
                .header("Content-Type", "application/json")
                .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=");
        Response response = specification.when().delete(url+"/"+bookingId);
        return response;
    }
}
