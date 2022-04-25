package com.cava.report.response;

import com.cava.report.model.LocationInfoModel;
import com.cava.report.model.ReportStatus;

import lombok.*;

import java.util.Date;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReportResponse {

    private String id;

    private Date requestDate;

    private ReportStatus reportStatus;

    private List<LocationInfoModel> locationInfoModelList;
}
