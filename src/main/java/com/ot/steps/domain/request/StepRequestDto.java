package com.ot.steps.domain.request;

import lombok.Getter;

@Getter
public class StepRequestDto {

  private Integer personId;
  private String date;
  private Integer steps;
  private String memo = null;
  
  public StepRequestDto(Integer personId, String date, Integer steps) {
    this.personId = personId;
    this.date = date;
    this.steps = steps;
  }
  
  public StepRequestDto(Integer personId, String date, Integer steps, String memo) {
    this.personId = personId;
    this.date = date;
    this.steps = steps;
    this.memo = memo;
  }
  
}
