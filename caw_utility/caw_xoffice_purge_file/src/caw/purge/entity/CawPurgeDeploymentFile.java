/**
 * CONFIDENTIAL AND PROPRIETARY SOURCE CODE. 
 * 
 * Use and distribution of this code is subject to applicable 
 * licenses and the permission of the code owner.  This notice 
 * does not indicate the actual or intended publication of 
 * this source code.
 * 
 * Portions developed for Camping World by BTM Global Consulting
 * LLC and are the property of Camping World.
 * 
 * ===== BTM Modification ===========================================
 * Req/Bug ID#          ddMMyy    Description
 * BZ35616              210320    Purge Xadmin deployments based on date 
 *===================================================================
 */
package caw.purge.entity;

public class CawPurgeDeploymentFile {
	private long organizationId;
	private long deploymentId;
	private String deploymentName;
	private String deploymentStatus;

	/**
	 * @return the deploymentId
	 */
	public long getDeploymentId() {
		return deploymentId;
	}

	/**
	 * @param deploymentId the deploymentId to set
	 */
	public void setDeploymentId(long deploymentId) {
		this.deploymentId = deploymentId;
	}

	/**
	 * @return the deploymentName
	 */
	public String getDeploymentName() {
		return deploymentName;
	}

	/**
	 * @param deploymentName the deploymentName to set
	 */
	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	/**
	 * @return the deploymentStatus
	 */
	public String getDeploymentStatus() {
		return deploymentStatus;
	}

	/**
	 * @param deploymentStatus the deploymentStatus to set
	 */
	public void setDeploymentStatus(String deploymentStatus) {
		this.deploymentStatus = deploymentStatus;
	}
	

	public long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(long organizationId) {
		this.organizationId = organizationId;
	}

	@Override
	public String toString() {
		return "[ORGANIZATION_ID="+ organizationId + ", DEPLOYMENT_ID="+ deploymentId + ", DEPLOYMENT_NAME=" + deploymentName + ", DEPLOYMENT_STATUS=" + deploymentStatus +"]";
	}
}
