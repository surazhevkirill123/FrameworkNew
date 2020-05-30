package com.company;

import java.util.Arrays;
import java.util.Scanner;
import java.util.UUID;

public class Customer {

    private String id;
    private String surname;
    private String name;
    private String patronymic;
    private String address;
    private int creditCardNumber;
    private int bankAccountNumber;

    Customer(String id,String surname,String name,String patronymic,String address,int creditCardNumber,int bankAccountNumber)
    {
        this.id = UUID.randomUUID().toString();
        this.surname=surname;
        this.name=name;
        this.patronymic=patronymic;
        this.address=address;
        this.creditCardNumber=creditCardNumber;
        this.bankAccountNumber=bankAccountNumber;
    }
    Customer()
    {
        this.id = UUID.randomUUID().toString();
        System.out.println("Введите фамилию: ");Scanner in1 = new Scanner(System.in);this.surname=in1.nextLine();
        System.out.println("Введите имя: ");Scanner in2 = new Scanner(System.in);this.name=in2.nextLine();
        System.out.println("Введите отчество: ");Scanner in3 = new Scanner(System.in);this.patronymic=in3.nextLine();
        System.out.println("Введите адрес: ");Scanner in4 = new Scanner(System.in);this.address=in4.nextLine();
        System.out.println("Введите номер кредитной карты: ");Scanner in5 = new Scanner(System.in);this.creditCardNumber=in5.nextInt();
        System.out.println("Введите номер банковского счёта: ");Scanner in6 = new Scanner(System.in);this.bankAccountNumber=in6.nextInt();


    }


    public String getId() {
        return id;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setBankAccountNumber(int bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public int getBankAccountNumber() {
        return bankAccountNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", address='" + address + '\'' +
                ", creditCardNumber=" + creditCardNumber +
                ", bankAccountNumber=" + bankAccountNumber +
                '}';
    }
    public Customer[] CustomerCreatingArray(int length)
    {

        Customer[]customers=new Customer[length];
        for (int i=0;i<length;i++)
            customers[i]=new Customer();
        return customers;
    }
    public Customer[]SortByAlphabet(Customer[]customers)
    {
        String[]surnames=new String[customers.length];
        for (int i=0;i<customers.length;i++)
        {
            surnames[i]=customers[i].getSurname();
        }
        Arrays.sort(surnames);
        for (int i=0;i<customers.length;i++)
        {
            customers[i].setSurname(surnames[i]);
        }
        return customers;
    }
    public Customer[] FindByCreditCardNumber(Customer[]customers, int start, int finish)
    {
        int flag=0;
        for (int i=0;i<customers.length;i++)
        {
            if (customers[i].getCreditCardNumber()>=start && customers[i].getCreditCardNumber()<=finish)
                flag++;

        }

        Customer[] findedCustomers=new Customer[flag];

        int j=0;
        for (int i=0;i<customers.length;i++)
        {

            if (customers[i].getCreditCardNumber()>=start && customers[i].getCreditCardNumber()<=finish)
            {
                findedCustomers[j]=customers[i];
                
                j++;

            }
        }

        return findedCustomers;
    }

    public static void main(String[] args) {

    Customer customer=new Customer("j","dgr","sfef","sfefsef","sffsf",56,78);
    Scanner in=new Scanner(System.in);
    System.out.println("\nВведите число объектов в массиве: ");
    int n=in.nextInt();
    Customer[]customers=customer.CustomerCreatingArray(n);
    System.out.println("\nИсходный массив: ");
    for (int i=0;i<n;i++)
    {
        System.out.println(customers[i].toString());
    }
    System.out.println("\nОтсортированный массив: ");
    Customer[] sortedCustomers=customer.SortByAlphabet(customers);
    for (int i=0;i<sortedCustomers.length;i++)
    {
        System.out.println(sortedCustomers[i].toString());
    }
    System.out.println("\nОбъекты с нужным номером банковской карточки: ");
    Customer[] findedCustomers=customer.FindByCreditCardNumber(customers,34,89);
        for (int i=0;i<findedCustomers.length;i++)
        {
            System.out.println(findedCustomers[i].toString());
        }



    }
}
