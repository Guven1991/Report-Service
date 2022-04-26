package com.cava.report.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LocationInfoModel {

//    public LocationInfoModel(String location, Long personCount) {
//        this.location = location;
//        this.personCount = personCount;
//    }

    private String location;

    private Long personCount;

    private Long phoneNumberCount;




}
