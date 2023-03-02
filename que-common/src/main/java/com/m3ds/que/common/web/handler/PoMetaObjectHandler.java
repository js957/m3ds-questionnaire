package com.m3ds.que.common.web.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.m3ds.que.common.core.util.UserContextHolder;
import com.m3ds.que.common.web.entity.po.BasePo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Date;

/**
 * Created by wjs on 2023/02/19
 */
@Slf4j
@Component
public class PoMetaObjectHandler implements MetaObjectHandler {
    /**
     * 获取当前交易的用户，为空返回默认system
     *
     * @return
     */
    private String getCurrentUsername() {
        return StringUtils.defaultIfBlank(UserContextHolder.getInstance().getUsername(), BasePo.DEFAULT_USERNAME);
    }

    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName(BasePo.Fields.createdBy, getCurrentUsername(), metaObject);
        this.setFieldValByName(BasePo.Fields.createdTime, LocalDateTime.now(), metaObject);
        this.updateFill(metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName(BasePo.Fields.updatedBy, getCurrentUsername(), metaObject);
        this.setFieldValByName(BasePo.Fields.updatedTime, LocalDateTime.now(), metaObject);
    }
}
