/**
 * Copyright (c) 2017 ATB
 * All rights reserved.
 * 
 * Version: V01
 * Created on: June 01, 2016
 * Created by: Kanimozhi Mahendran
 * Created Reference: ATB
 *  
 */
package com.atb.common;

import java.math.BigDecimal;
import java.security.Key;
import java.security.SecureRandom;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.TimeZone;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.StringUtils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * General purpose utility class.
 */
public class Util
{
    private static final Log    log                             = LogFactory.getLog(Util.class);

    private static final Random RANDOM                          = new SecureRandom();
    private static final String PASS_CHARS                      =
        "abcdefghijklmnopqrstuvwxyz!@#$%^&*-+ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    public static final int     PASSWORD_LENGTH                 = 10;

    private static final String ALGORITHM                       = "AES";
    private static final String KEY                             = "gbyu7!$%^&*WXYZQ";

    public static final String  ATB_DATE_FORMAT                = "dd-MMM-yyyy";
    public static final String  ATB_DATE_FORMAT_WITH_TIME      = "dd-MMM-yyyy HH:mm";
    public static final String  ATB_DATE_FORMAT_WITH_TIMESTAMP = "dd-MMM-yyyy HH:mm:ss";

    /**
     * Private constructor prevents instantiation.
     */
    private Util()
    {}

