package za.co.placd.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Main entry point.
 *
 * @author vusa
 */
public class uiEntryPoint implements EntryPoint {

    public uiEntryPoint() {
    }

    public void onModuleLoad() {
        DecoratedTabPanel tabPanel = new DecoratedTabPanel();
        tabPanel.setWidth("800px");
        tabPanel.setAnimationEnabled(true);
        tabPanel.add(new JobViews().makeJobsWidgets(), "Jobs");
        tabPanel.add(new ProfileView().makeProfileView(), "My Profile");
        tabPanel.selectTab(0);
        RootPanel.get("mainappContainer").add(tabPanel);
    }
}
