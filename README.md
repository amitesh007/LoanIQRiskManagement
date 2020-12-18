# LoanIQRiskManagement
Hackathon - project for displaying customers with past dues

Steps to Run the aplication with execuatble jar-
1. Download the jar - "LoanIQRiskManagementService-0.0.1-SNAPSHOT.jar" from 7z file -"LoanIQRiskManagementService-0.0.1-SNAPSHOT.jar.7z" into path "C:\Professional\hackathon"
2. Dowload conifg.properties into path "C:\Professional\hackathon"
3. In config.properties change the hostname depending upon the machin where you are going to run this service. 
    credit.risk.callback.url = https://10.215.132.81:8453/CreditRiskMangement/AuthCallBackHandlerServlet (hostname and port of the machin where the serivice is deployed.)
4. Open the CMD where jar "LoanIQRiskManagementService-0.0.1-SNAPSHOT.jar" is placed.
5. Run the following script assuiming that the script and config.properties files are placed under path - "C:\Professional\hackathon"
    C:\Professional\hackathon>java -jar LoanIQRiskManagementService-0.0.1-SNAPSHOT.jar --spring.config.location=file:C:\Professional\hackathon\config.properties
    
6. After successful execution you should see following on your screen-

----------------------------------------------------------------------------------Script--------------------------------------------------------------------
C:\Professional\hackathon>java -jar LoanIQRiskManagementService-0.0.1-SNAPSHOT.jar --spring.config.location=file:C:\Professional\hackathon\config.properties
----------------------------------------------------------------------------------Script--------------------------------------------------------------------

Download image - RunScript.png


7. Services Details -
7.1. https://localhost/past-dues/customer/PZBAEV1G (serach past dues based on customer id.)
PZBAEV1G - borrowerId id
Method - @GET
Response -
{"borrowerId":"PZBAEV1G","deals":[{"dealId":"KZBAF8BB","dealName":"BORROWER USD (6/12)","fees":[{"feeId":"KZBAFE2O","feeType":"ADMI","feeCyclePastDues":[{"dueAmount":"200000","currency":"USD","dueDate":"2019-06-17"}]}],"facilities":[{"facilityId":"00000229","outstandings":[{"outstandingType":"LOAN","outstandingAlias":"BORROWER C00007","interestDues":[{"interestDueAmount":"54657.53","currency":"CAD","interestDueDate":"2019-07-01"},{"interestDueAmount":"60513.7","currency":"CAD","interestDueDate":"2019-08-01"}]},{"outstandingType":"LOAN","outstandingAlias":"BORROWER U00001","interestDues":[{"interestDueAmount":"153424.66","currency":"USD","interestDueDate":"2019-07-01"},{"interestDueAmount":"169863.01","currency":"USD","interestDueDate":"2019-08-01"}]},{"outstandingType":"LOAN","outstandingAlias":"BORROWER U00008","interestDues":[{"interestDueAmount":"151666.67","currency":"USD","interestDueDate":"2019-07-25"}]},{"outstandingType":"LOAN","outstandingAlias":"BORROWER U00012","interestDues":[{"interestDueAmount":"13055.56","currency":"USD","interestDueDate":"2019-07-08"},{"interestDueAmount":"11831.6","currency":"USD","interestDueDate":"2019-08-06"}]},{"outstandingType":"LOAN","outstandingAlias":"BORROWER U00013","interestDues":[{"interestDueAmount":"758.33","currency":"USD","interestDueDate":"2019-07-25"}]}]},{"facilityId":"00000232","outstandings":[{"outstandingType":"LOAN","outstandingAlias":"BORROWER U00004","interestDues":[{"interestDueAmount":"46027.4","currency":"USD","interestDueDate":"2019-07-01"},{"interestDueAmount":"50958.9","currency":"USD","interestDueDate":"2019-08-01"}]}]}]},{"dealId":"KZBAFA5Q","dealName":"BORROWER USD & CAD (6/12)","fees":[{"feeId":"KZBAFE44","feeType":"ADMI","feeCyclePastDues":[{"dueAmount":"200000","currency":"USD","dueDate":"2019-06-17"}]}],"facilities":[{"facilityId":"00000233","outstandings":[{"outstandingType":"LOAN","outstandingAlias":"BORROWER C00010","interestDues":[{"interestDueAmount":"34520.55","currency":"CAD","interestDueDate":"2019-07-01"},{"interestDueAmount":"38219.18","currency":"CAD","interestDueDate":"2019-08-01"}]},{"outstandingType":"LOAN","outstandingAlias":"BORROWER C00008","interestDues":[{"interestDueAmount":"686805","currency":"JPY","interestDueDate":"2019-08-09"}]},{"outstandingType":"LOAN","outstandingAlias":"BORROWER U00011","interestDues":[{"interestDueAmount":"104270.83","currency":"USD","interestDueDate":"2019-07-25"}]}]},{"facilityId":"00000235","outstandings":[{"outstandingType":"LOAN","outstandingAlias":"BORROWER M00003","interestDues":[{"interestDueAmount":"932118","currency":"JPY","interestDueDate":"2019-07-16"}]},{"outstandingType":"LOAN","outstandingAlias":"BORROWER U00006","interestDues":[{"interestDueAmount":"110273.97","currency":"USD","interestDueDate":"2019-07-01"},{"interestDueAmount":"122089.04","currency":"USD","interestDueDate":"2019-08-01"}]}]}]}]}

