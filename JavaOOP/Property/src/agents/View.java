package agents;

import clients.Buyer;
import properties.Property;

import java.time.LocalDate;
import java.time.LocalTime;

public class View {
    private Property property;
    private Agent agent;
    private Buyer buyer;
    private LocalTime date;

    public View(Property property, Agent agent, Buyer buyer, LocalTime date) {
        this.property = property;
        this.agent = agent;
        this.buyer = buyer;
        this.date = date;
    }

    public Property getProperty() {
        return property;
    }

    public LocalTime getDate() {
        return date;
    }
}