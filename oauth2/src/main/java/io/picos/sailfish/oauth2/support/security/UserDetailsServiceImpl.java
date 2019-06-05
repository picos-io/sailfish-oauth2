package io.picos.sailfish.oauth2.support.security;

import io.picos.sailfish.oauth2.domain.model.User;
import io.picos.sailfish.oauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.stream.Collectors;

public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     * @param username the account name
     */
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
        if (!StringUtils.isEmpty(username)) {
            username = username.trim().toLowerCase();
        }
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("无效的用户名%s", username));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                                                                      user.getPassword(),
                                                                      user.isEnabled(),
                                                                      !user.isExpired(),
                                                                      !user.isExpired(),
                                                                      !user.isLocked(),
                                                                      user.getAuthorities()
                                                                          .stream()
                                                                          .map(item -> new SimpleGrantedAuthority(item.getAuthority()))
                                                                          .collect(Collectors.toList()));
    }

}
