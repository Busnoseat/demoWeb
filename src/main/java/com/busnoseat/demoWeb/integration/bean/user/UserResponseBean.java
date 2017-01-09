package com.busnoseat.demoWeb.integration.bean.user;

import com.busnoseat.common.facade.abs.AbsResponseBean;
import com.busnoseat.demoWeb.integration.vo.UserVo;

import java.util.List;

/**
 * The type UserResponseBean.
 *
 * @author xubo
 * @Description:
 * @Date 2017/1/4
 */
public class UserResponseBean extends AbsResponseBean{
    private List<UserVo> userList;
    private Integer totalRecord;
    private Integer  totalPage;

    public List<UserVo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserVo> userList) {
        this.userList = userList;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}
