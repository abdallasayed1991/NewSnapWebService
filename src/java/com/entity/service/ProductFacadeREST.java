/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.service;

import com.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Administrator
 */
@Stateless
@Path("com.entity.product")
public class ProductFacadeREST extends AbstractFacade<Product> {
    @PersistenceContext(unitName = "newSnapWebServicePU")
    private EntityManager em;

    public ProductFacadeREST() {
        super(Product.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Product entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Product entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({"application/xml", "application/json"})
    public Product find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Product> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Product> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces("text/plain")
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    @GET
    @Path("getTopRequest")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> getTopRequest()
    {
        List<Product> topUsers = new ArrayList();
        for(Product p: findAll())
        {
            if (p.getProductState()== 0) {
                topUsers.add(p);
                if(topUsers.size()==5)
                    break;
            }
        }
        return topUsers;
    }
    
    @GET
    @Path("getAllRequest")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Product> getAllRequest()
    {
        List<Product> topUsers = new ArrayList();
        for(Product p: findAll())
        {
            if (p.getProductState()== 0) {
                topUsers.add(p);
            }
        }
        return topUsers;
    }
    
    @GET
    @Path("findProductByID")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Product findProductByID(@QueryParam("Product_ID") int Product_ID)
    {
        Product product = null;
        for(Product p: findAll())
        {
            if (p.getProductID()== Product_ID) {
                product = p;
                break;
            }
        }
        return product;
    }
    
    
    
}
