package com.shinn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderModel extends AbstractModel{
    private String fullname;
    private String email;
    private String phoneNumber;
    private String address;
    private String note;
    private Long shippingFee;
    private Long price;
    private OrderStatusModel orderStatus;
    private UserModel user;
    private List<OrderProductModel> listOrderProduct;
}
