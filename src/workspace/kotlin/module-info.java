module fleet.greeting.plugin.workspace {
    requires kotlin.stdlib;
    requires fleet.kernel;
    requires fleet.greeting.plugin.common;
    requires fleet.run.common;
    requires io.ktor.client.core;
    requires io.ktor.client.cio;
    requires kotlinx.coroutines.core.jvm;

    exports greeting.workspace;
}