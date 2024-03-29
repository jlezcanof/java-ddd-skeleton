package tv.codely.mooc.students.domain;

import tv.codely.shared.domain.UuidMother;

public final class StudentNameMother {

    public static StudentName create(String value) {
        return new StudentName(value);
    }

    public static StudentName random() {
        return create(UuidMother.random());
    }
}
