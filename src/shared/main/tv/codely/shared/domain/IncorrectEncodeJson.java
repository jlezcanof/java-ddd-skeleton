package tv.codely.shared.domain;

import java.io.Serializable;
import java.util.HashMap;

public final class IncorrectEncodeJson extends DomainError {


    public IncorrectEncodeJson(HashMap<String, Serializable> map) {
        super("incorrect_encode_json",
            String.format(String.format("No support encode json <%s> ", map.toString())));
    }
}
