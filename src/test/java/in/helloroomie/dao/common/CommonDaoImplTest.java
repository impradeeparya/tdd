package in.helloroomie.dao.common;

import in.helloroomie.dao.AbstractDaoTest;
import in.helloroomie.domain.city.City;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: pradeep
 * Date: 17/12/16
 * Time: 11:19 PM
 * To change this template use File | Settings | File Templates.
 */

public class CommonDaoImplTest extends AbstractDaoTest {

    @Autowired
    ICommonDao commonDao;

    @Test
    @Transactional
    public void shouldReturnAllCities() {
        List<City> cities = commonDao.getAllCities();
        Assert.assertTrue(cities.size() > 0);
    }
}
