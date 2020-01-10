package cc.airson.im.server.rest.dao.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yuronghua-airson
 * @description PO: TechArticle
 * @template 2019.08.02 v11.0
 * @organization Zero One More, Inc. http://www.01more.com
 * @remark 文章表
 * @time 2019-12-13 17:56:27
 */
@Data
public class Article {

	/**
	 * 
	 */
	private Long id;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 标题
	 */
	private String title;
	
	/**
	 * 副标题
	 */
	private String subhead;
	
	/**
	 * 描述
	 */
	private String description;
	
	/**
	 * 内容
	 */
	private String content;
	
	/**
	 * 内容文件链接
	 */
	private String url;
	
	/**
	 * 状态：1.正常 2.停用 9.异常 99.删除
	 */
	private Integer state;
	
	/**
	 * 类型：1.本人创建 2.转载 3.后台创建
	 */
	private Integer type;
	
	/**
	 * 等级：与权重对应，从低到高
	 */
	private Integer rank;
	
	/**
	 * 是否允许评论
	 */
	private String allowComment;
	
	/**
	 * 是否允许转载
	 */
	private String allowReprint;
	
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	/**
	 * 更新时间（自动更新）
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	
	
}