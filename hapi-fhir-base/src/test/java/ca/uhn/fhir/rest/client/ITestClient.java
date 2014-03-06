package ca.uhn.fhir.rest.client;

import ca.uhn.fhir.model.api.Bundle;
import ca.uhn.fhir.model.dstu.composite.IdentifierDt;
import ca.uhn.fhir.model.dstu.resource.Patient;
import ca.uhn.fhir.model.primitive.IdDt;
import ca.uhn.fhir.rest.annotation.Read;
import ca.uhn.fhir.rest.client.api.IRestfulClient;
import ca.uhn.fhir.rest.server.operations.Search;
import ca.uhn.fhir.rest.server.parameters.Required;

public interface ITestClient extends IRestfulClient {

	@Read(value=Patient.class)
	Patient getPatientById(@Read.IdParam IdDt theId);

	@Search(value=Patient.class)
	Patient findPatientByMrn(@Required(name = Patient.SP_IDENTIFIER) IdentifierDt theId);
	
	@Search(value=Patient.class)
	Bundle findPatientByLastName(@Required(name = Patient.SP_FAMILY) IdentifierDt theId);
	
	
}
