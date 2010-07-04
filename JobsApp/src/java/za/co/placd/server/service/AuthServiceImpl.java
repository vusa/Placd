package za.co.placd.server.service;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;
import za.co.placd.server.model.AppUsers;
import za.co.placd.server.model.AuthType;
import za.co.placd.server.model.Groups;
import za.co.placd.server.util.MD5;
import za.co.placd.shared.dto.AppUsersDTO;
import za.co.placd.shared.dto.GroupsDTO;
import za.co.placd.shared.services.AuthService;

/**
 *
 * @author vusa
 */
@Service("authService")
public class AuthServiceImpl extends JpaDAO<Long, AppUsers> implements AuthService {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    @PostConstruct
    public void init() {
        super.setEntityManagerFactory(entityManagerFactory);
    }

    public boolean authenticate(String username, String password) {
        AppUsersDTO userDTO = null;
        try {
            userDTO = getUser(username, password);
        } catch (Exception e) {
            return false;
        }
        boolean authenticated = (userDTO != null);

        if (authenticated) {
            List<GrantedAuthority> authorities = getGrantedAuthorities(username);
            User user = new User(username, password, userDTO.isActive(), userDTO.isActive(), userDTO.isActive(), userDTO.isActive(), authorities);
            Authentication auth = new UsernamePasswordAuthenticationToken(user, password, authorities);
            SecurityContext sc = new SecurityContextImpl();
            sc.setAuthentication(auth);
            SecurityContextHolder.setContext(sc);
        }
        return authenticated;
    }

    public void logout() {
        SecurityContextHolder.clearContext();
    }

    public AppUsersDTO getUser(final String username, final String password) throws EmptyResultDataAccessException {
        AppUsersDTO dto = null;
        Object res = getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                String md5Pass = "";
                try {
                    md5Pass = MD5.getInstance().hashString(password);
                } catch (NoSuchAlgorithmException ex) {
                    Logger.getLogger(AuthServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
                Query q = em.createNamedQuery("AppUsers.byLoginAndPassword").setParameter("login", username).setParameter("password", md5Pass);
                return q.getSingleResult();
            }
        });
        if (res != null) {
            AppUsers user = (AppUsers) res;
            dto = new AppUsersDTO();
            dto.setActive(user.isActive());
            dto.setAuthType(user.getAuthType().toString());
            dto.setDob(user.getDob());
            dto.setEmail(dto.getEmail());
            dto.setId(user.getId());
            dto.setLastLogin(new Date());
            dto.setLogin(username);
            dto.setPassword(password);
        }
        return dto;
    }

    public void createOrUpdateUser(AppUsersDTO dto) {
        AppUsers user;
        if (dto.getId() != null) {
            user = findById(dto.getId());
        } else {
            user = new AppUsers();
            user.setLogin(dto.getLogin());
        }
        user.setActive(dto.isActive());
        user.setAuthType(AuthType.valueOf(dto.getAuthType()));
        user.setDob(dto.getDob());
        user.setEmail(dto.getEmail());
        if (dto.getPassword() != null) {
            try {
                user.setPassword(MD5.getInstance().hashString(dto.getPassword()));
            } catch (NoSuchAlgorithmException nsae) {
                /**/
            }
        }
        persist(user);

    }

    public void deleteUser(Long userId) {
        remove(findById(userId));
    }

    public List<GrantedAuthority> getGrantedAuthorities(String username) {
        List<GrantedAuthority> ga = new ArrayList<GrantedAuthority>();
        for (GroupsDTO g : getUserGroups(username)) {
            ga.add(new GrantedAuthorityImpl(g.getName()));
        }
        return ga;
    }

    public List<GroupsDTO> getUserGroups(final String login) {
        List<GroupsDTO> dtos = new ArrayList<GroupsDTO>();
        Object res = getJpaTemplate().execute(new JpaCallback() {

            public Object doInJpa(EntityManager em) throws PersistenceException {
                Query q = em.createNamedQuery("UserGroups.byLogin").setParameter("login", login);
                return q.getResultList();
            }
        });
        for (Groups g : (List<Groups>) res) {
            GroupsDTO dto = new GroupsDTO();
            dto.setName(g.name());
            dtos.add(dto);
        }
        return dtos;
    }

    public AppUsersDTO getUser(String username) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the user
     */
    public User getUserDetails() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return (User) auth.getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }

    public String getUsername() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return ((User) auth.getPrincipal()).getUsername();
        } catch (Exception e) {
            return null;
        }
    }

    public boolean currentUserHasAuthority(String role) {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            for (GrantedAuthority ga : ((User) auth.getPrincipal()).getAuthorities()) {
                if (role.equals(ga.getAuthority())) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
