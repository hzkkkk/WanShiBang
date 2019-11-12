package com.bugmaker.dao;

import com.bugmaker.entity.Order;
import org.springframework.stereotype.Repository;


public interface OrderDao {
    public void add(Order order);
}
