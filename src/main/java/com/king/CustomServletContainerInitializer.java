package com.king;

import com.king.filter.HelloWorldFilter;
import com.king.servlet.HelloWorldServlet;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import java.util.EnumSet;
import java.util.Set;
@HandlesTypes(value = {ServletContainerInitializer.class})
public class CustomServletContainerInitializer implements ServletContainerInitializer{
    private final static String JAR_HELLP_URL = "/hello";
    public void onStartup(Set<Class<?>> set, ServletContext servletContext) throws ServletException {
        System.out.println("感兴趣的类型：");
        if (set == null) {
            System.out.println("set == null");
            return;
        }
        for (Class<?> claz : set) {
            System.out.println(claz);
        }
        System.out.println("创建HellWorldServlet...");
        ServletRegistration.Dynamic servlet = servletContext.addServlet(
                HelloWorldServlet.class.getSimpleName(),
                HelloWorldServlet.class);
        servlet.addMapping(JAR_HELLP_URL);

        System.out.println("创建 helloWorldFilter...");
        FilterRegistration.Dynamic filter = servletContext.addFilter(
                HelloWorldFilter.class.getSimpleName(),
                HelloWorldFilter.class);

        EnumSet<DispatcherType> dispatcherTypes = EnumSet.allOf(DispatcherType.class);
        dispatcherTypes.add(DispatcherType.REQUEST);
        dispatcherTypes.add(DispatcherType.FORWARD);

        filter.addMappingForUrlPatterns(dispatcherTypes, true, JAR_HELLP_URL);
    }
}
