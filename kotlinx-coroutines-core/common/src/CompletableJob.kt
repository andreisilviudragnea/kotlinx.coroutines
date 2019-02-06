/*
 * Copyright 2016-2018 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

package kotlinx.coroutines

/**
 * A job that can be completed using [complete()] function.
 * It is returned by [Job()][Job] and [SupervisorJob()][SupervisorJob] constructor functions.
 */
public interface CompletableJob : Job {
    /**
     * Completes this job. The result is `true` if this job was completed as a result of this invocation and
     * `false` otherwise (if it was already completed).
     *
     * Repeated invocations of this function have no effect and always produce `false`.
     *
     * Note, that if this job has children, then it transitions into _completing_ state and becomes _complete_
     * once all its children are _complete_. See [Job] for details.
     */
    public fun complete(): Boolean

    /**
     * Completes this job exceptionally with a given [exception]. The result is `true` if this job was
     * completed as a result of this invocation and `false` otherwise (if it was already completed).
     *
     * Repeated invocations of this function have no effect and always produce `false`.
     */
    public fun completeExceptionally(exception: Throwable): Boolean
}