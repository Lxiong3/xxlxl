import com.newthread.framework.entity.Farmer;
import com.newthread.framework.entity.Products;
import com.newthread.framework.service.FarmersService;
import com.newthread.framework.service.FarmersServiceImpl;
import org.junit.Test;

import java.util.List;

/**
 * @author:LEI XIONG
 */

public class FarmerTests {

    private FarmersService farmersService = new FarmersServiceImpl();

    @Test
    public void addProduces() {

        Products p = new Products();
        p.setEnd_date("SDSS");
        p.setGcpid("23423");
        p.setName("APPLE");

        farmersService.addProduces(1,p);

    }

    @Test
    public void createFarm() {

        Farmer farmer = new Farmer();
        farmer.setFid(1231);
        farmer.setPersonal_info(new Farmer.PersonalInfoBean("tom", "123423@165.com", "1123"));
        farmersService.createFarm(farmer);
    }

    @Test
    public void update() {
        Farmer farmer = farmersService.getFarmer(1);
        farmer.setFid(12322221);
        farmer.setPersonal_info(new Farmer.PersonalInfoBean("tom", "122333423@165.com", "1123"));
        farmersService.update(farmer);
    }


    @Test
    public void getProducts() {

        Farmer farmer = farmersService.getFarmer(1);

        System.out.println(farmersService.getProducts(farmer.getFid()).get(0));
        ;
    }


}
