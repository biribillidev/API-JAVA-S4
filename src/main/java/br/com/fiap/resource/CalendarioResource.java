package br.com.fiap.resource;

import br.com.fiap.bo.CalendarioBO;
import br.com.fiap.to.CalendarioTO;

import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/calendario")
public class CalendarioResource {
    private CalendarioBO calendarioBO = new CalendarioBO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        ArrayList<CalendarioTO> resultado = calendarioBO.findAll();
        Response.ResponseBuilder response = null;

        if (resultado != null){
            response = Response.ok(); // 200 - Ok
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        response.entity(resultado);
        return  response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(@Valid CalendarioTO calendario){
        CalendarioTO resultado = calendarioBO.save(calendario);
        Response.ResponseBuilder response = null;

        if (resultado != null){
            response = Response.created(null); // 201 - CREATED
        } else {
            response = Response.status(400); // 400 - BAD REQUEST
        }
        response.entity(resultado);
        return  response.build();
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") Long id){
        Response.ResponseBuilder response = null;
        if (calendarioBO.delete(id)){
            response = Response.status(204); // 204 - NO CONTENT
        } else {
            response = Response.status(404); // 404 - NOT FOUND
        }
        return response.build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") Long id, @Valid CalendarioTO calendarioAtualizado){

        calendarioAtualizado.setId(id);
        CalendarioTO resultado = calendarioBO.update(calendarioAtualizado);

        if (resultado != null){
            return Response.ok(resultado).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
