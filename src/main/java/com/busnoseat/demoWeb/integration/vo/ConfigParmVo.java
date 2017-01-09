package com.busnoseat.demoWeb.integration.vo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * The type ConfigVo.
 *
 * @author xubo
 * @Description:
 * @Date 2017/1/5
 */

@Component
public class ConfigParmVo {
    @Value("#{propertyConfigurer['demo_user']}")
    public  String user;


}
