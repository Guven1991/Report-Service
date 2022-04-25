package com.cava.report.service;

import com.cava.report.dto.ReportDto;
import com.cava.report.model.LocationInfoModel;
import com.cava.report.model.ReportStatus;
import com.cava.report.repository.ReportRepository;

import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ReportService {

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    private final ReportRepository reportRepository;
//    private final CommunicationInfoService communicationInfoService;

    public ReportService(ReportRepository reportRepository, CommunicationInfoService communicationInfoService) {
        this.reportRepository = reportRepository;
        this.communicationInfoService = communicationInfoService;
    }

    public ReportDto createReport() {
        List<LocationInfoModel> locationInfoModelList = communicationInfoService.getLocationInfo();
        Date date = new Date();
        return ReportDto.builder()

                .locationInfoModelList(locationInfoModelList)
                .requestDate(date)
                .reportStatus(ReportStatus.DONE)
                .build();

    }
}
