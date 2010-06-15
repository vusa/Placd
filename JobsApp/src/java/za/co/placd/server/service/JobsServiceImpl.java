package za.co.placd.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import za.co.placd.server.model.Jobs;
import za.co.placd.server.model.PayPeriod;
import za.co.placd.shared.dto.JobsDTO;
import za.co.placd.shared.services.JobsService;

/**
 *
 * @author vusa
 */
@Service("jobsService")
public class JobsServiceImpl extends JpaDAO<Long, Jobs> implements JobsService {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
    }

    public List<JobsDTO> listJobs() {
        List<Jobs> jobs = findAll();
        List<JobsDTO> dtos = new ArrayList<JobsDTO>();
        for (Jobs job : jobs) {
            JobsDTO dto = new JobsDTO();
            dto.setDateClosing(job.getDateClosing());
            dto.setDatePosted(job.getDatePosted());
            dto.setDescription(job.getDescription());
            dto.setSummary(job.getSummary());
            dto.setId(job.getId());
            dto.setPayPeriod(job.getPayPeriod().toString());
            dto.setPayRate(job.getPayRate());
            dto.setTitle(job.getTitle());
            dtos.add(dto);
        }
        return dtos;
    }

    public JobsDTO getJob(long id) {
        Jobs job = findById(id);
        JobsDTO dto = new JobsDTO();
        dto.setDateClosing(job.getDateClosing());
        dto.setDatePosted(job.getDatePosted());
        dto.setDescription(job.getDescription());
        dto.setSummary(job.getSummary());
        dto.setId(job.getId());
        dto.setPayPeriod(job.getPayPeriod().toString());
        dto.setPayRate(job.getPayRate());
        dto.setTitle(job.getTitle());
        return dto;

    }

    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public void createOrUpdateJob(JobsDTO dto) {
        Jobs job;
        if (dto.getId() == null) {
            job = new Jobs();
            job.setDatePosted(new Date());
        } else {
            job = findById(dto.getId());
        }
        job.setDateClosing(dto.getDateClosing());
        job.setDescription(dto.getDescription());
        job.setPayPeriod(PayPeriod.valueOf(dto.getPayPeriod()));
        job.setPayRate(dto.getPayRate());
        job.setSummary(dto.getSummary());
        job.setTitle(dto.getTitle());

        persist(job);
    }
}
