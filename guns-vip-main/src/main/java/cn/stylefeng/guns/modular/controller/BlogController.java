/**
 * Copyright 2018-2020 stylefeng & fengshuonan (https://gitee.com/stylefeng)
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cn.stylefeng.guns.modular.controller;


import cn.hutool.core.bean.BeanUtil;
import cn.stylefeng.guns.base.log.BussinessLog;
import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.core.constant.dictmap.BlogMap;
import cn.stylefeng.guns.modular.entity.Blog;
import cn.stylefeng.guns.modular.service.BlogService;
import cn.stylefeng.guns.modular.warpper.BlogWrapper;
import cn.stylefeng.guns.sys.core.constant.dictmap.DeleteDict;
import cn.stylefeng.guns.sys.core.log.LogObjectHolder;
import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.kernel.model.response.ResponseData;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * 通知控制器
 *
 * @author fengshuonan
 * @Date 2017-05-09 23:02:21
 */
@Controller
@RequestMapping("/blog")
public class BlogController extends BaseController {

    private String PREFIX = "/blog/";

    @Autowired
    private BlogService blogService;

    /**
     * 跳转到通知列表首页
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:06 PM
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "blog.html";
    }

    /**
     * 跳转到添加通知
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:06 PM
     */
    @RequestMapping("/blog_add")
    public String blogAdd() {
        return PREFIX + "blog_add.html";
    }

    /**
     * 跳转到修改通知
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:06 PM
     */
    @RequestMapping("/blog_update")
    public String blogUpdate() {
        return PREFIX + "blog_edit.html";
    }

    /**
     * 获取通知详情
     *
     * @author fengshuonan
     * @Date 2019/8/26 18:14
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ResponseData blogDetail(Long blogId) {
        Blog blog = this.blogService.getById(blogId);
        Map<String, Object> blogMap = BeanUtil.beanToMap(blog);
        return ResponseData.success(blogMap);
    }

    /**
     * 获取通知列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:06 PM
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        LambdaQueryWrapper<Blog> ew = new LambdaQueryWrapper<Blog>()
                .like(StringUtils.isNotBlank(condition), Blog::getArticleTitle, condition);
        Page<Map<String, Object>> list = this.blogService.listEw(ew);
        Page<Map<String, Object>> wrap = new BlogWrapper(list).wrap();
        return LayuiPageFactory.createPageInfo(wrap);
    }

    /**
     * 新增通知
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:06 PM
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    @BussinessLog(value = "新增通知", key = "title", dict = BlogMap.class)
    public Object add(Blog blog) {
        this.blogService.save(blog);
        return SUCCESS_TIP;
    }

    /**
     * 删除通知
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:06 PM
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    @BussinessLog(value = "删除通知", key = "blogId", dict = DeleteDict.class)
    public Object delete(@RequestParam Long blogId) {

        this.blogService.removeById(blogId);

        return SUCCESS_TIP;
    }

    /**
     * 修改通知
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:06 PM
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    @BussinessLog(value = "修改通知", key = "title", dict = BlogMap.class)
    public Object update(Blog blog) {
        this.blogService.updateById(blog);
        return SUCCESS_TIP;
    }

}
