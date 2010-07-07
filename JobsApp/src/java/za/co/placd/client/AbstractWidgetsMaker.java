package za.co.placd.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.Window;
import za.co.placd.client.constants.MainCWConstants;
import za.co.placd.shared.constants.Groups;
import za.co.placd.shared.dto.AppUsersDTO;

/**
 *
 * @author vusa
 */
public abstract class AbstractWidgetsMaker {

    public MainCWConstants maincwConstants = (MainCWConstants) GWT.create(MainCWConstants.class);
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

    public boolean userHasRole(Groups role) {
        if (user != null) {
            for (String r : user.getRoles()) {
                if (r.equals(role.name())) {
                    return true;
                }
            }
        }
        return false;
    }
}
