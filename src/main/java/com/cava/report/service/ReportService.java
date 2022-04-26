package com.cava.report.service;

import com.cava.report.dto.ReportDto;
import com.cava.report.entity.Report;
import com.cava.report.model.LocationInfoModel;
import com.cava.report.model.ReportStatus;
//import com.cava.report.repository.ReportRepository;

import com.cava.report.repository.ReportRepository;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ReportService {

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public ReportDto createReport() {

//        todo uri yi constantlarda tut
        String uri = "http://localhost:8080/communicationInfo/locationInfoModel";
        RestTemplate restTemplate = new RestTemplate();
        List<LocationInfoModel> locationInfoModelList = (List<LocationInfoModel>) restTemplate.getForObject(uri, Object.class);

        Date date = new Date();
        ReportDto reportDto =ReportDto.builder()

                .locationInfoModelList(locationInfoModelList)
                .requestDate(date)
                .reportStatus(ReportStatus.DONE)
                .build();

        Report report = reportRepository.save(dozerBeanMapper.map(reportDto, Report.class));
        return dozerBeanMapper.map(report, ReportDto.class);

    }

    public List<ReportDto> getAllReports() {
        List<Report> reportList = reportRepository.findAll();

        return reportList.stream().map(report -> dozerBeanMapper
                .map(report, ReportDto.class)).collect(Collectors.toList());
    }

}
