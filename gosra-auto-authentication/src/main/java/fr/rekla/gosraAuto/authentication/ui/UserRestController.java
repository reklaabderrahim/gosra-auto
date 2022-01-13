package fr.rekla.gosraAuto.authentication.ui;

import fr.rekla.gosraAuto.authentication.api.UserCreateCommand;
import fr.rekla.gosraAuto.authentication.common.UserDto;
import lombok.AllArgsConstructor;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@RestController
@RequestMapping("/users")
@AllArgsConstructor
@CrossOrigin("*")
public class UserRestController {

    private CommandGateway commandGateway;
    private EventStore eventStore;

    @PostMapping("/create")
    public ResponseEntity<CompletableFuture<String>> createUser(@RequestBody UserDto userDto) {
        CompletableFuture<String> userId = commandGateway.send(new UserCreateCommand(
                UUID.randomUUID().toString(),
                userDto.getUsername()
        ));
        return new ResponseEntity<>(userId, HttpStatus.CREATED);
    }

    @GetMapping("/events/{eventId}")
    public Stream getEvents(@PathVariable String eventId) {
        System.out.println("toto");
        return eventStore.readEvents(eventId).asStream();
    }
}
