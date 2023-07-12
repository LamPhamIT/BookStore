package com.shinn.api.resource.v1;

import com.shinn.model.ProductModel;
import com.shinn.paging.PageRequest;
import com.shinn.paging.Pageble;
import com.shinn.services.IService.IProductService;
import com.shinn.services.impl.ProductService;
import com.shinn.sort.Sorter;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.apache.commons.math3.stat.descriptive.summary.Product;

import java.util.ArrayList;
import java.util.List;


// JAX-RS
@Path("v1/books")
public class ProductResource {
    private IProductService productService;

    public ProductResource() {
        productService = new ProductService();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductModel> getAll(@QueryParam("page") Integer page, @QueryParam("maxPageItem") Integer maxPageItem,
                                     @QueryParam("SortBy") String sortBy, @QueryParam("sortName") String sortName, @QueryParam("productId") Long productId) {
        List<ProductModel> list;
        if (productId != null) {
            list = new ArrayList<>();
            list.add(productService.findOne(productId));
        } else {
            Pageble pageRequest = new PageRequest(page, maxPageItem, new Sorter(sortBy, sortName));
            list = productService.findAll(pageRequest);
        }
        return list;
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ProductModel saveOne(ProductModel product) {
        Long id = productService.save(product);
        return productService.findOne(id);
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void update(ProductModel product) {
        productService.update(product);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(ProductModel product) {
        productService.delete(product);
    }

}
