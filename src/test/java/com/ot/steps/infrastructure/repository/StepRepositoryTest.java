package com.ot.steps.infrastructure.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.ot.steps.domain.request.StepRequestDto;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class StepRepositoryTest {

  @Autowired
  private StepRepository sut;

  @Test
//  @Disabled
  void saveStep_保存できること() {
      StepRequestDto dto = new StepRequestDto(12345, "2023-01-01", 10000, "保存テスト");    
      sut.saveStep(dto);
  }
  
  @Test
//  @Disabled
  void saveStep_メモがなくても保存できること() {
      StepRequestDto dto = new StepRequestDto(12345, "2023-01-01", 10000, null);    
      sut.saveStep(dto);
  }

}
