package tv.codely.mooc.students.application.create;

import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseName;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateStudentCommandHandler implements CommandHandler<CreateStudentCommand> {
    private final StudentCreator creator;

    public CreateStudentCommandHandler(StudentCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateStudentCommand command) {
        CourseId       id       = new CourseId(command.id());
        CourseName     name     = new CourseName(command.name());
        //TODO
        //CourseDuration duration = new CourseDuration(command.duration());

        //creator.create(id, name, duration);
    }
}
