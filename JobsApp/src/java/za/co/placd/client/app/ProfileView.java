package za.co.placd.client.app;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import za.co.placd.client.AbstractWidgetsMaker;
import za.co.placd.shared.dto.AppUsersDTO;
import za.co.placd.shared.services.AuthService;
import za.co.placd.shared.services.AuthServiceAsync;

/**
 *
 * @author vusa
 */
public class ProfileView extends AbstractWidgetsMaker {

    final AuthServiceAsync authService = GWT.create(AuthService.class);

    public ProfileView(AppUsersDTO user) {
        super(user);
    }

    public Widget makeProfileView() {
        final VerticalPanel profileVP = new VerticalPanel();
        if (user == null) {
            final VerticalPanel vp = new VerticalPanel();
            vp.add(new HTML("<b>You need to log in to view or edit your profile</b>"));
            FlexTable layout = new FlexTable();
            layout.setCellSpacing(6);
            FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

            // Add a title to the form
            layout.setHTML(0, 0, "Login");
            cellFormatter.setColSpan(0, 0, 2);
            cellFormatter.setHorizontalAlignment(0, 0, HasHorizontalAlignment.ALIGN_CENTER);

            // Add some login options
            layout.setHTML(1, 0, "Email");
            final TextBox emailBox = new TextBox();
            layout.setWidget(1, 1, emailBox);
            layout.setHTML(2, 0, "Password");
            final PasswordTextBox pswdBox = new PasswordTextBox();
            layout.setWidget(2, 1, pswdBox);

            // add button
            final Button loginBtn = new Button("Login");
            layout.setWidget(3, 1, loginBtn);

            // Wrap the content in a DecoratorPanel
            final DecoratorPanel decPanel = new DecoratorPanel();
            decPanel.setWidget(layout);
            vp.add(decPanel);

            //button listener
            loginBtn.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent ce) {
                    authService.authenticate(emailBox.getText(), pswdBox.getText(), new AsyncCallback<Boolean>() {

                        public void onFailure(Throwable thrwbl) {
                            throw new UnsupportedOperationException("Not supported yet.");
                        }

                        public void onSuccess(final Boolean t) {
                            final DialogBox dialogBox = new DialogBox();
                            dialogBox.setHTML("Logging in...");
                            dialogBox.setAnimationEnabled(true);
                            VerticalPanel dbvp = new VerticalPanel();
                            if (t) {
                                dbvp.add(new HTML("Login was successful"));
                            } else {
                                dbvp.add(new HTML("Your login and password were not accepted."));
                            }
                            final Button closeButton = new Button("Proceed");
                            closeButton.addClickHandler(new ClickHandler() {

                                public void onClick(ClickEvent ce) {
                                    if (t) {
                                        Window.Location.reload();
                                    } else {
                                        dialogBox.hide();
                                    }
                                }
                            });
                            dbvp.add(closeButton);
                            dialogBox.add(dbvp);
                            dialogBox.show();
                        }
                    });
                }
            });
            profileVP.add(vp);
        } else {
            profileVP.add(new HTML("User profile appears here with option to edit."));
            profileVP.add(new HTML("Hello " + user.getLogin() + " you last successfully logged in on " + user.getLastLogin()));
        }
        return profileVP;
    }
}
