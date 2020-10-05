package br.unicap.Repository;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.unicap.model.RequirementVacancy;
import br.unicap.model.Vacancy;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

public class UtilRepository implements PanacheRepository {
    EntityManager entityManager = this.getEntityManager();

    public List<Long> listIdRequirement(Long vacancyId) {
        Query query = entityManager
                .createNativeQuery("SELECT vr.requirements_id FROM vacancy_requirementvacancy vr WHERE vr.Vacancy_id = "
                        + vacancyId.toString());
        List<BigInteger> resultList = query.getResultList();
        List<Long> list = new ArrayList();
        for (BigInteger bigInteger : resultList) {
            list.add(bigInteger.longValue());
        }
        return list;
    }

    public List<Long> listIdSkill(Long studentId) {

        Query query = entityManager.createNativeQuery(
                "SELECT ss.skills_id FROM student_skillstudent  ss WHERE ss.Student_id = " + studentId.toString());
        List<BigInteger> resultList = query.getResultList();
        List<Long> list = new ArrayList();
        for (BigInteger bigInteger : resultList) {
            list.add(bigInteger.longValue());
        }
        return list;

    }

    public List<Vacancy> lVacancies(Long id) {
        Query query = entityManager.createNativeQuery("SELECT v.id, v.title, " +
        "v.description, v.email, rv.descriptionRequirement FROM student_skillstudent sss " +
        "INNER JOIN skillstudent s " +
        "ON sss.skills_id = s.id " +
        "INNER JOIN requirementvacancy rv " +
        "ON rv.descriptionRequirement = s.descriptionSkill " +
        "INNER JOIN vacancy_requirementvacancy vrv " +
        "ON rv.id = vrv.requirements_id " +
        "INNER JOIN vacancy v " +
        "ON vrv.Vacancy_id = v.id " +
        "WHERE sss.student_id = " + id);

        List<Object[]> resultList = query.getResultList();
        List<Vacancy> vacancyResults = new ArrayList();

        for (Object[] objects : resultList) {
            Vacancy v = new Vacancy();
            v.setTitle((String)objects[1]);
            v.setDescription((String)objects[2]);
            v.setEmail((String)objects[3]);
            RequirementVacancy requirementVacancy = new RequirementVacancy();
            requirementVacancy.setDescription((String)objects[4]);
            List<RequirementVacancy> list = new ArrayList();
            list.add(requirementVacancy);
            v.setRequirements(list);
            vacancyResults.add(v);
        }
       
        return vacancyResults;
    }

}
