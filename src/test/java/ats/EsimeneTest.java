package ats;

import org.junit.*;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EsimeneTest{
	@Test
	public void isikukoodiTest(){
		Rakendus r=new Rakendus();
		assertEquals("Tere, Ats Klemmer, Teie isikukood on 39511020244!", r.isik("Ats", "Klemmer", "39511020244"));
	}
}
