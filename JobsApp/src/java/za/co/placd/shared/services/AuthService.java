package za.co.placd.shared.services;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import java.util.List;
import za.co.placd.shared.dto.AppUsersDTO;
import za.co.placd.shared.dto.GroupsDTO;

/**
 *
 * @author vusa
 */
@RemoteServiceRelativePath("springGwtServices/authService")
public interface AuthService extends RemoteService {

    public boolean authenticate(String username, String password);

    public void logout();

    public AppUsersDTO getUser(String username, String password);

    public AppUsersDTO getUser();

    public boolean currentUserHasAuthority(String role);

    public String getUsername();

    public List<GroupsDTO> getUserGroups(String login);

    public void createOrUpdateUser(AppUsersDTO user);

    public void deleteUser(Long userId);
}
