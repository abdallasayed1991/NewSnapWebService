/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity.service;

import com.entity.Users;
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
@Path("com.entity.users")
public class UsersFacadeREST extends AbstractFacade<Users> {
    @PersistenceContext(unitName = "newSnapWebServicePU")
    private EntityManager em;

    public UsersFacadeREST() {
        super(Users.class);
    }

    @POST
    @Override
    @Consumes({"application/xml", "application/json"})
    public void create(Users entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({"application/xml", "application/json"})
    public void edit(@PathParam("id") Integer id, Users entity) {
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
    public Users find(@PathParam("id") Integer id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({"application/xml", "application/json"})
    public List<Users> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({"application/xml", "application/json"})
    public List<Users> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
    @Path("login")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Users logintest(@QueryParam("userEmail") String User_email,@QueryParam("User_Password") String User_Password)
    {
        Users user = null;
        for(Users u: findAll())
        {
            if (u.getUserEmail().equals(User_email)&&u.getUserPassword().equals(User_Password)) {
                user = u;
                break;
            }
        }
        return user;
    }
   
    @GET
    @Path("getTopRequest")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Users> getTopRequest()
    {
        List<Users> topUsers = new ArrayList();
        for(Users u: findAll())
        {
            if (u.getUserState() == 0) {
                topUsers.add(u);
                if(topUsers.size()==5)
                    break;
            }
        }
        return topUsers;
    }
    
    
    @GET
    @Path("findUserByID")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Users findUserByID(@QueryParam("User_ID") int User_ID)
    {
        Users user = null;
        for(Users u: findAll())
        {
            if (u.getUserID() == User_ID) {
                user = u;
                break;
            }
        }
        return user;
    }
    
    
}
