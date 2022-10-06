package tv.codely.mooc.students_register.application.find;

import java.util.Objects;
import tv.codely.shared.domain.bus.query.Response;

public final class StudentsCounterResponse implements Response {
    private Integer total;

    public StudentsCounterResponse(Integer total) {
        this.total = total;
    }

    public Integer total() {
        return total;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StudentsCounterResponse that = (StudentsCounterResponse) o;
        return total.equals(that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(total);
    }
}
