package com.ot.steps.infrastructure.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.ot.steps.domain.request.StepRequestDto;

@Repository
@Mapper
public interface StepRepository {

  /**
   * 万歩計情報を保存します
   */
  public void saveStep(@Param("dto") StepRequestDto dto);
  
}
