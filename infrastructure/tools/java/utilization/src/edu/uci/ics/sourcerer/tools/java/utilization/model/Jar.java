/* 
 * Sourcerer: an infrastructure for large-scale source code analysis.
 * Copyright (C) by contributors. See CONTRIBUTORS.txt for full list.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.

 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package edu.uci.ics.sourcerer.tools.java.utilization.model;

import java.util.ArrayList;
import java.util.Collection;

import edu.uci.ics.sourcerer.tools.java.repo.model.JarFile;

/**
 * @author Joel Ossher (jossher@uci.edu)
 */
public class Jar {
  private final JarFile jar;
  private final Collection<FqnFragment> fqns;
  
  Jar(JarFile jar) {
    this.jar = jar;
    fqns = new ArrayList<>();
  }
  
  void addFqn(FqnFragment fqn) {
    fqns.add(fqn);
    fqn.addJar(this);
  }
  
  void delete() {
    for (FqnFragment fragment : fqns) {
      fragment.deleteJar(this);
    }
  }
  
  public JarFile getJar() {
    return jar;
  }
  
  public Collection<FqnFragment> getFqns() {
    return fqns;
  }
  
  @Override
  public String toString() {
    return jar.toString();
  }
}