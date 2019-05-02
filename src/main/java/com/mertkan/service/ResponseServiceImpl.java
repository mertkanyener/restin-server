package com.mertkan.service;

import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.github.javafaker.Faker;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

@Service
public class ResponseServiceImpl implements ResponseService {

	private Faker faker = new Faker();
	
	@Override
	public String getDynamicResponse(String response) {
		Pattern pattern = Pattern.compile("\"\\$\\{\\w*\\.\\w*}\"");
		Matcher matcher = pattern.matcher(response);
		List<String> matches =  new ArrayList<String>();
		while(matcher.find()) {
			matches.add(matcher.group());
		}
		for(String s : matches) {
			String value = "\"" + fakerValue(s) + "\"";
			response = response.replace(s, value);
		}
		return response;
	}

	@Override
	public String prettyPrintXML(String xml){
		try {
			xml = "<response>"+xml+"</response>";
			DocumentBuilder db;
			db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document doc = db.parse(new InputSource(new StringReader(xml)));

			OutputFormat format = new OutputFormat(doc);
			format.setIndenting(true);
			format.setIndent(2);
			format.setOmitXMLDeclaration(true);

			format.setLineWidth(Integer.MAX_VALUE);
			Writer outxml = new StringWriter();
			XMLSerializer serializer = new XMLSerializer(outxml, format);
			serializer.serialize(doc);

			return outxml.toString();
		} catch (Exception e){
			System.out.println(e);
			System.exit(1);
			return null;
		}

	}

	@Override
	public String prettyPrintJSON(String json){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonParser jp = new JsonParser();
		JsonElement je = jp.parse(json);
		String prettyJson = gson.toJson(je);

		return prettyJson;
	}

