package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.UuidMother;

public final class StudentSurnameMother {

    public static StudentSurname create(String value) {
        return new StudentSurname(value);
    }

    public static StudentSurname random() {
        return create(UuidMother.random());
    }
}