7.2. https://localhost/past-dues/deal/)2DEUUFB (serach past dues based on deal id.)
)2DEUUFB  - deal id
Method - @GET
Response -
{"borrowerId":"NIB4LJ09","deals":[{"dealId":")2DEUUFB","dealName":"SYNDICATED TRANSACTION (DO NOT TOUCH)","facilities":[{"facilityId":"00001415","outstandings":[{"outstandingType":"LOAN","outstandingAlias":"CONSTRUCTI00022","principalDues":[{"principalDueAmount":"16559221.1","currency":"ILS","principalDueDate":"2019-07-29"}]},{"outstandingType":"LOAN","outstandingAlias":"LINKED","principalDues":[{"principalDueAmount":"33120000","currency":"ILS","principalDueDate":"2019-07-26"}]}]},{"facilityId":"00001416","outstandings":[{"outstandingType":"LOAN","outstandingAlias":"CONSTRUCTI00024","principalDues":[{"principalDueAmount":"276000000","currency":"ILS","principalDueDate":"2019-07-29"}]},{"outstandingType":"LOAN","outstandingAlias":"CONSTRUCTI00025","principalDues":[{"principalDueAmount":"368000000","currency":"ILS","principalDueDate":"2019-07-26"}]},{"outstandingType":"LOAN","outstandingAlias":"LINKED00030","principalDues":[{"principalDueAmount":"276000000","currency":"ILS","principalDueDate":"2019-07-26"}]}]}]}]}

7.3. https://locahost/search/deals/dealName/SYNDICATE* (Search deals by deal names)

SYNDICATE*  - deal name with wildcard
Method - @GET
Response -
{"dealIdentifiers":[{"id":"2f609712f80000b0","dealName":"SYNDICATED DEAL","alias":"SYNDICATED DEAL","trackingNumber":"212","alternateId":"GTD58LML","ansiId":"GTD58LML"},{"id":"30695c6c4b0000f6","dealName":"SYNDICATED TRAN (DO NOT TOUCH)","alias":"SYNDICATED DEAL IDB","trackingNumber":"262","alternateId":"?SDFKIZU","ansiId":"?SDFKIZU"},{"id":"30570555f20000e8","dealName":"SYNDICATED TRANSACTION (DO NOT TOUCH)","alias":"SYNDICATED TRANSACTI","trackingNumber":"253","alternateId":")2DEUUFB","ansiId":")2DEUUFB"}]}

4. https://localhost/search/customers/legalName/Borrower* (Search customers by legal name)

Borrower*  - customer name with wildcard
Method - @GET
Response -
{"customerIdentifiers":[{"shortName":"BORROWER 1","legalName":"Borrower 1","externalId":"(?BE1HHA","id":"29083c282400004c"},{"shortName":"AUS BORROWER","legalName":"Borrower 2","externalId":"(?BE1HRF","id":"29083dcae200004d"},{"shortName":"BORROWER CANADIAN ENTITY","legalName":"Borrower Canadian Entity","externalId":"PZBAEV1G","id":"28afea344a000042"},{"shortName":"LONDON GANTRY PROPCO LTD","legalName":"Borrower Multicurrency Entity","externalId":"PZBAEWAG","id":"28afec1c03000043"},{"shortName":"BORROWER US ENTITY","legalName":"Borrower US Entity, Inc.","externalId":"PZBAEULK","id":"28afe808e7000041"},{"shortName":"BORROWER VAT","legalName":"Borrower VAT","externalId":"SSDOX6DY","id":"9ac51e1fb6889a2c0000d5"}]}
