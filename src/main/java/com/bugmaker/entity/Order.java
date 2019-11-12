package com.bugmaker.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Order {
    private String orderNumber;
    private String title;
    private String time;
    private String address;
    private String pnumber;
    private String event;
    private String reward;
    private String aging;
    private String contact;
    private String seeker;
    private String helper;
    private String orderStatus;

    @Id
    @Column(name = "OrderNumber")
    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Time")
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "Pnumber")
    public String getPnumber() {
        return pnumber;
    }

    public void setPnumber(String pnumber) {
        this.pnumber = pnumber;
    }

    @Basic
    @Column(name = "Event")
    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Basic
    @Column(name = "Reward")
    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
    }

    @Basic
    @Column(name = "Aging")
    public String getAging() {
        return aging;
    }

    public void setAging(String aging) {
        this.aging = aging;
    }

    @Basic
    @Column(name = "Contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Basic
    @Column(name = "Seeker")
    public String getSeeker() {
        return seeker;
    }

    public void setSeeker(String seeker) {
        this.seeker = seeker;
    }

    @Basic
    @Column(name = "Helper")
    public String getHelper() {
        return helper;
    }

    public void setHelper(String helper) {
        this.helper = helper;
    }

    @Basic
    @Column(name = "OrderStatus")
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (orderNumber != null ? !orderNumber.equals(order.orderNumber) : order.orderNumber != null) return false;
        if (title != null ? !title.equals(order.title) : order.title != null) return false;
        if (time != null ? !time.equals(order.time) : order.time != null) return false;
        if (address != null ? !address.equals(order.address) : order.address != null) return false;
        if (pnumber != null ? !pnumber.equals(order.pnumber) : order.pnumber != null) return false;
        if (event != null ? !event.equals(order.event) : order.event != null) return false;
        if (reward != null ? !reward.equals(order.reward) : order.reward != null) return false;
        if (aging != null ? !aging.equals(order.aging) : order.aging != null) return false;
        if (contact != null ? !contact.equals(order.contact) : order.contact != null) return false;
        if (seeker != null ? !seeker.equals(order.seeker) : order.seeker != null) return false;
        if (helper != null ? !helper.equals(order.helper) : order.helper != null) return false;
        if (orderStatus != null ? !orderStatus.equals(order.orderStatus) : order.orderStatus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderNumber != null ? orderNumber.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (pnumber != null ? pnumber.hashCode() : 0);
        result = 31 * result + (event != null ? event.hashCode() : 0);
        result = 31 * result + (reward != null ? reward.hashCode() : 0);
        result = 31 * result + (aging != null ? aging.hashCode() : 0);
        result = 31 * result + (contact != null ? contact.hashCode() : 0);
        result = 31 * result + (seeker != null ? seeker.hashCode() : 0);
        result = 31 * result + (helper != null ? helper.hashCode() : 0);
        result = 31 * result + (orderStatus != null ? orderStatus.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber='" + orderNumber + '\'' +
                ", title='" + title + '\'' +
                ", time='" + time + '\'' +
                ", address='" + address + '\'' +
                ", pnumber='" + pnumber + '\'' +
                ", event='" + event + '\'' +
                ", reward='" + reward + '\'' +
                ", aging='" + aging + '\'' +
                ", contact='" + contact + '\'' +
                ", seeker='" + seeker + '\'' +
                ", helper='" + helper + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