	@Override
	public String fakerValue(String pattern) {
		String[] split = pattern.split("\\.");
		String category = split[0].substring(3);
		String subCategory = split[1].substring(0, split[1].length()-2).replace("-", "");
		String result = "";
		
		switch(category) {
		case "address":
			switch(subCategory) {
			case "streetname":
				result = faker.address().streetName();
				break;
			case "zipcode":
				result = faker.address().zipCode();
				break;
			case "city":
				result = faker.address().city();
				break;
			case "country":
				result = faker.address().country();
				break;
			case "state":
				result = faker.address().state();
				break;
			case "fulladdress":
				result = faker.address().fullAddress();
				break;
			}break;
		case "ancient":
			switch(subCategory) {
			case "god":
				result = faker.ancient().god();
				break;
			case "primordial":
				result = faker.ancient().primordial();
				break;
			case "titan":
				result = faker.ancient().titan();
				break;
			case "hero":
				result = faker.ancient().hero();
				break;
			}break;
		case "app":
			switch(subCategory) {
			case "name":
				result = faker.app().name();
				break;
			case "version":
				result = faker.app().version();
				break;
			case "author":
				result = faker.app().author();
				break;
			}break;
		case "artist":
			result = faker.artist().name();
			break;
		case "beer":
			switch(subCategory) {
			case "name":
				result = faker.beer().name();
				break;
			case "style":
				result = faker.beer().style();
				break;
			case "hop":
				result = faker.beer().hop();
				break;
			case "yeast":
				result = faker.beer().yeast();
				break;
			case "malt":
				result = faker.beer().malt();
				break;
			}break;
		case "book":
			switch(subCategory) {
			case "author":
				result = faker.book().author();
				break;
			case "title":
				result = faker.book().title();
				break;
			case "publisher":
				result = faker.book().publisher();
				break;
			case "genre":
				result = faker.book().genre();
				break;
			}break;
		case "cat":
			switch(subCategory) {
			case "name":
				result = faker.cat().name();
				break;
			case "breed":
				result = faker.cat().breed();
				break;
			case "registry":
				result = faker.cat().registry();
				break;
			}break;
		case "color":
			result = faker.color().name();
			break;
		case "commerce":
			switch(subCategory) {
			case "department":
				result = faker.commerce().department();
				break;
			case "productname":
				result = faker.commerce().productName();
				break;
			case "material":
				result = faker.commerce().material();
				break;
			case "price":
				result = faker.commerce().price();
				break;
			case "promotioncode":
				result = faker.commerce().promotionCode();
				break;
			}break;
		case "company":
			switch(subCategory) {
			case "name":
				result = faker.company().name();
				break;
			case "industry":
				result = faker.company().industry();
				break;
			case "profession":
				result = faker.company().profession();
				break;
			}
		case "currency":
			switch(subCategory) {
			case "name":
				result = faker.currency().name();
				break;
			case "code":
				result = faker.currency().code();
				break;
			}break;
		case "demographic":
			switch(subCategory) {
			case "race":
				result = faker.demographic().race();
				break;
			case "demonym":
				result = faker.demographic().demonym();
				break;
			case "sex":
				result = faker.demographic().sex();
				break;
			case "maritalstatus":
				result = faker.demographic().maritalStatus();
				break;
			}break;
		case "dog":
			switch(subCategory) {
			case "name":
				result = faker.dog().name();
				break;
			case "breed":
				result = faker.dog().breed();
				break;
			case "sound":
				result = faker.dog().sound();
				break;
			case "age":
				result = faker.dog().age();
				break;
			case "coatlength":
				result = faker.dog().coatLength();
				break;
			case "gender":
				result = faker.dog().gender();
				break;
			case "size":
				result = faker.dog().size();
			}break;
		case "dragonball":
			result = faker.dragonBall().character();
			break;
		case "educator":
			switch(subCategory) {
			case "university":
				result = faker.educator().university();
				break;
			case "course":
				result = faker.educator().course();
				break;
			case "secondaryschool":
				result = faker.educator().secondarySchool();
				break;
			case "campus":
				result = faker.educator().campus();
				break;
			}break;
		case "esports":
			switch(subCategory) {
			case "player":
				result = faker.esports().player();
				break;
			case "team":
				result = faker.esports().team();
				break;
			case "event":
				result = faker.esports().event();
				break;
			case "league":
				result = faker.esports().league();
				break;
			case "game":
				result = faker.esports().game();
				break;
			}break;
		case "finance":
			switch(subCategory) {
			case "creditcard":
				result = faker.finance().creditCard();
				break;
			case "iban":
				result = faker.finance().iban();
				break;
			}
		case "food":
			switch(subCategory) {
			case "ingredient":
				result = faker.food().ingredient();
				break;
			case "spice":
				result = faker.food().spice();
				break;
			}break;
		case "friends":
			switch(subCategory) {
			case "character":
				result = faker.friends().character();
				break;
			case "location":
				result = faker.friends().location();
				break;
			case "quote":
				result = faker.friends().quote();
				break;
			}break;
		case "gameofthrones":
			switch(subCategory) {
			case "character":
				result = faker.gameOfThrones().character();
				break;
			case "city":
				result = faker.gameOfThrones().city();
				break;
			case "dragon":
				result = faker.gameOfThrones().dragon();
				break;
			case "house":
				result = faker.gameOfThrones().house();
				break;
			case "quote":
				result = faker.gameOfThrones().quote();
				break;
			}break;
		case "harrypotter":
			switch(subCategory) {
			case "book":
				result = faker.harryPotter().book();
				break;
			case "character":
				result = faker.harryPotter().character();
				break;
			case "location":
				result = faker.harryPotter().location();
				break;
			case "quote":
				result = faker.harryPotter().quote();
			}break;
		case "hobbit":
			switch(subCategory) {
			case "character":
				result = faker.hobbit().character();
				break;
			case "location":
				result = faker.hobbit().location();
				break;
			case "quote":
				result = faker.hobbit().quote();
				break;
			case "thorinscompany":
				result = faker.hobbit().thorinsCompany();
				break;
			}
			break;
		case "howimetyourmother":
			switch(subCategory) {
			case "character":
				result = faker.howIMetYourMother().character();
				break;
			case "quote":
				result = faker.howIMetYourMother().quote();
				break;
			}
			break;
		case "internet":
			switch(subCategory) {
			case "emailaddress":
				result = faker.internet().emailAddress();
				break;
			case "domainname":
				result = faker.internet().domainName();
				break;
			case "url":
				result = faker.internet().url();
				break;
			case "password":
				result = faker.internet().password();
				break;
			}
			break;
		case "job":
			switch(subCategory) {
			case "field":
				result = faker.job().field();
				break;
			case "seniority":
				result = faker.job().seniority();
				break;
			case "position":
				result = faker.job().position();
				break;
			case "keyskills":
				result = faker.job().keySkills();
				break;
			case "title":
				result = faker.job().title();
				break;
			}break;
		case "leagueoflegends":
			switch(subCategory) {
			case "champion":
				result = faker.leagueOfLegends().champion();
				break;
			case "summonerspell":
				result = faker.leagueOfLegends().summonerSpell();
				break;
			case "rank":
				result = faker.leagueOfLegends().rank();
				break;
			case "location":
				result = faker.leagueOfLegends().location();
				break;
			case "quote":
				result = faker.leagueOfLegends().quote();
				break;
			}break;
		case "lordoftherings":
			switch(subCategory) {
			case "character":
				result = faker.lordOfTheRings().character();
				break;
			case "location":
				result = faker.lordOfTheRings().location();
				break;
			}break;
		case "music":
			switch(subCategory) {
			case "chord":
				result = faker.music().chord();
				break;
			case "instrument":
				result = faker.music().instrument();
				break;
			case "key":
				result = faker.music().key();
				break;
			}break;
		case "name":
			switch(subCategory) {
			case "fullname":
				result = faker.name().fullName();
				break;
			case "firstname":
				result = faker.name().firstName();
				break;
			case "lastname":
				result = faker.name().lastName();
				break;
			case "namewithmiddle":
				result = faker.name().nameWithMiddle();
				break;
			}break;
		case "phonenumber":
			switch(subCategory) {
			case "cellphone":
				result = faker.phoneNumber().cellPhone();
				break;
			case "phonenumber":
				result = faker.phoneNumber().phoneNumber();
				break;
			}break;
		case "pokemon":
			switch(subCategory) {
			case "name":
				result = faker.pokemon().name();
				break;
			case "location":
				result = faker.pokemon().location();
				break;
			}break;
		case "rockband":
			result = faker.rockBand().name();
			break;
		case "space":
			switch(subCategory) {
			case "agency":
				result = faker.space().agency();
				break;
			case "agencyabbreviation":
				result = faker.space().agencyAbbreviation();
				break;
			case "company":
				result = faker.space().company();
				break;
			case "consteallation":
				result = faker.space().constellation();
				break;
			case "distancemeasurement":
				result = faker.space().distanceMeasurement();
				break;
			case "galaxy":
				result = faker.space().galaxy();
				break;
			case "meteorite":
				result = faker.space().meteorite();
				break;
			case "moon":
				result = faker.space().moon();
				break;
			case "nasaspacecraft":
				result = faker.space().nasaSpaceCraft();
				break;
			case "nebula":
				result = faker.space().nebula();
				break;
			case "planet":
				result = faker.space().planet();
				break;
			case "star":
				result = faker.space().star();
				break;
			case "starcluster":
				result = faker.space().starCluster();
				break;
			}break;
		case "startrek":
			switch(subCategory) {
			case "character":
				result = faker.starTrek().character();
				break;
			case "location":
				result = faker.starTrek().location();
				break;
			case "specie":
				result = faker.starTrek().specie();
				break;
			case "villain":
				result = faker.starTrek().villain();
				break;
			}break;
		case "stock":
			switch(subCategory) {
			case "nsdqsymbol":
				result = faker.stock().nsdqSymbol();
				break;
			case "nysesymbol":
				result = faker.stock().nyseSymbol();
				break;
			}break;
		case "superhero":
			switch(subCategory) {
			case "descriptor":
				result = faker.superhero().descriptor();
				break;
			case "name":
				result = faker.superhero().name();
				break;
			case "power":
				result = faker.superhero().power();
				break;
			case "prefix":
				result = faker.superhero().prefix();
				break;
			case "suffix":
				result = faker.superhero().suffix();
				break;
			}break;
		case "team":
			switch(subCategory) {
			case "creature":
				result = faker.team().creature();
				break;
			case "name":
				result = faker.team().name();
				break;
			case "sport":
				result = faker.team().sport();
				break;
			case "state":
				result = faker.team().state();
				break;
			}break;
		case "weather":
			switch(subCategory) {
			case "description":
				result = faker.weather().description();
				break;
			case "temperaturecelsius":
				result = faker.weather().temperatureCelsius();
				break;
			case "temperaturefahrenheit":
				result = faker.weather().temperatureFahrenheit();
				break;
			}break;
		case "witcher":
			switch(subCategory) {
			case "character":
				result = faker.witcher().character();
				break;
			case "location":
				result = faker.witcher().location();
				break;
			case "monster":
				result = faker.witcher().monster();
				break;
			case "quote":
				result = faker.witcher().quote();
				break;
			case "school":
				result = faker.witcher().school();
				break;
			}break;
		}
		return result;
	};

