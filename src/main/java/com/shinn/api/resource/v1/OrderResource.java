package com.shinn.api.resource.v1;

import com.shinn.model.OrderModel;
import com.shinn.services.IService.IOrderService;
import com.shinn.services.impl.OrderService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/order/details")
public class OrderResource {
    private IOrderService orderService;

    public OrderResource() {
        orderService = new OrderService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderModel> findByStatusId(@QueryParam("id") Long id) {
        List<OrderModel> list =  orderService.findByStatusId(id);
        return list;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateStatus(OrderModel orderModel) {
        orderService.updateStatus(orderModel.getId(), orderModel.getOrderStatus().getId());
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(OrderModel orderModel) {
        orderService.delete(orderModel);
    }
}
