package aii.steps;

import org.junit.Test;

import aii.utils.APIConstants;
import aii.utils.APIGlobalVariables;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class API {
	
	@Test
	@When("I enter required information when creating quote and I validate response body for Quote Creation Confirmation")
	public void i_enter_required_information_when_creating_quote_and_i_validate_response_body_for_quote_creation_confirmation() {
	    
		String payload="{\r\n"
				+ "  \"customerId\": \"TEST\",\r\n"
				+ "  \r\n"
				+ "  \"customerKey\": null,\r\n"
				+ "  \"quoteRequest\": {\r\n"
				+ "  \"productType\": \"DP3\",\r\n"
				+ "  \"producer\": \"AG6718A1\",\r\n"
				+ "  \"priorPolicy\": {\r\n"
				+ "    \"expirationDate\": \"2022-02-01\",\r\n"
				+ "    \"premium\": 1200,\r\n"
				+ "    \"carrier\": \"OTHER\",\r\n"
				+ "    \"originalEffectiveDate\": \"\",\r\n"
				+ "    \"priorPolicyNumber\": \"\"\r\n"
				+ "  },\r\n"
				+ "  \"entityType\": \"JOINT\",\r\n"
				+ "  \"insured\": {\r\n"
				+ "    \"name\": {\r\n"
				+ "      \"commercial\": \"Victor Hedman and Sanna Hedman\",\r\n"
				+ "      \"first\": \"Victor\",\r\n"
				+ "      \"middle\": \"\",\r\n"
				+ "      \"last\": \"Hedman\"\r\n"
				+ "    },\r\n"
				+ "    \"dateOfBirth\": \"1990-12-18\",\r\n"
				+ "    \"primaryPhone\": {\r\n"
				+ "      \"value\": \"(904)371-4627\",\r\n"
				+ "      \"name\": \"Victor Hedman\"\r\n"
				+ "    },\r\n"
				+ "    \"email\": \"\"\r\n"
				+ "  },\r\n"
				+ "  \"insuranceScore\": \"Better Than Average (750-849)\",\r\n"
				+ "  \"coInsured\": {\r\n"
				+ "    \"firstName\": \"Sanna\",\r\n"
				+ "    \"middleName\": \"\",\r\n"
				+ "    \"lastName\": \"Hedman\",\r\n"
				+ "    \"dateOfBirth\": \"1991-09-06\"\r\n"
				+ "  },\r\n"
				+ "  \"insuredProperty\": {\r\n"
				+ "    \"dwellingType\": \"SINGLE FAMILY\",\r\n"
				+ "      \"location\": {\r\n"
				+ "      \"address\": \"3207 W PAUL AVE\",\r\n"
				+ "      \"city\": \"TAMPA\",\r\n"
				+ "      \"county\": \"Hillsborough\",\r\n"
				+ "      \"state\": \"FL\",\r\n"
				+ "      \"zipCode\": \"33611\"\r\n"
				+ "    },\r\n"
				+ "    \"bceg\": \"UNGRADED\",\r\n"
				+ "    \"constructionType\": \"FRAME\",\r\n"
				+ "    \"numberOfUnits\": 1,\r\n"
				+ "    \"occupancy\": \"OWNER\",\r\n"
				+ "    \"monthsOccupied\": 12,\r\n"
				+ "    \"numberOfStories\": 1,\r\n"
				+ "    \"storyUnitIsLocated\": 0,\r\n"
				+ "    \"distanceToCoast\": \"15 mi to less than 20 mi\"\r\n"
				+ "  },\r\n"
				+ "  \"dwelling\": {\r\n"
				+ "    \"distanceToHydrant\": \"LESS THAN OR EQUAL 1000 FEET\",\r\n"
				+ "    \"protectionClass\": 3,\r\n"
				+ "    \"squareFeet\": 1068,\r\n"
				+ "    \"yearOfConstruction\": 2016,\r\n"
				+ "    \"yearRoofMaterialUpdated\": 2016,\r\n"
				+ "    \"propertyManaged\": false,\r\n"
				+ "    \"shortTermRental\": false,\r\n"
				+ "    \"roofMaterial\": \"Concrete/Clay Tile\"\r\n"
				+ "  },\r\n"
				+ "  \"reservePackage\": \"INTEGRITYSELECT\",\r\n"
				+ "  \"deductibles\": {\r\n"
				+ "    \"aop\": 1000,\r\n"
				+ "    \"hurricane\": 10,\r\n"
				+ "    \"windHail\": 1000,\r\n"
				+ "    \"windHailExclusion\": false\r\n"
				+ "  },\r\n"
				+ "  \"coverages\": {\r\n"
				+ "    \"covA\": 750000,\r\n"
				+ "    \"covB\": 2,\r\n"
				+ "    \"covC\": 500000,\r\n"
				+ "    \"covE\": 300000,\r\n"
				+ "    \"covF\": 5000,\r\n"
				+ "    \"covL\": 300000,\r\n"
				+ "    \"covM\": 5000,\r\n"
				+ "    \"homeComputer\": 0,\r\n"
				+ "    \"homeSystemsProtection\": \"50000/10000\",\r\n"
				+ "    \"identityRecovery\": \"15000\",\r\n"
				+ "    \"lossAssessment\": \"1000\",\r\n"
				+ "    \"fungiMoldEtc\": \"10000/10000\",\r\n"
				+ "    \"ordinanceOrLaw\": 25,\r\n"
				+ "    \"serviceLine\": \"None\",\r\n"
				+ "    \"waterBackupSumpOverflow\": \"\",\r\n"
				+ "    \"refrigeratedPersonalProperty\": false\r\n"
				+ "  },\r\n"
				+ "  \"optionalCoverages\": {\r\n"
				+ "    \"animalLiability\": true,\r\n"
				+ "    \"carportPoolCageScreen\": \"\",\r\n"
				+ "    \"animalLiabilityAmount\":\"300001\",\r\n"
				+ "    \"increasedDwellingReplacementCost\": true,\r\n"
				+ "    \"personalInjury\": true,\r\n"
				+ "    \"personalPropertyReplacementCost\": false,\r\n"
				+ "    \"sinkholeLoss\": \"10\",\r\n"
				+ "    \"waterDamageExclusion\": false,\r\n"
				+ "    \"waterDamageLimited\": false,\r\n"
				+ "    \"unitOwnersCovA\": false,\r\n"
				+ "    \"unitOwnersCovC\": false,\r\n"
				+ "    \"storageSlipRental\": false\r\n"
				+ "  },\r\n"
				+ "  \"discounts\": {\r\n"
				+ "    \"burglarAlarmCredit\": \"CENTRAL STATION\",\r\n"
				+ "    \"fireAlarmCredit\": \"CENTRAL STATION\",\r\n"
				+ "    \"proofOfUpdates\": \"ROOF ONLY\",\r\n"
				+ "    \"securedCommunityBldg\": \"\",\r\n"
				+ "    \"sprinklerSystem\": \"NONE\",\r\n"
				+ "    \"openFoundation\": false,\r\n"
				+ "    \"hardiplankSiding\": false,\r\n"
				+ "    \"military\": true\r\n"
				+ "  },\r\n"
				+ "  \"windMitigation\": {\r\n"
				+ "    \"openingProtection\": \"NONE\",\r\n"
				+ "    \"roofCover\": \"FBC EQUIVALENT\",\r\n"
				+ "    \"roofDeck\": \"\",\r\n"
				+ "    \"roofDeckAttachment\": \"\",\r\n"
				+ "    \"roofShape\": \"GABLE\",\r\n"
				+ "    \"roofToWallAttachment\": \"\",\r\n"
				+ "    \"secondaryWaterResistance\": false\r\n"
				+ "  },\r\n"
				+ "  \"effectiveDate\": \"2022-02-01\",\r\n"
				+ "   \"dataReports\": {\r\n"
				+ "  	\"runInsuranceScore\": false\r\n"
				+ "  }	\r\n"
				+ "} ,\r\n"
				+ "  \"requestId\": \"8720-88776\",\r\n"
				+ "  \"responseDetail\": true\r\n"
				+ "}";
		
		RestAssured.baseURI=APIConstants.BASE_URI;
		
		RestAssured.given().auth().preemptive().
		basic(APIGlobalVariables.username, APIGlobalVariables.password).
		body(payload)
		.contentType(ContentType.JSON).post().prettyPeek().then().
		assertThat().statusCode(200);

		
		
	}
	


}
