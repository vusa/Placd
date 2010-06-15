package za.co.placd.client;

import com.google.gwt.core.client.EntryPoint;

/**
 * Main entry point.
 *
 * @author vusa
 */
public class uiEntryPoint implements EntryPoint {


    public uiEntryPoint() {
    }

    public void onModuleLoad() {
        new JobViews().makeJobsWidgets();
    }
}
