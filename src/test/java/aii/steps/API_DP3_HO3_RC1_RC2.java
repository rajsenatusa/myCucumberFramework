package aii.steps;

import org.junit.Test;

import aii.utils.APIConstants;
import aii.utils.APIGlobalVariables;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.hamcrest.Matchers.*;

public class API_DP3_HO3_RC1_RC2 {

	// Scenario: Validation DP3 Quote Process
	@Test
	@When("User enters required information when creating quote and I validate response body for Quote Creation Confirmation")
	public void user_enters_required_information_when_creating_quote_and_i_validate_response_body_for_quote_creation_confirmation() {

		String payload = "{\r\n" + "  \"customerId\": \"TEST\",\r\n" + "  \r\n" + "  \"customerKey\": null,\r\n"
				+ "  \"quoteRequest\": {\r\n" + "  \"productType\": \"DP3\",\r\n" + "  \"producer\": \"AG6718A1\",\r\n"
				+ "  \"priorPolicy\": {\r\n" + "    \"expirationDate\": \"2022-04-01\",\r\n"
				+ "    \"premium\": 1200,\r\n" + "    \"carrier\": \"OTHER\",\r\n"
				+ "    \"originalEffectiveDate\": \"\",\r\n" + "    \"priorPolicyNumber\": \"\"\r\n" + "  },\r\n"
				+ "  \"entityType\": \"JOINT\",\r\n" + "  \"insured\": {\r\n" + "    \"name\": {\r\n"
				+ "      \"commercial\": \"Victor Hedman and Sanna Hedman\",\r\n" + "      \"first\": \"Victor\",\r\n"
				+ "      \"middle\": \"\",\r\n" + "      \"last\": \"Hedman\"\r\n" + "    },\r\n"
				+ "    \"dateOfBirth\": \"1990-12-18\",\r\n" + "    \"primaryPhone\": {\r\n"
				+ "      \"value\": \"(904)371-4627\",\r\n" + "      \"name\": \"Victor Hedman\"\r\n" + "    },\r\n"
				+ "    \"email\": \"\"\r\n" + "  },\r\n" + "  \"insuranceScore\": \"\",\r\n" + "  \"coInsured\": {\r\n"
				+ "    \"firstName\": \"Sanna\",\r\n" + "    \"middleName\": \"\",\r\n"
				+ "    \"lastName\": \"Hedman\",\r\n" + "    \"dateOfBirth\": \"1991-09-06\"\r\n" + "  },\r\n"
				+ "  \"insuredProperty\": {\r\n" + "    \"dwellingType\": \"SINGLE FAMILY\",\r\n"
				+ "      \"location\": {\r\n" + "      \"address\": \"1710 E Kirby\",\r\n"
				+ "      \"city\": \"TAMPA\",\r\n" + "      \"county\": \"Hillsborough\",\r\n"
				+ "      \"state\": \"FL\",\r\n" + "      \"zipCode\": \"33604\"\r\n" + "    },\r\n"
				+ "    \"bceg\": \"UNGRADED\",\r\n" + "    \"constructionType\": \"FRAME\",\r\n"
				+ "    \"numberOfUnits\": 1,\r\n" + "    \"occupancy\": \"TENANT\",\r\n"
				+ "    \"monthsOccupied\": 12,\r\n" + "    \"numberOfStories\": 1,\r\n"
				+ "    \"storyUnitIsLocated\": 0,\r\n" + "    \"distanceToCoast\": \"15 mi to less than 20 mi\"\r\n"
				+ "  },\r\n" + "  \"dwelling\": {\r\n"
				+ "    \"distanceToHydrant\": \"LESS THAN OR EQUAL 1000 FEET\",\r\n" + "    \"protectionClass\": 3,\r\n"
				+ "    \"squareFeet\": 1068,\r\n" + "    \"yearOfConstruction\": 2018,\r\n"
				+ "    \"yearRoofMaterialUpdated\": 2018,\r\n" + "    \"propertyManaged\": false,\r\n"
				+ "    \"shortTermRental\": false,\r\n" + "    \"roofMaterial\": \"Concrete/Clay Tile\"\r\n"
				+ "  },\r\n" + "  \"reservePackage\": \"BASIC\",\r\n" + "  \"deductibles\": {\r\n"
				+ "    \"aop\": 1000,\r\n" + "    \"hurricane\": 10,\r\n" + "    \"windHail\": 1000,\r\n"
				+ "    \"windHailExclusion\": false\r\n" + "  },\r\n" + "    \"underwritingQuestions\":{\r\n"
				+ "    \"businessActivityOnPremises\":false,\r\n" + "    \"childOrAdultDaycareOnPremises\":false,\r\n"
				+ "    \"existingDamage\":false,\r\n" + "    \"exoticAnimalsOnPremises\":false,\r\n"
				+ "    \"foundationDisclosure\":false,\r\n" + "    \"haveKnownSinkholeActivity\":false,\r\n"
				+ "    \"havePreviousInsuranceLapse\":false,\r\n" + "    \"havePriorInsurance\":true,\r\n"
				+ "    \"locationCurrentlyVacantOrUnoccupied\":false,\r\n" + "    \"propertyOccupied\":false,\r\n"
				+ "    \"locationInSpecialFloodHazardArea\":false,\r\n" + "    \"ownOrCareForAnimals\":false,\r\n"
				+ "    \"ownRecreationalVehicles\":false,\r\n" + "    \"previousConviction\":false,\r\n"
				+ "    \"previousForeclosure\":false,\r\n" + "    \"previousSinkholeInspection\":false,\r\n"
				+ "    \"previousSinkholeLoss\":false,\r\n"
				+ "    \"previouslyInsuredWithAmericanIntegrity\":false,\r\n"
				+ "    \"assignmentOfBenefits\":false,\r\n" + "    \"firstPartyLawsuit\":false,\r\n"
				+ "    \"priorAIPolicyNumber\":\"XXXXXXX\",\r\n" + "    \"priorFloodLoss\":true,\r\n"
				+ "    \"priorInsuranceCancelled\":false,\r\n" + "    \"priorLosses\":false,\r\n"
				+ "    \"priorNonWeatherLosses\":false,\r\n" + "    \"nonWeatherWaterLosses\":true,\r\n"
				+ "    \"shortSaleOrForeclosure\":false,\r\n" + "    \"swimmingPoolHotTubSpa\":false,\r\n"
				+ "    \"enclosed\":false,\r\n" + "    \"haveExcessiveLiabilityExposure\":false,\r\n"
				+ "    \"unrelatedRentersOrBoarders\":true\r\n" + "},\r\n" + "  \"coverages\": {\r\n"
				+ "    \"covA\": 350000,\r\n" + "    \"covB\": 2,\r\n" + "    \"covC\": 100000,\r\n"
				+ "    \"covE\": 100000,\r\n" + "    \"covF\": 5000,\r\n" + "    \"covL\": 100000,\r\n"
				+ "    \"covM\": 0,\r\n" + "    \"homeComputer\": 25000,\r\n"
				+ "    \"homeSystemsProtection\": \"50000/10000\",\r\n" + "    \"identityRecovery\": \"15000\",\r\n"
				+ "    \"fungiMoldEtc\": \"10000/10000\",\r\n" + "    \"ordinanceOrLaw\": 0,\r\n"
				+ "    \"serviceLine\": \"None\",\r\n" + "    \"waterBackupSumpOverflow\": \"\",\r\n"
				+ "    \"refrigeratedPersonalProperty\": true\r\n" + "  },\r\n" + "  \"optionalCoverages\": {\r\n"
				+ "    \"animalLiability\": true,\r\n" + "    \"animalLiabilityAmount\": 50000,\r\n"
				+ "    \"carportPoolCageScreen\": \"\",\r\n" + "    \"increasedDwellingReplacementCost\": true,\r\n"
				+ "    \"limitedTheft\": false,\r\n" + "    \"personalInjury\": true,\r\n"
				+ "    \"personalPropertyReplacementCost\": false,\r\n" + "    \"sinkholeLoss\": \"10\",\r\n"
				+ "    \"waterDamageExclusion\": true,\r\n" + "    \"waterDamageLimited\": true,\r\n"
				+ "    \"unitOwnersCovA\": false,\r\n" + "    \"unitOwnersCovC\": false,\r\n"
				+ "    \"storageSlipRental\": false\r\n" + "  },\r\n" + "  \"discounts\": {\r\n"
				+ "    \"burglarAlarmCredit\": \"CENTRAL STATION\",\r\n"
				+ "    \"fireAlarmCredit\": \"CENTRAL STATION\",\r\n" + "    \"proofOfUpdates\": \"ROOF ONLY\",\r\n"
				+ "    \"securedCommunityBldg\": \"\",\r\n" + "    \"sprinklerSystem\": \"NONE\",\r\n"
				+ "    \"openFoundation\": false,\r\n" + "    \"hardiplankSiding\": false,\r\n"
				+ "    \"military\": true\r\n" + "  },\r\n" + "  \"windMitigation\": {\r\n"
				+ "    \"openingProtection\": \"NONE\",\r\n" + "    \"roofCover\": \"FBC EQUIVALENT\",\r\n"
				+ "    \"roofDeck\": \"\",\r\n" + "    \"roofDeckAttachment\": \"\",\r\n"
				+ "    \"roofShape\": \"GABLE\",\r\n" + "    \"roofToWallAttachment\": \"\",\r\n"
				+ "    \"secondaryWaterResistance\": false\r\n" + "  },\r\n"
				+ "  \"effectiveDate\": \"2022-02-01\",\r\n" + "   \"dataReports\": {\r\n"
				+ "    \"runInsuranceScore\": true\r\n" + "  } ,\r\n" + "\"workflowFlags\": {\r\n"
				+ "      \"bindApplication\": true\r\n" + "} \r\n" + "},\r\n" + "  \"requestId\": \"8720-88776\",\r\n"
				+ "  \"responseDetail\": true\r\n" + "}\r\n" + "";

		RestAssured.baseURI = APIConstants.BASE_URI;

		RestAssured.given().auth().preemptive().basic(APIGlobalVariables.username, APIGlobalVariables.password)
				.body(payload).contentType(ContentType.JSON).post().prettyPeek().then().assertThat().statusCode(200);
		System.out.println("DP3 quote has been created and status code validated. Test Passed");

	}

