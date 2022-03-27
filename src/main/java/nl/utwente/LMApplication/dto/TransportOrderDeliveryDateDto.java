package nl.utwente.LMApplication.dto;

import java.util.Date;

public class TransportOrderDeliveryDateDto {
    
    private int transportOrderId;
    private Date pickupDate;
    private Date proposedDeliveryDate;
    private Date confirmedDeliveryDate;

    public TransportOrderDeliveryDateDto(int transportOrderId, Date pickupDate, Date proposedDeliveryDate, Date confirmedDeliveryDate) {
        this.transportOrderId = transportOrderId;
        this.pickupDate = pickupDate;
        this.proposedDeliveryDate = proposedDeliveryDate;
        this.confirmedDeliveryDate = confirmedDeliveryDate;
    }


    public int getTransportOrderId() {
        return this.transportOrderId;
    }

    public void setTransportOrderId(int transportOrderId) {
        this.transportOrderId = transportOrderId;
    }

    public Date getPickupDate() {
        return this.pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getProposedDeliveryDate() {
        return this.proposedDeliveryDate;
    }

    public void setProposedDeliveryDate(Date proposedDeliveryDate) {
        this.proposedDeliveryDate = proposedDeliveryDate;
    }

    public Date getConfirmedDeliveryDate() {
        return this.confirmedDeliveryDate;
    }

    public void setConfirmedDeliveryDate(Date confirmedDeliveryDate) {
        this.confirmedDeliveryDate = confirmedDeliveryDate;
    }

}
