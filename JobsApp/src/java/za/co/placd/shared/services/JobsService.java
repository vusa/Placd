package za.co.placd.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;
import za.co.placd.shared.dto.JobsDTO;

/**
 *
 * @author vusa
 */
@RemoteServiceRelativePath("springGwtServices/jobsService")
public interface JobsService extends RemoteService {

    public List<JobsDTO> listJobs();

    public JobsDTO getJob(long id);

    public void createOrUpdateJob(JobsDTO dto);

}
