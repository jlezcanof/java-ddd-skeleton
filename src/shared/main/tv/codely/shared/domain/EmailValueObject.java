package tv.codely.shared.domain;

import java.util.Objects;
import java.util.regex.Pattern;

public abstract class EmailValueObject {
    private final String value;

    private final String regexPattern ="^(.+)@(\\S+)$";
    //private final String regexPattern2 ="^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    public EmailValueObject(final String value) {
        if (!Pattern.compile(regexPattern)
            .matcher(value)
            .matches()) {
            throw new InvalidFieldEmail(value);
        }
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public String toString() {
        return this.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EmailValueObject)) {
            return false;
        }
        EmailValueObject that = (EmailValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
