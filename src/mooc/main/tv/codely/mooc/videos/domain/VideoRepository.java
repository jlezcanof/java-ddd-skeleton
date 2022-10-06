package tv.codely.mooc.videos.domain;

import java.util.Optional;
import tv.codely.mooc.steps.domain.StepId;
import tv.codely.mooc.steps.domain.video.VideoStep;

public interface VideoRepository {
    Optional<VideoStep> search(StepId videoId);

    void save(VideoStep video);

}
