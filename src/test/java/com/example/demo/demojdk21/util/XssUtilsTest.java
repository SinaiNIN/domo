package com.example.demo.demojdk21.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class XssUtilsTest {
    private XssUtils xssUtils;

    @Before
    public void setUp() {
        xssUtils = new XssUtils();
    }

    // Internet Explorer, Edge
    @Test
    public void testXssScript1() {
        String content = "<svg><script>alert(1)<p>";
        assertTrue(XssUtils.isContainXssString(content));
        assertFalse(false);
    }

    // Firefox

    @Test
    public void testXssScript2() {
        String content = "<svg><x><script>alert(1)</x>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript3() {
        String content = "'';!--\"<XSS>=&{()}";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void test_script4() {
        String content = "<SCRIPT SRC=http://ha.ckers.org/xss.js></SCRIPT>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript5() {
        String content = "<IMG SRC=\"javascript:alert('XSS');\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript6() {
        String content = "<IMG SRC=javascript:alert('XSS')>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript7() {
        String content = "<IMG SRC=JaVaScRiPt:alert('XSS')>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript8() {
        String content = "<IMG SRC=javascript:alert(\"XSS\")>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript9() {
        String content = "<IMG SRC=`javascript:alert(\"RSnake says, 'XSS'\")`>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript10() {
        String content = "<a onmouseover=\"alert(document.cookie)\">xxs link</a>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript11() {
        String content = "<a onmouseover=alert(document.cookie)>xxs link</a>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript12() {
        String content = "<IMG \"\"\"><SCRIPT>alert(\"XSS\")</SCRIPT>\">\\";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript13() {
        String content = "<IMG SRC=javascript:alert(String.fromCharCode(88,83,83))>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript14() {
        String content = "<IMG SRC=# onmouseover=\"alert('xxs')\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript15() {
        String content = "<IMG SRC= onmouseover=\"alert('xxs')\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript16() {
        String content = "<IMG onmouseover=\"alert('xxs')\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript17() {
        String content = "<IMG SRC=/ onerror=\"alert(String.fromCharCode(88,83,83))\"></img>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript18() {
        String content = "<IMG SRC=&#106;&#97;&#118;&#97;&#115;&#99;&#114;&#105;&#112;&#116;&#58;&#97;&#108;&#101;&#114;&#116;&#40;\r\n"
                + "&#39;&#88;&#83;&#83;&#39;&#41;>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void test_scrip19t() {
        String content = "<IMG SRC=&#0000106&#0000097&#0000118&#0000097&#0000115&#0000099&#0000114&#0000105&#0000112&#0000116&#0000058&#0000097&\r\n"
                + "#0000108&#0000101&#0000114&#0000116&#0000040&#0000039&#0000088&#0000083&#0000083&#0000039&#0000041>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript20() {
        String content = "<IMG SRC=&#x6A&#x61&#x76&#x61&#x73&#x63&#x72&#x69&#x70&#x74&#x3A&#x61&#x6C&#x65&#x72&#x74&#x28&#x27&#x58&#x53&#x53&#x27&#x29>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript21() {
        String content = "<IMG SRC=\"jav&#x09;ascript:alert('XSS');\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript22() {
        String content = "<IMG SRC=\"jav&#x0A;ascript:alert('XSS');\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript23() {
        String content = "<IMG SRC=\"jav&#x0D;ascript:alert('XSS');\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript24() {
        String content = "<IMG SRC=\" &#14;  javascript:alert('XSS');\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript25() {
        String content = "<SCRIPT/XSS SRC=\"http://ha.ckers.org/xss.js\"></SCRIPT>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript26() {
        String content = "<BODY onload!#$%&()*~+-_.,:;?@[/|\\]^`=alert(\"XSS\")>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript27() {
        String content = "<SCRIPT/SRC=\"http://ha.ckers.org/xss.js\"></SCRIPT>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript28() {
        String content = "<<SCRIPT>alert(\"XSS\");//<</SCRIPT>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript329() {
        String content = "<SCRIPT SRC=http://ha.ckers.org/xss.js?< B >";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript30() {
        String content = "<SCRIPT SRC=//ha.ckers.org/.j>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript31() {
        String content = "<BODY ONLOAD=alert('XSS')>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript32() {
        String content = "<IMG SRC=\"javascript:alert('XSS')\"";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript33() {
        String content = "<iframe src=http://ha.ckers.org/scriptlet.html <";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript34() {
        String content = "<IMG SRC=\"livescript:[code]\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript35() {
        String content = "</TITLE><SCRIPT>alert(\"XSS\");</SCRIPT>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript36() {
        String content = "<INPUT TYPE=\"IMAGE\" SRC=\"javascript:alert('XSS');\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript37() {
        String content = "<BODY BACKGROUND=\"javascript:alert('XSS')\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript38() {
        String content = "<IMG DYNSRC=\"javascript:alert('XSS')\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript39() {
        String content = "<IMG LOWSRC=\"javascript:alert('XSS')\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript40() {
        String content = "<STYLE>li {list-style-image: url(\"javascript:alert('XSS')\");}</STYLE><UL><LI>XSS</br>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript41() {
        String content = "<IMG SRC='vbscript:msgbox(\"XSS\")'>";
        assertTrue(XssUtils.isContainXssString(content));
    }


    @Test
    public void testXssScript42() {
        String content = "<a onclick=\"alert(document.cookie)\">xxs link</a>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript43() {
        String content = "<a onfocus=\"alert(document.cookie)\">xxs link</a>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript44() {
        String content = "<input onchange=\"alert(document.cookie)\">xxs link</a>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript45() {
        String content = "<input onchange=\"alert(document.cookie)\">xxs link</a>";
        assertTrue(XssUtils.isContainXssString(content));
    }


    @Test
    public void testXssScript46() {
        String content = "<input type=\"text\" onkeypress=\"myFunction()\">";
        assertTrue(XssUtils.isContainXssString(content));
    }


    @Test
    public void testXssScript47() {
        String content = "<input type=\"text\" onkeydown=\"myFunction()\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript48() {
        String content = "<input type=\"text\" onkeyup=\"myFunction()\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript49() {
        String content = "<embed type=\"image/jpg\" src=\"pic_trulli.jpg\" width=\"300\" height=\"200\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript50() {
        String content = "<object data=\"pic_trulli.jpg\" width=\"300\" height=\"200\"></object>";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testXssScript51() {
        String content = "<link rel=\"stylesheet\" href=\"styles.css\">";
        assertTrue(XssUtils.isContainXssString(content));
    }

    @Test
    public void testSecureHTMLTag() {
        String content = "<div class=\"myDiv\">\r\n"
                + "  <h2>This is a heading in a div element</h2>\r\n"
                + "  <p>This is some text in a div element.</p>\r\n"
                + "</div>";
        assertFalse(XssUtils.isContainXssString(content));
    }

    @Test
    public void test_scriptXml() {
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
                + "<ase:aseXML\r\n"
                + "	xmlns:ase=\"urn:aseXML:r40\"\r\n"
                + "	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:aseXML:r40 http://www.nemmco.com.au/aseXML/schemas/r40/aseXML_r40.xsd\">\r\n"
                + "	<Header>\r\n"
                + "		<From>TXUN</From>\r\n"
                + "		<To>HANSEN</To>\r\n"
                + "		<MessageID>TXUN-3143a-202421031520305</MessageID>\r\n"
                + "		<MessageDate>2023-07-17T16:10:08.433+10:00</MessageDate>\r\n"
                + "		<TransactionGroup>CUST</TransactionGroup>\r\n"
                + "		<Priority>Medium</Priority>\r\n"
                + "		<Market>VICGAS</Market>\r\n"
                + "	</Header>\r\n"
                + "	<Transactions>\r\n"
                + "		<Transaction transactionID=\"NSI-3143a-VGAS-202421031520305\" transactionDate=\"2024-03-21T16:10:08.435+10:00\">\r\n"
                + "			<LifeSupportNotification version=\"r38\">\r\n"
                + "				<LifeSupportData>\r\n"
                + "					<NMI checksum=\"7\">5330486178</NMI>\r\n"
                + "					<Reason>Update</Reason>\r\n"
                + "					<RegistrationOwner>Yes</RegistrationOwner>\r\n"
                + "					<Status>Registered - Medical Confirmation</Status>\r\n"
                + "					<DateRequired>2024-02-09</DateRequired>\r\n"
                + "					<Equipment>Other</Equipment>\r\n"
                + "					<ManagementContactDetail>\r\n"
                + "						<PersonName nameType=\"LGL\">\r\n"
                + "							<NameTitle>Miss</NameTitle>\r\n"
                + "							<GivenName>&lt;IMG SRC=javascript:alert(&#39;XSS&#39;)&gt;&quot;</GivenName>\r\n"
                + "							<FamilyName>Nicholls</FamilyName>\r\n"
                + "						</PersonName>\r\n"
                + "						<PostalAddress>\r\n"
                + "							<AustralianAddress>\r\n"
                + "								<StructuredAddress>\r\n"
                + "									<House>\r\n"
                + "										<HouseNumber>18</HouseNumber>\r\n"
                + "									</House>\r\n"
                + "									<Street>\r\n"
                + "										<StreetName>CARPENTER</StreetName>\r\n"
                + "										<StreetType>ST</StreetType>\r\n"
                + "									</Street>\r\n"
                + "								</StructuredAddress>\r\n"
                + "								<SuburbOrPlaceOrLocality>WENDOUREE</SuburbOrPlaceOrLocality>\r\n"
                + "								<StateOrTerritory>VIC</StateOrTerritory>\r\n"
                + "								<PostCode>3355</PostCode>\r\n"
                + "								<DeliveryPointIdentifier>56018559</DeliveryPointIdentifier>\r\n"
                + "							</AustralianAddress>\r\n"
                + "						</PostalAddress>\r\n"
                + "						<PhoneNumber serviceType=\"Mobile Voice\">\r\n"
                + "							<Prefix>04</Prefix>\r\n"
                + "							<Number>97852433</Number>\r\n"
                + "						</PhoneNumber>\r\n"
                + "						<EmailAddress>mellisajnichols@gmail.com.au</EmailAddress>\r\n"
                + "					</ManagementContactDetail>\r\n"
                + "					<PreferredContactMethod>Postal Address</PreferredContactMethod>\r\n"
                + "					<SpecialNotes>\r\n"
                + "						<CommentLine>equipment type not stored</CommentLine>\r\n"
                + "					</SpecialNotes>\r\n"
                + "					<LastModifiedDateTime>2024-02-10T18:10:03.891+10:00</LastModifiedDateTime>\r\n"
                + "				</LifeSupportData>\r\n"
                + "			</LifeSupportNotification>\r\n"
                + "		</Transaction>\r\n"
                + "	</Transactions>\r\n"
                + "</ase:aseXML>\r\n"
                + "";

        assertTrue(XssUtils.isXmlContainXssString(content));
    }

    @Test
    public void test_scriptXml_Scure() {
        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
                + "<ase:aseXML\r\n"
                + "	xmlns:ase=\"urn:aseXML:r40\"\r\n"
                + "	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"urn:aseXML:r40 http://www.nemmco.com.au/aseXML/schemas/r40/aseXML_r40.xsd\">\r\n"
                + "	<Header>\r\n"
                + "		<From>TXUN</From>\r\n"
                + "		<To>HANSEN</To>\r\n"
                + "		<MessageID>TXUN-3143a-202421031520304</MessageID>\r\n"
                + "		<MessageDate>2023-07-17T16:10:08.433+10:00</MessageDate>\r\n"
                + "		<TransactionGroup>CUST</TransactionGroup>\r\n"
                + "		<Priority>Medium</Priority>\r\n"
                + "		<Market>VICGAS</Market>\r\n"
                + "	</Header>\r\n"
                + "	<Transactions>\r\n"
                + "		<Transaction transactionID=\"NSI-3143a-VGAS-202421031520304\" transactionDate=\"2024-03-21T16:10:08.435+10:00\">\r\n"
                + "			<LifeSupportNotification version=\"r38\">\r\n"
                + "				<LifeSupportData>\r\n"
                + "					<NMI checksum=\"7\">5330486178</NMI>\r\n"
                + "					<Reason>Update</Reason>\r\n"
                + "					<RegistrationOwner>Yes</RegistrationOwner>\r\n"
                + "					<Status>Registered - Medical Confirmation</Status>\r\n"
                + "					<DateRequired>2024-02-09</DateRequired>\r\n"
                + "					<Equipment>Other</Equipment>\r\n"
                + "					<ManagementContactDetail>\r\n"
                + "						<PersonName nameType=\"LGL\">\r\n"
                + "							<NameTitle>Miss</NameTitle>\r\n"
                + "							<GivenName>Name</GivenName>\r\n"
                + "							<FamilyName>Nicholls</FamilyName>\r\n"
                + "						</PersonName>\r\n"
                + "						<PostalAddress>\r\n"
                + "							<AustralianAddress>\r\n"
                + "								<StructuredAddress>\r\n"
                + "									<House>\r\n"
                + "										<HouseNumber>18</HouseNumber>\r\n"
                + "									</House>\r\n"
                + "									<Street>\r\n"
                + "										<StreetName>CARPENTER</StreetName>\r\n"
                + "										<StreetType>ST</StreetType>\r\n"
                + "									</Street>\r\n"
                + "								</StructuredAddress>\r\n"
                + "								<SuburbOrPlaceOrLocality>WENDOUREE</SuburbOrPlaceOrLocality>\r\n"
                + "								<StateOrTerritory>VIC</StateOrTerritory>\r\n"
                + "								<PostCode>3355</PostCode>\r\n"
                + "								<DeliveryPointIdentifier>56018559</DeliveryPointIdentifier>\r\n"
                + "							</AustralianAddress>\r\n"
                + "						</PostalAddress>\r\n"
                + "						<PhoneNumber serviceType=\"Mobile Voice\">\r\n"
                + "							<Prefix>04</Prefix>\r\n"
                + "							<Number>97852433</Number>\r\n"
                + "						</PhoneNumber>\r\n"
                + "						<EmailAddress>mellisajnichols@gmail.com.au</EmailAddress>\r\n"
                + "					</ManagementContactDetail>\r\n"
                + "					<PreferredContactMethod>Postal Address</PreferredContactMethod>\r\n"
                + "					<SpecialNotes>\r\n"
                + "						<CommentLine>equipment type not stored</CommentLine>\r\n"
                + "					</SpecialNotes>\r\n"
                + "					<LastModifiedDateTime>2024-02-10T18:10:03.891+10:00</LastModifiedDateTime>\r\n"
                + "				</LifeSupportData>\r\n"
                + "			</LifeSupportNotification>\r\n"
                + "		</Transaction>\r\n"
                + "	</Transactions>\r\n"
                + "</ase:aseXML>\r\n"
                + "";

        assertFalse(XssUtils.isXmlContainXssString(content));
    }
}
