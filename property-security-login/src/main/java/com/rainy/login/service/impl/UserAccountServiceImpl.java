package com.rainy.login.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.rainy.login.domain.UserAccount;
import java.util.List;
import com.rainy.login.mapper.UserAccountMapper;
import com.rainy.login.service.UserAccountService;
/**
  *
  * @ProjectName: login
  * @ClassName: UserAccountServiceImpl
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/22 21:27
  * @version v1.0
  *
  */
@Service
public class UserAccountServiceImpl implements UserAccountService, UserDetailsService {

    @Resource
    private UserAccountMapper userAccountMapper;

    @Override
    public int updateBatch(List<UserAccount> list) {
        return userAccountMapper.updateBatch(list);
    }

    @Override
    public int updateBatchSelective(List<UserAccount> list) {
        return userAccountMapper.updateBatchSelective(list);
    }

    @Override
    public int batchInsert(List<UserAccount> list) {
        return userAccountMapper.batchInsert(list);
    }

    @Override
    public int insertOrUpdate(UserAccount record) {
        return userAccountMapper.insertOrUpdate(record);
    }

    @Override
    public int insertOrUpdateSelective(UserAccount record) {
        return userAccountMapper.insertOrUpdateSelective(record);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserAccount account = new UserAccount();
        account.setUsername(s);

        UserAccount userAccount = userAccountMapper.selectOne(account);
        if (userAccount == null){
            return new UserAccount();
        }
        return userAccount;
    }
}
