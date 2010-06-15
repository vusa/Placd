package za.co.placd.client;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.datepicker.client.DateBox;
import java.util.Date;
import java.util.List;
import za.co.placd.shared.dto.JobsDTO;

/**
 *
 * @author vusa
 */
public class JobViews extends AbstractWidgetsMaker {

    public void makeJobsWidgets() {

        final Button saveOrUpdateButton = new Button("SaveOrUpdate");
        final Button retrieveButton = new Button("Retrieve");
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
        // We can add style names to widgets
        saveOrUpdateButton.addStyleName("sendButton");
        retrieveButton.addStyleName("sendButton");
        // Add the nameField and sendButton to the RootPanel
        // Use RootPanel.get() to get the entire body element
        RootPanel.get("jobtitleContainer").add(jobTitleBox);
        RootPanel.get("jobsummaryContainer").add(jobSummaryArea);
        RootPanel.get("jobdescriptionContainer").add(jobDescriptionArea);
        RootPanel.get("jobpayContainer").add(jobSalaryBox);
        RootPanel.get("jobpayContainer").add(payPeriodsBox);
        RootPanel.get("jobclosingdateContainer").add(closingDateBox);
        RootPanel.get("jobsaveContainer").add(saveOrUpdateButton);
        RootPanel.get("jobRetrieverBtnContainer").add(retrieveButton);
        RootPanel.get("errorLabelContainer").add(errorLabel);
        // Focus the cursor on the name field when the app loads
        jobTitleBox.setFocus(true);
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
                dto.setTitle(jobTitleBox.getText());
                dto.setDatePosted(new Date());
                dto.setDateClosing(closingDateBox.getValue());
                dto.setDescription(jobDescriptionArea.getText());
                dto.setPayPeriod(payPeriodsBox.getItemText(payPeriodsBox.getSelectedIndex()));
                dto.setPayRate(new Integer(jobSalaryBox.getValue()));
                dto.setSummary(jobSummaryArea.getText());
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
                jobsService.listJobs(new AsyncCallback<List<JobsDTO>>() {

                    public void onFailure(Throwable caught) {
                        throw new UnsupportedOperationException("Not supported yet.");
                    }

                    public void onSuccess(List<JobsDTO> result) {
                        String jobListHTML = "";
                        for (JobsDTO dto : result) {
                            jobListHTML += "<p><b>" + dto.getId() + "</b>&nbsp;" + dto.getTitle() + "<br />" + dto.getSummary() + "<p>";
                        }
                        RootPanel.get("jobsListContainer").clear();
                        RootPanel.get("jobsListContainer").add(new HTML(jobListHTML));
                    }
                });
            }
        }
        // Add a handler to send the job to the server
        SaveOrUpdateJobHandler saveOrUpdateJobhandler = new SaveOrUpdateJobHandler();
        saveOrUpdateButton.addClickHandler(saveOrUpdateJobhandler);

        // Add a handler to get jobs list from server
        RetrieveJobsHandler retrieveJobshandler = new RetrieveJobsHandler();
        retrieveButton.addClickHandler(retrieveJobshandler);
    }
}
