package io.digdag.server;

import java.util.Date;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;
import io.digdag.core.config.Config;
import io.digdag.core.repository.StoredRepository;
import io.digdag.core.repository.StoredRevision;
import io.digdag.core.repository.StoredWorkflowSource;

@Value.Immutable
@JsonSerialize(as = ImmutableRestWorkflow.class)
@JsonDeserialize(as = ImmutableRestWorkflow.class)
public abstract class RestWorkflow
{
    public abstract int getId();

    public abstract String getName();

    public abstract IdName getRepository();

    public abstract String getRevision();

    public abstract Config getConfig();

    //public abstract IdName getSchedule();

    public static ImmutableRestWorkflow.Builder builder()
    {
        return ImmutableRestWorkflow.builder();
    }

    public static RestWorkflow of(StoredRepository repo, StoredRevision rev, StoredWorkflowSource workflow)
    {
        return builder()
            .id(workflow.getId())
            .name(workflow.getName())
            .config(workflow.getConfig())
            .repository(IdName.of(repo.getId(), repo.getName()))
            .revision(rev.getName())
            .build();
    }
}
