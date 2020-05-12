package cn.stylefeng.guns.base.config.properties;

import lombok.Data;

/**
 * canal的配置
 *
 * @author fengshuonan
 * @date 2019-01-16-2:21 PM
 */
@Data
public class CanalProperties {

    /**
     * canal的地址
     */
    private String address;

    /**
     * canal的端口
     */
    private Integer port;

}
