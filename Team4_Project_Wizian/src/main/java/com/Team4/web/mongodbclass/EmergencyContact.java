package com.Team4.web.mongodbclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
class EmergencyContact {
    private String emerName;
    private String relation;
    private String emerTel;
    private String emerNote;

}
