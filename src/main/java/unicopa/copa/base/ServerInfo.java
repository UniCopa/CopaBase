/*
 * Copyright (C) 2013 UniCoPA
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package unicopa.copa.base;

import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * Contains information about the service running.
 * 
 * @author Felix Wiemuth
 */
public class ServerInfo {
    private String version;
    private String commitID;
    private String apiVersion;
    private Date runningSince;
    private List<String> availableRequests;

    public ServerInfo(Properties versionProperties, Date runningSince,
	    List<String> availableRequests) {
	version = versionProperties.getProperty("version");
	commitID = versionProperties.getProperty("commitID");
	apiVersion = versionProperties.getProperty("apiVersion");
	this.runningSince = runningSince;
	this.availableRequests = availableRequests;
    }

    public String getVersion() {
	return version;
    }

    public String getCommitID() {
	return commitID;
    }

    public String getShortCommitID() {
	if (commitID == null || commitID.length() < 7) {
	    return null;
	}
	return commitID.substring(0, 7);
    }

    public String getApiVersion() {
	return apiVersion;
    }

    public Date getRunningSince() {
	return runningSince;
    }

    public List<String> getAvailableRequests() {
	return availableRequests;
    }
}