    public static String getListOfLongAsCommaSeparated(List<Long> ids)
    {
        if (ids == null)
        {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (Long id : ids)
        {
            sb.append(id + ",");
        }
        if (sb.length() > 0)
        {
            sb.deleteCharAt(sb.length() - 1);
        }

        log.debug(ids + " --> " + sb.toString());
        return sb.toString();
    }

    /**
     * Return a Long corresponding to a String, null if the String is not a valid Long
     * 
     * @param string
     * @return
     */
    public static Long getLong(String string)
    {
        try
        {
            return Long.valueOf(string);
        }
        catch (NumberFormatException e)
        {
            return null;
        }
    }

    /**
     * @param collection a collection
     * @return true if the collection is neither null nor empty, otherwise false
     */
    public static boolean isNeitherNullNorEmpty(Collection<?> collection)
    {
        return !isNullOrEmpty(collection);
    }

    /**
     * @param map a map
     * @return true if the map is neither null nor empty, otherwise false
     */
    public static boolean isNeitherNullNorEmpty(Map<?, ?> map)
    {
        return !isNullOrEmpty(map);
    }

    /**
     * @param array an array
     * @return true if the array is neither null nor has length of 0, otherwise false
     */
    public static boolean isNeitherNullNorEmpty(Object[] array)
    {
        return !isNullOrEmpty(array);
    }

    /**
     * @param string a string
     * @return true if the string is not null and has non-whitespace length at least one, else false
     */
    public static boolean isNeitherNullNorEmpty(String string)
    {
        return string != null && string.trim().length() > 0;
    }

    /**
     * @param collection a collection
     * @return true if the collection is null or empty, otherwise false
     */
    public static boolean isNullOrEmpty(Collection<?> collection)
    {
        return (collection == null || collection.isEmpty());
    }

    /**
     * @param map a map
     * @return true if the map is null or empty, otherwise false
     */
    public static boolean isNullOrEmpty(Map<?, ?> map)
    {
        return (map == null || map.isEmpty());
    }

    /**
     * @param array an array of objects
     * @return true if the array is null or has length of 0, otherwise false
     */
    public static boolean isNullOrEmpty(Object[] array)
    {
        return (array == null || array.length == 0);
    }

    /**
     * If - the given String is null - or equal to the empty String - or contains only spaces
     * returns true.
     * 
     * If the String has non-space content, returns false.
     * 
     * Useful for parameter checking in requests and elsewhere.
     * 
     * @param String
     * @return boolean
     */
    public static boolean isNullOrEmpty(String target)
    {
        if (target == null)
        {
            return true;
        }
        if ("".equals(target.trim()))
        {
            return true;
        }
        return false;
    }

    /**
     * @author maria.p.chinnappan
     * 
     *         Returns the Search Pattern from the GenericSearchCriteria.
     * 
     * @param GenericSearchCriteria
     * @return SearchPattern - String.
     */
    public static String getSearchPattern(GenericSearchCriteria criteria)
    {
        if (StringUtils.hasText(criteria.getSearchString()))
        {
            return "'%" + criteria.getSearchString().toLowerCase().replace('*', '%') + "%'";
        }
        else
        {
            return "'%'";
        }
    }

    /**
     * 
     * Returns the Search String with Comma separted
     * 
     * @param String
     * @return String.
     */
    public static String convertStringAsCommaSeperated(String searchString)
    {
        StringTokenizer st = new StringTokenizer(searchString, ",");
        String newSearchString = "";
        while (st.hasMoreTokens())
        {
            newSearchString = newSearchString.concat("'" + st.nextToken() + "',");
        }
        return newSearchString.substring(0, newSearchString.length() - 1);
    }

    public static String appendZeros(Long number, String type)
    {
        String numberString = "";
        if (String.valueOf(number).length() == 1)
        {
            numberString = type.concat("0000".concat(String.valueOf(number)));
        }
        else if (String.valueOf(number).length() == 2)
        {
            numberString = type.concat("000".concat(String.valueOf(number)));
        }
        else if (String.valueOf(number).length() == 3)
        {
            numberString = type.concat("00".concat(String.valueOf(number)));
        }
        else if (String.valueOf(number).length() == 4)
        {
            numberString = type.concat("0".concat(String.valueOf(number)));
        }
        else
        {
            numberString = type.concat(String.valueOf(number));
        }
        return numberString;

    }

    public static String getIncreasedNumber(String releaseNoteNumber, String releaseNoteType)
    {
        Long rnNumber = getLong(releaseNoteNumber.substring(2, 7)) + 1;
        return appendZeros(rnNumber, releaseNoteType);
    }

    public static String generateRandomPassword()
    {
        String password = "";
        for (int i = 0; i < PASSWORD_LENGTH; i++)
        {
            int index = (int) (RANDOM.nextDouble() * PASS_CHARS.length());
            password += PASS_CHARS.substring(index, index + 1);
        }
        return password;
    }

    public static String formatLastLoginDate(Date lastLoginDate)
    {
        if (null != lastLoginDate)
        {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");
            format = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");
            return format.format(lastLoginDate);
        }
        else
        {
            return "First time login";
        }

    }

    public static String getArrayOfStringAsCommaSeperated(String[] names)
    {
        if (names == null)
        {
            return "";
        }

        StringBuffer sb = new StringBuffer();
        for (String id : names)
        {
            sb.append("'" + id + "',");
        }
        if (sb.length() > 0)
        {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    /**
     * Left-pad the number with zeros to the requested length.
     * 
     * @param number the number to left-pad
     * @param length the end-length to pad up to
     * @return
     */
    public static String leftPad(Long number, int length)
    {
        if (number == null)
        {
            return null;
        }
        String string = String.valueOf(number);
        int diff = length - string.length();
        if (diff > 0)
        {
            String padding = "";
            for (int i = 0; i < diff; i++)
            {
                padding += "0";
            }
            string = padding + string;
        }
        return string;
    }

    public static String getIncreasedAssetRequestCode(String assetRequestCode, String assetRequestType)
    {
        Long number = getLong(assetRequestCode.substring(2, 7)) + 1;
        return appendZeros(number, assetRequestType);
    }

    public static int checkDay(String day)
    {
        Map<String, Integer> mp = new HashMap<String, Integer>();

        mp.put("SUNDAY", 0);
        mp.put("MONDAY", 1);
        mp.put("TUESDAY", 2);
        mp.put("WEDNESDAY", 3);
        mp.put("THURSDAY", 4);
        mp.put("FRIDAY", 5);
        mp.put("SATURDAY", 6);

        return mp.get(day).intValue();
    }

   

   
    public static String convertTime(long time)
    {
        Date date = new Date(time);
        Format format = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        return format.format(date);
    }

    public static String encryptPassword(String password)
        throws Exception
    {
        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedByteValue = cipher.doFinal(password.getBytes("utf-8"));
        String encryptedPassword = new BASE64Encoder().encode(encryptedByteValue);
        return encryptedPassword;
    }

    public static String decryptPassword(String encryptedPassword)
        throws Exception
    {

        Key key = generateKey();
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedValue64 = new BASE64Decoder().decodeBuffer(encryptedPassword);
        byte[] decryptedByteValue = cipher.doFinal(decryptedValue64);
        String decryptedPassword = new String(decryptedByteValue, "utf-8");
        return decryptedPassword;
    }

    private static Key generateKey()
        throws Exception
    {
        Key key = new SecretKeySpec(KEY.getBytes(), ALGORITHM);
        return key;
    }

    public static <T> T rangeSafeGet(List<T> result, int i)
    {
        if (result == null || i < 0 || i >= result.size())
        {
            return null;
        }
        return result.get(i);
    }

    /**
     * @param date a date
     * @return the date in standard E-PM format, "dd-MMM-yyyy". For example,
     *         <code>31-Jan-2004</code>
     */
    public static String getAsATBDate(Date date)
    {
        return (date == null ? null : formatDate(date, ATB_DATE_FORMAT));
    }

    /**
     * Takes a Date and time (as a <code>java.util.Date</code>) formats it to the specified pattern
     * as a String.
     * 
     * @param pDate The date to be formatted.
     * @param pPattern Pattern according to which the date should be reformatted.
     * 
     * @return The date formatted accordingly to the specified pattern.
     */
    public static String formatDate(Date pDate, String pPattern)
    {
        DateFormat df = new SimpleDateFormat(pPattern, Locale.US);

        return df.format(pDate);
    }

    /**
     * Overloaded version of <code>formatDate</code> that takes separate date and time patterns and
     * concatenates them together (with an added space), calling the overloaded method.
     * 
     * @param pDate DOCUMENT ME!
     * @param pDatePattern DOCUMENT ME!
     * @param pTimePattern DOCUMENT ME!
     * 
     * @return DOCUMENT ME!
     */
    public static String formatDate(Date pDate, String pDatePattern, String pTimePattern)
    {
        return formatDate(pDate, pDatePattern + " " + pTimePattern);
    }

    /**
     * Converts String value to Long value.
     * 
     * @param String
     * @return
     */
    public static Long parseLong(String string)
    {
        return parseLong(string, false);
    }

    public static Long parseLong(String string, boolean acceptEmptyString)
    {
        if (acceptEmptyString && "".equals(string))
        {
            return new Long(0);
        }

        Long value = null;
        try
        {
            value = (string != null ? new Long(string) : null);
        }
        catch (NumberFormatException nfe)
        {
            log.debug("Not able to parse string to long: " + string);
        }
        return value;
    }

    public static String getSearchPattern(String seachString)
    {
        if (StringUtils.hasText(seachString))
        {
            try
            {
                Long numVal = Long.valueOf(seachString);
                return "'%" + numVal + "%'";
            }
            catch (NumberFormatException e)
            {
                return "'%" + seachString.toLowerCase().replace('*', '%') + "%'";
            }
        }
        else
        {
            return "'%'";
        }
    }

    /**
     * Search pattern by objects
     * 
     * @param seachString
     * @return
     */
    public static String getSearchPatternObjects(String seachString)
    {
        if (StringUtils.hasText(seachString))
        {
            return "'%" + seachString.toLowerCase().replace('*', '%') + "%'";
        }
        else
        {
            return "'%'";
        }
    }

    /**
     * Split a string by a separator.
     * 
     * @param string the string to split
     * @param token the separator token
     * @return a List of strings
     */
    public static List<String> split(String string, String token)
    {
        List<String> list = new ArrayList<String>();
        if (string != null)
        {
            StringTokenizer st = new StringTokenizer(string, token);
            while (st.hasMoreTokens())
            {
                list.add(st.nextToken());
            }
        }
        return list;
    }

    public static boolean equals(String string1, String string2)
    {
        if (string1 == null && string2 == null)
        {
            return true;
        }
        if ((string1 == null && string2 != null) || (string1 != null && string2 == null))
        {
            return false;
        }
        return string1.equals(string2);
    }

    /**
     * Return a blank string if null parameter is given, otherwise return Object.toString().
     * 
     * @param object
     * @return object.toString() if parameter wasn't null, otherwise a blank string
     */
    public static String emptyIfNull(Object object)
    {
        if (object == null)
            return "";

        return object.toString();
    }

    public static String getIncreasedPurchaseRequestNumber(String purchaseRequestNumber, String purchaseRequestType)
    {
        Long number = getLong(purchaseRequestNumber.substring(3, 7)) + 1;// Defect 247
        return appendZeros(number, purchaseRequestType);
    }

    public static int convertLongintoInt(Long rowCount)
    {
        return rowCount != null ? rowCount.intValue() : 0;
    }

    public static String getIncreasedCPRNumber(String consolidatedPrNumber, String consolidatedPurchaseRequestNum)
    {
        Long number = getLong(consolidatedPrNumber.substring(3, 8)) + 1;
        return appendZeros(number, consolidatedPurchaseRequestNum);
    }

    /**
     * Convert String to Date
     * 
     * @param string
     * 
     * @format yyyy-mm-dd
     * 
     * @return date
     */
    public static Date convertStringAsDate(String date)
    {
        log.info("Date Recevied from the UI" + date);
        if (isNeitherNullNorEmpty(date))
        {

            String[] parsedDate = date.split("-");
            if (parsedDate.length == 3)
            {
                int year = Integer.parseInt(parsedDate[2]);
                int month = Integer.parseInt(parsedDate[1]);
                int day = Integer.parseInt(parsedDate[0]);
                log.info("year" + year);
                log.info("month" + month);
                log.info("day" + day);
                GregorianCalendar gregorianCalendar = new GregorianCalendar(year, month - 1, day);
                log.info("gregorianCalendar" + gregorianCalendar);
                log.info("gregorianCalendar.getTime()" + gregorianCalendar.getTime());
                return gregorianCalendar.getTime();
            }
        }
        return null;
    }

   

    public static boolean isAvailableInConstant(String availableList, String stringToTest)
    {

        String[] avaailableListArray = new String[100];
        List<String> arrayToList = new ArrayList<String>();

        if (null != availableList)
        {
            avaailableListArray = availableList.split(",");
            arrayToList = Arrays.asList(avaailableListArray);
            if (null != arrayToList && !arrayToList.isEmpty() && arrayToList.contains(stringToTest))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public static String convertDate(Date date)
    {

        SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date orgDate = null;
        try
        {
            orgDate = inFormat.parse("" + date);
        }
        catch (ParseException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(orgDate);
    }

    public static boolean compareStringValue(String oldValue, String newValue)
    {
        if (oldValue == null && newValue == null)
        {
            return true;
        }
        if ((oldValue == null && newValue != null) || (oldValue != null && newValue == null))
        {
            return false;
        }
        return oldValue.equals(newValue);

    }

    public static boolean compareLongValue(Long oldValue, Long newValue)
    {

        if (oldValue == null && newValue == null)
        {
            return true;
        }
        if ((oldValue == null && newValue != null) || (oldValue != null && newValue == null))
        {
            return false;
        }
        return oldValue.equals(newValue);
    }

    public static boolean compareBigDecimalValue(BigDecimal oldValue, BigDecimal newValue)
    {

        if (oldValue == null && newValue == null)
        {
            return true;
        }
        if ((oldValue == null && newValue != null) || (oldValue != null && newValue == null))
        {
            return false;
        }
        return oldValue.equals(newValue);
    }

    public static boolean compareDateValue(java.sql.Date oldValue, java.sql.Date newValue)
    {
        if (oldValue == null && newValue == null)
        {
            return true;
        }
        if ((oldValue == null && newValue != null) || (oldValue != null && newValue == null))
        {
            return false;
        }
        return oldValue.equals(newValue);
    }

    public static boolean compareDateValue(Date oldValue, Date newValue)
    {
        if (oldValue == null && newValue == null)
        {
            return true;
        }
        if ((oldValue == null && newValue != null) || (oldValue != null && newValue == null))
        {
            return false;
        }
        return oldValue.equals(newValue);
    }

    public static boolean compareDateValueStr(Date oldValue, Date newValue)
    {

        if (oldValue == null && newValue == null)
        {
            return true;
        }
        if ((oldValue == null && newValue != null) || (oldValue != null && newValue == null))
        {
            return false;
        }
        else
        {

            SimpleDateFormat inFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
            Date orgDate = null;
            try
            {
                orgDate = inFormat.parse("" + oldValue);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String oldDateStr = formatter.format(orgDate);

            SimpleDateFormat inFormatNew = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
            Date orgDateNew = null;
            try
            {
                orgDateNew = inFormatNew.parse("" + newValue);
            }
            catch (ParseException e)
            {
                e.printStackTrace();
            }

            Format formatterNew = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String newDateStr = formatterNew.format(orgDateNew);

            return oldDateStr.equals(newDateStr);
        }
    }

    public static String convertToISO8601Format(Date inputDate)
    {
        TimeZone tz = TimeZone.getTimeZone("UTC");
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"); // Quoted "Z" to
                                                                              // indicate UTC, no
                                                                              // timezone offset
        df.setTimeZone(tz);
        String nowAsISO = df.format(inputDate);
        return nowAsISO;
    }

    public static String getStringFromCommaSeperatedValue(String searchValue)
    {
        String[] items = searchValue.split(",");
        String queryValue = "";
        for (String item : items)
        {
            if (StringUtils.hasText(item))
            {
                queryValue = queryValue.concat("'" + item.toLowerCase().replace('*', '%').trim() + "',");
            }
        }
        return queryValue.substring(0, queryValue.length() - 1);
    }

    public static String covertIntoNumber(String objectCode)
    {
        String[] items = objectCode.split("-");
        String queryValue = "";
        for (String item : items)
        {
            if (StringUtils.hasText(item))
            {
                if (item.length() <= 3)
                    item = Long.valueOf(item).toString();
                queryValue = queryValue.concat(item + "-");
            }
        }
        return queryValue.substring(0, queryValue.length() - 1);

    }

}