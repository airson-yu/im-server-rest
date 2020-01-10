package cc.airson.im.server.rest.dao.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yuronghua-airson
 * @description PO: TechUser
 * @template 2019.08.02 v11.0
 * @organization Zero One More, Inc. http://www.01more.com
 * @remark 用户表
 * @time 2019-12-13 17:56:27
 */
@Data
public class User {

	/**
	 * 
	 */
	private Long id;
	
	/**
	 * 昵称
	 */
	private String userName;
	
	/**
	 * 真实姓名
	 */
	private String realName;
	
	/**
	 * 手机
	 */
	private String phone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 身份证
	 */
	private String idCard;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 状态：1.正常 2.停用 3.异常 99.删除
	 */
	private Integer state;
	
	/**
	 * 类型：1.普通用户 2.测试用户
	 */
	private Integer type;
	
	/**
	 * 等级：1.普通 2.VIP1 3.VIP2
	 */
	private Integer rank;
	
	/**
	 * 性别：1.未知 2.男 3.女 4.保密
	 */
	private Integer sex;
	
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
	
	/**
	 * 生日
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date birthday;
	
	/**
	 * 省
	 */
	private String province;
	
	/**
	 * 市
	 */
	private String city;
	
	/**
	 * 地址
	 */
	private String address;
	
	/**
	 * 头像地址
	 */
	private String avatar;
	
	/**
	 * 个人二维码
	 */
	private String qrCode;
	
	/**
	 * 个人主页
	 */
	private String url;
	
	/**
	 * 简介
	 */
	private String introduction;
	
	
	
}