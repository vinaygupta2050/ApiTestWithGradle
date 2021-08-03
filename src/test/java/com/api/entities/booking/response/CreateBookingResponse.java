package com.api.entities.booking.response;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class CreateBookingResponse {
    private int bookingid;

    private Booking booking;

    public void setBookingid(int bookingid){
        this.bookingid = bookingid;
    }
    public int getBookingid(){
        return this.bookingid;
    }
    public void setBooking(Booking booking){
        this.booking = booking;
    }
    public Booking getBooking(){
        return this.booking;
    }
    public void assertResponse(){
        assertNotNull(bookingid);
        assertNotNull(booking.getFirstname());
        assertNotNull(booking.getLastname());
        assertNotNull(booking.getTotalprice());
        assertNotNull(booking.getDepositpaid());
        assertNotNull(booking.getBookingdates().getCheckin());
        assertNotNull(booking.getBookingdates().getCheckout());
        assertNotNull(booking.getAdditionalneeds());
    }

}
