package com.m3ds.que.api.web.filter;

import cn.hutool.core.util.StrUtil;
import com.anji.captcha.model.vo.CaptchaVO;
import com.anji.captcha.service.CaptchaService;
import com.google.common.collect.Lists;
import com.m3ds.que.api.util.ResponseUtils;
import com.m3ds.que.common.core.exception.ResponseErrorType;
import com.m3ds.que.common.core.util.SpringContextUtils;
import com.m3ds.que.common.core.vo.Result;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @author : smalljop
 * @description : 滑动验证码校验
 * @create : 2020-12-14 15:51
 **/
public class ValidateCodeFilter implements Filter {

    private List<String> validateUrls = Lists.newArrayList(
            "/login/account"
    );

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        // 如果提交请求地址不在validateUrls，则跳过过滤
        if (!StrUtil.containsAnyIgnoreCase(httpServletRequest.getRequestURI(),
                validateUrls.toArray(new String[validateUrls.size()]))) {
            filterChain.doFilter(request, response);
            return;
        }
        //从请求中获取slideCode
        String code = request.getParameter("slideCode");
        if (StrUtil.isBlank(code)) {
            ResponseUtils.outJson(response, Result.fail(ResponseErrorType.NEED_VERIFICATION));
            return;
        }
        CaptchaService captchaService = SpringContextUtils.getBean(CaptchaService.class);
        CaptchaVO vo = new CaptchaVO();
        vo.setCaptchaVerification(code);
        // 若验证失败
        if (!captchaService.verification(vo).isSuccess()) {
            ResponseUtils.outJson(response, Result.fail(ResponseErrorType.VALIDATE_CODE_FAIL));
            return;
        }
        filterChain.doFilter(request, response);
    }

}
