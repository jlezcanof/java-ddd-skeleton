package tv.codely.apps.mooc.backend.controller.videos;

import java.util.HashMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.videos.application.create.CreateVideoCommand;
import tv.codely.shared.domain.DomainError;
import tv.codely.shared.domain.bus.command.CommandBus;
import tv.codely.shared.domain.bus.command.CommandHandlerExecutionError;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.infrastructure.spring.ApiController;

@RestController
public final class VideosPutController extends ApiController {

    public VideosPutController(
        QueryBus queryBus,
        CommandBus commandBus
    ) {
        super(queryBus, commandBus);
    }

    @PutMapping(value = "/videos/{id}")
    public ResponseEntity<String> index(
        @PathVariable String id,
        @RequestBody Request request
    ) throws CommandHandlerExecutionError {
        dispatch(new CreateVideoCommand(id, request.url(), request.text(), request.title()));

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public HashMap<Class<? extends DomainError>, HttpStatus> errorMapping() {
        return null;
    }
}

final class Request {
    private final String url;
    private final String text;
    private final String title;

    public Request(String url, String text, String title){
        this.url  = url;
        this.text  = text;
        this.title = title;
    }


    public String text() {
        return text;
    }

    public String title() {
        return title;
    }

    public String url() {
        return url;
    }
}
