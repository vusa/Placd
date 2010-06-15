package za.co.placd.client.constants;

import com.google.gwt.i18n.client.Constants;

/**
 *
 * @author vusa
 */
public interface MainCWConstants extends Constants{

    @DefaultStringArrayValue({"HOURLY", "MONTHLY", "ANNUALLY", "ONCEOFF"})
    String [] payPeriods();

}
