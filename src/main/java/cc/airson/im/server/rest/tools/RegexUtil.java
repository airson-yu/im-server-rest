package cc.airson.im.server.rest.tools;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//import org.apache.oro.text.regex.*;      

/**
 * 类简介: 使用正则表达式验证数据或提取数据,类中的方法全为静态的
 * 主要方法:1. isHardRegexpValidate(String source, String regexp)
 * 区分大小写敏感的正规表达式批配    *
 * 2. isSoftRegexpValidate(String source, String regexp)
 * 不区分大小写的正规表达式批配
 * 3. getHardRegexpMatchResult(String source, String regexp)
 * 返回许要的批配结果集(大小写敏感的正规表达式批配)
 * 4. getSoftRegexpMatchResult(String source, String regexp)
 * 返回许要的批配结果集(不区分大小写的正规表达式批配)
 * 5  getHardRegexpArray(String source, String regexp)
 * 返回许要的批配结果集(大小写敏感的正规表达式批配)
 * 6. getSoftRegexpMatchResult(String source, String regexp)
 * 返回许要的批配结果集(不区分大小写的正规表达式批配)
 * 7.  getBetweenSeparatorStr(final String originStr,final char leftSeparator,final char rightSeparator)
 * 得到指定分隔符中间的字符串的集合
 */
public class RegexUtil {

    //http://blog.csdn.net/kiss_vicente/article/details/8050816

