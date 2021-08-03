package com.api.entities.booking.request;

/**
 * @author in-vinaykumar.gupta on 01/08/21
 * @project IntelliJ IDEA
 */
public class CreateBookingRequest {
    private String firstname;

    private String lastname;

    private int totalprice;

    private boolean depositpaid;

    private Bookingdates bookingdates;

    private String additionalneeds;

    public void setFirstname(String firstname){
        this.firstname = firstname;
    }
    public String getFirstname(){
        return this.firstname;
    }
    public void setLastname(String lastname){
        this.lastname = lastname;
    }
    public String getLastname(){
        return this.lastname;
    }
    public void setTotalprice(int totalprice){
        this.totalprice = totalprice;
    }
    public int getTotalprice(){
        return this.totalprice;
    }
    public void setDepositpaid(boolean depositpaid){
        this.depositpaid = depositpaid;
    }
    public boolean getDepositpaid(){
        return this.depositpaid;
    }
    public void setBookingdates(Bookingdates bookingdates){
        this.bookingdates = bookingdates;
    }
    public Bookingdates getBookingdates(){
        return this.bookingdates;
    }
    public void setAdditionalneeds(String additionalneeds){
        this.additionalneeds = additionalneeds;
    }
    public String getAdditionalneeds(){
        return this.additionalneeds;
    }
}
