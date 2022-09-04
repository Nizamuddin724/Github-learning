package in.ashokit.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import in.ashokit.entity.EligibilityDetails;
public interface EligibilityDetailsRespo extends JpaRepository<EligibilityDetails, Integer> {
	@Query(value="select distinct(plan_name) from eligibility_details", nativeQuery = true)
	public List<String> findPlanNames();
	
	@Query(value="select distinct(plan_staus) from eligibility_details", nativeQuery = true)
	public List<String> findPlanStatuses();
	

}
