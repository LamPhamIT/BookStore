package com.shinn.api.resource.v1;

import com.shinn.dao.idao.ICartDAO;
import com.shinn.dao.impl.CartDAO;
import com.shinn.model.CartModel;
import com.shinn.services.IService.ICartService;
import com.shinn.services.impl.CartService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.ArrayList;
import java.util.List;

@Path("v1/carts")
public class CartResource {


    private ICartService cartService;

    public CartResource() {
        cartService = new CartService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<CartModel> find(@QueryParam("cart_id") Long cartId, @QueryParam("user_id") Long userId) {
        List<CartModel> list = new ArrayList<>();
        if (cartId == null && userId == null) {
            list = cartService.findAll();
        } else if (cartId == null && userId != null) {
            list = cartService.findByUserId(userId);
        } else if (cartId != null && userId == null) {
            list.add(cartService.findByCartId(cartId));
        } else if (cartId != null && userId != null) {
        }
        return list;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CartModel insert(CartModel cartModel) {
        Long id = cartService.insert(cartModel);
        return cartService.findByCartId(id);
    }
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public CartModel update(CartModel cartModel) {
        return cartService.update(cartModel);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(CartModel cartModel) {
        cartService.delete(cartModel);
    }
}
