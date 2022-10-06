package tv.codely.backoffice.videos.infrastructure;

import tv.codely.backoffice.videos.infrastructure.persistence.InMemoryBackofficeVideoRepository;

public abstract class BackofficeVideoCreateModuleInfrastructureTestCase   {
    protected InMemoryBackofficeVideoRepository inMemoryBackofficeVideoRepository =
      new InMemoryBackofficeVideoRepository();

    //@Autowired
    //protected BackofficeVideoRepository mySqlBackofficeVideoRepository;
}
