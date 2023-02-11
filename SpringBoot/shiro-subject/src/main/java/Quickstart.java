import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Simple Quickstart application showing how to use Shiro's API.
 *
 * @since 0.9 RC2
 */
public class Quickstart {

    private static final transient Logger log = LoggerFactory.getLogger(Quickstart.class);


    public static void main(String[] args) {

        //使用配置的
        //域、用户、角色和权限使用简单的INI配置。
        //我们将使用一个工厂来实现这一点，该工厂可以接收一个.ini文件并
        //返回SecurityManager实例：
        //使用shiro。 classpath下的ini文件
        //（file:and url：前缀分别从文件和url加载）：
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();

        //对于这个简单的示例quickstart，使用SecurityManager
        //可作为JVM单例访问。大多数应用程序不会这样做
        //而是依赖于它们的容器配置或web.xml
        //网络应用程序。这里不讲
        SecurityUtils.setSecurityManager(securityManager);

        // 现在设置了一个简单的Shiro环境，让我们看看您可以做什么

        // 获取当前正在执行的用户：
        Subject currentUser = SecurityUtils.getSubject();

        // 用会话做一些事情（不需要web或EJB容器！！！）
        // 获取session 并传递一些值
        Session session = currentUser.getSession();
        session.setAttribute("someKey", "aValue");
        // 获取session中的值存放在value 并判断是否与给session传递的值相同
        String value = (String) session.getAttribute("someKey");
        if (value.equals("aValue")) {
            log.info("Retrieved the correct value! [" + value + "]");
        }

        // 让我们登录当前用户，以便检查角色和权限：:
        if (!currentUser.isAuthenticated()) {
            // 创建一个Token
            UsernamePasswordToken token = new UsernamePasswordToken("lonestarr", "vespa");
            // 记住我
            token.setRememberMe(true);
            try {
                // 执行login方法，并传递token
                currentUser.login(token);
            } catch (UnknownAccountException uae) {
                log.info("There is no user with username of " + token.getPrincipal());
            } catch (IncorrectCredentialsException ice) {
                log.info("Password for account " + token.getPrincipal() + " was incorrect!");
            } catch (LockedAccountException lae) {
                log.info("The account for username " + token.getPrincipal() + " is locked.  " +
                        "Please contact your administrator to unlock it.");
            }
            // ... catch more exceptions here (maybe custom ones specific to your application?
            catch (AuthenticationException ae) {
                //unexpected condition?  error?
            }
        }

        //打印用户名:
        log.info("User [" + currentUser.getPrincipal() + "] logged in successfully.");

        // 测试一个角色
        if (currentUser.hasRole("schwartz")) {
            log.info("May the Schwartz be with you!");
        } else {
            log.info("Hello, mere mortal.");
        }

        //测试类型化权限（非实例级）
        if (currentUser.isPermitted("lightsaber:wield")) {
            log.info("You may use a lightsaber ring.  Use it wisely.");
        } else {
            log.info("Sorry, lightsaber rings are for schwartz masters only.");
        }

        //实例级权限((very powerful)
        if (currentUser.isPermitted("winnebago:drive:eagle5")) {
            log.info("You are permitted to 'drive' the winnebago with license plate (id) 'eagle5'.  " +
                    "Here are the keys - have fun!");
        } else {
            log.info("Sorry, you aren't allowed to drive the 'eagle5' winnebago!");
        }

        //注销
        currentUser.logout();

        System.exit(0);
    }
}