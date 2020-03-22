package com.spring5.mvc.rest.api.v1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CustomerDTO {
    private Long id;
    @ApiModelProperty(required = true)
    private String  firstName;
    private String  lastName;
    /**
     * In order to have a different name for your property in the JSON generated , use below annotation
     */
    @JsonProperty("customer_url")
    private String customerURL;
}
