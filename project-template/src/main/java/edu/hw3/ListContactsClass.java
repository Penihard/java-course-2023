package edu.hw3;

import java.util.Arrays;

public class ListContactsClass {

    private ListContactsClass() {

    }

    public static String[] listContacts(String[] contacts, OrderByEnum orderBy) {
        if (contacts == null || contacts.length == 0) {
            return new String[0];
        }

        Arrays.sort(contacts, (value1, value2) -> {
            String lastName1 = value1.substring(value1.lastIndexOf(" ") + 1);
            String lastName2 = value2.substring(value2.lastIndexOf(" ") + 1);

            if (orderBy == OrderByEnum.ASC) {
                return lastName1.compareTo(lastName2);
            } else {
                return lastName2.compareTo(lastName1);
            }
        });

        return contacts;
    }

   /* public static void main(String[] args) {
        String[] arr1={ "John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"};
        var b = listContacts(arr1,OrderByEnum.ASC);
        for (var a:b
             ) {
            System.out.println(a);
        }
        System.out.println();
    }*/
}

