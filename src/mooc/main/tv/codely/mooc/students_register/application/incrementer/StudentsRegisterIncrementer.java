package tv.codely.mooc.students_register.application.incrementer;

import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students_register.domain.StudentsRegisterRepository;
import tv.codely.mooc.students_register.domain.StudentsRegister;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.UuidGenerator;

@Service
public final class StudentsRegisterIncrementer {

    private StudentsRegisterRepository repository;
    private UuidGenerator uuidGenerator;

    public StudentsRegisterIncrementer(StudentsRegisterRepository repository, UuidGenerator uuidGenerator) {
        this.repository    = repository;
        this.uuidGenerator = uuidGenerator;
    }

    public void increment(StudentId id) {
        StudentsRegister counter = repository.search()
            .orElseGet(() -> StudentsRegister.initialize(uuidGenerator.generate()));

        if (!counter.hasIncremented(id)) {
            counter.increment(id);

            repository.save(counter);
        }
    }
}
