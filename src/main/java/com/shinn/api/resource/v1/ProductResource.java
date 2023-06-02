package com.shinn.api.resource.v1;

import com.shinn.model.ProductModel;
import com.shinn.services.IService.IProductService;
import com.shinn.services.impl.ProductService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("v1/books")
public class ProductResource {
   private IProductService productService;
   public ProductResource() {
       productService = new ProductService();
   }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
   public List<ProductModel> getAll() {
       return productService.findAll();
   }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductModel saveOne(ProductModel product) {
        Long id = productService.save(product);
        return productService.findOne(id);
    }

}
