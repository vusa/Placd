package za.co.placd.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.DisclosurePanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Hyperlink;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DateBox;
import java.util.Date;
import java.util.List;
import za.co.placd.client.AbstractWidgetsMaker;
import za.co.placd.shared.constants.Groups;
import za.co.placd.shared.dto.AppUsersDTO;
import za.co.placd.shared.dto.JobsDTO;
import za.co.placd.shared.services.JobsService;
import za.co.placd.shared.services.JobsServiceAsync;

/**
 *
 * @author vusa
 */
public class JobViews extends AbstractWidgetsMaker {

    public final JobsServiceAsync jobsService = GWT.create(JobsService.class);

    public JobViews(AppUsersDTO user) {
        super(user);
    }

    public Widget makeJobsWidgets() {
        final boolean userIsRecruiter = userHasRole(Groups.ROLE_RECRUITER);
        final boolean userIsAdmin = userHasRole(Groups.ROLE_ADMIN);
        VerticalPanel vp = new VerticalPanel();
        FlexTable layout = new FlexTable();
        layout.setWidget(1, 0, new Label("id"));
        layout.setWidget(2, 0, new Label("Position"));
        layout.setWidget(3, 0, new Label("Summary"));
        layout.setWidget(4, 0, new Label("Full description"));
        layout.setWidget(5, 0, new Label("Pay Rate"));
        layout.setWidget(6, 0, new Label("Closing Date"));
        layout.setWidget(0, 0, new Label("Enter new position"));
        final Label jobIdLbl = new Label();
        final Button saveOrUpdateButton = new Button("SaveOrUpdate");
        final TextBox jobTitleBox = new TextBox();
        final TextArea jobSummaryArea = new TextArea();
        final TextArea jobDescriptionArea = new TextArea();
        final TextBox jobSalaryBox = new TextBox();
        final ListBox payPeriodsBox = new ListBox(false);
        String[] payPeriods = maincwConstants.payPeriods();
        for (int i = 0; i < payPeriods.length; i++) {
            payPeriodsBox.addItem(payPeriods[i]);
        }
        final DateBox closingDateBox = new DateBox();
        final Label errorLabel = new Label();

        //only recruiters need to add jobs
        //admins can edit existing jobs
        final DisclosurePanel jobEditdp = new DisclosurePanel();
        jobEditdp.setAnimationEnabled(true);
        if (userIsRecruiter || userIsAdmin) {
            saveOrUpdateButton.addStyleName("sendButton");
            // Add widgets to flextable
            layout.setWidget(1, 1, jobIdLbl);
            layout.setWidget(2, 1, jobTitleBox);
            layout.setWidget(3, 1, jobSummaryArea);
            layout.setWidget(4, 1, jobDescriptionArea);
            HorizontalPanel salaryBox = new HorizontalPanel();
            salaryBox.add(jobSalaryBox);
            salaryBox.add(payPeriodsBox);
            layout.setWidget(5, 1, salaryBox);
            layout.setWidget(6, 1, closingDateBox);
            layout.setWidget(7, 0, saveOrUpdateButton);
            jobEditdp.add(layout);
            if (userIsRecruiter) {
                jobEditdp.setHeader(new HTML(maincwConstants.jobsEditDisclosurePanelTitle()));
            }
            vp.add(jobEditdp);
            // Focus the cursor on the name field when the app loads
            jobTitleBox.setFocus(true);

        }
        vp.add(errorLabel);

        //show list jobs button.
        final Button retrieveButton = new Button("Retrieve");
        retrieveButton.addStyleName("sendButton");
        final CheckBox showRecruiterOnlyJobsChk = new CheckBox("Only show jobs I posted");
        HorizontalPanel hp = new HorizontalPanel();
        hp.add(new HTML("Listed Jobs"));
        hp.add(retrieveButton);
        if (userIsRecruiter) {
            showRecruiterOnlyJobsChk.setValue(true);
            hp.add(showRecruiterOnlyJobsChk);
        }
        vp.add(hp);
        final VerticalPanel joblistVP = new VerticalPanel();
        vp.add(joblistVP);
        // Create the popup dialog box
        final DialogBox dialogBox = new DialogBox();
        dialogBox.setText("Remote Procedure Call");
        dialogBox.setAnimationEnabled(true);
        final Button closeButton = new Button("Close");
        // We can set the id of a widget by accessing its Element
        closeButton.getElement().setId("closeButton");
        final Label textToServerLabel = new Label();
        final HTML serverResponseLabel = new HTML();
        VerticalPanel dialogVPanel = new VerticalPanel();
        dialogVPanel.addStyleName("dialogVPanel");
        dialogVPanel.add(new HTML("<b>Sending request to the server:</b>"));
        dialogVPanel.add(textToServerLabel);
        dialogVPanel.add(new HTML("<b>Server replies:</b>"));
        dialogVPanel.add(serverResponseLabel);
        dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
        dialogVPanel.add(closeButton);
        dialogBox.setWidget(dialogVPanel);
        // Add a handler to close the DialogBox
        closeButton.addClickHandler(new ClickHandler() {

            public void onClick(ClickEvent event) {
                dialogBox.hide();
                saveOrUpdateButton.setEnabled(true);
                saveOrUpdateButton.setFocus(true);
                retrieveButton.setEnabled(true);
            }
        });
        // Create a handler for the saveOrUpdateButton
        class SaveOrUpdateJobHandler implements ClickHandler, KeyUpHandler {

            public void onClick(ClickEvent event) {
                sendJobInfoToServer();
            }

            public void onKeyUp(KeyUpEvent kue) {
            }

            private void sendJobInfoToServer() {
                errorLabel.setText("");
                JobsDTO dto = new JobsDTO();
                try {
                    dto.setId(new Long(jobIdLbl.getText()));
                } catch (NumberFormatException nfe) {
                    dto.setId(null);
                }
                dto.setTitle(jobTitleBox.getText());
                dto.setSummary(jobSummaryArea.getText());
                dto.setDescription(jobDescriptionArea.getText());
                try {
                    dto.setPayRate(new Integer(jobSalaryBox.getValue()));
                } catch (NumberFormatException nfe) {
                    dto.setPayRate(null);
                }
                dto.setPayPeriod(payPeriodsBox.getItemText(payPeriodsBox.getSelectedIndex()));
                dto.setDateClosing(closingDateBox.getValue());
                dto.setDatePosted(new Date());

                // Then, we send the input to the server.
                saveOrUpdateButton.setEnabled(false);
                textToServerLabel.setText(dto.getSummary());
                serverResponseLabel.setText("");
                jobsService.createOrUpdateJob(dto, new AsyncCallback<Void>() {

                    public void onFailure(Throwable caught) {
                        // Show the RPC error message to the user
                        dialogBox.setText("Remote Procedure Call - Failure");
                        serverResponseLabel.addStyleName("serverResponseLabelError");
                        serverResponseLabel.setHTML(SERVER_ERROR + caught.toString());
                        dialogBox.center();
                        closeButton.setFocus(true);
                    }

                    public void onSuccess(Void noAnswer) {
                        dialogBox.setText("Remote Procedure Call");
                        serverResponseLabel.removeStyleName("serverResponseLabelError");
                        serverResponseLabel.setHTML("OK");
                        dialogBox.center();
                        closeButton.setFocus(true);
                        //clear joedit widgets
                        jobIdLbl.setText("");
                        jobTitleBox.setText("");
                        jobSummaryArea.setText("");
                        jobDescriptionArea.setText("");
                        jobSalaryBox.setText("");
                        payPeriodsBox.setSelectedIndex(0);
                        closingDateBox.setValue(new Date());
                        jobEditdp.setOpen(false);
                    }
                });
            }
        }

        // Create a handler for the retrieveButton
        class RetrieveJobsHandler implements ClickHandler, KeyUpHandler {

            public void onClick(ClickEvent event) {
                getJobsFromServer();
            }

            public void onKeyUp(KeyUpEvent event) {
                if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
                    getJobsFromServer();
                }
            }

            private void getJobsFromServer() {
                errorLabel.setText("");
                retrieveButton.setEnabled(false);
                serverResponseLabel.setText("");
                jobsService.listJobs(showRecruiterOnlyJobsChk.getValue(), new AsyncCallback<List<JobsDTO>>() {

                    public void onFailure(Throwable caught) {
                        Window.alert("jobsService failed listJobs()");
                    }

                    public void onSuccess(List<JobsDTO> result) {
                        joblistVP.clear();
                        boolean userCanEditAll = false;
                        if (userIsAdmin) {
                            userCanEditAll = true;
                        }
                        for (JobsDTO dto : result) {
                            HorizontalPanel jobListHP = new HorizontalPanel();
                            String jobListHTML = "<b>" + dto.getId() + "</b>&nbsp;" + dto.getTitle() + "<br />" + dto.getSummary() + "&nbsp;";
                            jobListHP.add(new HTML(jobListHTML));
                            if (userCanEditAll || (userIsRecruiter && user.getId().equals(dto.getPostedby()))) {
                                jobListHP.add(new Hyperlink("Edit", dto.getId().toString()));
                            }
                            joblistVP.add(jobListHP);
                            joblistVP.add(new HTML("&nbsp;"));
                        }
                        History.addValueChangeHandler(new EditJobHandler());
                    }
                });

            }

            //Handler for editing job
            class EditJobHandler implements ValueChangeHandler<String> {

                public void onValueChange(ValueChangeEvent<String> vce) {
                    jobsService.getJob(new Long(vce.getValue()), new AsyncCallback<JobsDTO>() {

                        public void onFailure(Throwable thrwbl) {
                            Window.alert("jobService failed getJob saying " + thrwbl.getMessage());
                            jobEditdp.setOpen(false);
                        }

                        public void onSuccess(JobsDTO dto) {
                            jobIdLbl.setText(dto.getId().toString());
                            jobTitleBox.setText(dto.getTitle());
                            jobSummaryArea.setText(dto.getSummary());
                            jobDescriptionArea.setText(dto.getDescription());
                            jobSalaryBox.setText(dto.getPayRate().toString());
                            payPeriodsBox.setTitle(dto.getPayPeriod());
                            closingDateBox.setValue(dto.getDateClosing());
                            jobEditdp.setOpen(true);
                            jobTitleBox.setFocus(true);
                        }
                    });
                }
            }
        }
        // Add a handler to send the job to the server
        saveOrUpdateButton.addClickHandler(new SaveOrUpdateJobHandler());
        // Add a handler to get jobs list from server
        retrieveButton.addClickHandler(new RetrieveJobsHandler());
        return vp;
    }
}
