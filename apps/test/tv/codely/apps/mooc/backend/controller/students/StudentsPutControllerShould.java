package tv.codely.apps.mooc.backend.controller.students;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.MoocApplicationTestCase;

public final class StudentsPutControllerShould extends MoocApplicationTestCase {
    @Test
    void create_a_valid_non_existing_student() throws Exception {
        assertRequestWithBody(
            "PUT",
            "/students/1aab45ba-3c7a-4344-8936-78466eca77fb",
            "{\"name\": \"name\", \"surname\": \"surname\", \"email\": \"a@a.es\"}",
            201
        );
    }
}
