package za.co.placd.client.admin;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 *
 * @author vusa
 */
public class AdminEntryPoint implements EntryPoint{

    public void onModuleLoad() {
        DecoratedTabPanel tabPanel = new DecoratedTabPanel();
        tabPanel.setWidth("800px");
        tabPanel.setAnimationEnabled(true);
        tabPanel.add(new VerticalPanel(), "System");
        tabPanel.add(new VerticalPanel(), "User Settings");
        tabPanel.add(new VerticalPanel(), "Permissions");
        tabPanel.selectTab(0);
        RootPanel.get("mainappContainer").add(tabPanel);
    }

}
