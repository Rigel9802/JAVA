/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package pbo_praktik_keterhubunganclassjava;

/**
 *
 * @author Lucky
 */
public class Student {
    private String name;
    private Course[] listCourse = new Course[1000];
    private int countCourse;
    
    public Student(String name){
        this.name = name;
    }
    
    public String getNameStudent(){
        return name;
    }
    
    public void takeCourse(Course c){
        listCourse[countCourse] = c;
        countCourse++;
    }
    
    public Course[] getListCourse(){
        return listCourse;
    }
    
    public int getCountCourse(){
        return countCourse;
    }
    
    public static void main(String[] args) {
        
    }
    
}