	// Scenario: Validation HO3 Quote Process
	@Test
	@When("User enters required information when creating HO3 quote and I validate response body for Quote Creation Confirmation")
	public void user_enters_required_information_when_creating_ho3_quote_and_i_validate_response_body_for_quote_creation_confirmation() {

		String payloadHo3 = "{\r\n" + "  \"customerId\": \"TEST\",\r\n" + "  \"customerKey\": \"\",\r\n"
				+ "  \"quoteRequest\": {\r\n" + "  \"productType\": \"HO3\",\r\n" + "  \"producer\": \"AG1777A1\",\r\n"
				+ "  \"priorPolicy\": {\r\n" + "    \"expirationDate\": \"2022-12-18\",\r\n"
				+ "    \"carrier\": \"AVATAR\"\r\n" + "  },\r\n" + "  \"entityType\": \"INDIVIDUAL\",\r\n"
				+ "  \"insured\": {\r\n" + "    \"name\": {\r\n" + "      \"commercial\": \"Jake Ward\",\r\n"
				+ "      \"first\": \"Jake\",\r\n" + "      \"last\": \"Ward\"\r\n" + "    },\r\n"
				+ "    \"dateOfBirth\": \"1970-05-20\",\r\n" + "    \"primaryPhone\": {\r\n"
				+ "      \"value\": \"111-111-1111\",\r\n" + "      \"name\": \"MOBILE\"\r\n" + "    },\r\n"
				+ "    \"email\": \"abc@abc.com\"\r\n" + "  },\r\n"
				+ "  \"insuranceScore\": \"Better than Average (750-849)\",\r\n" + "  \"insuredProperty\": {\r\n"
				+ "    \"dwellingType\": \"SINGLE FAMILY\",\r\n" + "    \"location\": {\r\n"
				+ "       \"houseNumber\":\"41\",\r\n" + "      \"address\": \"Kelly Ridge Rd\",\r\n"
				+ "      \"city\": \"Frostproof\",\r\n" + "      \"county\": \"Polk County\",\r\n"
				+ "      \"state\": \"FL\",\r\n" + "      \"zipCode\": \"33843\"\r\n" + "    },\r\n"
				+ "    \"constructionType\": \"MASONRY\",\r\n" + "    \"occupancy\": \"OWNER\",\r\n"
				+ "    \"numberOfStories\": 2,\r\n" + "    \"bceg\": 1\r\n" + "  },\r\n" + "  \"dwelling\": {\r\n"
				+ "    \"distanceToHydrant\": \"LESS THAN OR EQUAL 1000 FEET\",\r\n" + "    \"protectionClass\": 5,\r\n"
				+ "    \"squareFeet\": 2409,\r\n" + "    \"yearOfConstruction\": 2014,\r\n"
				+ "    \"yearRoofMaterialUpdated\": 2014,\r\n" + "    \"roofMaterial\": \" \"\r\n" + "  },\r\n"
				+ "  \"reservePackage\": \"SILVER\",\r\n" + "  \"deductibles\": {\r\n" + "    \"aop\": 2500,\r\n"
				+ "    \"hurricane\": 2,\r\n" + "    \"windHailExclusion\": false\r\n" + "  },\r\n"
				+ "  \"coverages\": {\r\n" + "    \"covA\": 400000,\r\n" + "    \"covB\": 10,\r\n"
				+ "    \"covC\": 50,\r\n" + "    \"covE\": 400000,\r\n" + "    \"covF\": 5000,\r\n"
				+ "    \"homeSystemsProtection\": \"NONE\",\r\n" + "    \"identityRecovery\": \"NONE\",\r\n"
				+ "    \"fungiMoldEtc\": \"10000/10000\",\r\n" + "    \"lossAssessment\": 1000,\r\n"
				+ "    \"ordinanceOrLaw\": 25,\r\n" + "    \"waterBackupSumpOverflow\": \"NONE\"\r\n" + "  },\r\n"
				+ "  \"optionalCoverages\": {\r\n" + "    \"animalLiabilityAmount\":\"200001\",\r\n"
				+ "    \"carportPoolCageScreen\": \"10000\",\r\n" + "    \"personalPropertyReplacementCost\": true,\r\n"
				+ "    \"unitOwnersCovA\": false,\r\n" + "    \"unitOwnersCovC\": false,\r\n"
				+ "    \"storageSlipRental\": false,\r\n" + "    \"waterDamageExclusion\": false,\r\n"
				+ "    \"mandatoryMediationArbitration\":false \r\n" + "  },\r\n" + "  \"discounts\": {\r\n"
				+ "    \"burglarAlarmCredit\": \"NONE\",\r\n" + "    \"fireAlarmCredit\": \"NONE\",\r\n"
				+ "    \"securedCommunityBldg\": \"NONE\",\r\n" + "    \"sprinklerSystem\": \"NONE\",\r\n"
				+ "    \"leakProtection\": \"NONE\",\r\n" + "    \"leakManufacturer\": \"NONE\",\r\n"
				+ "    \"leakManufacturerModelNumber\": \"NONE\"\r\n" + "  },\r\n" + "  \"windMitigation\": {\r\n"
				+ "    \"openingProtection\": \"HURRICANE IMPACT\",\r\n" + "    \"roofShape\": \"GABLE\",\r\n"
				+ "    \"secondaryWaterResistance\": true\r\n" + "  },\r\n"
				+ "  \"existingTransactionNumber\": \"\",\r\n" + "  \"effectiveDate\": \"2022-04-22\",\r\n"
				+ "  \"source\": \"\",\r\n" + "  \"dataReports\": {\r\n" + "    \"runInsuranceScore\": false\r\n"
				+ "  },\r\n" + "  \"workflowFlags\": {\r\n" + "    \"bindApplication\": false\r\n" + "  }\r\n"
				+ "} ,\r\n" + "  \"requestId\": \"8720-787\",\r\n" + "  \"responseDetail\": true\r\n" + "}";

		RestAssured.baseURI = APIConstants.BASE_URI;

		RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic(APIGlobalVariables.username, APIGlobalVariables.password).body(payloadHo3).post().prettyPeek()
				.then().assertThat().statusCode(200).body("quoteResponse.quoteNumber", containsString("QT-")).and()
				.body("quoteResponse.premium", equalTo("7181.08")).and()
				.body("quoteResponse.dtoApplication.DTOLine.LineCd", hasItem("Homeowners")).and()
				.body("quoteResponse.dtoApplication.DTOLine.RatingService", hasItem("ManualRate")).and()
				.body("quoteResponse.dtoApplication.DTOLine.DTORisk.TypeCd", anything("Homeowners"));

		System.out.println("HO3 quote has been created and response body validated. Test Passed");

	}

