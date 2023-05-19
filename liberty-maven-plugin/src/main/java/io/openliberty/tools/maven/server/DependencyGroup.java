/**
 * (C) Copyright IBM Corporation 2020, 2023.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package io.openliberty.tools.maven.server;

import java.util.ArrayList;
import java.util.List;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * A collection of Dependency with an optional location.
 */
public class DependencyGroup {

    /**
     * A list of Dependency to copy.
     */
    private List<Dependency> copyDependencyList = new ArrayList<Dependency>();
    
    /**
     * Optional location to copy the Dependency to. This can be a full path, or a path relative to
     * ${server.config.dir}. The location in the containing CopyDependencies configuration will be 
     * used if nothing is specified here.
     */
    @Parameter
    private String location = null;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
    
    /**
     * Boolean to indicate whether to strip versions from the file names when copying.
     * The stripVersion in the containing CopyDependencies configuration will be 
     * used if nothing is specified here.
     */
    @Parameter
    private Boolean stripVersion = null;

    public Boolean getStripVersion() {
        return this.stripVersion;
    }

    public void setStripVersion(boolean strip) {
        this.stripVersion = Boolean.valueOf(strip);
    }
    /**
     * Get all the current Dependency to copy.
     *
     * @return A list with the Dependency to copy.
     */
    public List<Dependency> getDependencies() {
        return copyDependencyList;
    }

    /**
     * Add a Dependency into a list.
     *
     * @param dependency
     */
    public void addDependency(Dependency dependency) {
        copyDependencyList.add(dependency);
    }

}
