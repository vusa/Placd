package za.co.placd.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import za.co.placd.shared.dto.JobsDTO;

/**
 *
 * @author vusa
 */
public interface JobsServiceAsync{

    public void listJobs(AsyncCallback<List<JobsDTO>> asyncCallback);

    public void getJob(long id, AsyncCallback<JobsDTO> asyncCallback);

    public void createOrUpdateJob(JobsDTO dto, AsyncCallback<Void> asyncCallback);

}
