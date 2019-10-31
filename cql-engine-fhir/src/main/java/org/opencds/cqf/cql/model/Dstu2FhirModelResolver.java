package org.opencds.cqf.cql.model;

import ca.uhn.fhir.context.FhirContext;
import ca.uhn.fhir.context.FhirVersionEnum;

import org.hl7.fhir.instance.model.*;

public class Dstu2FhirModelResolver extends FhirModelResolver {

	public Dstu2FhirModelResolver() {
		super(FhirContext.forDstu2());
	}

	public Dstu2FhirModelResolver(FhirContext fhirContext) {
        super(fhirContext);
        
        if (fhirContext.getVersion().getVersion() != FhirVersionEnum.DSTU2) {
            throw new IllegalArgumentException("The supplied context is not configured for DSTU2");
        }
	}

	@Override
	protected void setPackageName() {
		this.packageName = "org.hl7.fhir.instance.model";
	}

    @Override
    public Boolean objectEqual(Object left, Object right) {
        if (left == null) {
            return null;
        }

        if (right == null) {
            return null;
        }

        Base base = (Base)left;
        return base.equalsDeep((Base)right);
    }

    @Override
    public Boolean objectEquivalent(Object left, Object right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null) {
            return false;
        }

        Base base = (Base)left;
        return base.equalsDeep((Base)right);
    }

	@Override
	public Object getContextPath(String contextType, String targetType) {
        switch (targetType) {
            case "Patient":
                return "id";
            default: return "patient";
        }
	}
}