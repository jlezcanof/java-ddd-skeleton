package tv.codely.mooc.students_register;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import tv.codely.mooc.students_register.domain.StudentsRegister;
import tv.codely.mooc.students_register.domain.StudentsRegisterRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

public abstract class StudentsRegisterModuleUnitTestCase extends UnitTestCase {
    protected StudentsRegisterRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();

        repository = mock(StudentsRegisterRepository.class);
    }

    public void shouldSearch(StudentsRegister register) {
        Mockito.when(repository.search()).thenReturn(Optional.of(register));
    }

    public void shouldSearch() {
        Mockito.when(repository.search()).thenReturn(Optional.empty());
    }

    public void shouldHaveSaved(StudentsRegister student) {
        verify(repository, atLeastOnce()).save(student);
    }
}
