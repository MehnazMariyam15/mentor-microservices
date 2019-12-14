package com.cognizant.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.userservice.model.Training;

@Repository
public interface TrainingRepository extends JpaRepository<Training, String> {

	@Query(value = "Select * FROM training t WHERE t.tg_status='PENDING' AND t.tg_me_id=?1 ", nativeQuery = true)
	public List<Training> getPendingList(Long id);

	@Query(value = "FROM Training t WHERE t.proposalStatus ='ACCEPTED' AND t.id=?1 ")
	public List<Training> getAcceptedList(Long id);

	@Query(value = "From Training t where t.id=?1")
	public Training findAllById(Long trainingId);

	@Query(value = "Select * FROM training t WHERE t.tg_me_id=?1 ", nativeQuery = true)
	public List<Training> getMentorList(Long id);

	@Query(value = "Select * FROM training t WHERE t.tg_tr_id=?1 ", nativeQuery = true)
	public List<Training> getMentorsList(Long id);
}
