package tv.codely.mooc.students_register.domain;

import java.util.Optional;

public interface StudentsRegisterRepository {
    void save(StudentsRegister register);

    Optional<StudentsRegister> search();
}
