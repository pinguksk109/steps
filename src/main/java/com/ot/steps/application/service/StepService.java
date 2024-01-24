package com.ot.steps.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ot.steps.domain.request.StepRequestDto;
import com.ot.steps.infrastructure.repository.StepRepository;

@Service
public class StepService {

  @Autowired
  private StepRepository stepRepository;
  
  /**
   * 歩数をDBに保存します
   * @param dto
   * @throws Exception
   */
  public void saveStep(StepRequestDto dto) throws Exception {
    try {
      stepRepository.saveStep(dto);
    } catch (Exception e) {
      throw new Exception("Serviceクラスでエラーが発生しました", e);
    }
  }
  
}
