package com.njit.lib.service.impl;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njit.lib.base.DaoSupportImpl;
import com.njit.lib.domain.Privilege;
import com.njit.lib.service.PrivilegeService;
@Service
@Transactional
@SuppressWarnings("unchecked")
public class PrivilegeServiceImpl extends DaoSupportImpl<Privilege> implements PrivilegeService{

	public Collection<String> getAllPrivilegeUrls() {
		return getSession().createQuery(
				"SELECT DISTINCT p.url FROM Privilege p WHERE p.url IS NOT NULL")
				.list();
	}
	

}
