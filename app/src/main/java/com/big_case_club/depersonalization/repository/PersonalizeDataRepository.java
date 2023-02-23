package com.big_case_club.depersonalization.repository;

import com.big_case_club.depersonalization.model.PersonalizeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalizeDataRepository extends JpaRepository<PersonalizeData, Long> {
}