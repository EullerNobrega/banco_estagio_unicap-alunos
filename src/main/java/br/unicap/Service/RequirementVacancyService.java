package br.unicap.Service;

import java.util.List;

import br.unicap.Repository.RequirementVacancyRepository;
import br.unicap.Service.serviceInterface.IRemoveDepencies;

public class RequirementVacancyService implements IRemoveDepencies {
    RequirementVacancyRepository requirementVacancyRepository = new RequirementVacancyRepository();

    @Override
    public void removeDependecy(List<Long> list) {
        for (Long id : list) {
            requirementVacancyRepository.deleteById(id);
        }

    }

}
