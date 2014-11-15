package daotest;


import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/xssfrontview-servlet.xml", "classpath:applicationContext.xml"})
public class ShortdaoTest extends AbstractTransactionalJUnit4SpringContextTests {

}