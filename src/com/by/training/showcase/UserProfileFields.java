package com.day2;

import java.util.function.Predicate;

public class UserProfileFields {

   public static void main(String[] args){
      //FirstName & LastName
      Predicate<String> nameValidationPredicate = name -> Character.isUpperCase(name.charAt(0)) &&
              name.length()>=3;
      //email Validation
      Predicate<String> emailValidation = UserProfileFields::isValidEmail;
      //phoneNumber
      String phoneNumber="91 9898989898";
      boolean validPhoneFlag= isValidPhoneNumber(phoneNumber);
      //password
      String password="Rajan@12";
      boolean validPasswordFlag= isValidPassword(password);

      System.out.println("FirstName >"+nameValidationPredicate.test("Kuldeep"));//firstName
      System.out.println("LastName >"+nameValidationPredicate.test("Sharma"));//lastName
      System.out.println("Email Details >"+emailValidation.test("abc.xyz@bl.co.in"));//email
      System.out.println("Phone Number >"+validPhoneFlag);//phoneNumber
      System.out.println("Password Details "+validPasswordFlag);//password

   }
   private static boolean isValidEmail(String email) {
      return email.startsWith("abc") && email.contains("bl.co")
              && email.split("@")[0].contains(".") && email.
              split("@")[1].contains(".");
   }
   private static boolean isValidPhoneNumber(String phoneNumber) {
      String phoneReg = "\\d{2}\\s\\d{10}";
      return phoneNumber.matches(phoneReg);
   }

   private static boolean isValidPassword(String password) {
      /*
      ^ represents starting character of the string.
      (?=.*[0-9]) represents a digit must occur at least once -.
      (?=.*[a-z]) represents a lower case alphabet must occur at least once.
      (?=.*[A-Z]) represents an upper case alphabet that must occur at least once -.
      (?=.*[@#$%^&-+=()] represents a special character that must occur at least once -.
      (?=\\S+$) white spaces don’t allowed in the entire string.
      .{8, 20} represents at least 8 characters and at most 20 characters -.
      $ represents the end of the string.
       */
      String passwordReg = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#$%^&-+=()]).{8,20}$";
      return password.matches(passwordReg);
   }
}
