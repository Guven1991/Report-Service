package com.cava.report.controller;

import com.cava.report.dto.ReportDto;
import com.cava.report.response.ReportResponse;
import com.cava.report.service.ReportService;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/report")
@RequiredArgsConstructor
public class ReportController {

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    private final ReportService reportService;

    @PostMapping()
    public ResponseEntity<ReportResponse> createReport() {

        return ResponseEntity.ok(dozerBeanMapper.map(reportService.createReport(), ReportResponse.class));
    }

    @GetMapping
    public ResponseEntity<List<ReportResponse>> getAllReports() {

        List<ReportDto> reportDtoList = reportService.getAllReports();

        return ResponseEntity.ok(reportDtoList.stream().map(reportDto ->
                dozerBeanMapper.map(reportDto, ReportResponse.class))
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportResponse> getReportById(@PathVariable("id") String id) {

             ReportDto  reportDto = reportService.getReportById(id);

        return ResponseEntity.ok(dozerBeanMapper.map(reportService.getReportById(id), ReportResponse.class));
    }


}
