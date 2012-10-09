class GuiceGriffonPlugin {
    // the plugin version
    String version = '0.1'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.1.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [:]
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = []
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-guice-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]
    String title = 'Guice DI support'
    String description = '''
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
'''
}

