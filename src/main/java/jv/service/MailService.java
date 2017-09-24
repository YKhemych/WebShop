package jv.service;

import jv.entity.User;

/**
 * Created by user on 15.09.2017.
 */
public interface MailService {
    void send(User user, String message);
}
