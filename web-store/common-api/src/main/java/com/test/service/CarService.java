package com.test.service;

import com.test.domain.Orders;

import javax.servlet.http.HttpServletRequest;

public interface CarService {
     String addCarServlet(HttpServletRequest request);
     String showCar(HttpServletRequest request);
     String updateOrder(Orders orders, HttpServletRequest request);
}
