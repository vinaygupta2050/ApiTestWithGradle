package com.api.entities.booking.response;

/**
 * @author in-vinaykumar.gupta on 02/08/21
 * @project IntelliJ IDEA
 */
public class Bookingdates
{
    private String checkin;

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    private String checkout;


}