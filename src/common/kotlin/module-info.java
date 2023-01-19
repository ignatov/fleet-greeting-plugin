module fleet.greeting.plugin.common {
    requires fleet.rhizomedb;
    requires kotlin.stdlib;
    requires fleet.kernel;
    requires fleet.run.common;

    exports greeting.common;
}