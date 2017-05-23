package alari;

import org.junit.*;
import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class EsimeneTest{
	@Test
	public void isikukoodiTest(){
		Rakendus r=new Rakendus();
		assertEquals("Tere, Alari Verev, Teie isikukood on 39511020244!", r.isik("Alari", "Verev", "39511020244"));
		assertEquals("Tere, Olari Verev, Teie isikukood on 39511020233!", r.isik("Olari", "Verev", "39511020233"));
	}
}
