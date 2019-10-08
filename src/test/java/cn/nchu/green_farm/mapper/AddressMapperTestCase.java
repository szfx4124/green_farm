package cn.nchu.green_farm.mapper;

import cn.nchu.green_farm.entity.Address;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Choococo
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AddressMapperTestCase {

    @Resource
    private AddressMapper addressMapper;

    @Test // 增加收货地址数据【测试成功】
    public void addnew() {
        Address address = new Address();
        address.setUid(1);
        address.setName("小张老师");
        address.setIsDefault(0);
        Date now = new Date();
        address.setCreatedUser("Admin");
        address.setModifiedUser("Admin");
        address.setCreatedTime(now);
        address.setModifiedTime(now);
        Integer rows = addressMapper.addnew(address);
        System.err.println("rows=" + rows);
    }

    @Test
    public void getCountByUid() {
        Integer uid = 1;// 测试两个数据，一个是存在的，一个是不存在的用户id
        Integer count = addressMapper.getCountByUid(uid);
        System.err.println("count=" + count);
    }

    @Test // 显示收货地址列表
    public void findByUid() {
        Integer uid = 2;
        List<Address> list  = addressMapper.findByUid(uid);
        System.err.println("BEGIN.");
        for (Address address : list) {
            System.err.println("address=" + address);
        }
        System.err.println("END.");

    }

    @Test
    public void updateNonDefault() {
        // 将所有用户的收获地址全部设置为非默认
        Integer uid = 3;
        Integer rows = addressMapper.updateNonDefault(uid);
        System.err.println("rows=" + rows);
    }

    @Test
    public void updateDefault() {
        // 将特定的收获地址设置为默认
        Integer id = 4;
        String modifiedUser = "user";
        Date modifiedTime = new Date();
        Integer rows = addressMapper.updateDefault(id, modifiedUser, modifiedTime);
        System.err.println("rows=" + rows);
    }

    @Test // 第一次设计用于设为默认的比对数据
    public void findById() {
        Integer id = 13;
        Address address = addressMapper.findById(id);
        System.err.println("address=" + address);
    }

    @Test // 删除
    public void deleteById() {
        Integer id = 1;
        Integer rows = addressMapper.deleteById(id);
        System.err.println("rows=" + rows);
    }

    @Test
    public void findLastModified() {
        Integer uid = 3;
        Address address = addressMapper.findLastModified(uid);
        System.err.println("address= " + address);
    }

    @Test // 这里测试的数据要删除掉
    public void updateInfo() {
        Address address = new Address();
        address.setId(3);
        address.setName("小明");
        address.setAddress("新安家园8单元601室");
        addressMapper.updateInfo(address);
        System.err.println("OK.");
    }


}