	// Scenario: Validation HO3 Quote Process
	@Test
	@When("I validate H03 Premium Rates and H03 Commission Calculations")
	public void i_validate_h03_premium_rates_and_h03_commission_calculations() {
		String payload2 = "{\r\n" + "  \"customerId\": \"TEST\",\r\n" + "  \"customerKey\": \"\",\r\n"
				+ "  \"quoteRequest\": {\r\n" + "  \"productType\": \"HO3\",\r\n" + "  \"producer\": \"AG1777A1\",\r\n"
				+ "  \"priorPolicy\": {\r\n" + "    \"expirationDate\": \"2022-12-18\",\r\n"
				+ "    \"carrier\": \"AVATAR\"\r\n" + "  },\r\n" + "  \"entityType\": \"INDIVIDUAL\",\r\n"
				+ "  \"insured\": {\r\n" + "    \"name\": {\r\n" + "      \"commercial\": \"Jake Ward\",\r\n"
				+ "      \"first\": \"Jake\",\r\n" + "      \"last\": \"Ward\"\r\n" + "    },\r\n"
				+ "    \"dateOfBirth\": \"1970-05-20\",\r\n" + "    \"primaryPhone\": {\r\n"
				+ "      \"value\": \"111-111-1111\",\r\n" + "      \"name\": \"MOBILE\"\r\n" + "    },\r\n"
				+ "    \"email\": \"abc@abc.com\"\r\n" + "  },\r\n"
				+ "  \"insuranceScore\": \"Better than Average (750-849)\",\r\n" + "  \"insuredProperty\": {\r\n"
				+ "    \"dwellingType\": \"SINGLE FAMILY\",\r\n" + "    \"location\": {\r\n"
				+ "       \"houseNumber\":\"41\",\r\n" + "      \"address\": \"Kelly Ridge Rd\",\r\n"
				+ "      \"city\": \"Frostproof\",\r\n" + "      \"county\": \"Polk County\",\r\n"
				+ "      \"state\": \"FL\",\r\n" + "      \"zipCode\": \"33843\"\r\n" + "    },\r\n"
				+ "    \"constructionType\": \"MASONRY\",\r\n" + "    \"occupancy\": \"OWNER\",\r\n"
				+ "    \"numberOfStories\": 2,\r\n" + "    \"bceg\": 1\r\n" + "  },\r\n" + "  \"dwelling\": {\r\n"
				+ "    \"distanceToHydrant\": \"LESS THAN OR EQUAL 1000 FEET\",\r\n" + "    \"protectionClass\": 5,\r\n"
				+ "    \"squareFeet\": 2409,\r\n" + "    \"yearOfConstruction\": 2014,\r\n"
				+ "    \"yearRoofMaterialUpdated\": 2014,\r\n" + "    \"roofMaterial\": \" \"\r\n" + "  },\r\n"
				+ "  \"reservePackage\": \"SILVER\",\r\n" + "  \"deductibles\": {\r\n" + "    \"aop\": 2500,\r\n"
				+ "    \"hurricane\": 2,\r\n" + "    \"windHailExclusion\": false\r\n" + "  },\r\n"
				+ "  \"coverages\": {\r\n" + "    \"covA\": 400000,\r\n" + "    \"covB\": 10,\r\n"
				+ "    \"covC\": 50,\r\n" + "    \"covE\": 400000,\r\n" + "    \"covF\": 5000,\r\n"
				+ "    \"homeSystemsProtection\": \"NONE\",\r\n" + "    \"identityRecovery\": \"NONE\",\r\n"
				+ "    \"fungiMoldEtc\": \"10000/10000\",\r\n" + "    \"lossAssessment\": 1000,\r\n"
				+ "    \"ordinanceOrLaw\": 25,\r\n" + "    \"waterBackupSumpOverflow\": \"NONE\"\r\n" + "  },\r\n"
				+ "  \"optionalCoverages\": {\r\n" + "    \"animalLiabilityAmount\":\"200001\",\r\n"
				+ "    \"carportPoolCageScreen\": \"10000\",\r\n" + "    \"personalPropertyReplacementCost\": true,\r\n"
				+ "    \"unitOwnersCovA\": false,\r\n" + "    \"unitOwnersCovC\": false,\r\n"
				+ "    \"storageSlipRental\": false,\r\n" + "    \"waterDamageExclusion\": false,\r\n"
				+ "    \"mandatoryMediationArbitration\":false \r\n" + "  },\r\n" + "  \"discounts\": {\r\n"
				+ "    \"burglarAlarmCredit\": \"NONE\",\r\n" + "    \"fireAlarmCredit\": \"NONE\",\r\n"
				+ "    \"securedCommunityBldg\": \"NONE\",\r\n" + "    \"sprinklerSystem\": \"NONE\",\r\n"
				+ "    \"leakProtection\": \"NONE\",\r\n" + "    \"leakManufacturer\": \"NONE\",\r\n"
				+ "    \"leakManufacturerModelNumber\": \"NONE\"\r\n" + "  },\r\n" + "  \"windMitigation\": {\r\n"
				+ "    \"openingProtection\": \"HURRICANE IMPACT\",\r\n" + "    \"roofShape\": \"GABLE\",\r\n"
				+ "    \"secondaryWaterResistance\": true\r\n" + "  },\r\n"
				+ "  \"existingTransactionNumber\": \"\",\r\n" + "  \"effectiveDate\": \"2022-04-22\",\r\n"
				+ "  \"source\": \"\",\r\n" + "  \"dataReports\": {\r\n" + "    \"runInsuranceScore\": false\r\n"
				+ "  },\r\n" + "  \"workflowFlags\": {\r\n" + "    \"bindApplication\": false\r\n" + "  }\r\n"
				+ "} ,\r\n" + "  \"requestId\": \"8720-787\",\r\n" + "  \"responseDetail\": true\r\n" + "}";

		RestAssured.baseURI = APIConstants.BASE_URI;

		RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic(APIGlobalVariables.username, APIGlobalVariables.password).body(payload2).post().prettyPeek()
				.then().assertThat().and()
				.body("quoteResponse.dtoApplication.DTOLine.WrittenPremiumAmt", anything("7104.18")).and()
				.body("quoteResponse.dtoApplication.DTOLine.TransactionCommissionAmt", anything("852.50"));

		System.out.println("H03 Premium Rates and H03 Commission Calculations confirmed. Test Passed");

	}

