package nl.utwente.LMApplication.model;

public class TransportCompany {

    private int transportCompanyId;
    private String transportCompanyName;

    public TransportCompany(int transportCompanyId, String transportCompanyName) {
        this.transportCompanyId = transportCompanyId;
        this.transportCompanyName = transportCompanyName;
    }

    public int getTransportCompanyId() {
        return transportCompanyId;
    }

    public void setTransportCompanyId(int transportCompanyId) {
        this.transportCompanyId = transportCompanyId;
    }

    public String getTransportCompanyName() {
        return transportCompanyName;
    }

    public void setTransportCompanyName(String transportCompanyName) {
        this.transportCompanyName = transportCompanyName;
    }



}
