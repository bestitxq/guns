package cn.stylefeng.guns.modular.mapper;

import cn.stylefeng.guns.modular.entity.Blog;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * <p>
 * 通知表 Mapper 接口
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-07
 */
public interface BlogMapper extends BaseMapper<Blog> {

    /**
     * 获取通知列表
     */
    Page<Map<String, Object>> list(Page page, @Param("ew") LambdaQueryWrapper ew);

}
