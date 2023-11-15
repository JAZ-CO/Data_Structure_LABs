package test;

import java.util.*;

class Graph { 
        int numVertices; 

        // using 2d array instead of 2d ArrayList
        int matrix[][];
          
        Graph(int numVertices) { 
            this.numVertices = numVertices;
            // initialize matrix
            matrix = new int[numVertices][numVertices];

            // setting all initial values of matrix as false
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        void displayGraph(){
            for (int i = 0; i < numVertices; i++) {
                System.out.print("       "+i);
            }
            System.out.println();
            for (int i = 0; i < numVertices; i++) {
                System.out.print(i + "      ");
                for (int j = 0; j <numVertices ; j++) {
                    System.out.print(isEdge(i,j)+ "   ");
                }
                System.out.println();
            }
        }

       // LAB TASKS
       public void addEdge(int i, int j){
           matrix[i][j] = 1;       //add edge:   source ---> destination
           matrix[j][i] = 1;       //add edge:   destination ---> sorce

       }
        public void removeEdge(int i, int j){
            // set the values to zero
            matrix[i][j] = 0;       //add edge:   source ---> destination
            matrix[j][i] = 0;       //add edge:   destination ---> sorce
        }

        public boolean isEdge(int i, int j){
            return matrix[i][j] == 1 && matrix[j][i] == 1 ? true:false;
        }

   }

