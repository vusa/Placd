package za.co.placd.client;

import com.google.gwt.user.client.ui.DecoratorPanel;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.FlexTable.FlexCellFormatter;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

/**
 *
 * @author vusa
 */
public class ProfileView extends AbstractWidgetsMaker {

    public Widget makeProfileView() {
        VerticalPanel vp = new VerticalPanel();
        vp.add(new HTML("<b>You need loggin in to view or edit your profile</b>"));
        FlexTable layout = new FlexTable();
        layout.setCellSpacing(6);
        FlexCellFormatter cellFormatter = layout.getFlexCellFormatter();

        // Add a title to the form
        layout.setHTML(0, 0, "Login");
        cellFormatter.setColSpan(0, 0, 2);
        cellFormatter.setHorizontalAlignment(0, 0,HasHorizontalAlignment.ALIGN_CENTER);

        // Add some standard form options
        layout.setHTML(1, 0, "Email");
        layout.setWidget(1, 1, new TextBox());
        layout.setHTML(2, 0, "Password");
        layout.setWidget(2, 1, new PasswordTextBox());

        // Wrap the content in a DecoratorPanel
        DecoratorPanel decPanel = new DecoratorPanel();
        decPanel.setWidget(layout);
        vp.add(decPanel);
        return vp;

    }
}
