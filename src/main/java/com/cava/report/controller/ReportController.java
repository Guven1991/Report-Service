package com.cava.report.controller;

import com.cava.report.dto.ReportDto;
import com.cava.report.response.ReportResponse;
import com.cava.report.service.ReportService;

import lombok.RequiredArgsConstructor;
import org.dozer.DozerBeanMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
}
