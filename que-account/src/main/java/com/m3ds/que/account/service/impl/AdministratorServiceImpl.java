package com.m3ds.que.account.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.m3ds.que.account.entity.po.Administrator;
import com.m3ds.que.account.mapper.AdministratorMapper;
import com.m3ds.que.account.service.IAdministratorService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wjs
 * @since 2023-02-26
 */
@Service
public class AdministratorServiceImpl extends ServiceImpl<AdministratorMapper, Administrator> implements IAdministratorService {

}
