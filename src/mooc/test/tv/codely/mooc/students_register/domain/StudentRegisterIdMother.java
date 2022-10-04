package tv.codely.mooc.students_register.domain;

import tv.codely.shared.domain.UuidMother;

public final class StudentRegisterIdMother {

    public static StudentsRegisterId create(String value) {
        return new StudentsRegisterId(value);
    }

    public static StudentsRegisterId random() {
        return create(UuidMother.random());
    }
}
