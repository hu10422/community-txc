package top.tanpu.community.service;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TxcServiceTest extends TestCase {

    @Autowired
    TxcService txcService;

    @Test
    public void contextLoads() {

        txcService.getFeedback();
    }

    @Test
    public void sslUtil(){

    }
}