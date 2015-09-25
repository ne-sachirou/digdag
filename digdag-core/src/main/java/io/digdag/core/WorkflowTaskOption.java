package io.digdag.core;

import org.immutables.value.Value;
import com.fasterxml.jackson.annotation.JsonProperty;

@Value.Immutable
public abstract class WorkflowTaskOption
{
    @JsonProperty("g")
    public abstract boolean getGroupingOnly();

    public static class Builder extends ImmutableWorkflowTaskOption.Builder { }
}
