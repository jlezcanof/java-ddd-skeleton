package tv.codely.mooc.students.infraestructure;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.mooc.students.infrastructure.InMemoryStudentRepository;
import tv.codely.shared.infrastructure.JavaUuidGenerator;

public abstract class StudentCreateModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {

    protected InMemoryStudentRepository inMemoryStudentRepository =
        new InMemoryStudentRepository(new JavaUuidGenerator());

    @Autowired
    protected StudentRepository mySqlStudentRepository;
}
