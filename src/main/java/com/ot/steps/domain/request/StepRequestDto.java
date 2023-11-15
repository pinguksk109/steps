package com.ot.steps.domain.request;

import lombok.Value;

@Value
public class StepRequestDto {

  private Integer personId;
  private String date;
  private Integer steps;
  private String memo;
  
}
