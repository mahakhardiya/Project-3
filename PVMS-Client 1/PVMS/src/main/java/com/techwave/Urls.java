package com.techwave;

public class Urls {
	public static final String getAllStateNames="http://localhost:9090/getAllStateNames";
	public static final String getAllCityNames="http://localhost:9090/getAllCityNames{stateName}";
	public static final String getPinCode="http://localhost:9090/getPinCode/{cityName}";
	public static final String getPassportByUserId="http://localhost:9090/getPassport/{userId}";
	public static final String checkExpiryDate="http://localhost:9090/checkExpiry/{userId}";
	public static final String reissuePassport="http://localhost:9090/ReissuePassport";
	public static final String lostPassport="http://localhost:9090/PassportLost";
	
	
	
	public static final String registerUser="http://localhost:9090/addUserDetails";
	public static final String getUserById="http://localhost:9090/getUser/{id}";
	public static final String updatePassword="http://localhost:9090/updateUserPwd/{id}";
	
	
	public static final String getPassport="http://localhost:9090/PassportExists/{userId}";
	public static final String applyPassport="http://localhost:9090/passportdatainsert/{userId}";
	
	
	public static final String insertVisa="http://localhost:9090/addVisa";
	public static final String getVisa="http://localhost:9090/getVisa";
	public static final String getVisaPermit="http://localhost:9090/getVisaPermit/{occupation}";
	public static final String getPassportObject="http://localhost:9090/getPassport/{userId}";
	
	
	
	public static final String getById="http://localhost:9090/getvisa/{id}";
	public static final String UpdateVisaStatus="http://localhost:9090/updatevisa/{id}";
	public static final String findVisaCancellationCost="http://localhost:9090/getCost/{visaId}";
	public static final String findByPassportId="http://localhost:9090/getByPassportId/{passportId}";
	public static final String findByvisapassport = "http://localhost:9090/getvisapassport/{passportId}";
	public static final String getCountofVisa = "http://localhost:9090/CountOfVisa/{userId}";
}
