
Guice DI support
----------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/guice](http://artifacts.griffon-framework.org/plugin/guice)


Enables the usage of [Google's Guice][1] as Dependency Injection provider, and much more!

Usage
-----
Upon installation the plugin will generate the following artifacts in `$appdir/src/guice`:

 * GuiceConfig.groovy - defines the Modules to be included in the Guice injector.
 * <appName>Module.groovy - defines a defualt Module for the application itself.

Configuration
-------------
Define as many Modules as needed, then configure them in `GuiceConfig.groovy`.

The default `com.google.inject.Injector` is accessible via `GuiceInjectorHolder.getInjector()`.

[1]: http://code.google.com/p/google-guice

