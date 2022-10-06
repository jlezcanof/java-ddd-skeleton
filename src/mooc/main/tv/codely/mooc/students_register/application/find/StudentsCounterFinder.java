package tv.codely.mooc.students_register.application.find;

import tv.codely.mooc.students_register.domain.StudentsCounterNotInitialized;
import tv.codely.mooc.students_register.domain.StudentsCounterRepository;
import tv.codely.mooc.students_register.domain.StudentsRegister;
import tv.codely.shared.domain.Service;

@Service
public final class StudentsCounterFinder {
    private StudentsCounterRepository repository;

    public StudentsCounterFinder(StudentsCounterRepository repository) {
        this.repository = repository;
    }

    public StudentsCounterResponse find() {
        StudentsRegister register = repository.search().orElseGet(() -> {
            throw new StudentsCounterNotInitialized();
        });

        return new StudentsCounterResponse(register.total().value());
    }
}
