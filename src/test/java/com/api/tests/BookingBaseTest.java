package com.api.tests;

import com.api.entities.booking.request.CreateBookingRequest;
import com.api.entities.booking.response.*;
import com.api.util.ResponseHelper;
import com.jayway.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.util.List;

import static org.testng.Assert.assertEquals;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class BookingBaseTest {
    public CreateBookingResponse createBookingId(CreateBookingRequest bookingRequest) throws IOException {
        Response response = new BookingResource().returnCreateBookingIdResponse(bookingRequest);
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        return (CreateBookingResponse) ResponseHelper.getResponseObject(response.asString(), CreateBookingResponse.class);
    }
    public UpdateBookingResponse updateBookingId(CreateBookingRequest bookingRequest,int bookingId) throws IOException {
        Response response = new BookingResource().returnUpdateBookingIdResponse(bookingRequest,bookingId);
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        return (UpdateBookingResponse) ResponseHelper.getResponseObject(response.asString(), UpdateBookingResponse.class);
    }
    public List<BookingId> getListOfBookingIds() throws IOException {
        Response response = new BookingResource().returnListOfBookingIds();
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        List<BookingId> asList = (List<BookingId>) ResponseHelper.getResponseObjectForStarArray(response.asString(), BookingId.class);
        return asList;
    }
    public GetSingleBookingIdResponse getBookingInformationOfBookingId(int bookingId) throws IOException {
        Response response = new BookingResource().returnBookingInformationOfBookingIds(bookingId);
        assertEquals(response.getStatusCode(), HttpStatus.SC_OK);
        return (GetSingleBookingIdResponse) ResponseHelper.getResponseObject(response.asString(), GetSingleBookingIdResponse.class);
    }
    public void deleteBooking(int bookingId) throws IOException {
        Response response = new BookingResource().retunDeleteBookingResponse(bookingId);
        assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);
    }

}
