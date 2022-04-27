package com.cava.report;

import com.cava.report.dto.ReportDto;
import com.cava.report.entity.Report;
import com.cava.report.model.LocationInfoModel;
import com.cava.report.model.ReportStatus;
import com.cava.report.repository.ReportRepository;
import com.cava.report.service.ReportService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ReportServiceTests {

    @Mock
    private ReportRepository reportRepository;

    @InjectMocks
    private ReportService reportService;

    Report report;
    ReportDto reportDto;
    LocationInfoModel locationInfoModel;

    @Before
    public void init() {

        locationInfoModel = LocationInfoModel.builder()
                .location("ANKARA")
                .personCount(1L)
                .phoneNumberCount(5554443332L)
                .build();


        List<LocationInfoModel> locationInfoModelList
                = List.of(locationInfoModel);



        report = Report.builder()
                .id("1")
                .requestDate(new Date(System.currentTimeMillis()))
                .reportStatus(ReportStatus.DONE)
                .locationInfoModelList(locationInfoModelList)
                .build();

        reportDto = ReportDto.builder()
                .id(report.getId())
                .requestDate(report.getRequestDate())
                .reportStatus(report.getReportStatus())
                .locationInfoModelList(report.getLocationInfoModelList())
                .build();

    }

    @Test
    public void createReport() {
        when(reportRepository.save(any())).thenReturn(report);
        ReportDto reportDto = reportService.createReport();
        assertEquals(Optional.of("ANKARA"), Optional.ofNullable(reportDto.getLocationInfoModelList().get(0).getLocation()));
    }

    @Test
    public void getAllReports(){
        when(reportRepository.findAll()).thenReturn(List.of(report));
        List<ReportDto> reportDtoList = reportService.getAllReports();
        assertEquals(Optional.of("ANKARA"), Optional.ofNullable(reportDtoList
                .get(0).getLocationInfoModelList().get(0).getLocation()));
        assertEquals(Optional.of(ReportStatus.DONE), Optional.ofNullable(reportDtoList
                .get(0).getReportStatus()));
    }

    @Test
    public void getReportById(){
        when(reportRepository.findById(any())).thenReturn(Optional.of(report));
        ReportDto reportDto = reportService.getReportById("1");
        assertEquals(Optional.of("ANKARA"),
                                             Optional.ofNullable(reportDto.getLocationInfoModelList()
                                                     .get(0).getLocation()));

        assertEquals(Optional.of(ReportStatus.DONE),
                                            Optional.ofNullable(reportDto
                                                    .getReportStatus()));
    }


}
