package tv.codely.shared.domain;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public abstract class UrlValueObject {
    private final String value;

    public UrlValueObject(final String value) {
        try {
            new URL(value);
        } catch (MalformedURLException malFormed){
            throw new InvalidFieldUrl(value);
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
        if (!(o instanceof UrlValueObject)) {
            return false;
        }
        UrlValueObject that = (UrlValueObject) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
