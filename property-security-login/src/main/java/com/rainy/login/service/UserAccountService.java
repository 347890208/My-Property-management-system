package com.rainy.login.service;

import com.rainy.login.domain.UserAccount;
import java.util.List;
    /**
  *
  * @ProjectName: login
  * @ClassName: UserAccountService
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/22 21:27
  * @version v1.0
  *
  */
public interface UserAccountService{


    int updateBatch(List<UserAccount> list);

    int updateBatchSelective(List<UserAccount> list);

    int batchInsert(List<UserAccount> list);

    int insertOrUpdate(UserAccount record);

    int insertOrUpdateSelective(UserAccount record);

}
