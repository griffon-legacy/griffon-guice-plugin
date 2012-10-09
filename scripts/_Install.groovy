/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the 'License');
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an 'AS IS' BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * @author Andres Almiray
 */
 
includeTargets << griffonScript('_GriffonCreateArtifacts')

ant.mkdir(dir: "${basedir}/src/guice")

argsMap = argsMap ?: [:]
argsMap['skip-package-prompt'] = true

defaultFileType = buildConfig.app.fileType
defaultPackageName = buildConfig.app.defaultPackageName
defaultPackageNameAsPath = defaultPackageName.replace('\\.','/')
applicationName = griffonAppName.capitalize()
defaultAppModule = new File("${basedir}/src/guice/${defaultPackageNameAsPath}.${applicationName}Module.${defaultFileType}")

guiceConfigFile = new File("${basedir}/src/guice/GuiceConfig.groovy")
if(!guiceConfigFile.exists()) {
   createArtifact(
      name:   "GuiceConfig",
      suffix: "",
      type:   "GuiceConfig",
      path:   "src/guice")
}
if(guiceConfigFile.exists()) {
    ant.replace(file: guiceConfigFile) {
        replacefilter(token: "@module.name@", value: "${applicationName}Module")
        replacefilter(token: "@module.package@", value: defaultPackageName)
    }
}

if(!defaultAppModule.exists()) {
   createArtifact(
      name:   "${defaultPackageName}.${applicationName}",
      suffix: "Module",
      type:   "GuiceModule",
      path:   "src/guice")
}
