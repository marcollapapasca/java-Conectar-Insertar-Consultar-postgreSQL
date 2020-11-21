package com.example.postgresql;

public class Example {
    public static void main(String[] args) {

        Projects projects = new Projects();
        projects.name = "dev-java-postgreSQL";
        projects.description = "Development environment";

        daProjects daProjects = new daProjects();

        //Insertar registros en PosgreSQL
        daProjects.insert(projects);

        //Listar registros desde PosgreSQL
        daProjects.select();
    }
}
