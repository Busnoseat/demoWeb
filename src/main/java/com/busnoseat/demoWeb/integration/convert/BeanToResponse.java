package com.busnoseat.demoWeb.integration.convert;

import com.busnoseat.demo.facade.response.UserResponse;
import com.busnoseat.common.util.ConverterBeanUtil;
import com.busnoseat.demoWeb.integration.bean.user.UserResponseBean;
import com.busnoseat.demoWeb.integration.vo.UserVo;
import java.util.ArrayList;
import java.util.List;

/**
 * The type BeanToResponse.
 *
 * @author xubo
 * @Description:
 * @Date 2017/1/5
 */
public class BeanToResponse {

    public static UserResponseBean convert(UserResponse response) {
        UserResponseBean responseBean = new UserResponseBean();
        ConverterBeanUtil.copyBeanProperties(response, responseBean);
        List<UserVo> userVoList = new ArrayList<>();
        ConverterBeanUtil.copyListBeanPropertiesToList(response.getUserList(), userVoList, UserVo.class);
        responseBean.setUserList(userVoList);
        return responseBean;
    }
}