	// Scenario: Validation DP3 Application Process
	@Test
	@When("I enter required information when creating DP3 application and I validate below response body for Application Creation Confirmation")
	public void i_enter_required_information_when_creating_dp3_application_and_i_validate_below_response_body_for_application_creation_confirmation() {

		String payload3 = "{\r\n" + "  \"customerId\": \"TEST\",\r\n" + "  \r\n" + "  \"customerKey\": null,\r\n"
				+ "  \"quoteRequest\": {\r\n" + "  \"productType\": \"DP3\",\r\n" + "  \"producer\": \"AG6718A1\",\r\n"
				+ "  \"priorPolicy\": {\r\n" + "    \"expirationDate\": \"2022-04-01\",\r\n"
				+ "    \"premium\": 1200,\r\n" + "    \"carrier\": \"OTHER\",\r\n"
				+ "    \"originalEffectiveDate\": \"\",\r\n" + "    \"priorPolicyNumber\": \"\"\r\n" + "  },\r\n"
				+ "  \"entityType\": \"JOINT\",\r\n" + "  \"insured\": {\r\n" + "    \"name\": {\r\n"
				+ "      \"commercial\": \"Victor Hedman and Sanna Hedman\",\r\n" + "      \"first\": \"Victor\",\r\n"
				+ "      \"middle\": \"\",\r\n" + "      \"last\": \"Hedman\"\r\n" + "    },\r\n"
				+ "    \"dateOfBirth\": \"1990-12-18\",\r\n" + "    \"primaryPhone\": {\r\n"
				+ "      \"value\": \"(904)371-4627\",\r\n" + "      \"name\": \"Victor Hedman\"\r\n" + "    },\r\n"
				+ "    \"email\": \"\"\r\n" + "  },\r\n" + "  \"insuranceScore\": \"\",\r\n" + "  \"coInsured\": {\r\n"
				+ "    \"firstName\": \"Sanna\",\r\n" + "    \"middleName\": \"\",\r\n"
				+ "    \"lastName\": \"Hedman\",\r\n" + "    \"dateOfBirth\": \"1991-09-06\"\r\n" + "  },\r\n"
				+ "  \"insuredProperty\": {\r\n" + "    \"dwellingType\": \"SINGLE FAMILY\",\r\n"
				+ "      \"location\": {\r\n" + "      \"address\": \"1710 E Kirby\",\r\n"
				+ "      \"city\": \"TAMPA\",\r\n" + "      \"county\": \"Hillsborough\",\r\n"
				+ "      \"state\": \"FL\",\r\n" + "      \"zipCode\": \"33604\"\r\n" + "    },\r\n"
				+ "    \"bceg\": \"UNGRADED\",\r\n" + "    \"constructionType\": \"FRAME\",\r\n"
				+ "    \"numberOfUnits\": 1,\r\n" + "    \"occupancy\": \"TENANT\",\r\n"
				+ "    \"monthsOccupied\": 12,\r\n" + "    \"numberOfStories\": 1,\r\n"
				+ "    \"storyUnitIsLocated\": 0,\r\n" + "    \"distanceToCoast\": \"15 mi to less than 20 mi\"\r\n"
				+ "  },\r\n" + "  \"dwelling\": {\r\n"
				+ "    \"distanceToHydrant\": \"LESS THAN OR EQUAL 1000 FEET\",\r\n" + "    \"protectionClass\": 3,\r\n"
				+ "    \"squareFeet\": 1068,\r\n" + "    \"yearOfConstruction\": 2018,\r\n"
				+ "    \"yearRoofMaterialUpdated\": 2018,\r\n" + "    \"propertyManaged\": false,\r\n"
				+ "    \"shortTermRental\": false,\r\n" + "    \"roofMaterial\": \"Concrete/Clay Tile\"\r\n"
				+ "  },\r\n" + "  \"reservePackage\": \"BASIC\",\r\n" + "  \"deductibles\": {\r\n"
				+ "    \"aop\": 1000,\r\n" + "    \"hurricane\": 10,\r\n" + "    \"windHail\": 1000,\r\n"
				+ "    \"windHailExclusion\": false\r\n" + "  },\r\n" + "    \"underwritingQuestions\":{\r\n"
				+ "    \"businessActivityOnPremises\":false,\r\n" + "    \"childOrAdultDaycareOnPremises\":false,\r\n"
				+ "    \"existingDamage\":false,\r\n" + "    \"exoticAnimalsOnPremises\":false,\r\n"
				+ "    \"foundationDisclosure\":false,\r\n" + "    \"haveKnownSinkholeActivity\":false,\r\n"
				+ "    \"havePreviousInsuranceLapse\":false,\r\n" + "    \"havePriorInsurance\":true,\r\n"
				+ "    \"locationCurrentlyVacantOrUnoccupied\":false,\r\n" + "    \"propertyOccupied\":false,\r\n"
				+ "    \"locationInSpecialFloodHazardArea\":false,\r\n" + "    \"ownOrCareForAnimals\":false,\r\n"
				+ "    \"ownRecreationalVehicles\":false,\r\n" + "    \"previousConviction\":false,\r\n"
				+ "    \"previousForeclosure\":false,\r\n" + "    \"previousSinkholeInspection\":false,\r\n"
				+ "    \"previousSinkholeLoss\":false,\r\n"
				+ "    \"previouslyInsuredWithAmericanIntegrity\":false,\r\n"
				+ "    \"assignmentOfBenefits\":false,\r\n" + "    \"firstPartyLawsuit\":false,\r\n"
				+ "    \"priorAIPolicyNumber\":\"XXXXXXX\",\r\n" + "    \"priorFloodLoss\":true,\r\n"
				+ "    \"priorInsuranceCancelled\":false,\r\n" + "    \"priorLosses\":false,\r\n"
				+ "    \"priorNonWeatherLosses\":false,\r\n" + "    \"nonWeatherWaterLosses\":true,\r\n"
				+ "    \"shortSaleOrForeclosure\":false,\r\n" + "    \"swimmingPoolHotTubSpa\":false,\r\n"
				+ "    \"enclosed\":false,\r\n" + "    \"haveExcessiveLiabilityExposure\":false,\r\n"
				+ "    \"unrelatedRentersOrBoarders\":true\r\n" + "},\r\n" + "  \"coverages\": {\r\n"
				+ "    \"covA\": 350000,\r\n" + "    \"covB\": 2,\r\n" + "    \"covC\": 100000,\r\n"
				+ "    \"covE\": 100000,\r\n" + "    \"covF\": 5000,\r\n" + "    \"covL\": 100000,\r\n"
				+ "    \"covM\": 0,\r\n" + "    \"homeComputer\": 25000,\r\n"
				+ "    \"homeSystemsProtection\": \"50000/10000\",\r\n" + "    \"identityRecovery\": \"15000\",\r\n"
				+ "    \"fungiMoldEtc\": \"10000/10000\",\r\n" + "    \"ordinanceOrLaw\": 0,\r\n"
				+ "    \"serviceLine\": \"None\",\r\n" + "    \"waterBackupSumpOverflow\": \"\",\r\n"
				+ "    \"refrigeratedPersonalProperty\": true\r\n" + "  },\r\n" + "  \"optionalCoverages\": {\r\n"
				+ "    \"animalLiability\": true,\r\n" + "    \"animalLiabilityAmount\": 50000,\r\n"
				+ "    \"carportPoolCageScreen\": \"\",\r\n" + "    \"increasedDwellingReplacementCost\": true,\r\n"
				+ "    \"limitedTheft\": false,\r\n" + "    \"personalInjury\": true,\r\n"
				+ "    \"personalPropertyReplacementCost\": false,\r\n" + "    \"sinkholeLoss\": \"10\",\r\n"
				+ "    \"waterDamageExclusion\": true,\r\n" + "    \"waterDamageLimited\": true,\r\n"
				+ "    \"unitOwnersCovA\": false,\r\n" + "    \"unitOwnersCovC\": false,\r\n"
				+ "    \"storageSlipRental\": false\r\n" + "  },\r\n" + "  \"discounts\": {\r\n"
				+ "    \"burglarAlarmCredit\": \"CENTRAL STATION\",\r\n"
				+ "    \"fireAlarmCredit\": \"CENTRAL STATION\",\r\n" + "    \"proofOfUpdates\": \"ROOF ONLY\",\r\n"
				+ "    \"securedCommunityBldg\": \"\",\r\n" + "    \"sprinklerSystem\": \"NONE\",\r\n"
				+ "    \"openFoundation\": false,\r\n" + "    \"hardiplankSiding\": false,\r\n"
				+ "    \"military\": true\r\n" + "  },\r\n" + "  \"windMitigation\": {\r\n"
				+ "    \"openingProtection\": \"NONE\",\r\n" + "    \"roofCover\": \"FBC EQUIVALENT\",\r\n"
				+ "    \"roofDeck\": \"\",\r\n" + "    \"roofDeckAttachment\": \"\",\r\n"
				+ "    \"roofShape\": \"GABLE\",\r\n" + "    \"roofToWallAttachment\": \"\",\r\n"
				+ "    \"secondaryWaterResistance\": false\r\n" + "  },\r\n"
				+ "  \"effectiveDate\": \"2022-02-01\",\r\n" + "   \"dataReports\": {\r\n"
				+ "    \"runInsuranceScore\": true\r\n" + "  } ,\r\n" + "\"workflowFlags\": {\r\n"
				+ "      \"bindApplication\": true\r\n" + "} \r\n" + "},\r\n" + "  \"requestId\": \"8720-88776\",\r\n"
				+ "  \"responseDetail\": true\r\n" + "}\r\n" + "";

		RestAssured.baseURI = APIConstants.BASE_URI;

		RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic(APIGlobalVariables.username, APIGlobalVariables.password).body(payload3).post().prettyPeek()
				.then().assertThat().statusCode(200).and()
				.body("quoteResponse.dtoApplication.DTOLine.StatusCd", hasItem("Active")).and()
				.body("quoteResponse.quoteNumber", containsString("AP-")).and()
				.body("quoteResponse.dtoApplication.DTOLine.LineCd", hasItem("DwellingSpecial")).and()
				.body("quoteResponse.dtoApplication.DTOLine.RatingService", hasItem("ManualRate")).and()
				.body("quoteResponse.dtoApplication.TypeCd", is("Application"));

		System.out.println("DP3 application has been created and response body validated. Test Passed");

	}

