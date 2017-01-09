package com.busnoseat.demoWeb.integration.bean.user;

import com.busnoseat.common.facade.abs.AbsRequestBean;
import com.busnoseat.common.pagination.Page;
import com.busnoseat.demoWeb.integration.vo.UserVo;

/**
 * The type UserRequestBean.
 *
 * @author xubo
 * @Description:
 * @Date 2017/1/4
 */
public class UserRequestBean extends AbsRequestBean {
    private Page page;
    private UserVo userVo;

    public Page getPage() {
        return page;
    }

    public UserRequestBean(Page page, UserVo userVo) {
        this.page = page;
        this.userVo = userVo;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public UserVo getUserVo() {
        return userVo;
    }

    public void setUserVo(UserVo userVo) {
        this.userVo = userVo;
    }
}
