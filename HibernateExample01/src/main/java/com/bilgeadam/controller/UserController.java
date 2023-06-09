package com.bilgeadam.controller;

import com.bilgeadam.entity.*;
import com.bilgeadam.repository.UserRepository;
import com.bilgeadam.utility.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserController {

    public static void main(String[] args) {
        // createUser();

        UserRepository userRepository = new UserRepository();
       // userRepository.findAll().forEach(System.out::println);

       // userRepository.findAllUserInformation().forEach(System.out::println);
       // userRepository.findAllInformationByName().forEach(System.out::println);
       // userRepository.findAllNativeQuery().forEach(System.out::println);
        User user = userRepository.findById(2L);
        System.out.println(user.getUsername()+ " "+ user.getInformation().getMiddleName());
    }

    public static void createUser() {

        Session session;
        Transaction transaction;

        // user save
        session = HibernateUtils.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        List<String> list1 = Arrays.asList("Book", "Comics");
        List<String> list2 = Arrays.asList("Painting", "Walking");
        List<String> list3 = Arrays.asList("Swimming", "Tennis");

        Map<AddressType, Address> adres1 = new HashMap<>();
        Map<AddressType, Address> adres2 = new HashMap<>();
        Map<AddressType, Address> adres3 = new HashMap<>();
        adres1.put(AddressType.HOME, new Address("Ankara", "Türkiye", "Madenli"));
        adres2.put(AddressType.OTHER, new Address("Aydın", "Türkiye", "General"));
        adres3.put(AddressType.BUSINESS, new Address("Denizli", "Türkiye", "Bakkal"));

        Information information = new Information("Damla", "Erişmiş", "derya");
        User user = new User("damii", "1234", information, EGender.WOMAN, list1, adres1);

        Information information2 = new Information("mehmet", "kış", "yaz");
        User user2 = new User("son", "12348534", information2, EGender.MAN, list2, adres2);

        Information information3 = new Information("Ayşe", "Ünal", "nur");
        User user3 = new User("hello", "123544", information3, EGender.OTHER, list3, adres3);

        Information information4 = new Information("zeynep", "zayıf", "zey");
        User user4 = new User("zeyn123", "456", information4, EGender.WOMAN, list3, adres3);

        Information information5 = new Information("buket", "kuş", "bkt");
        User user5 = new User("buket123", "778899", information5, EGender.WOMAN, list3, adres3);

        session.save(user);
        session.save(user2);
        session.save(user3);
        session.save(user4);
        session.save(user5);
        transaction.commit();
        session.close();

    }
}
