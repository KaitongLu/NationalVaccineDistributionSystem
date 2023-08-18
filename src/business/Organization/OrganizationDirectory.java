/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business.Organization;

import business.Organization.Organization.Type;
import java.util.ArrayList;

public class OrganizationDirectory {

    private ArrayList<Organization> organizationList;

    public OrganizationDirectory() {
        organizationList = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationList() {
        return organizationList;
    }

    public Organization createOrganization(Type type, String name) {
        Organization organization = null;
        if (type.getValue().equals(Type.CDC.getValue())) {
            organization = new CDCOrganization(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.PHD.getValue())) {
            organization = new PHDOrganization(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Distributor.getValue())) {
            organization = new DistributorOrganization(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Clinic.getValue())) {
            organization = new ClinicOrganization(name);
            organizationList.add(organization);
        } else if (type.getValue().equals(Type.Provider.getValue())) {
            organization = new ProviderOrganization(name);
            organizationList.add(organization);
        }
        return organization;
    }

    public Organization createOrganization(Type type, Organization parentOrganization, String name) {
        Organization organization = createOrganization(type, name);
        if (organization instanceof ClinicOrganization && parentOrganization instanceof ProviderOrganization) {
            ((ClinicOrganization) organization).setParentProvider((ProviderOrganization) parentOrganization);
            ((ProviderOrganization) parentOrganization).getClinics().add((ClinicOrganization) organization);
        } else if (organization instanceof ProviderOrganization && parentOrganization instanceof PHDOrganization) {
            ((ProviderOrganization) organization).setParentPHD((PHDOrganization) parentOrganization);
            ((PHDOrganization) parentOrganization).getProviders().add((ProviderOrganization) organization);
        } else if (organization instanceof PHDOrganization && parentOrganization instanceof CDCOrganization) {
            ((PHDOrganization) organization).setParentCDC((CDCOrganization) parentOrganization);
            ((CDCOrganization) parentOrganization).getPhdOrganizations().add((PHDOrganization) organization);
        }

        return organization;
    }

    public Organization findOrganization(String name) {
        for (Organization organization : organizationList) {
            if (organization.getName().equals(name)) {
                return organization;
            }
        }
        return null;
    }
}
