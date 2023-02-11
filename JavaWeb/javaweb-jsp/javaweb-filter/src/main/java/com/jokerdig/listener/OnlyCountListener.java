package com.jokerdig.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author Joker大雄
 * @data 2022/4/9 - 10:32
 **/

// 统计网站在线人数
public class OnlyCountListener implements HttpSessionListener {

    // 创建session监听  session创建就触发
    public void sessionCreated(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onlyCount =(Integer) context.getAttribute("onlyCount");

        // 判断是否有人在线
        if(onlyCount==null){
            onlyCount= new Integer(1);
        } else {
            int count = onlyCount.intValue();
            onlyCount= new Integer(count+1);
        }
        context.setAttribute("onlyCount",onlyCount);

    }
    //销毁session监听  session销毁就触发
    public void sessionDestroyed(HttpSessionEvent se) {
        ServletContext context = se.getSession().getServletContext();
        Integer onlyCount =(Integer) context.getAttribute("onlyCount");
        // 判断是否有人在线
        if(onlyCount==null){
            onlyCount= new Integer(0);
        } else {
            int count = onlyCount.intValue();
            onlyCount= new Integer(count-1);
        }
        context.setAttribute("onlyCount",onlyCount);

        /*
            Session销毁：
                手动销毁 se.getSession().invalidate();
                自动销毁 在web.xml配置session-timeout
         */
    }
}