	// Scenario: Validation DP3 Application Process
	@Test
	@When("I validate DP3 Premium and Base Rates and DP3 Commission Calculations")
	public void i_validate_dp3_premium_and_base_rates_and_dp3_commission_calculations() {

		String payload4 = "{\r\n" + "  \"customerId\": \"TEST\",\r\n" + "  \r\n" + "  \"customerKey\": null,\r\n"
				+ "  \"quoteRequest\": {\r\n" + "  \"productType\": \"DP3\",\r\n" + "  \"producer\": \"AG6718A1\",\r\n"
				+ "  \"priorPolicy\": {\r\n" + "    \"expirationDate\": \"2022-04-01\",\r\n"
				+ "    \"premium\": 1200,\r\n" + "    \"carrier\": \"OTHER\",\r\n"
				+ "    \"originalEffectiveDate\": \"\",\r\n" + "    \"priorPolicyNumber\": \"\"\r\n" + "  },\r\n"
				+ "  \"entityType\": \"JOINT\",\r\n" + "  \"insured\": {\r\n" + "    \"name\": {\r\n"
				+ "      \"commercial\": \"Victor Hedman and Sanna Hedman\",\r\n" + "      \"first\": \"Victor\",\r\n"
				+ "      \"middle\": \"\",\r\n" + "      \"last\": \"Hedman\"\r\n" + "    },\r\n"
				+ "    \"dateOfBirth\": \"1990-12-18\",\r\n" + "    \"primaryPhone\": {\r\n"
				+ "      \"value\": \"(904)371-4627\",\r\n" + "      \"name\": \"Victor Hedman\"\r\n" + "    },\r\n"
				+ "    \"email\": \"\"\r\n" + "  },\r\n" + "  \"insuranceScore\": \"\",\r\n" + "  \"coInsured\": {\r\n"
				+ "    \"firstName\": \"Sanna\",\r\n" + "    \"middleName\": \"\",\r\n"
				+ "    \"lastName\": \"Hedman\",\r\n" + "    \"dateOfBirth\": \"1991-09-06\"\r\n" + "  },\r\n"
				+ "  \"insuredProperty\": {\r\n" + "    \"dwellingType\": \"SINGLE FAMILY\",\r\n"
				+ "      \"location\": {\r\n" + "      \"address\": \"1710 E Kirby\",\r\n"
				+ "      \"city\": \"TAMPA\",\r\n" + "      \"county\": \"Hillsborough\",\r\n"
				+ "      \"state\": \"FL\",\r\n" + "      \"zipCode\": \"33604\"\r\n" + "    },\r\n"
				+ "    \"bceg\": \"UNGRADED\",\r\n" + "    \"constructionType\": \"FRAME\",\r\n"
				+ "    \"numberOfUnits\": 1,\r\n" + "    \"occupancy\": \"TENANT\",\r\n"
				+ "    \"monthsOccupied\": 12,\r\n" + "    \"numberOfStories\": 1,\r\n"
				+ "    \"storyUnitIsLocated\": 0,\r\n" + "    \"distanceToCoast\": \"15 mi to less than 20 mi\"\r\n"
				+ "  },\r\n" + "  \"dwelling\": {\r\n"
				+ "    \"distanceToHydrant\": \"LESS THAN OR EQUAL 1000 FEET\",\r\n" + "    \"protectionClass\": 3,\r\n"
				+ "    \"squareFeet\": 1068,\r\n" + "    \"yearOfConstruction\": 2018,\r\n"
				+ "    \"yearRoofMaterialUpdated\": 2018,\r\n" + "    \"propertyManaged\": false,\r\n"
				+ "    \"shortTermRental\": false,\r\n" + "    \"roofMaterial\": \"Concrete/Clay Tile\"\r\n"
				+ "  },\r\n" + "  \"reservePackage\": \"BASIC\",\r\n" + "  \"deductibles\": {\r\n"
				+ "    \"aop\": 1000,\r\n" + "    \"hurricane\": 10,\r\n" + "    \"windHail\": 1000,\r\n"
				+ "    \"windHailExclusion\": false\r\n" + "  },\r\n" + "    \"underwritingQuestions\":{\r\n"
				+ "    \"businessActivityOnPremises\":false,\r\n" + "    \"childOrAdultDaycareOnPremises\":false,\r\n"
				+ "    \"existingDamage\":false,\r\n" + "    \"exoticAnimalsOnPremises\":false,\r\n"
				+ "    \"foundationDisclosure\":false,\r\n" + "    \"haveKnownSinkholeActivity\":false,\r\n"
				+ "    \"havePreviousInsuranceLapse\":false,\r\n" + "    \"havePriorInsurance\":true,\r\n"
				+ "    \"locationCurrentlyVacantOrUnoccupied\":false,\r\n" + "    \"propertyOccupied\":false,\r\n"
				+ "    \"locationInSpecialFloodHazardArea\":false,\r\n" + "    \"ownOrCareForAnimals\":false,\r\n"
				+ "    \"ownRecreationalVehicles\":false,\r\n" + "    \"previousConviction\":false,\r\n"
				+ "    \"previousForeclosure\":false,\r\n" + "    \"previousSinkholeInspection\":false,\r\n"
				+ "    \"previousSinkholeLoss\":false,\r\n"
				+ "    \"previouslyInsuredWithAmericanIntegrity\":false,\r\n"
				+ "    \"assignmentOfBenefits\":false,\r\n" + "    \"firstPartyLawsuit\":false,\r\n"
				+ "    \"priorAIPolicyNumber\":\"XXXXXXX\",\r\n" + "    \"priorFloodLoss\":true,\r\n"
				+ "    \"priorInsuranceCancelled\":false,\r\n" + "    \"priorLosses\":false,\r\n"
				+ "    \"priorNonWeatherLosses\":false,\r\n" + "    \"nonWeatherWaterLosses\":true,\r\n"
				+ "    \"shortSaleOrForeclosure\":false,\r\n" + "    \"swimmingPoolHotTubSpa\":false,\r\n"
				+ "    \"enclosed\":false,\r\n" + "    \"haveExcessiveLiabilityExposure\":false,\r\n"
				+ "    \"unrelatedRentersOrBoarders\":true\r\n" + "},\r\n" + "  \"coverages\": {\r\n"
				+ "    \"covA\": 350000,\r\n" + "    \"covB\": 2,\r\n" + "    \"covC\": 100000,\r\n"
				+ "    \"covE\": 100000,\r\n" + "    \"covF\": 5000,\r\n" + "    \"covL\": 100000,\r\n"
				+ "    \"covM\": 0,\r\n" + "    \"homeComputer\": 25000,\r\n"
				+ "    \"homeSystemsProtection\": \"50000/10000\",\r\n" + "    \"identityRecovery\": \"15000\",\r\n"
				+ "    \"fungiMoldEtc\": \"10000/10000\",\r\n" + "    \"ordinanceOrLaw\": 0,\r\n"
				+ "    \"serviceLine\": \"None\",\r\n" + "    \"waterBackupSumpOverflow\": \"\",\r\n"
				+ "    \"refrigeratedPersonalProperty\": true\r\n" + "  },\r\n" + "  \"optionalCoverages\": {\r\n"
				+ "    \"animalLiability\": true,\r\n" + "    \"animalLiabilityAmount\": 50000,\r\n"
				+ "    \"carportPoolCageScreen\": \"\",\r\n" + "    \"increasedDwellingReplacementCost\": true,\r\n"
				+ "    \"limitedTheft\": false,\r\n" + "    \"personalInjury\": true,\r\n"
				+ "    \"personalPropertyReplacementCost\": false,\r\n" + "    \"sinkholeLoss\": \"10\",\r\n"
				+ "    \"waterDamageExclusion\": true,\r\n" + "    \"waterDamageLimited\": true,\r\n"
				+ "    \"unitOwnersCovA\": false,\r\n" + "    \"unitOwnersCovC\": false,\r\n"
				+ "    \"storageSlipRental\": false\r\n" + "  },\r\n" + "  \"discounts\": {\r\n"
				+ "    \"burglarAlarmCredit\": \"CENTRAL STATION\",\r\n"
				+ "    \"fireAlarmCredit\": \"CENTRAL STATION\",\r\n" + "    \"proofOfUpdates\": \"ROOF ONLY\",\r\n"
				+ "    \"securedCommunityBldg\": \"\",\r\n" + "    \"sprinklerSystem\": \"NONE\",\r\n"
				+ "    \"openFoundation\": false,\r\n" + "    \"hardiplankSiding\": false,\r\n"
				+ "    \"military\": true\r\n" + "  },\r\n" + "  \"windMitigation\": {\r\n"
				+ "    \"openingProtection\": \"NONE\",\r\n" + "    \"roofCover\": \"FBC EQUIVALENT\",\r\n"
				+ "    \"roofDeck\": \"\",\r\n" + "    \"roofDeckAttachment\": \"\",\r\n"
				+ "    \"roofShape\": \"GABLE\",\r\n" + "    \"roofToWallAttachment\": \"\",\r\n"
				+ "    \"secondaryWaterResistance\": false\r\n" + "  },\r\n"
				+ "  \"effectiveDate\": \"2022-02-01\",\r\n" + "   \"dataReports\": {\r\n"
				+ "    \"runInsuranceScore\": true\r\n" + "  } ,\r\n" + "\"workflowFlags\": {\r\n"
				+ "      \"bindApplication\": true\r\n" + "} \r\n" + "},\r\n" + "  \"requestId\": \"8720-88776\",\r\n"
				+ "  \"responseDetail\": true\r\n" + "}\r\n" + "";

		RestAssured.baseURI = APIConstants.BASE_URI;

		RestAssured.given().header("Content-Type", "application/json").auth().preemptive()
				.basic(APIGlobalVariables.username, APIGlobalVariables.password).body(payload4).post().prettyPeek()
				.then().assertThat().and().body("quoteResponse.premium", equalTo("2366.44")).and()
				.body("quoteResponse.dtoApplication.DTOLine.TransactionCommissionAmt", anything("0.00"));

		System.out.println("dp3 premium and base rates and dp3 commission calculations api Test Passed");
	}

}
