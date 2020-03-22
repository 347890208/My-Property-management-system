package com.rainy.login.mapper;

import com.rainy.login.domain.UserAccount;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
  *
  * @ProjectName: login
  * @ClassName: UserAccountMapper
  * @Description: TODO(一句话描述该类的功能)
  * @Author: 34789
  * @Date: 2020/3/22 21:27
  * @version v1.0
  *
  */
@Mapper
public interface UserAccountMapper extends tk.mybatis.mapper.common.Mapper<UserAccount> {
    int updateBatch(List<UserAccount> list);

    int updateBatchSelective(List<UserAccount> list);

    int batchInsert(@Param("list") List<UserAccount> list);

    int insertOrUpdate(UserAccount record);

    int insertOrUpdateSelective(UserAccount record);
}