package tv.codely.mooc.videos.application.create;

import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.StepTitle;
import tv.codely.mooc.steps.domain.video.Video;
import tv.codely.mooc.steps.domain.video.VideoStep;
import tv.codely.mooc.steps.domain.video.VideoStepText;
import tv.codely.mooc.videos.domain.VideoRepository;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.VideoUrl;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public final class VideoCreator {
    private final VideoRepository repository;
    private final EventBus         eventBus;

    public VideoCreator(VideoRepository repository, EventBus eventBus) {
        this.repository = repository;
        this.eventBus   = eventBus;
    }

    public void create(StepId id, VideoStepText text, VideoUrl url, StepTitle title) {
          Video video = Video.create(id, text, url, title);
        //        VideoStep video = VideoStep.create(id, name, duration);

        //repository.save(video);
        eventBus.publish(video.pullDomainEvents());

    }
}
