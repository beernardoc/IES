package com.example.ex3_3.entity;

public class Movie {

        private String name;
        private int ID;

        public Movie(String name, int ID) {
            this.name = name;
            this.ID = ID;
        }

        public String getName() {
            return name;
        }

        public int getID() {
            return ID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setID(int ID) {
            this.ID = ID;
        }



}
