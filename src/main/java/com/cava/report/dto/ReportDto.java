package com.cava.report.dto;

import com.cava.report.model.LocationInfoModel;
import com.cava.report.model.ReportStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    private String id;

    private Date requestDate;

    private ReportStatus reportStatus;

    private List<LocationInfoModel> locationInfoModelList;
}
