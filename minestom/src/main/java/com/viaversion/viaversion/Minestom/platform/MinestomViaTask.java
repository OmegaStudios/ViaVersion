package com.viaversion.viaversion.Minestom.platform;

import com.google.common.base.Preconditions;
import com.viaversion.viaversion.api.platform.PlatformTask;
import net.minestom.server.timer.Task;
import org.checkerframework.checker.nullness.qual.Nullable;

public class MinestomViaTask implements PlatformTask<Task> {
    private final Task task;

    public MinestomViaTask(Task task) { this.task = task; }

    @Override
    public @Nullable Task getObject() {
        return task;
    }

    @Override
    public void cancel() {
        Preconditions.checkArgument(task != null, "Task cannot be cancelled");
        task.cancel();
    }
}
