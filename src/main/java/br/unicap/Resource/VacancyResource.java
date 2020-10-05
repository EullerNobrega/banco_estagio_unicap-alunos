package br.unicap.Resource;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.unicap.Service.VacancyService;
import br.unicap.Service.serviceInterface.IVacancyService;
import br.unicap.model.Vacancy;

@Path("/vacancies")
public class VacancyResource {
    IVacancyService vacancyService = new VacancyService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacancy> fetchAll() {
        return vacancyService.list();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") Long id) {
        Vacancy v = vacancyService.get(id);
        return Response.ok().entity(v).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Vacancy vacancy) {
        vacancyService.save(vacancy);

        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("id") Long id, Vacancy vacancy) {
        vacancyService.update(id,vacancy);
        return Response.status(Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        vacancyService.delete(id);
        return Response.status(Status.ACCEPTED).build();
    }

}
