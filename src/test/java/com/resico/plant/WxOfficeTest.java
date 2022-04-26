package com.resico.plant;

import com.resico.plant.office.WechatOfficeAccountService;
import com.resico.plant.office.WxOfficeConfig;
import com.resico.plant.office.model.WxToken;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class WxOfficeTest {

    @Autowired
    private WechatOfficeAccountService wechatOfficeAccountService;

    @Autowired
    private WxOfficeConfig wxOfficeConfig;

    @Test
    public void testToken(){

        WxToken token = wechatOfficeAccountService.getToken();
        log.info("token={}",token);

    }



}
