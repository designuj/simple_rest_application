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
public class CustomerRest {
    private static List<Customer> customersList = new ArrayList<Customer>();

    static {
        Customer customer1 = new Customer();
        customer1.setId(1);
        customer1.setName("Bartek");
        customer1.setEmail("ba@rt.ek");

        Customer customer2 = new Customer();
        customer2.setId(2);
        customer2.setName("Slawek");
        customer2.setEmail("sl@aw.ek");

        Customer customer3 = new Customer();
        customer3.setId(3);
        customer3.setName("Wojtek");
        customer3.setEmail("wo@jt.ek");

        Customer customer4 = new Customer();
        customer4.setId(4);
        customer4.setName("Grzesiu");
        customer4.setEmail("grz@es.iu");

        customersList.add(customer1);
        customersList.add(customer2);
        customersList.add(customer3);
        customersList.add(customer4);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return customersList;
    }

    @GET
    @Path("customer")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getClient(@QueryParam("id") long id) {
        Customer customer = null;
        for (Customer c: customersList) {
            if (c.getId() == id) {
                customer = c;
            }
        }
        return customer;
    }
}
