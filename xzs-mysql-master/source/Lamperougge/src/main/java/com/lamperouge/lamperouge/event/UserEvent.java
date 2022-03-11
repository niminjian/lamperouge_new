package com.lamperouge.lamperouge.event;

import com.lamperouge.lamperouge.domain.UserEventLog;
import org.springframework.context.ApplicationEvent;

/**
 * @author nmj
 * @create 2022-01-16 17:16
 */
public class UserEvent extends ApplicationEvent {

    private final UserEventLog userEventLog;

    public UserEvent(final UserEventLog userEventLog) {
        super(userEventLog);
        this.userEventLog = userEventLog;
    }

    public UserEventLog getUserEventLog() {
        return userEventLog;
    }
}
