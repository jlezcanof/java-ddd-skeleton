package tv.codely.mooc.students_register.domain;

import java.util.ArrayList;
import java.util.List;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.shared.domain.ListMother;

public final class StudentsRegisterMother {

    public static StudentsRegister create(
        StudentsRegisterId id,
        StudentsRegisterTotal total,
        List<StudentId> existingStudents
                                       ) {
        return new StudentsRegister(id, total, existingStudents);
    }

    public static StudentsRegister withOne(StudentId studentId) {
        return create(
            StudentRegisterIdMother.random(), StudentsRegisterTotalMother.one(),
            ListMother.one(studentId));
    }

    public static StudentsRegister random() {
        List<StudentId> existingCourses = ListMother.random(StudentIdMother::random);

        return create(
            StudentRegisterIdMother.random(),
            StudentsRegisterTotalMother.create(existingCourses.size()),
            existingCourses
                     );
    }

    public static StudentsRegister incrementing(StudentsRegister existingRegister,
                                                StudentId studentId) {
        List<StudentId> existingStudents =
            new ArrayList<>(existingRegister.existingStudents());
        existingStudents.add(studentId);

        return create(
            existingRegister.id(),
            StudentsRegisterTotalMother.create(existingRegister.total().value() + 1),
            existingStudents);
    }
}
