package za.co.placd.client.app;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;
import za.co.placd.shared.dto.AppUsersDTO;
import za.co.placd.shared.services.AuthService;
import za.co.placd.shared.services.AuthServiceAsync;

/**
 * Main entry point.
 *
 * @author vusa
 */
public class AppEntryPoint implements EntryPoint {

    private AuthServiceAsync authService = GWT.create(AuthService.class);
    private AppUsersDTO user;

    public AppEntryPoint() {
    }

    public void onModuleLoad() {
        authService.getUser(new AsyncCallback<AppUsersDTO>() {

            public void onFailure(Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            public void onSuccess(AppUsersDTO t) {
                if (t != null) {
                    user = t;
                    for (String ga : t.getRoles()) {
                        if ("ROLE_ADMIN".equals(ga)) {
                            RootPanel.get("adminLinkContainer").add(new HTML("<a href=\"admin.html\">Admin</a>"));
                            break;
                        }
                    }
                    RootPanel.get("loginTextContainer").add(new HTML("<a href=\"spring_security_login\">Logout</a>&nbsp;"+t.getLogin()));
                } else {
                    RootPanel.get("loginTextContainer").add(new HTML("<a href=\"spring_security_login\">Login</a>"));
                }
            }
        });
        
        DecoratedTabPanel tabPanel = new DecoratedTabPanel();
        tabPanel.setWidth("800px");
        tabPanel.setAnimationEnabled(true);
        tabPanel.add(new JobViews(user).makeJobsWidgets(), "Jobs");
        tabPanel.add(new ProfileView(user).makeProfileView(), "My Profile");
        tabPanel.selectTab(0);
        RootPanel.get("mainappContainer").add(tabPanel);
    }
}
