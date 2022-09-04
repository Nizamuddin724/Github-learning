package in.ashokit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.ashokit.entity.EligibilityDetails;
import in.ashokit.repo.EligibilityDetailsRespo;

@Component
public class AppRunner implements ApplicationRunner{
	@Autowired
	private EligibilityDetailsRespo repo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("-------inside Runner------");
		EligibilityDetails entity2=new EligibilityDetails();
		entity2.setEligId(3);
		entity2.setName("nizam");
		entity2.setEmail("nizam@725");
		entity2.setMobile(8686913958l);
		entity2.setGender('M');
		entity2.setSsn(666666l);
		entity2.setPlanName("MONtly");
		entity2.setPlanStaus("Approved");
		repo.save(entity2);
		
		EligibilityDetails entity3=new EligibilityDetails();
		entity3.setEligId(2);
		entity3.setName("amol");
		entity3.setEmail("amol@725");
		entity3.setMobile(8686913958l);
		entity3.setGender('M');
		entity3.setSsn(666666l);
		entity3.setPlanName("MONtly");
		entity3.setPlanStaus("denaied");
		repo.save(entity3);
		
	}

}
