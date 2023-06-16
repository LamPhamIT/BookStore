package com.shinn.api.resource.v1;

import com.shinn.dao.idao.ICartDAO;
import com.shinn.dao.impl.CartDAO;
import com.shinn.model.CartModel;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("v1/carts")
public class CartResource {


    private ICartDAO cartDAO;
    public CartResource() {
        cartDAO =new CartDAO();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<CartModel> find(@QueryParam("cart_id") Long cartId, @QueryParam("user_id") Long userId) {
        List<CartModel> list = new ArrayList<>();
        if(cartId == null && userId == null) {
            list = cartDAO.findAll();
        } else if(cartId == null && userId != null) {
            list=cartDAO.findByUserId(userId);
        } else if(cartId != null && userId == null) {
            list.add(cartDAO.findByCartId(cartId));
        }
        return list;
    }

}
