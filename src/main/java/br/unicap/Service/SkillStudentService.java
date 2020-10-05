package br.unicap.Service;

import java.util.List;

import br.unicap.Repository.SkillStudentRepository;
import br.unicap.Service.serviceInterface.IRemoveDepencies;

public class SkillStudentService implements IRemoveDepencies {
    SkillStudentRepository skillStudentRepository = new SkillStudentRepository();

    @Override
    public void removeDependecy(List<Long> list) {
        for (Long id : list) {
            skillStudentRepository.deleteById(id);
        }

    }

}
