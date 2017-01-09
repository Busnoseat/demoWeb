package com.busnoseat.demoWeb.controller;

import com.busnoseat.demoWeb.integration.bean.user.UserRequestBean;
import com.busnoseat.demoWeb.integration.bean.user.UserResponseBean;
import com.busnoseat.common.code.CommonRspCode;
import com.busnoseat.common.pagination.PaginationBean;
import com.busnoseat.demoWeb.integration.rest.user.UserClient;
import com.busnoseat.common.facade.abs.AbsResponseBean;
import com.busnoseat.common.pagination.Page;
import com.busnoseat.demoWeb.integration.vo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * The type UserController.
 *
 * @author xubo
 * @Description:
 * @Date 2017/1/4
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserClient userClient;

    @RequestMapping("/index")
    public String index(){
        return "user/index";
    }

    /**
     * 获取列表数据
     * @param model
     * @param page
     * @param userVo
     * @return String  用于页面跳转  并把数据放到modelMap里缓存
     */
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public String listUser(ModelMap model, Page page, UserVo userVo) {
        UserRequestBean requestBean = new UserRequestBean(page, userVo);
        UserResponseBean responseBean = userClient.queryUser(requestBean);
        if (CommonRspCode.SUCCESS.getCode().equals(responseBean.getRespCode())) {
            PaginationBean<UserVo> pagination = new PaginationBean<>(page, responseBean.getTotalRecord());
            pagination.setPageList(responseBean.getUserList());
            model.put("pagination", pagination);
        }
        return "/user/table";
    }

    /**
     *
     * @param model
     * @param userVo
     * @return String 返回新增或修改角色的页面
     */
    @RequestMapping(value = "/toModify", method = RequestMethod.POST)
    public String toModify(ModelMap model,UserVo userVo) {
        if(userVo.getUserId()==null){
            model.put("method", "add");
            model.put("userVo", userVo);
        }else{
            model.put("method", "update");
        }
        return "/user/modify";
    }

    /**
     *
     * @param userVo
     * @return AbsResponseBean 返回数据 并转换为json类型
     */
   @RequestMapping(value = "/update" ,method = RequestMethod.POST)
    public @ResponseBody AbsResponseBean modify(UserVo userVo){
     AbsResponseBean response=userClient.modifyUser(userVo);
        return response;
    }
}
