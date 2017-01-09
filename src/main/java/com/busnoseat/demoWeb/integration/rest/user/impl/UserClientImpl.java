package com.busnoseat.demoWeb.integration.rest.user.impl;

import com.busnoseat.common.code.CommonRspCode;
import com.busnoseat.common.facade.abs.BaseResponse;
import com.busnoseat.common.facade.abs.AbsResponseBean;
import com.busnoseat.common.util.ConverterBeanUtil;
import com.busnoseat.demo.facade.request.UserRequest;
import com.busnoseat.demo.facade.response.UserResponse;;
import com.busnoseat.demoWeb.integration.bean.user.UserRequestBean;
import com.busnoseat.demoWeb.integration.bean.user.UserResponseBean;
import com.busnoseat.demoWeb.integration.convert.BeanToResponse;
import com.busnoseat.demoWeb.integration.rest.user.UserClient;
import com.busnoseat.demoWeb.integration.vo.ConfigParmVo;
import com.busnoseat.demoWeb.integration.vo.ConfigUrlVo;
import com.busnoseat.demoWeb.integration.vo.UserVo;
import com.busnoseat.runtime.rest.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * The type UserClientImpl.
 *
 * @author xubo
 * @Description:
 * @Date 2017/1/4
 */

@Service
public class UserClientImpl implements UserClient{
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private ConfigUrlVo configUrlVo;
    @Resource
    private ConfigParmVo configParmVo;

    @Value("#{restClient}")
    private RestClient client;

    /**@see UserClient#queryUser(UserRequestBean) */
    public UserResponseBean queryUser(UserRequestBean requestBean) {
        UserResponseBean responseBean=new UserResponseBean();
        try {
            UserRequest request=new UserRequest();
            ConverterBeanUtil.copyBeanProperties(requestBean.getPage(),request);
            ConverterBeanUtil.copyBeanProperties(requestBean.getUserVo(),request);
            //step2:调用服务
            String url=configUrlVo.demoUrl+configParmVo.user;
            UserResponse response=client.get(url,request,UserResponse.class);
            //step3:返回结果
            responseBean=BeanToResponse.convert(response);
            return responseBean;
        } catch (Exception e) {
            logger.error("调用异常", e);
            responseBean.setRespCode(CommonRspCode.REST_ERROR.getCode());
            return responseBean;
        }
    }

    /**@see UserClient#modifyUser(UserVo)   */
    public AbsResponseBean modifyUser(UserVo userVo) {
        AbsResponseBean responseBean=new AbsResponseBean();
        try {
            UserRequest request=new UserRequest();
            ConverterBeanUtil.copyBeanProperties(userVo,request);
            //step2:调用服务
            String url=configUrlVo.demoUrl+configParmVo.user;
            BaseResponse response=client.post(url,request,BaseResponse.class);
            //step3:返回结果
            ConverterBeanUtil.copyBeanProperties(response,responseBean);
            return responseBean;
        } catch (Exception e) {
            logger.error("调用异常", e);
            responseBean.setRespCode(CommonRspCode.REST_ERROR.getCode());
            return responseBean;
        }
    }
}
