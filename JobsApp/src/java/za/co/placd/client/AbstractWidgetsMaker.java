package za.co.placd.client;

import com.google.gwt.core.client.GWT;
import za.co.placd.client.constants.MainCWConstants;
import za.co.placd.shared.dto.AppUsersDTO;
import za.co.placd.shared.services.JobsService;
import za.co.placd.shared.services.JobsServiceAsync;

/**
 *
 * @author vusa
 */
public abstract class AbstractWidgetsMaker {

    public MainCWConstants maincwConstants = (MainCWConstants) GWT.create(MainCWConstants.class);
    public final JobsServiceAsync jobsService = GWT.create(JobsService.class);
    public static final String SERVER_ERROR = "An error occurred while "
            + "attempting to contact the server. Please check your network "
            + "connection and try again. The error is : ";
    public final AppUsersDTO user;

    public AbstractWidgetsMaker(AppUsersDTO user) {
        this.user = user;
    }

    public AbstractWidgetsMaker() {
        user = null;
    }
}
