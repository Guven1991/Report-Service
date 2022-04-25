package com.cava.report.entity;

import com.cava.report.model.ReportStatus;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Report {

    @Id
    private String id;

    private Date requestDate;

    @Enumerated(EnumType.STRING)
    private ReportStatus reportStatus;

}

