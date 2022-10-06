package tv.codely.mooc.videos.application.create;

import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepTitle;
import tv.codely.mooc.steps.domain.video.VideoStepText;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.bus.command.CommandHandler;

@Service
public final class CreateVideoCommandHandler implements CommandHandler<CreateVideoCommand> {
    private final VideoCreator creator;

    public CreateVideoCommandHandler(VideoCreator creator) {
        this.creator = creator;
    }

    @Override
    public void handle(CreateVideoCommand command) {
        StepId        id    = new StepId(command.id());
        VideoStepText text  = new VideoStepText(command.text());
        VideoUrl      url   = new VideoUrl(command.url());
        StepTitle     title = new StepTitle(command.title());

        creator.create(id, text, url, title);
    }
}
