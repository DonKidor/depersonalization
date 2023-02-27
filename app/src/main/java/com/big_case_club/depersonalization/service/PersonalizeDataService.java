package com.big_case_club.depersonalization.service;

import com.big_case_club.depersonalization.model.personalize.PersonalizeData;
import com.big_case_club.depersonalization.repository.personalize.PersonalizeDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonalizeDataService {

    @Autowired
    private PersonalizeDataRepository personalizeDataRepository;

    public List<PersonalizeData> viewDatabase(String sorted) {
        List<PersonalizeData> out = new ArrayList<>();
        if(sorted == ""){
            out=personalizeDataRepository.findAllByOrderByIdAsc();
        }
        return out;
    }

    public PersonalizeData findDataById(Long id) {
        Optional<PersonalizeData> optionalData = personalizeDataRepository.findById(id);
        return optionalData.orElse(null);
    }

    public PersonalizeData saveData(PersonalizeData personalizeData) {
        return personalizeDataRepository.save(personalizeData);
    }

    public PersonalizeData updateData(PersonalizeData updatedPersonalizeData, Long id) {
        PersonalizeData existingPersonalizeData = personalizeDataRepository.findById(id).orElse(null);
        if (existingPersonalizeData != null && updatedPersonalizeData.getId().equals(id)) {
            return personalizeDataRepository.save(updatedPersonalizeData);
        }
        return null;
    }

    public void deleteAllData(){
        personalizeDataRepository.deleteAll();
    }

    public void deleteDataById(Long id) {
        personalizeDataRepository.deleteById(id);
    }
}
