package com.ot.steps.application.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import com.ot.steps.domain.request.StepRequestDto;
import com.ot.steps.infrastructure.repository.StepRepository;

@ExtendWith(MockitoExtension.class)
class StepServiceTest extends StepService {

  @Mock
  private StepRepository stepRepository;
  
  @InjectMocks
  private StepService sut;
  
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
  }
  
  @Test
  void saveStep_処理が成功すること() throws Exception {
    StepRequestDto dto = new StepRequestDto(1, "2023-01-01", 10000, "hoge");
    sut.saveStep(dto);
    
    verify(stepRepository, times(1)).saveStep(any());
  }
  
  @Test
  void saveStep_データ保存で500が発生した場合_処理が成功すること() throws Exception {
    
    doThrow(new RuntimeException()).when(stepRepository).saveStep(any());
    
    assertThrows(Exception.class, () -> {
      sut.saveStep(any());
    });
  }

}
