package tv.codely.shared.domain;

public final class UrlMother {

    public static String random() {
        return MotherCreator.random().internet().url();
    }
}
