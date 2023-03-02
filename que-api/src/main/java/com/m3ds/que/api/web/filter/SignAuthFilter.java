package com.m3ds.que.api.web.filter;

import cn.hutool.core.map.MapUtil;
import cn.hutool.core.util.ObjectUtil;
import com.m3ds.que.api.config.PlatformSignProperties;
import com.m3ds.que.api.util.HttpUtils;
import com.m3ds.que.api.util.ResponseUtils;
import com.m3ds.que.api.util.SignUtils;
import com.m3ds.que.api.web.wrapper.BodyReaderHttpServletRequestWrapper;
import com.m3ds.que.common.core.exception.ResponseErrorType;
import com.m3ds.que.common.core.vo.Result;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.SortedMap;

/**
 * @description: 签名认证接口
 * @author: smalljop
 * @create: 2019-12-09 13:51
 **/
@Slf4j
@Data
public class SignAuthFilter implements Filter {

    private final static String TIMESTAMP_KEY_NAME = "timestamp";
    /**
     * 最大有效时间 默认 10秒钟失效 超出10s失效
     */
    private final static Long MAX_EFFECTIVE_TIMESTAMP = 10L * 1000;
    private PlatformSignProperties platformSignProperties;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        //是否配置了过滤
        AntPathMatcher matcher = new AntPathMatcher();
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        boolean existsMatch = false;
        // 跳过无需验证请求url
        for (String pattern : platformSignProperties.getIgnoreUrls()) {
            boolean match = matcher.match(pattern, httpServletRequest.getRequestURI());
            if (match) {
                existsMatch = true;
                break;
            }
        }
        // debug模式
        if (existsMatch) {
            filterChain.doFilter(request, response);
            return;
        } else {
            //包装request  获取里面包含的内容
            BodyReaderHttpServletRequestWrapper requestWrapper = null;
            if (!(request instanceof BodyReaderHttpServletRequestWrapper)) {
                requestWrapper = new BodyReaderHttpServletRequestWrapper(
                        (HttpServletRequest) request);
            }
            if (requestWrapper.getMethod().equals(RequestMethod.OPTIONS.name())) {
                return;
            }
            //获取全部参数
            SortedMap<String, Object> allParams = null;
            try {
                allParams = HttpUtils.getAllParams(requestWrapper);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //取出时间戳 做超时校验
            Long timestamp = MapUtil.getLong(allParams, TIMESTAMP_KEY_NAME);
            if (ObjectUtil.isNull(timestamp)) {
                ResponseUtils.outJson(response, Result.fail(ResponseErrorType.SIGN_FAIL));
                return;
            }
            Long diffTimestamp = System.currentTimeMillis() - timestamp;
            if (diffTimestamp > MAX_EFFECTIVE_TIMESTAMP) {
                ResponseUtils.outJson(response, Result.fail(ResponseErrorType.SIGN_FAIL));
                return;
            }
            //对参数进行签名验证
            boolean verifySign = SignUtils.verifySign(allParams, platformSignProperties.getSecret());
            if (verifySign) {
                filterChain.doFilter(requestWrapper, response);
                return;
            } else {
                ResponseUtils.outJson(response, Result.fail(ResponseErrorType.SIGN_FAIL));
            }
        }
    }
}




