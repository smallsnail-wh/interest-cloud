package com.interest.message.model.response;

import com.interest.message.model.entity.EmailEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EmailResponse extends EmailEntity {

    private String username;

}
