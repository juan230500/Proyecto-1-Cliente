/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import NET.*;
import adt.LinkedQueue;

/**
 *
 * @author reds
 */
public class Cola_Test1 {
    public static void main(String[] args) {
		//Test1
		LinkedQueue cola1=new LinkedQueue ();
                cola1.enqueue("1 primer elemento");
                cola1.enqueue("segundo elemtno");
                System.out.println(cola1.dequeue());
                System.out.println(cola1.dequeue());
                System.out.println(cola1.dequeue());
		
	}
    
}
