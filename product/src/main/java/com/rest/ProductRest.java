package com.rest;

import javax.inject.Named;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Named
@Path("/")
public class ProductRest {
    private static List<Product> productsList = new ArrayList<Product>();

    static {
        Product product1 = new Product();
        product1.setId(1);
        product1.setType("Game");
        product1.setDescription("Game for kids");

        Product product2 = new Product();
        product2.setId(2);
        product2.setType("Toy");
        product2.setDescription("Toy for animals");

        Product product3 = new Product();
        product3.setId(3);
        product3.setType("Book");
        product3.setDescription("Book for students");

        Product product4 = new Product();
        product4.setId(4);
        product4.setType("Wine");
        product4.setDescription("Wine for adults");

        productsList.add(product1);
        productsList.add(product2);
        productsList.add(product3);
        productsList.add(product4);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProducts() {
        return productsList;
    }

    @GET
    @Path("product")
    @Produces(MediaType.APPLICATION_JSON)
    public Product getProduct(@QueryParam("id") long id) {
        Product product = null;
        for (Product p : productsList) {
            if (p.getId() == id) {
                product = p;
            }
        }
        return product;
    }
}
