package com.m3ds.que.center.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.m3ds.que.center.entity.po.SubjectQue;
import com.m3ds.que.center.mapper.SubjectQueMapper;
import com.m3ds.que.center.service.ISkipService;
import com.m3ds.que.center.service.ISubjectQueService;
import org.springframework.stereotype.Service;

/**
 * Created by wjs on 2023/06/12
 */
@Service
public class SubjectQueServiceImpl extends ServiceImpl<SubjectQueMapper, SubjectQue> implements ISubjectQueService {
}