    public static boolean match(String regexp, String str) {
        Pattern p = Pattern.compile(regexp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static final String ip_regexp = "\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}";

    /**
     * 存放各种正规表达式(以key->value的形式)
     */
    public static HashMap<String, String> regexpHash = new HashMap<String, String>();

    /**
     * 匹配图象
     * <p>
     * <p>
     * 格式: /相对路径/文件名.后缀 (后缀为gif,dmp,png)
     * <p>
     * 匹配 : /forum/head_icon/admini2005111_ff.gif 或 admini2005111.dmp
     * <p>
     * <p>
     * 不匹配: c:/admins4512.gif
     */
    public static final String icon_regexp = "^(/{0,1}\\w){1,}\\.(gif|dmp|png|jpg)$|^\\w{1,}\\.(gif|dmp|png|jpg)$";

    /**
     * 匹配email地址
     * <p>
     * <p>
     * 格式: XXX@XXX.XXX.XX
     * <p>
     * 匹配 : foo@bar.com 或 foobar@foobar.com.au
     * <p>
     * <p>
     * 不匹配: foo@bar 或 $$$@bar.com
     */
    public static final String email_regexp = "(?:\\w[-._\\w]*\\w@\\w[-._\\w]*\\w\\.\\w{2,3}$)";

    /**
     * 匹配匹配并提取url
     * <p>
     * <p>
     * 格式: XXXX://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX
     * <p>
     * 匹配 : http://www.suncer.com 或news://www
     * <p>
     * <p>
     * 提取(MatchResult matchResult=matcher.getMatch()):
     * matchResult.group(0)= http://www.suncer.com:8080/index.html?login=true
     * matchResult.group(1) = http
     * matchResult.group(2) = www.suncer.com
     * matchResult.group(3) = :8080
     * matchResult.group(4) = /index.html?login=true
     * <p>
     * 不匹配: c:\window
     */
    public static final String url_regexp = "(\\w+)://([^/:]+)(:\\d*)?([^#\\s]*)";

    /**
     * 匹配并提取http
     * <p>
     * <p>
     * 格式: http://XXX.XXX.XXX.XX/XXX.XXX?XXX=XXX 或 ftp://XXX.XXX.XXX 或 https://XXX
     * <p>
     * 匹配 : http://www.suncer.com:8080/index.html?login=true
     * <p>
     * <p>
     * 提取(MatchResult matchResult=matcher.getMatch()):
     * matchResult.group(0)= http://www.suncer.com:8080/index.html?login=true
     * matchResult.group(1) = http
     * matchResult.group(2) = www.suncer.com
     * matchResult.group(3) = :8080
     * matchResult.group(4) = /index.html?login=true
     * <p>
     * 不匹配: news://www
     */
    public static final String http_regexp = "(http|https|ftp)://([^/:]+)(:\\d*)?([^#\\s]*)";

    /**
     * 匹配日期
     * <p>
     * <p>
     * 格式(首位不为0): XXXX-XX-XX 或 XXXX XX XX 或 XXXX-X-X
     * <p>
     * <p>
     * 范围:1900--2099
     * <p>
     * <p>
     * 匹配 : 2005-04-04
     * <p>
     * <p>
     * 不匹配: 01-01-01
     */
    public static final String date_regexp = "^((((19){1}|(20){1})d{2})|d{2})[-\\s]{1}[01]{1}d{1}[-\\s]{1}[0-3]{1}d{1}$";// 匹配日期

    /**
     * 匹配电话
     * <p>
     * <p>
     * 格式为: 0XXX-XXXXXX(10-13位首位必须为0) 或0XXX XXXXXXX(10-13位首位必须为0) 或
     * <p>
     * (0XXX)XXXXXXXX(11-14位首位必须为0) 或 XXXXXXXX(6-8位首位不为0) 或
     * XXXXXXXXXXX(11位首位不为0)
     * <p>
     * <p>
     * 匹配 : 0371-123456 或 (0371)1234567 或 (0371)12345678 或 010-123456 或
     * 010-12345678 或 12345678912
     * <p>
     * <p>
     * 不匹配: 1111-134355 或 0123456789
     */
    public static final String phone_regexp = "^(?:0[0-9]{2,3}[-\\s]{1}|\\(0[0-9]{2,4}\\))[0-9]{6,8}$|^[1-9]{1}[0-9]{5,7}$|^[1-9]{1}[0-9]{10}$";

    /**
     * 匹配身份证
     * <p>
     * <p>
     * 格式为: XXXXXXXXXX(10位) 或 XXXXXXXXXXXXX(13位) 或 XXXXXXXXXXXXXXX(15位) 或
     * XXXXXXXXXXXXXXXXXX(18位)
     * <p>
     * <p>
     * 匹配 : 0123456789123
     * <p>
     * <p>
     * 不匹配: 0123456
     */
    public static final String ID_card_regexp = "^\\d{10}|\\d{13}|\\d{15}|\\d{18}$";

    /**
     * 匹配邮编代码
     * <p>
     * <p>
     * 格式为: XXXXXX(6位)
     * <p>
     * <p>
     * 匹配 : 012345
     * <p>
     * <p>
     * 不匹配: 0123456
     */
    public static final String ZIP_regexp = "^[0-9]{6}$";// 匹配邮编代码

    //public static final String non_special_char_regexp = "^[^'\"\\;,:-<>\\s].*$";
    public static final String non_special_char_regexp = "^[\\S\\s]*[`~@#&;<>/\\'\\!\\=\\$\\^\\*\\(\\)\\|\\{\\}\\:\\,\\-\\[\\]\\?\\+\\\\]{0}[\\S\\s]*$";
    // XXX 放开：\.（Pagination类中ascOrdesc参数需要用到） 2019年11月11日9:52:37
    public static final String special_char_regexp     = "^[\\S\\s]*[`~@#&;<>/\\'\\!\\=\\$\\^\\*\\(\\)\\|\\{\\}\\:\\,\\-\\[\\]\\?\\+\\\\]+[\\S\\s]*$";

    /**
     * 匹配非负整数（正整数 + 0)
     */
    public static final String non_negative_integers_regexp = "^\\d+$";

    /**
     * 匹配不包括零的非负整数（正整数 > 0)
     */
    public static final String non_zero_negative_integers_regexp = "^[1-9]+\\d*$";

    /**
     * 匹配正整数
     */
    public static final String positive_integer_regexp = "^[0-9]*[1-9][0-9]*$";

    /**
     * 匹配非正整数（负整数 + 0）
     */
    public static final String non_positive_integers_regexp = "^((-\\d+)|(0+))$";

    /**
     * 匹配负整数
     */
    public static final String negative_integers_regexp = "^-[0-9]*[1-9][0-9]*$";

    /**
     * 匹配整数
     */
    public static final String integer_regexp = "^-?\\d+$";

    /**
     * 匹配整数
     */
    public static final String state_regexp = "^[0-2]";

    /**
     * 匹配非负浮点数（正浮点数 + 0）
     */
    public static final String non_negative_rational_numbers_regexp = "^\\d+(\\.\\d+)?$";

    /**
     * 匹配正浮点数
     */
    public static final String positive_rational_numbers_regexp = "^(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*))$";

    /**
     * 匹配非正浮点数（负浮点数 + 0）
     */
    public static final String non_positive_rational_numbers_regexp = "^((-\\d+(\\.\\d+)?)|(0+(\\.0+)?))$";

    /**
     * 匹配负浮点数
     */
    public static final String negative_rational_numbers_regexp = "^(-(([0-9]+\\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\\.[0-9]+)|([0-9]*[1-9][0-9]*)))$";

    /**
     * 匹配浮点数
     */
    public static final String rational_numbers_regexp = "^(-?\\d+)(\\.\\d+)?$";

    /**
     * 匹配由26个英文字母组成的字符串
     */
    public static final String letter_regexp = "^[A-Za-z]+$";

    /**
     * 匹配由26个英文字母的大写组成的字符串
     */
    public static final String upward_letter_regexp = "^[A-Z]+$";

    /**
     * 匹配由26个英文字母的小写组成的字符串
     */
    public static final String lower_letter_regexp = "^[a-z]+$";

    /**
     * 匹配由数字和26个英文字母组成的字符串
     */
    public static final String letter_number_regexp = "^[A-Za-z0-9]+$";

    /**
     * 匹配由数字、26个英文字母或者下划线组成的字符串
     */
    public static final String letter_number_underline_regexp = "^\\w+$";

    /**
     * excel特殊字符替换
     */
    public static final String EXCEL_SPECICL_REG = "[`~@#&;<>/\\\\'\\\\!\\\\=\\\\$\\\\^\\\\*\\\\(\\\\)\\\\|\\\\{\\\\}\\\\:\\\\,\\\\-\\\\[\\\\]\\\\?\\\\+\\\\\\\\]";

    /**
     * 添加正规表达式 (以key->value的形式存储)
     *
     * @param regexpName 该正规表达式名称 `
     * @param regexp     该正规表达式内容
     */
    public void putRegexpHash(String regexpName, String regexp) {
        regexpHash.put(regexpName, regexp);
    }

    /**
     * 得到正规表达式内容 (通过key名提取出value[正规表达式内容])
     *
     * @param regexpName 正规表达式名称
     * @return 正规表达式内容
     */
    public String getRegexpHash(String regexpName) {
        if (regexpHash.get(regexpName) != null) {
            return (regexpHash.get(regexpName));
        } else {
            System.out.println("在regexpHash中没有此正规表达式");
            return "";
        }
    }

    /**
     * 清除正规表达式存放单元
     */
    public void clearRegexpHash() {
        regexpHash.clear();
        return;
    }

    /**
     * 大小写敏感的正规表达式批配
     *
     * @param source 批配的源字符串
     * @param regexp 批配的正规表达式
     * @return 如果源字符串符合要求返回真, 否则返回假 如:  Regexp.isHardRegexpValidate("ygj@suncer.com.cn",email_regexp) 返回真
     */
    public static boolean isHardRegexpValidate(String source, String regexp) {

		/* try     
		{      
		    // 用于定义正规表达式对象模板类型      
		    PatternCompiler compiler = new Perl5Compiler();      
		
		    // 正规表达式比较批配对象      
		    PatternMatcher matcher = new Perl5Matcher();      
		
		    // 实例大小大小写敏感的正规表达式模板      
		    Pattern hardPattern = compiler.compile(regexp);      
		
		    // 返回批配结果      
		    return matcher.contains(source, hardPattern);      
		
		}      
		catch (MalformedPatternException e)      
		{      
		    e.printStackTrace();      
		
		}      */
        return false;
    }
}
