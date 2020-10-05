package br.unicap.Service;

import java.util.List;

import br.unicap.Repository.UtilRepository;
import br.unicap.Repository.VacancyRepository;
import br.unicap.Service.serviceInterface.IVacancyService;
import br.unicap.model.RequirementVacancy;
import br.unicap.model.Student;
import br.unicap.model.Vacancy;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Sort;

public class VacancyService implements IVacancyService {
    PanacheRepository<Vacancy> vacancyRepository = new VacancyRepository();
    UtilRepository utilRepository = new UtilRepository();

    @Override
    public void save(Vacancy v) {
        List<RequirementVacancy> requirements = v.getRequirements();
        for (RequirementVacancy rv : requirements) {
            rv.setDescription(rv.getDescription().toUpperCase());
        }
        this.vacancyRepository.persist(v);

    }

    @Override
    public void update(Long id, Vacancy v) {
        Vacancy vacancy = this.vacancyRepository.findById(id);
        vacancy.setTitle(v.getTitle());
        vacancy.setEmail(v.getEmail());
        vacancy.setDescription(v.getDescription());
    }

    @Override
    public void delete(Long id) {
        List<Long> listIdSkill = utilRepository.listIdRequirement(id);
        this.vacancyRepository.delete("id", id);
        RequirementVacancyService requirementVacancyService = new RequirementVacancyService();
        requirementVacancyService.removeDependecy(listIdSkill);
    }

    @Override
    public List<Vacancy> list() {
        return this.vacancyRepository.listAll(Sort.by("id"));
    }

    @Override
    public Vacancy get(Long id) {
        return this.vacancyRepository.find("id", id).singleResult();
    }

    @Override
    public List<Student> findStudentsForVacancy(Long id) {
        // TODO Auto-generated method stub
        return null;
    }

}
