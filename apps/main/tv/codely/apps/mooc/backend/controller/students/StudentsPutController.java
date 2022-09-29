package tv.codely.apps.mooc.backend.controller.students;

import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import tv.codely.mooc.students.application.create.CreateStudentCommand;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

@RestController
public final class StudentsPutController extends ApiController {
    public StudentsPutController(
        QueryBus queryBus,
        CommandBus commandBus
                                ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/students/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
                                       ) throws CommandHandlerExecutionError {
        dispatch(new CreateStudentCommand(id, request.name(), request.surname(), request.email()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

final class Request {
    private final String name;

    private final String surname;

    private final String email;

    public Request(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }


    String name() {
        return name;
    }

    String surname() {
        return surname;
    }

    String email() {
        return email;
    }
}
