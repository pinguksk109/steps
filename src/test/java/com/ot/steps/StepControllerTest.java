package com.ot.steps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.ot.steps.application.service.StepService;

@ExtendWith(MockitoExtension.class)
class StepControllerTest extends StepController {

  @InjectMocks
  private StepController sut;
  
  private MockMvc mvc;
  
  @Mock
  private StepService stepService;
  
  @BeforeEach
  public void setUp() {
    MockitoAnnotations.initMocks(this);
    mvc = MockMvcBuilders.standaloneSetup(sut).build();
  }
  
  @Test
  public void POST_saveStep_処理が成功した場合_HTTPステータス200を返すこと() throws Exception {

    String requestBody = "{ \"date\": \"2023-01-01\", \"steps\": 1, \"memo\": \"hogehoge\" }";

    mvc.perform(MockMvcRequestBuilders
            .post("/person_id/1")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON)
            .content(requestBody))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();

  }
  
  @Test
  public void POST_saveStep_日付が入力されていない場合_HTTPステータスコード400を返すこと() throws Exception {
    String requestBody = "{}";
    
    mvc.perform(MockMvcRequestBuilders
        .post("/person_id/1")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON)
        .content(requestBody))
      .andExpect(MockMvcResultMatchers.status().isBadRequest())
      .andReturn();
  }

}
