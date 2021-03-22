package com.dev.warehouse.bus.userinfo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dev.warehouse.bus.entity.UserInfo;
import com.dev.warehouse.bus.userinfo.mapper.UserInfoMapper;
import com.dev.warehouse.bus.userinfo.service.IUserInfoService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
