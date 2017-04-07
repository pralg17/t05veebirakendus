package app;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FormTest{


	@Autowired
	private ManageTable manager;

	@Test
	public void saveTest() {
		Salary salary = new Salary("M", "R", -1);
		manager.save(salary);
		Assert.assertNotNull(manager.findOne(salary.id));
	}
	@Test
	public void saveTest2(){
		Salary salary = new Salary("", "", 1000);
		manager.save(salary);
		Assert.assertNotNull(manager.findOne(salary.id));
		
	}

}