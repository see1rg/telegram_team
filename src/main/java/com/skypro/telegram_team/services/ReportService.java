package com.skypro.telegram_team.services;

import com.skypro.telegram_team.models.Report;
import com.skypro.telegram_team.repositories.ReportRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log4j
@Service
public class ReportService {
    ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }
    @Transactional
    public void save(Report report) {
        log.info("Saving report: " + report);
        reportRepository.save(report);
    }

    public Report findById(Long id) {
        log.info("Finding report by id: " + id);
        return reportRepository.findById(id).orElse(null);
    }
    @Transactional
    public void deleteById(Long id) {
        log.info("Deleting report by id: " + id);
        reportRepository.deleteById(id);
    }

    public List<Report> findAll() {
        log.info("Finding all reports");
        return reportRepository.findAll();
    }

}
