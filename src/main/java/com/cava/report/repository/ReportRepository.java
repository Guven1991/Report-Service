package com.cava.report.repository;


import com.cava.report.entity.Report;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ReportRepository extends MongoRepository<Report, String > {

}
