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

import br.unicap.Service.StudentService;
import br.unicap.Service.serviceInterface.IServiceStudent;
import br.unicap.model.Student;
// import br.unicap.model.StudentSkillVacancies;
import br.unicap.model.Vacancy;

@Path("/students")
public class StudentResource {
    IServiceStudent studentService = new StudentService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Student> fetchAll() {
        return studentService.list();
    }

    @GET
    @Path("/{registration}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("registration") String registration) {
        Student s = studentService.get(registration);
        return Response.ok().entity(s).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response create(Student student) {
        studentService.save(student);

        return Response.status(Status.CREATED).build();
    }

    @PUT
    @Path("/{registration}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Transactional
    public Response update(@PathParam("registration") String registration, Student student) {
        studentService.update(registration, student);
        return Response.status(Status.ACCEPTED).build();
    }

    @DELETE
    @Path("/{registration}")
    @Transactional
    public Response delete(@PathParam("registration") String registration) {
        studentService.delete(registration);
        return Response.status(Status.ACCEPTED).build();
    }

    @GET
    @Path("/{registration}/vacancies")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Vacancy> findVacanciesForStudent(@PathParam("registration") String registration) {
        List<Vacancy> findVacancyForStudent = studentService.findVacancyForStudent(registration);
        return findVacancyForStudent;
    }

}