	@Override
	public String getMirroredResponse(String response){
		return null;
	}

	@Override
	public MediaType getMIME(String contentType) {
		MediaType result = null;
		if (contentType.equals("text/plain")) {
			result = MediaType.TEXT_PLAIN;
		} else if (contentType.equals("application/xml") ) {
			result = MediaType.APPLICATION_XML;
		} else {
			result = MediaType.APPLICATION_JSON;
		}
		return result;
	}
	
	@Override
	public HttpStatus getStatus(int code) {
		HttpStatus status = null;
		switch(code) {
		case 200:
			status = HttpStatus.OK;
			break;
		case 400:
			status = HttpStatus.BAD_REQUEST;
			break;
		case 401:
			status = HttpStatus.UNAUTHORIZED;
			break;
		case 403:
			status = HttpStatus.FORBIDDEN;
			break;
		case 404:
			status = HttpStatus.NOT_FOUND;
			break;
		case 405:
			status = HttpStatus.METHOD_NOT_ALLOWED;
			break;
		case 406:
			status = HttpStatus.NOT_ACCEPTABLE;
			break;
		case 407:
			status = HttpStatus.PROXY_AUTHENTICATION_REQUIRED;
			break;
		case 408:
			status = HttpStatus.REQUEST_TIMEOUT;
			break;
		case 409:
			status = HttpStatus.CONFLICT;
			break;
		case 410:
			status = HttpStatus.GONE;
			break;
		case 411:
			status = HttpStatus.LENGTH_REQUIRED;
			break;
		case 412:
			status = HttpStatus.PRECONDITION_FAILED;
			break;
		case 413:
			status = HttpStatus.PAYLOAD_TOO_LARGE;
			break;
		case 414:
			status = HttpStatus.URI_TOO_LONG;
			break;
		case 415:
			status = HttpStatus.UNSUPPORTED_MEDIA_TYPE;
			break;
		case 416:
			status = HttpStatus.REQUESTED_RANGE_NOT_SATISFIABLE;
			break;
		case 417:
			status = HttpStatus.EXPECTATION_FAILED;
			break;
		case 418:
			status = HttpStatus.I_AM_A_TEAPOT;
			break;
		case 426:
			status = HttpStatus.UPGRADE_REQUIRED;
			break;
		case 428:
			status = HttpStatus.PRECONDITION_REQUIRED;
			break;
		case 429:
			status = HttpStatus.TOO_MANY_REQUESTS;
			break;
		case 431:
			status = HttpStatus.REQUEST_HEADER_FIELDS_TOO_LARGE;
			break;
		case 451:
			status = HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS;
			break;
		case 500:
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			break;
		case 501:
			status = HttpStatus.NOT_IMPLEMENTED;
			break;
		case 502:
			status = HttpStatus.BAD_GATEWAY;
			break;
		case 503:
			status = HttpStatus.SERVICE_UNAVAILABLE;
			break;
		}
		return status;
	}
	
	

}
