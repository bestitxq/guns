package cn.stylefeng.guns.modular.service;


import cn.stylefeng.guns.base.pojo.page.LayuiPageFactory;
import cn.stylefeng.guns.modular.entity.Blog;
import cn.stylefeng.guns.modular.mapper.BlogMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * <p>
 * 通知表 服务实现类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
@Service
public class BlogService extends ServiceImpl<BlogMapper, Blog> {

    /**
     * 获取通知列表
     *
     * @author fengshuonan
     * @Date 2018/12/23 6:05 PM
     */
    public Page<Map<String, Object>> listEw(LambdaQueryWrapper<Blog> ew) {
        Page page = LayuiPageFactory.defaultPage();
        return this.baseMapper.list(page, ew);
    }

}
