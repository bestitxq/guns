package cn.stylefeng.guns.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * canal配置
 *
 * @author fengshuonan
 * @date 2019-01-16-2:19 PM
 */
@Configuration
public class CanalAutoConfiguration {

    /**
     * 注入工具
     *
     * @author fengshuonan
     * @Date 2019/12/11 14:51
     */
    @Bean(name = "springContextHolder")
    public SpringContextHolder customSpringContextHolder() {
        return new SpringContextHolder();
    }

}

