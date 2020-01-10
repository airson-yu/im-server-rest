package cc.airson.im.server.rest.dao.po;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author yuronghua-airson
 * @description PO: TechLoginLog
 * @template 2019.08.02 v11.0
 * @organization Zero One More, Inc. http://www.01more.com
 * @remark 登录日志表
 * @time 2019-12-13 17:56:27
 */
@Data
public class LoginLog {

	/**
	 * 
	 */
	private Long id;
	
	/**
	 * 用户ID
	 */
	private Long userId;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 账号
	 */
	private String account;
	
	/**
	 * 登录IP
	 */
	private String loginIp;
	
	/**
	 * 登录时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date loginTime;
	
	
	
}