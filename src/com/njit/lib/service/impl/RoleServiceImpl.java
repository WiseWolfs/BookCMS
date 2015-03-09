package com.njit.lib.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.base.DaoSupportImpl;
import com.njit.lib.domain.Role;
import com.njit.lib.service.RoleService;
@Service
@Transactional
public class RoleServiceImpl extends DaoSupportImpl<Role> implements RoleService {

}
