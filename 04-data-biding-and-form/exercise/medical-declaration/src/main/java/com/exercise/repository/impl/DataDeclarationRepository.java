package com.exercise.repository.impl;

import com.exercise.repository.IDataDeclarationRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DataDeclarationRepository implements IDataDeclarationRepository {
    private static List<String> genders = new ArrayList<>();
    private static List<String> years = new ArrayList<>();
    private static List<String> days = new ArrayList<>();
    private static List<String> months = new ArrayList<>();
    private static List<String> travels = new ArrayList<>();
    private static List<String> nations = new ArrayList<>();

    static {
        genders.add("Nam");
        genders.add("Nữ");

        for (int i = 1930; i <= 2022; i++) {
            years.add(i + "");
        }

        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                days.add("0" + i);
            } else {
                days.add(i + "");
            }
        }

        for (int i = 1; i <= 12; i++) {
            if (i < 10) {
                months.add("0" + i);
            } else {
                months.add(i + "");
            }
        }

        travels.add("Tàu bay");
        travels.add("Tàu thuyền");
        travels.add("Ô tô");
        travels.add("Khác");

        nations.add("Việt Nam");
        nations.add("Lào");
        nations.add("Campuchia");
        nations.add("Thái Lan");
    }

    @Override
    public List<String> getAllGenders() {
        return genders;
    }

    @Override
    public List<String> getAllYears() {
        return years;
    }

    @Override
    public List<String> getAllDays() {
        return days;
    }

    @Override
    public List<String> getAllMonths() {
        return months;
    }

    @Override
    public List<String> getAllTravels() {
        return travels;
    }

    @Override
    public List<String> getAllNations() {
        return nations;
    }
}
