/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufpr.tads.services;

import br.ufpr.tads.bean.Mutante;
import br.ufpr.tads.bean.User;
import br.ufpr.tads.dao.MutanteDAO;
import br.ufpr.tads.dao.UserDAO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ArtVin
 */
@Path("mutantes")
public class MutantesResources {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of MutantesResources
     */
    public MutantesResources() {
    }
    
    @POST
    @Path("/mutante")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertMutante(Mutante mutante) {
        MutanteDAO dao = new MutanteDAO();
        if(dao.insertMutante(mutante) > 0)
            return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(mutante)
                .build();
        else
            return Response
                .status(Response.Status.CONFLICT)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
    
    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    public String postJson() {
        return null;
    }
    
    /**
     * Retrieves representation of an instance of Servidor.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/mutantes")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListMutante() {
        MutanteDAO dao = new MutanteDAO();
        List<Mutante> lista = dao.getListMutantes();
        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(lista)
                .build();
    }

    /**
     * Retrieves representation of an instance of Servidor.GenericResource
     * @param idMutante
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/id/{idMutante}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMutanteById(@PathParam("idMutante") int idMutante) {
        MutanteDAO dao = new MutanteDAO();
        Mutante mutante = dao.getMutante(idMutante);
        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(mutante)
                .build();
    }

    /**
     * Retrieves representation of an instance of Servidor.GenericResource
     * @param idMutante
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/nome/{nomeMutante}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMutanteByName(@PathParam("nomeMutante") String nomeMutante) {
        MutanteDAO dao = new MutanteDAO();
        Mutante mutante = dao.getMutante(nomeMutante);
        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(mutante)
                .build();
    }
    
    /**
     * Retrieves representation of an instance of Servidor.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/skills/{skill}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getListMutanteWithSkill(@PathParam("skill") String skill) {
        MutanteDAO dao = new MutanteDAO();
        List<Mutante> lista = dao.getListMutantesWithSkill(skill);
        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(lista)
                .build();
    }
    
    /**
     * PUT method for updating or creating an instance of MutantesResources
     * @param content representation for the resource
     */
    @PUT
    @Path("/mutante")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateMutante(Mutante mutante) {
        MutanteDAO dao = new MutanteDAO();
        if(dao.updateMutante(mutante))
            return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(mutante)
                .build();
        else
            return Response
                .status(Response.Status.CONFLICT)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
    
    /**
     * DELETE method for updating or creating an instance of MutantesResources
     * @param content representation for the resource
     */
    @DELETE
    @Path("/{idMutante}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteMutanteById(@PathParam("idMutante") int idMutante) {
        MutanteDAO dao = new MutanteDAO();
        if(dao.deleteMutante(idMutante))
            return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .build();
        else
            return Response
                .status(Response.Status.CONFLICT)
                .header("Access-Control-Allow-Origin", "*")
                .build();

    }
    
    /**
     * Retrieves representation of an instance of Servidor.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Path("/user/{userName}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserByName(@PathParam("userName") String userName) {
        UserDAO dao = new UserDAO();
        User usuario = dao.getUser(userName);
        return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(userName)
                .build();
    }

    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertUser(User user) {
        UserDAO dao = new UserDAO();
        if(dao.insertUser(user) > 0)
            return Response
                .status(Response.Status.OK)
                .header("Access-Control-Allow-Origin", "*")
                .entity(user)
                .build();
        else
            return Response
                .status(Response.Status.CONFLICT)
                .header("Access-Control-Allow-Origin", "*")
                .build();
    }
}
