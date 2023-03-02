package com.m3ds.que.api.config;

import com.google.common.collect.Lists;
import com.m3ds.que.api.web.interceptor.AuthorizationInterceptor;
import com.m3ds.que.api.web.interceptor.NoRepeatSubmitInterceptor;
import com.m3ds.que.api.web.resolver.LoginUserHandlerMethodArgumentResolver;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;
import java.util.List;

/**
 * web mvc 配置
 *
 * @author smalljop
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * html静态资源   js静态资源    css静态资源
     */
    private final List<String> staticResources = Lists.newArrayList("/**/*.html",
            "/**/*.js",
            "/**/*.css",
            "/**/*.woff",
            "/**/*.ttf");

    @Autowired
    private AuthorizationInterceptor authorizationInterceptor;
    @Autowired
    private NoRepeatSubmitInterceptor noRepeatSubmitInterceptor;
    @Autowired
    private LoginUserHandlerMethodArgumentResolver loginUserHandlerMethodArgumentResolver;

    /**
     * 配置本地文件上传的虚拟路径和静态化的文件生成路径
     * 备注：这是一种图片上传访问图片的方法，实际上也可以使用nginx反向代理访问图片
     *
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        if (storageConfig.getOssType() == OssTypeEnum.LOCAL) {
//            // 文件上传
//            String uploadFolder = storageConfig.getUploadFolder();
//            uploadFolder = StringUtils.appendIfMissing(uploadFolder, File.separator);
//            registry.addResourceHandler(storageConfig.getAccessPathPattern())
//                    .addResourceLocations("file:" + uploadFolder);
//        }
//        //这句不要忘了，否则项目默认静态资源映射会失效
//        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        // swagger 配置
//        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//
//    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //所有路径都被拦截
        registry.addInterceptor(noRepeatSubmitInterceptor).addPathPatterns("/**").excludePathPatterns(staticResources);
        registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**").excludePathPatterns(staticResources);
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(loginUserHandlerMethodArgumentResolver);
    }
}