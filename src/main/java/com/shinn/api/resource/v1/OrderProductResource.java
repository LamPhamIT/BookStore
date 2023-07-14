package com.shinn.api.resource.v1;

import com.shinn.model.OrderProductModel;
import com.shinn.services.IService.IOrderProductService;
import com.shinn.services.impl.OrderProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/order/products")
public class OrderProductResource {
    private IOrderProductService orderProductService;
    public OrderProductResource() {
        orderProductService = new OrderProductService();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<OrderProductModel> findByOrderId(@QueryParam("id") Long id) {
        return orderProductService.findByOrderId(id);
    }

}
