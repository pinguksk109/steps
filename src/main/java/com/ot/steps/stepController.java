package com.ot.steps;

import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ot.steps.application.service.StepService;
import com.ot.steps.domain.request.StepRequestDto;

@RestController
@RequestMapping("/")
public class stepController {

  @Autowired
  private StepService stepService;
  
  @PostMapping("person_id/{personId}")
  public ResponseEntity<?> saveStep(@PathVariable("personId") @NotBlank String personId, @Valid @RequestBody StepRequest request, BindingResult bindingResult) throws Exception {
    
    if(bindingResult.hasErrors()) {
//      throw new 
    }
    
    StepRequestDto dto = null;
    
    if(Objects.isNull(request.getMemo())) {
      dto = new StepRequestDto(Integer.parseInt(personId), request.getDate(), request.getSteps());
    }
    if(Objects.nonNull(request.getMemo())) {
      dto = new StepRequestDto(Integer.parseInt(personId), request.getDate(), request.getSteps(), request.getMemo());
    }
    
    stepService.saveStep(dto);
    
    return ResponseEntity.ok().build();
    
  }
  
}
