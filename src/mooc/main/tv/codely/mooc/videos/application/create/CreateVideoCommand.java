package tv.codely.mooc.videos.application.create;

import tv.codely.shared.domain.bus.command.Command;

public final class CreateVideoCommand implements Command {
    private final String id;

    private final String url;

    private final String text;

    private final String title;


    public CreateVideoCommand(String id, String url, String text, String title) {
        this.id      = id;
        this.url     = url;
        this.text    = text;
        this.title   = title;
    }


    public String id() {
        return id;
    }

    public String url() {
        return url;
    }

    public String text() {
        return text;
    }

    public String title() {
        return title;
    }




}
