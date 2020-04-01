package com.mogul.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mogul.entity.User;
import com.mogul.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	private UserService userServiceImpl;
	/**
	 * 页面跳转
	 */
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
//	/**
//	 * 查询全部信息
//	 * @param model
//	 * @return
//	 */
//    @RequestMapping("/list")
//    public String findUserAll(Model model){
//    	List<User> user = userServiceImpl.findUserAll();
//    	model.addAttribute("user", user);
//    	return "user/list";
//    }
//	
    /**
     * 无条件分页查询
     * @param model
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("/list")
    public String findUserNoCriteria(Model model,@RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "size", defaultValue = "3") Integer size){
    	Page<User> user=userServiceImpl.findUserNoCriteria(page, size);
    	model.addAttribute("user", user);
				return "user/list";
    	
    }
    /*
     * @author qianliu on 2019/5/14 17:39
     * @Discription:跳转到增加用户页面
     */
    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    /*
     * @author qianliu on 2019/5/14 17:41
     * @param  "/add"链接
     * @return  重定向到/list页面
     * @Discription: 保存User实体到数据库，然后返回到list界面
     */
    @RequestMapping("/addUser")
    public String addUser(User user) {
        userServiceImpl.addUser(user);
        return "redirect:/user/list";
    }

    /*
     * @author qianliu on 2019/5/14 18:39
     * @param  /toEdit链接进入该程序
     * @return 查询出User以后，跳转到"user/userEdit"编辑界面
     * @Discription:
     */
    @RequestMapping("/toEdit")
    public String toEdit(Model model,Integer id) {
        User user=userServiceImpl.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    /*
     * @author qianliu on 2019/5/14 18:40
     * @param  "/edit"链接进入该程序
     * @return 重定向到"/list"链接
     * @Discription:更新数据库中的User以后跳转到list
     */
    @RequestMapping("/editUser")
    public String editUser(User user) {
        userServiceImpl.editUser(user);
        return "redirect:/user/list";
    }
  

    /*
     * @author qianliu on 2019/5/14 18:43
     * @param  "/delete"链接进入该方法
     * @return  重定向到"/list"
     * @Discription: 删除某一个数据后定向到"/list"
     */
    @RequestMapping("/delete")
    public String deleteUser(Integer id) {
        userServiceImpl.deleteUserById(id);
        return "redirect:/user/list";
    }
    
//    /**
//     * 无条件分页查询
//     * @param model
//     * @param page
//     * @param size
//     * @return
//     */
//    @RequestMapping("/findUserNoCriteria")
//    public String findUserNoCriteria(Model model,@RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "size", defaultValue = "3") Integer size){
//    	Page<User> datas=userServiceImpl.findUserNoCriteria(page, size);
//    	model.addAttribute("datas", datas);
//				return "user/index1";
//    	
//    }

}
