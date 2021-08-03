package com.api.entities.booking.response;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author in-vinaykumar.gupta on 02/08/21
 * @project IntelliJ IDEA
 */
public class GetBookingResponse {
    public List<BookingId> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<BookingId> bookingIds) {
        this.bookingIds = bookingIds;
    }

    private List<BookingId> bookingIds;
    public void assertMinimumBookingTobePresent(int minBooking) {
        assertTrue(bookingIds.size()>minBooking);
    }
    public void assertBookingIds() {
        for(BookingId booking:bookingIds)
        {
            assertNotNull(booking);
        }
    }
}
