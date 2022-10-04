package tv.codely.mooc.students_register.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import tv.codely.mooc.students.domain.StudentId;

public final class StudentsRegister {
    private StudentsRegisterId    id;
    private StudentsRegisterTotal total;
    private List<StudentId>       existingStudents;

    public StudentsRegister(StudentsRegisterId id, StudentsRegisterTotal total, List<StudentId> existingStudents) {
        this.id               = id;
        this.total            = total;
        this.existingStudents = existingStudents;
    }

    private StudentsRegister() {
        this.id               = null;
        this.total            = null;
        this.existingStudents = null;
    }

    public static StudentsRegister initialize(String id) {
        return new StudentsRegister(new StudentsRegisterId(id), StudentsRegisterTotal.initialize(), new ArrayList<>());
    }

    public StudentsRegisterId id() {
        return id;
    }

    public StudentsRegisterTotal total() {
        return total;
    }

    public List<StudentId> existingStudents() {
        return existingStudents;
    }

    public boolean hasIncremented(StudentId id) {
        return existingStudents.contains(id);
    }

    public void increment(StudentId id) {
        total = total.increment();
        existingStudents.add(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentsRegister that = (StudentsRegister) o;
        return id.equals(that.id) &&
               total.equals(that.total) &&
            existingStudents.equals(that.existingStudents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existingStudents);
    }
}
