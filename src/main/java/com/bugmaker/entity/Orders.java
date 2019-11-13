package com.bugmaker.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@Entity
public class Orders {
    private String orderNumber;
    private String title;
    private Timestamp time;   //
    private String address;
    private Integer pnumber; //
    private String event;
    private Integer reward; //
    private Timestamp aging; //
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
    public Timestamp getTime() {
        return time;
    }
    //由于要转换为json格式，所以这里要把Timestamp转化为String类型
    public String getTime(String flag) {
        return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time);
    }
    public void setTime(Timestamp time) {
        this.time = time;
    }
    //前端发过来的是String,spring必须要要求属性一致，所以这里额外添加一个set方法是String类型的，Spring就会找到这个set的方法，把值设置进去
    //同时也把String转为Timestamp类型，以便数据库插入时。属性一致
    public void setTime(String time) {
        this.time = Timestamp.valueOf(time);;
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
    public Integer getPnumber() {
        return pnumber;
    }
    public String getPnumber(String flag){
        return pnumber.toString();
    }
    public void setPnumber(Integer pnumber) {
        this.pnumber = pnumber;
    }
    public void setPnumber(String pnumber){
        this.pnumber=Integer.valueOf(pnumber);
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
    public Integer getReward() {
        return reward;
    }

    public void setReward(Integer reward) {
        this.reward = reward;
    }

    @Basic
    @Column(name = "Aging")
    public Timestamp getAging() {
        return aging;
    }
    public String getAging(String flag) {
        return  new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(aging);
    }

    public void setAging(Timestamp aging) {
        this.aging = aging;
    }
    public void setAging(String aging) {
        this.aging = Timestamp.valueOf(aging);
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

        Orders orders = (Orders) o;

        if (orderNumber != null ? !orderNumber.equals(orders.orderNumber) : orders.orderNumber != null) return false;
        if (title != null ? !title.equals(orders.title) : orders.title != null) return false;
        if (time != null ? !time.equals(orders.time) : orders.time != null) return false;
        if (address != null ? !address.equals(orders.address) : orders.address != null) return false;
        if (pnumber != null ? !pnumber.equals(orders.pnumber) : orders.pnumber != null) return false;
        if (event != null ? !event.equals(orders.event) : orders.event != null) return false;
        if (reward != null ? !reward.equals(orders.reward) : orders.reward != null) return false;
        if (aging != null ? !aging.equals(orders.aging) : orders.aging != null) return false;
        if (contact != null ? !contact.equals(orders.contact) : orders.contact != null) return false;
        if (seeker != null ? !seeker.equals(orders.seeker) : orders.seeker != null) return false;
        if (helper != null ? !helper.equals(orders.helper) : orders.helper != null) return false;
        if (orderStatus != null ? !orderStatus.equals(orders.orderStatus) : orders.orderStatus != null) return false;

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
        return "Orders{" +
                "orderNumber='" + orderNumber + '\'' +
                ", title='" + title + '\'' +
                ", time=" + time +
                ", address='" + address + '\'' +
                ", pnumber=" + pnumber +
                ", event='" + event + '\'' +
                ", reward=" + reward +
                ", aging=" + aging +
                ", contact='" + contact + '\'' +
                ", seeker='" + seeker + '\'' +
                ", helper='" + helper + '\'' +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
