module fleet.greeting.plugin.workspace {
    requires kotlin.stdlib;
    requires fleet.kernel;
    requires fleet.greeting.plugin.common;
    requires fleet.run.common;

    exports greeting.workspace;
}