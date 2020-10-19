package tv.codely.apps.mooc.backend.controller.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.students.application.create.CreateStudentCommand;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

import java.util.HashMap;

@RestController
public final class StudentsPutController extends ApiController {

    public StudentsPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @Override public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }

    @PutMapping(value = "/students/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new CreateStudentCommand(id, request.name(), request.duration()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    final class Request {
        private String name;
        private String duration;

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public void setName(String name) {
            this.name = name;
        }

        String name() {
            return name;
        }

        String duration() {
            return duration;
        }
    }
}
