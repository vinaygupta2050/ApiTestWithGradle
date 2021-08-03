package com.api.requestBuilders;

import com.api.entities.booking.request.Bookingdates;
import com.api.entities.booking.request.CreateBookingRequest;
import com.api.entities.booking.request.UpdateBookingRequest;

import java.text.ParseException;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class BookingRequestBuilder {
    CreateBookingRequest request;
    public BookingRequestBuilder(String firstName, String lastName, int totalPrice, boolean depositPaid, String checkinDate, String checkOutDate, String additionalNeeds) throws ParseException {
        Bookingdates bookingDate = new Bookingdates();
        bookingDate.setCheckin(checkinDate);
        bookingDate.setCheckout(checkOutDate);
        request = new CreateBookingRequest();
        request.setFirstname(firstName);
        request.setLastname(lastName);
        request.setTotalprice(totalPrice);
        request.setDepositpaid(depositPaid);
        request.setBookingdates(bookingDate);
        request.setAdditionalneeds(additionalNeeds);
    }
    public BookingRequestBuilder(String firstName,String lastName){
        request = new CreateBookingRequest();
        request.setFirstname(firstName);
        request.setLastname(lastName);
    }
    public CreateBookingRequest build(){
        return  request;
    }
}
