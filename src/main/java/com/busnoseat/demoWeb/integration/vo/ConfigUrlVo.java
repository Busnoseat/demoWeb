package com.busnoseat.demoWeb.integration.vo;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
/**
 * The type ConfigVo.
 *
 * @author xubo
 * @Description:
 * @Date 2017/1/5
 */

@Component
public class ConfigUrlVo {
    @Value("#{propertyConfigurer['demoUrl']}")
    public  String demoUrl;


}
