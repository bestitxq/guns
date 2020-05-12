package cn.stylefeng.guns.modular.entity;

import com.baomidou.mybatisplus.annotation.*;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * <p>
 * 通知表
 * </p>
 *
 * @author stylefeng
 * @since 2019-04-01
 */
@Data
@TableName("`b3_solo_article")
public class Blog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "oId", type = IdType.AUTO)
    private String oId;
    /**
     * 文章标题
     */
    private String articleTitle;
    /**
     * 文章摘要 Markdown
     */
    private String articleAbstract;
    /**
     * 文章摘要纯文本
     */
    private String articleAbstractText;
    /**
     * 文章标签，英文逗号分隔
     */
    private String articleTags;
    /**
     * 文章作者 id
     */
    private String articleUserId;
    /**
     * 文章评论计数
     */
    private Integer articleCommentCount;
    /**
     * 文章浏览计数
     */
    private Integer articleViewCount;
    /**
     * 文章正文内容
     */
    private String articleContent;
    /**
     * 文章访问路径
     */
    private String articlePermalink;
    /**
     * 文章是否置顶
     */
    private String articlePutTop;
    /**
     * 文章创建时间戳
     */
    private Date createTime;
    /**
     * 文章更新时间戳
     */
    private Date updateTime;
    /**
     * 文章随机数，用于快速查询随机文章列表
     */
    private Double articleRandomDouble;
    /**
     * 文章关联的签名档 id
     */
    private String articleSignId;
    /**
     * 文章是否可以评论
     */
    private String articleCommentable;
    /**
     * 文章浏览密码，留空为不设置访问密码
     */
    private String articleViewPwd;
    /**
     * 文章首图地址
     */
    private String articleImg1URL;
    /**
     * 文章状态，0：已发布，1：草稿
     */
    private Integer articleStatus;

}