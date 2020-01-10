package cc.airson.im.server.rest.dao.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yuronghua-airson
 * @description PO: TechCategory
 * @template 2019.08.02 v11.0
 * @organization Zero One More, Inc. http://www.01more.com
 * @remark 分类表
 * @time 2019-12-13 17:56:27
 */
@Data
public class Category {

	/**
	 * 系统编号
	 */
	private Long id;
	
	/**
	 * 父节点系统编号
	 */
	private Long parentId;
	
	/**
	 * 分类名称
	 */
	private String categoryName;
	
	/**
	 * 排序优先级
	 */
	private String priority;
	
	/**
	 * 状态
	 */
	private Integer state;
	
	/**
	 * 创建用户id
	 */
	private Long createUserId;
	
	/**
	 * 创建用户名
	 */
	private String createUserName;
	
	/**
	 * 创建时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	/**
	 * 编辑用户id
	 */
	private Long updateUserId;
	
	/**
	 * 编辑用户名
	 */
	private String updateUserName;
	
	/**
	 * 编辑时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	
	
	
}