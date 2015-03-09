package com.njit.lib.service;

import java.util.Collection;
import java.util.List;

import com.njit.lib.base.DaoSupport;
import com.njit.lib.domain.Privilege;

public interface PrivilegeService extends DaoSupport<Privilege> {

	Collection<String> getAllPrivilegeUrls();
}
