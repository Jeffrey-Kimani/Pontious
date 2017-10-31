package com.Tunes_Developers.Utils;

import com.Tunes_Developers.Models.FakerItem;

/**
 * Created by Geoffrey-Kimani on 10/14/2017.
 */
public class FakerDatabase {
    String country = null;
    String language = null;

    public FakerDatabase() {

    }

    public FakerDatabase(String language, String country) {
        this.country = country;
        this.language = language;
    }

    //Base
    public FakerItem randomDigit() {
        return new FakerItem(country,language,1);
    }

    public FakerItem digitBetween(int min,int max) {
        return new FakerItem(country,language,2,min,max);
    }

    public FakerItem randomLetter() {
        return new FakerItem(country,language,3);
    }

    public FakerItem numerify(String format) {
        return new FakerItem(country,language,4,format);
    }

    public FakerItem numerifyNoZeros(String format) {
        return new FakerItem(country,language,5,format);
    }

    public FakerItem numerifyAboveZero(String format) {
        return new FakerItem(country,language,6,format);
    }

    public FakerItem numerify(String format,String constrain) {
        return new FakerItem(country,language,7,format,constrain);
    }

    public FakerItem numerifyNoZeros(String format,String constrain) {
        return new FakerItem(country,language,8,format,constrain);
    }

    public FakerItem lexify(String format) {
        return new FakerItem(country,language,9,format);
    }

    public FakerItem bothify(String format) {
        return new FakerItem(country,language,10,format);
    }

    public FakerItem ascify(String format) {
        return new FakerItem(country,language,11,format);
    }

    //Lorem
    public FakerItem word() {
        return new FakerItem(country,language,12);
    }

    public FakerItem sentence() {
        return new FakerItem(country,language,13);
    }

    public FakerItem sentence(int nbWords) {
        return new FakerItem(country,language,14,nbWords);
    }

    public FakerItem paragraph(int nbWords,int nbSentences) {
        return new FakerItem(country,language,15,nbWords,nbSentences);
    }

    public FakerItem paragraph() {
        return new FakerItem(country,language,16);
    }

    public FakerItem paragraphs() {
        return new FakerItem(country,language,17);
    }

    public FakerItem paragraphs(int nbWords, int nbSentences, int nbParagraphs) {
        return new FakerItem(country,language,18,nbWords,nbSentences,nbParagraphs);
    }

    //Person
    public FakerItem title() {
        return new FakerItem(country,language,19);
    }

    public FakerItem titleMale() {
        return new FakerItem(country,language,20);
    }

    public FakerItem titleFemale() {
        return new FakerItem(country,language,21);
    }

    public FakerItem oneName() {
        return new FakerItem(country,language,22);
    }

    public FakerItem name() {
        return new FakerItem(country,language,23);
    }

    public FakerItem nameMale() {
        return new FakerItem(country,language,24);
    }

    public FakerItem nameFemale() {
        return new FakerItem(country,language,25);
    }

    //Address
    public FakerItem city() {
        return new FakerItem(country,language,26);
    }

    public FakerItem county() {
        return new FakerItem(country,language,27);
    }

    public FakerItem country() {
        return new FakerItem(country,language,28);
    }

    public FakerItem postCode() {
        return new FakerItem(country,language,29);
    }

    public FakerItem longitude() {
        return new FakerItem(country,language,30);
    }

    public FakerItem latitude() {
        return new FakerItem(country,language,31);
    }

    public FakerItem phoneNumber() {
        return new FakerItem(country,language,32);
    }

    //Text
    public FakerItem text() {
        return new FakerItem(country,language,33);
    }

    public FakerItem text(int nbParagraphs, int nbSentences) {
        return new FakerItem(country,language,34,nbParagraphs,nbSentences);
    }

    //Address
    public FakerItem date() {
        return new FakerItem(country,language,35);
    }

    public FakerItem dateNow() {
        return new FakerItem(country,language,36);
    }

    public FakerItem dateTime() {
        return new FakerItem(country,language,37);
    }

    public FakerItem dateTimeNow() {
        return new FakerItem(country,language,38);
    }

    public FakerItem time() {
        return new FakerItem(country,language,39);
    }

    public FakerItem timeNow() {
        return new FakerItem(country,language,40);
    }

