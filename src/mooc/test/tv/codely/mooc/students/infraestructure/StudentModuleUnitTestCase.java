package tv.codely.mooc.students.infraestructure;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

public abstract class StudentModuleUnitTestCase extends UnitTestCase {
    protected StudentRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(StudentRepository.class);
    }

    public void shouldHaveSaved(Student student) {
        verify(repository, atLeastOnce()).register(student);
    }
}
