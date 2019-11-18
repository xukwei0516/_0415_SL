package com.sy.service.common;

import com.sy.mapper.common.AuthorityMapper;
import com.sy.model.common.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthorityServiceImpl implements AuthorityService {


    @Autowired
    private AuthorityMapper authorityMapper;
    @Override
    public List<Authority> getList(Authority authority) throws Exception {
        return authorityMapper.getList(authority);
    }

    @Override
    public Authority getAuthority(Authority authority) throws Exception {
        return authorityMapper.getAuthority(authority);
    }
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public int addAuthority(Authority authority) throws Exception {

        return authorityMapper.addAuthority(authority);
    }
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public int modifyAuthority(Authority authority) throws Exception {
        return authorityMapper.modifyAuthority(authority);
    }
    @Transactional(isolation = Isolation.DEFAULT,propagation = Propagation.REQUIRED)
    @Override
    public int deleteAuthority(Authority authority) throws Exception {
        return authorityMapper.deleteAuthority(authority);
    }
}
