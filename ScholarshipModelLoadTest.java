import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;


public class ScholarshipModelLoadTest {

	@Test
	public void test() {
		ScholarshipModel testModel = new ScholarshipModel();
		ArrayList<Scholar> testScholars;
		//Name of a file with 4 scholars
		testModel.loadData("scholars.sch");
		
		testScholars = testModel.getScholars();
		
		//Check to see that 4 scholars were added
		Assert.assertEquals(testScholars.size(), 4);
	}

}
