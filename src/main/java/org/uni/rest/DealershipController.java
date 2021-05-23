package org.uni.rest;

import lombok.Getter;
import lombok.Setter;
import org.uni.entities.Dealership;
import org.uni.persistance.DealershipPersistance;
import org.uni.rest.dto.DealershipDTO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
@Path("/dealerships")
public class DealershipController {
    @Inject
    @Setter
    @Getter
    private DealershipPersistance dealershipPersistance;

    @Path("/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getALl() {
        List<Dealership> dealerships = dealershipPersistance.loadAll();
        if (dealerships.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        List<DealershipDTO> dealershipDTOList = dealerships.stream()
                .map(DealershipDTO::formEntity)
                .collect(Collectors.toList());

        return Response.ok(dealershipDTOList).build();
    }

    @Path("/get/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") final Integer id) {
        Dealership dealershipTmp = dealershipPersistance.findOne(id);
        if (dealershipTmp == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(DealershipDTO.formEntity(dealershipTmp)).build();
    }

    @Path("/post")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(DealershipDTO dealershipDTO) {
        Dealership dealershipTmp = new Dealership();
        dealershipTmp.setName(dealershipDTO.getName());
        dealershipTmp.setLocation(dealershipDTO.getLocation());
        dealershipPersistance.persist(dealershipTmp);
        return Response.ok(Response.Status.OK).build();
    }

    @Path("/put")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(DealershipDTO dealershipDTO) {
        try {
            Dealership dealershipTmp = dealershipPersistance.findOne(dealershipDTO.getId());
            if (dealershipTmp == null) {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
            dealershipTmp.setName(dealershipDTO.getName());
            dealershipTmp.setLocation(dealershipDTO.getLocation());
            //dealershipTmp.setCars(dealershipDTO.getCars());
            //dealershipTmp.setSales(dealershipDTO.getSales());

            dealershipPersistance.update(dealershipTmp);
            return Response.ok(Response.Status.OK).build();
        } catch (OptimisticLockException ole) {
            return Response.status(Response.Status.CONFLICT).build();
        }
    }
}
