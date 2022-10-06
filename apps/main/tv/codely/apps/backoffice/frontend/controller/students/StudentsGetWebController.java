package tv.codely.apps.backoffice.frontend.controller.students;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import tv.codely.mooc.students_register.application.find.FindStudentsCounterQuery;
import tv.codely.mooc.students_register.application.find.StudentsCounterResponse;
import tv.codely.shared.domain.bus.query.QueryBus;
import tv.codely.shared.domain.bus.query.QueryHandlerExecutionError;

@Controller
public final class StudentsGetWebController {
    private final QueryBus bus;

    public StudentsGetWebController(QueryBus bus) {
        this.bus = bus;
    }

    @GetMapping("/students")
    public ModelAndView index(
        @ModelAttribute("inputs") HashMap<String, Serializable> inputs,
        @ModelAttribute("errors") HashMap<String, List<String>> errors
                             ) throws QueryHandlerExecutionError {

        StudentsCounterResponse counterResponse = bus.ask(new FindStudentsCounterQuery());

        return new ModelAndView("pages/students/students",
            new HashMap<String, Serializable>() {{
            put("title", "Students");
            put("description", "Students CodelyTV - Backoffice");
            put("students_counter", counterResponse.total());
            put("inputs", inputs);
            put("errors", errors);
            put("generated_uuid", UUID.randomUUID().toString());
        }});
    }

}
