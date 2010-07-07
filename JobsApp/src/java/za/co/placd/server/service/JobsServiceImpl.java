package za.co.placd.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import za.co.placd.server.model.AppUsers;
import za.co.placd.server.model.Jobs;
import za.co.placd.server.model.PayPeriod;
import za.co.placd.shared.constants.Groups;
import za.co.placd.shared.dto.AppUsersDTO;
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
    @Autowired
    AuthServiceImpl authService;

    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
    }

    public List<JobsDTO> listJobs(boolean forCurrentUser) {
        List<Jobs> jobs = new ArrayList<Jobs>();
        if (forCurrentUser) {
            jobs = (List<Jobs>) getJpaTemplate().execute(new JpaCallback() {

                public Object doInJpa(EntityManager em) throws PersistenceException {
                    Query q = em.createNamedQuery("Jobs.byPostedById").setParameter("postedById", authService.getUser().getId());
                    return q.getResultList();
                }
            });
        } else {
            jobs = findAllOrderedById();
        }

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
            if (job.getPostedBy() != null) {
                dto.setPostedby(job.getPostedBy().getId());
            }
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
        AppUsersDTO currentUser = authService.getUser();
        if (dto.getId() == null) {
            job = new Jobs();
            job.setDatePosted(new Date());
            job.setPostedBy(new AppUsers(currentUser.getId()));
        } else {
            job = findById(dto.getId());
        }
        if (job.getPostedBy().getId().equals(currentUser.getId()) || authService.currentUserHasAuthority(Groups.ROLE_ADMIN.name())) {
            job.setDateClosing(dto.getDateClosing());
            job.setDescription(dto.getDescription());
            job.setPayPeriod(PayPeriod.valueOf(dto.getPayPeriod()));
            job.setPayRate(dto.getPayRate());
            job.setSummary(dto.getSummary());
            job.setTitle(dto.getTitle());
            persist(job);
        }
    }
}
