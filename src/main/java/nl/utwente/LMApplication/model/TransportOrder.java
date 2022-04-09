package nl.utwente.LMApplication.model;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TransportOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer transportOrderId;
    private int salesOrderId;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Goods> goodsList;
    private int branchId;
    private int transportCompanyId;
    private int truckId;
    private double orderWeight;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pickupDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date proposedDeliveryDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date confirmedDeliveryDate;
    private String status;

    public TransportOrder() {
    }

    public TransportOrder(Integer transportOrderId, int salesOrderId, List<Goods> goodsList, int branchId,
            int transportCompanyId, int truckId, double orderWeight, Date creationDate, Date pickupDate,
            Date proposedDeliveryDate, Date confirmedDeliveryDate, String status) {
        this.transportOrderId = transportOrderId;
        this.salesOrderId = salesOrderId;
        this.goodsList = goodsList;
        this.branchId = branchId;
        this.transportCompanyId = transportCompanyId;
        this.truckId = truckId;
        this.orderWeight = orderWeight;
        this.creationDate = creationDate;
        this.pickupDate = pickupDate;
        this.proposedDeliveryDate = proposedDeliveryDate;
        this.confirmedDeliveryDate = confirmedDeliveryDate;
        this.status = status;
    }

    public int getSalesOrderId() {
        return this.salesOrderId;
    }

    public void setSalesOrderId(int salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public Integer getTransportOrderId() {
        return this.transportOrderId;
    }

    public void setTransportOrderId(Integer transportOrderId) {
        this.transportOrderId = transportOrderId;
    }

    public List<Goods> getGoodsList() {
        return this.goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    public int getBranchId() {
        return this.branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    public int getTransportCompanyId() {
        return this.transportCompanyId;
    }

    public void setTransportCompanyId(int transportCompanyId) {
        this.transportCompanyId = transportCompanyId;
    }

    public int getTruckId() {
        return this.truckId;
    }

    public void setTruckId(int truckId) {
        this.truckId = truckId;
    }

    public double getOrderWeight() {
        return this.orderWeight;
    }

    public void setOrderWeight(double orderWeight) {
        this.orderWeight = orderWeight;
    }

    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
