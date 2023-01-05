module fleet.greeting.plugin.frontend {
    requires fleet.frontend;
    requires fleet.kernel;
    requires fleet.noria.ui;
    requires fleet.rhizomedb;
    requires fleet.frontend.ui;
    requires fleet.greeting.plugin.common;

    exports greeting.frontend;
}