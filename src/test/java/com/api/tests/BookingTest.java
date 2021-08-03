package com.api.tests;

import com.api.entities.booking.request.CreateBookingRequest;
import com.api.entities.booking.request.UpdateBookingRequest;
import com.api.entities.booking.response.*;
import com.api.requestBuilders.BookingRequestBuilder;
import com.api.testData.BookingTestData;
import com.api.util.Categories;
import org.testng.annotations.Test;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class BookingTest extends BookingBaseTest{

    @Test(groups = Categories.BOOKING,dataProviderClass = BookingTestData.class, dataProvider = "newUserData")
    public void shouldCreateBookingId(String firstName,String lastname,int totalprice,boolean depositpaid,String checkin, String checkOut,String additionalneeds) throws Exception {
        CreateBookingRequest request = new BookingRequestBuilder(firstName,lastname,totalprice,depositpaid,checkin,checkOut,additionalneeds).build();
        CreateBookingResponse response = createBookingId(request);
        response.assertResponse();
    }
    @Test(groups = Categories.BOOKING)
    public void shouldUpdateSpecificBookingId() throws Exception {
        CreateBookingRequest request = new BookingRequestBuilder("Kuldeepkumar","Gupta",120,true,"2020-01-02","2020-01-06","Brunch").build();
        CreateBookingResponse response = createBookingId(request);
        response.assertResponse();
        int bookingId= response.getBookingid();
        String additionalFieldToUpdate = "Dinner";
        CreateBookingRequest updateRequest = new BookingRequestBuilder("Kuldeepkumar","Gupta",120,true,"2020-01-02","2020-01-06",additionalFieldToUpdate).build();
        UpdateBookingResponse updateResponse = updateBookingId(updateRequest,bookingId);
        updateResponse.assertUpdatedAdditionalDetailsField(additionalFieldToUpdate);
    }
    @Test(groups = Categories.BOOKING)
    public void shouldgGetListOfBookingIds() throws Exception {
        CreateBookingRequest firstBookingRequest = new BookingRequestBuilder("Kuldeepkumar","Gupta",120,true,"2020-01-02","2020-01-06","Brunch").build();
        CreateBookingResponse firstBookingResponse = createBookingId(firstBookingRequest);
        firstBookingResponse.assertResponse();
        CreateBookingRequest secondBookingRequest = new BookingRequestBuilder("Kuldeepkumar123","Gupta123",120,true,"2020-01-02","2020-01-06","Brunch").build();
        CreateBookingResponse secondBookingResponse = createBookingId(secondBookingRequest);
        secondBookingResponse.assertResponse();
        GetBookingResponse response = new GetBookingResponse();
        response.setBookingIds(getListOfBookingIds());
        //We are checking minimum booking to be present as 2. As we have created booking id for 2 people and we are making sure that minimum 2 booking is present.
        response.assertMinimumBookingTobePresent(2);
        response.assertBookingIds();
    }
    @Test(groups = Categories.BOOKING)
    public void shouldgGetBookingInformationOfSearchedBookingId() throws Exception {
        String firstName = "Kuldeepkumar";
        CreateBookingRequest request = new BookingRequestBuilder(firstName,"Gupta",120,true,"2020-01-02","2020-01-06","Brunch").build();
        CreateBookingResponse response = createBookingId(request);
        response.assertResponse();
        int bookingId= response.getBookingid();
        GetSingleBookingIdResponse getBookingIdResponse = getBookingInformationOfBookingId(bookingId);
        getBookingIdResponse.assertBookingInformation(firstName);

    }
    @Test(groups = Categories.BOOKING)
    public void shouldDeleteBookigId() throws Exception {
        String firstName = "Kuldeepkumar";
        CreateBookingRequest request = new BookingRequestBuilder(firstName,"Gupta",120,true,"2020-01-02","2020-01-06","Brunch").build();
        CreateBookingResponse response = createBookingId(request);
        response.assertResponse();
        int bookingId= response.getBookingid();
        deleteBooking(bookingId);
    }

}
