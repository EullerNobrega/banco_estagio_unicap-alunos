package br.unicap.Service;

import java.util.List;

import br.unicap.Repository.StudentRepository;
import br.unicap.Repository.UtilRepository;
import br.unicap.Service.serviceInterface.IServiceStudent;
import br.unicap.model.SkillStudent;
import br.unicap.model.Student;
import br.unicap.model.Vacancy;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import io.quarkus.panache.common.Sort;

public class StudentService implements IServiceStudent {
    PanacheRepository<Student> studentRepository = new StudentRepository();
    UtilRepository utilRepository = new UtilRepository();

    @Override
    public void save(Student s) {
        List<SkillStudent> skills = s.getSkills();
        for (SkillStudent ss : skills) {
            ss.setDescription(ss.getDescription().toUpperCase());
        }
        this.studentRepository.persist(s);

    }

    @Override
    public void update(String registration, Student s) {
        Student singleResult = this.studentRepository.find("registration", registration).singleResult();
        singleResult.setName(s.getName());
        singleResult.setEmail(s.getEmail());
       
    }

    @Override
    public void delete(String registration) {
        Student student = get(registration);
        List<Long> listIdSkill = utilRepository.listIdSkill(student.id);

        this.studentRepository.delete("registration", registration);

        SkillStudentService skillStudentService = new SkillStudentService();
        skillStudentService.removeDependecy(listIdSkill);

    }

    @Override
    public List<Student> list() {
        return this.studentRepository.listAll(Sort.by("registration"));
    }

    @Override
    public Student get(String registration) {
        return this.studentRepository.find("registration", registration).singleResult();
    }

    @Override
    public List<Vacancy> findVacancyForStudent(String registration) {
        Student find = studentRepository.find("registration", registration).singleResult();
        return utilRepository.lVacancies(find.id);
        
    }

}
