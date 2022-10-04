package tv.codely.mooc.students_register;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.students_register.domain.StudentsRegisterRepository;

public abstract class StudentsRegisterModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {
    @Autowired
    protected StudentsRegisterRepository repository;
}
