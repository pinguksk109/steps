package com.ot.steps;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StepRequest {

  // TODO: yyyy-mm-dd以外は許容したくない
  @NotBlank(message = "日付を入力してください")
  private String date;
  @NotBlank(message = "歩数を入力してください")
  private Integer steps;

  private String memo;
  
}
