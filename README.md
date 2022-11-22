snyk-gradle-init
================

This java maven dependency contains a fork of the snyk gradle init script.
The orignally can be found [here](https://github.com/snyk/snyk-gradle-plugin/blob/master/lib/init.gradle)
This adjusted init script is used as a workaround to support the collection of buildscript dependencies and plugins
in a gradle build. The default snyk script will only collect compile dependencies for a java/kotlin/etc build.

I started this project with a commit of the original file to track the changes over time.
The fix consists of two changes.

1. The actual change to include the `classpath` configuration from the build script.
2. A change on how the `snykResolvedDepsJson` task is added. Snyk doesn't provide a simple custom task type but rather a doLast script which needs to be replaced.
 
LICENSE
=======

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

<http://www.apache.org/licenses/LICENSE-2.0>

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
