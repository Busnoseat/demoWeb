package com.busnoseat.demoWeb.integration.rest.user;

import com.busnoseat.common.facade.abs.AbsResponseBean;
import com.busnoseat.demoWeb.integration.bean.user.UserRequestBean;
import com.busnoseat.demoWeb.integration.bean.user.UserResponseBean;
import com.busnoseat.demoWeb.integration.vo.UserVo;

/**
 * The type UserClient.
 *
 * @author xubo
 * @Description:
 * @Date 2017/1/4
 */
public interface UserClient {

    /**
     * 查询用户
     * @param requestBean
     * @return
     */
    public UserResponseBean queryUser(UserRequestBean requestBean);

    /**
     * 新增用户
     * @param userVo（如果前后台是同一人开发 可以偷懒 直接使用后台的出入参）
     * @return
     */
    public AbsResponseBean modifyUser(UserVo userVo);
}
