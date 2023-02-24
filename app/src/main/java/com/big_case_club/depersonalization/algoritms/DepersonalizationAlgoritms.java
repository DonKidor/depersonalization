package com.big_case_club.depersonalization.algoritms;

import com.big_case_club.depersonalization.model.personalize.PersonalizeData;
import org.springframework.stereotype.Component;

@Component
public class DepersonalizationAlgoritms {
    public void depersonalizeFullName(PersonalizeData data) {
        data.setFullName("DEPERSONALIZED_NAME");
    }
}
