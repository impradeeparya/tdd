package in.helloroomie.dao.common;

import in.helloroomie.domain.city.City;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 17/12/16
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"classpath:applicationconfiguration/test/mvc-dispatcher-servlet-test.xml"})
public class CommonDaoImplTest {

    @Autowired
    ICommonDao commonDao;

    @Test
    public void shouldReturnAllCities() {
        List<City> cities = commonDao.getAllCities();
        Assert.assertTrue(cities.size() > 0);
    }
}
