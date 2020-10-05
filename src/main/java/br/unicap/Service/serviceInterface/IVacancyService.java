package br.unicap.Service.serviceInterface;

import java.util.List;

import br.unicap.model.Student;
import br.unicap.model.Vacancy;

public interface IVacancyService {

   public void save(Vacancy v);

   public void update(Long id, Vacancy v);

   public void delete(Long id);

   public List<Vacancy> list();

   public Vacancy get(Long id);

   public List<Student> findStudentsForVacancy(Long id);
}
