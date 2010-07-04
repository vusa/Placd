package za.co.placd.shared.services;

import com.google.gwt.user.client.rpc.AsyncCallback;
import java.util.List;
import za.co.placd.shared.dto.AppUsersDTO;
import za.co.placd.shared.dto.GroupsDTO;

/**
 *
 * @author vusa
 */
public interface AuthServiceAsync {

    public void authenticate(String username, String password, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void logout(AsyncCallback<Void> asyncCallback);

    public void getUser(String username, String password, AsyncCallback<AppUsersDTO> asyncCallback);

    public void getUserGroups(String login, AsyncCallback<List<GroupsDTO>> asyncCallback);

    public void createOrUpdateUser(AppUsersDTO user, AsyncCallback<Void> asyncCallback);

    public void deleteUser(Long userId, AsyncCallback<Void> asyncCallback);

    public void getUsername(AsyncCallback<String> asyncCallback);

    public void currentUserHasAuthority(String role, AsyncCallback<java.lang.Boolean> asyncCallback);

    public void getUser(AsyncCallback<AppUsersDTO> asyncCallback);

}
