package fr.rekla.gosraAuto.authentication.command;

import fr.rekla.gosraAuto.authentication.api.UserCreateCommand;
import fr.rekla.gosraAuto.authentication.api.UserCreatedEvent;
import fr.rekla.gosraAuto.authentication.common.CurrentStatus;
import org.apache.commons.lang3.StringUtils;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.context.annotation.Profile;

import static org.axonframework.modelling.command.AggregateLifecycle.apply;

@Profile("command")
@Aggregate(cache = "userCache")
public class User {

    @AggregateIdentifier
    private String userId;
    private String username;
    private CurrentStatus currentStatus;

    public User() {
        // Required by Axon to construct an empty instance to initiate Event Sourcing.
    }

    @CommandHandler
    public User(UserCreateCommand userCreateCommand) {
        if (StringUtils.isEmpty(userCreateCommand.getUsername())) {
            throw new IllegalArgumentException("username is not defined");
        }
        apply(new UserCreatedEvent(userCreateCommand.getId(), userCreateCommand.getUsername()));
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent event) {
        userId = event.getId();
        username = event.getUsername();
        currentStatus = CurrentStatus.CREATED;
    }
}