    public FakerItem dateOld() {
        return new FakerItem(country,language,41);
    }

    public FakerItem dateTimeOld() {
        return new FakerItem(country,language,42);
    }

    public FakerItem month() {
        return new FakerItem(country,language,43);
    }

    public FakerItem year() {
        return new FakerItem(country,language,44);
    }

    public FakerItem dateOfMonth() {
        return new FakerItem(country,language,45);
    }

    public FakerItem monthName() {
        return new FakerItem(country,language,46);
    }

    public FakerItem monthNameShort() {
        return new FakerItem(country,language,47);
    }

    public FakerItem dayOfWeek() {
        return new FakerItem(country,language,48);
    }

    public FakerItem dayOfWeekShort() {
        return new FakerItem(country,language,49);
    }

    public FakerItem dateTimeThisYear() {
        return new FakerItem(country,language,50);
    }

    //Internet
    public FakerItem email() {
        return new FakerItem(country,language,51);
    }

    public FakerItem safeEmail() {
        return new FakerItem(country,language,52);
    }

    public FakerItem freeEmail() {
        return new FakerItem(country,language,53);
    }

    public FakerItem emailResource() {
        return new FakerItem(country,language,54);
    }

    public FakerItem safeEmailResource() {
        return new FakerItem(country,language,55);
    }

    public FakerItem freeEmailResource() {
        return new FakerItem(country,language,56);
    }

    public FakerItem ipv4() {
        return new FakerItem(country,language,57);
    }

    public FakerItem localIpv4() {
        return new FakerItem(country,language,58);
    }

    public FakerItem ipv6() {
        return new FakerItem(country,language,59);
    }

    public FakerItem macAddress() {
        return new FakerItem(country,language,60);
    }

    public FakerItem url() {
        return new FakerItem(country,language,61);
    }

    public FakerItem domainName() {
        return new FakerItem(country,language,62);
    }

    public FakerItem slug() {
        return new FakerItem(country,language,63);
    }

    public FakerItem password() {
        return new FakerItem(country,language,64);
    }

    public FakerItem username() {
        return new FakerItem(country,language,65);
    }

    public FakerItem usernameResource() {
        return new FakerItem(country,language,66);
    }

    public FakerItem tid() {
        return new FakerItem(country,language,67);
    }

    //Payment
    public FakerItem creditCardType() {
        return new FakerItem(country,language,68);
    }

    public FakerItem creditCardNumber() {
        return new FakerItem(country,language,69);
    }

    public FakerItem creditCardNumberResource() {
        return new FakerItem(country,language,70);
    }

    public FakerItem creditCardExpirationDate() {
        return new FakerItem(country,language,71);
    }

    //Color
    public FakerItem hexColor() {
        return new FakerItem(country,language,72);
    }

    public FakerItem rgbColor() {
        return new FakerItem(country,language,73);
    }

    public FakerItem rgbCssColor() {
        return new FakerItem(country,language,74);
    }

    public FakerItem colorName() {
        return new FakerItem(country,language,75);
    }

    public FakerItem safeColorName() {
        return new FakerItem(country,language,76);
    }

    //Barcode
    public FakerItem ean13() {
        return new FakerItem(country,language,77);
    }

    public FakerItem ean8() {
        return new FakerItem(country,language,78);
    }

    public FakerItem isbn13() {
        return new FakerItem(country,language,79);
    }

    public FakerItem isbn10() {
        return new FakerItem(country,language,80);
    }

    //Miscellaneous
    public FakerItem bool() {
        return new FakerItem(country,language,81);
    }

    public FakerItem md5() {
        return new FakerItem(country,language,82);
    }

    public FakerItem sha1() {
        return new FakerItem(country,language,83);
    }

    public FakerItem sha256() {
        return new FakerItem(country,language,84);
    }

    public FakerItem locale() {
        return new FakerItem(country,language,85);
    }

    public FakerItem countryCode() {
        return new FakerItem(country,language,86);
    }

    public FakerItem countryCodeIsoAlpha3() {
        return new FakerItem(country,language,87);
    }

    public FakerItem languageCode() {
        return new FakerItem(country,language,88);
    }

    public FakerItem currencyCode() {
        return new FakerItem(country,language,89);
    }
}
