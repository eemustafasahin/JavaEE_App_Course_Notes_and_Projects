package org.csystem.app.samples.examsimulationapp;

import org.csystem.util.ArrayUtil;
import org.csystem.util.ConsoleUtil;

import java.util.Random;
import java.util.Scanner;

public class ExamSimulation {
    private final String m_lectureName;
    private int [][] m_grades;
    private double [] m_averages;
    private double average;

    public void fillGrades(Scanner kb)
    {
        Random r = new Random();

        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube öğrenci sayısını giriniz:", i + 1);
            m_grades[i] = ArrayUtil.getRandomArray(r, Integer.parseInt(kb.nextLine()), 0, 101);
        }
    }

    public void createGradesInfo()
    {
        Scanner kb = new Scanner(System.in);
        System.out.printf("'%s' sınavı şube sayısını giriniz:", m_lectureName);
        int n = Integer.parseInt(kb.nextLine());

        m_grades = new int[n][];
        m_averages = new double[n];

        fillGrades(kb);
    }

    public void calculateAverages()
    {
        int totalGrade = 0;
        int numberOfStudents = 0;

        for (int i = 0; i < m_grades.length; ++i) {
            int sumOfGrades = ArrayUtil.sum(m_grades[i]);

            totalGrade += sumOfGrades;
            numberOfStudents += m_grades[i].length;
            m_averages[i] = (double)sumOfGrades / m_grades[i].length;
        }

        average = (double)totalGrade / numberOfStudents;
    }

    public void displayHeader()
    {
        String fmt = String.format("%n%s DERSİ SINAV RAPORU:%n", m_lectureName);
        System.out.printf(fmt, m_lectureName);
        ConsoleUtil.putCharsLine(fmt.length(), '-');
    }

    public void displayGrades()
    {
        System.out.println("Şube Notları:");
        ConsoleUtil.putCharsLine(13, '-');

        for (int i = 0; i < m_grades.length; ++i) {
            System.out.printf("%d. şube notlar:%n", i + 1);
            ArrayUtil.display(2, m_grades[i]);
        }
    }

    public void displayAverages()
    {
        System.out.println("Ortalamalar:");
        ConsoleUtil.putCharsLine(13, '-');
        for (int i = 0; i < m_averages.length; ++i)
            System.out.printf("%d. şube ortalaması:%f%n", i + 1, m_averages[i]);

        System.out.printf("Okul ortalaması:%f%n", average);
    }

    public ExamSimulation(String name)
    {
        m_lectureName = name;
    }

    public void displayReport()
    {
        displayHeader();
        displayGrades();
        displayAverages();
        System.out.println("///////////////////////////");
    }

    public void run()
    {
        createGradesInfo();
        calculateAverages();
    }

    //
}
