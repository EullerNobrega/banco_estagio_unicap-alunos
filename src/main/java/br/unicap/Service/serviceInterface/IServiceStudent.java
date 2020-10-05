package br.unicap.Service.serviceInterface;

import java.util.List;

import br.unicap.model.Student;
// import br.unicap.model.StudentSkillVacancies;
import br.unicap.model.Vacancy;

public interface IServiceStudent {

    public void save(Student s);

    public void update(String registration ,Student s);

    public void delete(String registration);

    public List<Student> list();

    public Student get(String registration);

    public List<Vacancy> findVacancyForStudent(String registration);

}
