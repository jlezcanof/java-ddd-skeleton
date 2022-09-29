package tv.codely.apps.mooc.backend.controller.students;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

public final class StudentsPutControllerShould extends MoocApplicationTestCase {

    @Test
    void register_a_valid_non_existing_student() throws Exception{

        assertRequestWithBody(
            "PUT",
            "/students/469ba883-f471-4290-b389-3b1b1e12790c",
            "{\"name\": \"guzman\", \"surname\": \"el bueno\", \"email\": \"a@a.es\"}",
            201
                             );
    }
}
